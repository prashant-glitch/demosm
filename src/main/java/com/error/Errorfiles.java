package com.error;


public class Errorfiles {

    public static final String SCHDULED = "scheduled";
    public static final String DISPATCHED = "dispatched";
    public static final String SEND_NOW = "send now";

    public static final String INVALID_USERNAME = "invalid username";
    public static final String INVALID_PASSWORD = "invalid password";
    public static final String WRONG_CREDENTIALS = "username or password is not correct";
    public static final String INVALID_MSG = "invalid message or empty message";
    public static final String INVALID_DATE = "invalid date";
    public static final String INVALID_PHONENUMBER = "invalid phone number";

    public static final String BAD_REQUEST = " bad request";
    public static final String INTERNAL_ERROR = "internal error";
    public static final String SERVICE_UNAVAILABLE = "service unavailable";
    public static final String TIME_OUT = "session out";
    public static final String NOT_FOUND = " not found";

    public static String codeToString(int errorcode) {
        String value;

        switch (errorcode) {
            case 100:
                value = SCHDULED;
                break;
            case 101:
                value = DISPATCHED;
                break;
            case 102:
                value = SEND_NOW;
                break;
            case 400:
                value = INVALID_USERNAME;
                break;
            case 401:
                value = INVALID_PASSWORD;
                break;
            case 402:
                value = WRONG_CREDENTIALS;
            case 403:
                value = INVALID_MSG;
                break;
            case 404:
                value = INVALID_DATE;
                break;
            case 405:
                value = INVALID_PHONENUMBER;
                break;
            case 500:
                value = BAD_REQUEST;
                break;
            case 501:
                value = INTERNAL_ERROR;
                break;
            case 502:
                value = SERVICE_UNAVAILABLE;
                break;
            case 503:
                value = TIME_OUT;
                break;
            default:
                value = NOT_FOUND;
        }
        return value;
    }
}
