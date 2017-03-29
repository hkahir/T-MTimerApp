package com.t_mtimer.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.t_mtimer.Tm_TimerApplication;

public class Preferences {
    private static final String USERID = "user_id";
    private static final String TOKEN = "token";


    private static final String BOOK_COUINT = "book_count";
    private static final String USER_PROFILE = "userProfile";
    private static final String CONTACT_NO = "contact_no";
    private static final String UDID = "udid";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String USERNAME = "user_name";
    private static final String KEY = "key";
    private static final String RESPONSECODE = "ResponseCode";
    private static final String USER_VERIFIED = "isUserVerified";
    private static final String USER_PROFILE_SETUP = "userProfileSetup";
    private static final String Service_contact_Fetch = "serviceContactFetch";
    private static final String GO_TO_DIRECT_HOME = "goToDirectHome";

    public static String getFootballCourtMasterId() {
        return FOOTBALL_COURT_MASTER_ID;
    }

    public static void setFootballCourtMasterId(String successOrfail) {
        get().edit().putString(FOOTBALL_COURT_MASTER_ID, successOrfail).commit();
    }


    private static final String FOOTBALL_COURT_MASTER_ID = "football_court_master_id";
    private static String allDetails;

    private static SharedPreferences get() {
        return Tm_TimerApplication.getAppContext().getSharedPreferences("BakaalaApplication", Context.MODE_PRIVATE);
    }

    public static Boolean getUserVerified() {
        return get().getBoolean(USER_VERIFIED, false);
    }

    public static void setUserVerified(boolean userVerified) {
        get().edit().putBoolean(USER_VERIFIED, userVerified).commit();
    }

    public static Boolean getGoToDirectHome() {
        return get().getBoolean(GO_TO_DIRECT_HOME, false);
    }

    public static void setGoToDirectHome(boolean goToDirectHome) {
        get().edit().putBoolean(GO_TO_DIRECT_HOME, goToDirectHome).commit();
    }

    public static String getReceiverMessage() {
        return get().getString(Service_contact_Fetch, null);
    }


    // contact retrive service and receiver
    // success / null
    public static void setReceiverMessage(String successOrfail) {
        get().edit().putString(Service_contact_Fetch, successOrfail).commit();
    }

    public static String getAllDetails() {
        return get().getString(USER_PROFILE_SETUP, null);
    }

    // when user complete profile setup
    public static void setAllDetails(String allDetails) {
        get().edit().putString(USER_PROFILE_SETUP, allDetails).commit();
    }

    public static String getUserId() {
        return get().getString(USERID, null);
    }

    public static void setUserId(String user_id) {
        get().edit().putString(USERID, user_id).commit();
    }

    public static String getPhoneno() {
        return get().getString(CONTACT_NO, null);
    }

    public static void setPhoneno(String phone_no) {
        get().edit().putString(CONTACT_NO, phone_no).commit();
    }

    public static String getToken() {
        return get().getString(TOKEN, null);
    }

    public static void setToken(String token) {
        get().edit().putString(TOKEN, token).commit();
    }

    public static String getUdid() {
        return get().getString(UDID, null);
    }

    public static void setUdid(String udid) {
        get().edit().putString(UDID, udid).commit();
    }

    public static String getId() {
        return get().getString(ID, null);
    }

    public static void setId(String id) {
        get().edit().putString(ID, id).commit();
    }

    public static String getEmail() {
        return get().getString(EMAIL, null);
    }

    public static void setEmail(String email) {
        get().edit().putString(EMAIL, email).commit();
    }

    public static String getUsername() {
        return get().getString(USERNAME, null);
    }

    public static void setUsername(String username) {
        get().edit().putString(USERNAME, username).commit();
    }

    public static String getKey() {
        return get().getString(KEY, null);
    }

    public static void setKey(String key) {
        get().edit().putString(KEY, key).commit();
    }

    public static Integer getDateCount() {
        return get().getInt(BOOK_COUINT, 0);
    }

    public static void setDateCount(Integer dateCount) {
        get().edit().putInt(BOOK_COUINT, dateCount).commit();
    }

//	@SuppressWarnings("unchecked")
//	public static ArrayList<PersonalInfoBean> getPersonalInfo() throws ClassNotFoundException, IOException {
//		return (ArrayList<PersonalInfoBean>) ObjectSerializer.deserialize(get().getString(PERSONAL_INFO, ObjectSerializer.serialize(null)));
//	}
//
//	public static void setPersonalInfo(ArrayList<PersonalInfoBean> listType) throws IOException {
//		get().edit().putString(PERSONAL_INFO, ObjectSerializer.serialize(listType)).commit();
//	}
//
//	@SuppressWarnings("unchecked")
//	public static ArrayList<WorkInfoBean> getWorkInfo() throws ClassNotFoundException, IOException {
//		return (ArrayList<WorkInfoBean>) ObjectSerializer.deserialize(get().getString(WORK_INFO, ObjectSerializer.serialize(null)));
//	}
//
//	public static void setWorkInfo(ArrayList<WorkInfoBean> listType) throws IOException {
//		get().edit().putString(WORK_INFO, ObjectSerializer.serialize(listType)).commit();
//	}
}