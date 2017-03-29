package com.t_mtimer;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.t_mtimer.common.Constants;
import com.t_mtimer.common.Preferences;
import com.t_mtimer.common.Utils;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    final int PERMISSION_REQUEST_CODE = 111;
    private Activity activity;
    // private String udid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = SplashActivity.this;
        Preferences.setKey("ba167ab7f60b864976a072d53e3c41e2");
        //  udid = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Utils.isNetworkAvailable(activity, true, false)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (!checkInternetPermission()) {
                            requestPermission();
                        } else {
                            generateKey();
                        }
                    } else {
                        generateKey();
                    }
                }
            }
        }, SPLASH_TIME_OUT);

    }

    private void generateKey() {
        StringRequest postRequest = new StringRequest(Request.Method.GET, (Constants.URL_USER),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject job = new JSONObject(response);
                            String ResCode = job.getString("ResponseCode");
                            String ResMsg = job.getString("ResponseMsg");
                            if (ResCode.equalsIgnoreCase("1")) {


                                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                                finish();

                            } else {
                                Utils.showAlertWithFinish(activity, getResources().getString(R.string.app_name), ResMsg.toLowerCase(),true);

                            }
                        } catch (Exception e) {
                            Utils.showAlert(activity, getResources().getString(R.string.app_name), getResources().getString(R.string.catch_msg));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("!_@@ getKey()", ".....");
                        Utils.showAlert(activity, getResources().getString(R.string.app_name), getResources().getString(R.string.catch_msg));
                    }
                }
        ) {

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        int socketTimeout = 1000 * 60;// 60 seconds
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        postRequest.setRetryPolicy(policy);
        requestQueue.add(postRequest);
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.INTERNET},
                PERMISSION_REQUEST_CODE);
    }

    private boolean checkInternetPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                } else {
                    finish();
                }
                break;
        }
    }
}
