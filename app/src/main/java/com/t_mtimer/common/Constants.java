package com.t_mtimer.common;

import java.util.ArrayList;

public class Constants {

    public static String robotRegularTtf = "font/Roboto-Regular.ttf";
    public static String robotBoldTtf = "font/Roboto-Bold.ttf";

    public static String Url = "https://api.forecast.io/forecast/fed0501c96365f6a84455896852d8a77/";
    public static String PlaceDetailUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
    public static String PlaceAddUrl = "https://maps.googleapis.com/maps/api/place/add/json?key=";
    public static String RESULT = "Result";
    public static String ERROR = "error";
    // Sign In
    public static final String STATUS = "status";
    public static final String PASSWORD = "password";
    public static final String RESPONSECODE = "ResponseCode";
    public static final String RESPONSEMSG = "ResponseMsg";
    public static final String USERDETAIL = "userDetail";
    public static String ID = "id";
    public static String DATA = "data";
    public static String USERID = "user_id";
    public static String PAGE = "page";
    public static String NAME = "name";
    public static String EMAIL = "email";
    public static String SUBJECT = "subject";
    public static String MESSAGE = "message";
    public static String USER_NAME = "user_name";
    public static String NAME_EMAIL = "email";
    public static String CONTACT_NO = "contact_no";

    public static String NEW_PASSWORD = "new_password";
    public static String OLD_PASSWORD = "old_password";


    public static String DEVICE_ID = "device_id";
    public static String DEVICE_UDID = "device_udid";
    public static String DEVICE_TYPE = "device_type";

    public static String PLACEID = "PlaceID";
    public static String BUSINESSID = "BusinessID";

    public static String MAP_TYPE = "Normal";
    public static String DISTANCE_TYPE = "KILOMETERS";
    public static boolean IS_GOTO_GPS_SETTINGS = false;
    public static boolean isMapTypeChange = false;
    public static boolean isDistanceUnitChange = false;
    public static boolean IsFromFavoriteScreen = false;

    public static String URL_USER = "http://silverskytechnology.com/prakash_maood/api/get_flag.php";

    public static String KEY = "key";
    public static String TOKEN = "token";
    public static String STANDARD_KEY = "ba167ab7f60b864976a072d53e3c41e2";
    public static String GENERATE_KEY = "generateKey";
    public static String SIGNUP = "userSignup";
    public static String LOGIN = "userLogin";
    public static String VERIFICATION = "checkVerificationCode";
    public static String SETUP_PROFILE = "editProfile";
    public static String SET_MYCONTACTS = "setMyContacts";
    public static String GET_MYCONTACTS = "getMyContacts";
    public static String GET_CONNECTED_INVITE = "getConnectedInviteContacts";
    public static String SEND_INVITE = "sendInvitation";
    public static String CHANGE_PASSWORD = "changePassword";
    public static String FORGOT_PASSWORD = "forgotPassword";
    public static String GET_FOOTBALL_COURT = "getFootballCourt";
    public static String BOOK_FOOTBALL_COURT = "bookFootballCourtOrder";
    public static String BOOK_RESORT = "bookResortsOrder";
    public static String GET_RESORT = "getResorts";
    public static String GET_ORDER = "getOrders";
    public static String DATE_STRING = "dates";
    public static String GET_FOOTBALL_COURT_AVAILABILITY = "getFootballCourtAvailability";
    public static String GET_RESORT_AVAILABILITY = "getResortAvailability";
    public static String CONFIRM_ORDER_FOOTBALL = "payFootballCourtOrderPayment";
    public static String CONFIRM_ORDER_RESORT = "payResortOrderPayment";
    public static String FOOTBALL_COURT_MASTER_ID = "football_court_master_id";
    public static String GET_PROFILE_DATA_FROM_HOME = "getPersonalWorkInformation";
    public static String SEND_QUERY = "sendContactDetails";
    /**
     * font declaration
     */
    public static String texgyreadventorTtf = "font/texgyreadventor_regular.otf";
    public static String texgyreadventorBoldTtf = "font/texgyreadventor_bold.otf";

    public static String RESORT_MASTER_ID = "resorts_master_id";
    public static String ORDER_DATE = "order_date";
    public static String ORDER_TIME = "order_time";
    public static String DATE = "date";
    public static String PAY_KEY = "pay_key";
    public static String ORDER_AMOUNT = "order_amount";
    public static ArrayList<String> selectedSlotArray = new ArrayList<String>();
    public static int CHECK_ALL_SELECTED = 0;
    public static int dateChanged = 0, slot_selected = 0;
    public static String last_selected_date = "", selecting_date = "";
    public static String DATE_FORMAT = "MM/dd/yyyy";

}
