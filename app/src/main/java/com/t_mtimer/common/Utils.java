package com.t_mtimer.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.t_mtimer.R;

public class Utils {
    public static AlertDialog alert;
    private static String TAG = Utils.class.getSimpleName();
    static String Response;
    public static Dialog pDialog;

    public static Typeface SetCustomFont(String fontName, Context context) {
        return Typeface.createFromAsset(context.getAssets(), fontName);
    }

    public static void ShowTost(Context context, String ToastMessage) {
        Toast.makeText(context, ToastMessage, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || charSequence.toString().equalsIgnoreCase("null");
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target))
            return false;
        else
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static void hideKeyBoard(View view, Activity mActivity) {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showKeyBoard(View v, Activity mActivity) {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, 0);
    }

    public static boolean isNetworkAvailable(final Context context, boolean canShowErrorDialogOnFail, final boolean isFinish) {
        boolean isNetAvailable = false;
        if (context != null) {
            final ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (mConnectivityManager != null) {
                boolean mobileNetwork = false;
                boolean wifiNetwork = false;
                boolean mobileNetworkConnecetd = false;
                boolean wifiNetworkConnecetd = false;

                final NetworkInfo mobileInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                final NetworkInfo wifiInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (mobileInfo != null) {
                    mobileNetwork = mobileInfo.isAvailable();
                }

                if (wifiInfo != null) {
                    wifiNetwork = wifiInfo.isAvailable();
                }

                if (wifiNetwork || mobileNetwork) {
                    if (mobileInfo != null)
                        mobileNetworkConnecetd = mobileInfo
                                .isConnectedOrConnecting();
                    wifiNetworkConnecetd = wifiInfo.isConnectedOrConnecting();
                }

                isNetAvailable = (mobileNetworkConnecetd || wifiNetworkConnecetd);
            }
            context.setTheme(R.style.AppTheme);
            if (!isNetAvailable && canShowErrorDialogOnFail) {
                Log.v("TAG", "context : " + context.toString());
                if (context instanceof Activity) {
                    ((Activity) context).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            showAlertWithFinish((Activity) context, context.getString(R.string.app_name), context.getString(R.string.network_alert), isFinish);
                        }
                    });
                }
            }
        }

        return isNetAvailable;
    }

    public static void showAlertWithFinish(final Activity activity, String title, String message, final boolean isFinish) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isFinish) {
                    dialog.dismiss();
                    activity.finish();
                } else {
                    dialog.dismiss();
                }
            }
        }).show();
    }

//    public static void goToHome(final Activity activity, String title, String message, final Activity go_activity) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AppCompatAlertDialogStyle);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(activity.this, go_activity.class);
//                startActivity(intent);
//            }
//        }).show();
//    }

    public static void showAlert(final Activity activity, String title, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //enterTextDialog();
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = builder.create();

        // show it
        alertDialog.show();
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts radians to decimal degrees             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
