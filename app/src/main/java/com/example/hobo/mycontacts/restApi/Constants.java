package com.example.hobo.mycontacts.restApi;

/**
 * Created by Caleb on 7/20/2017.
 */

public final class Constants {
    public static final String VERSION          = "v1/";
    public static final String ROOT_URL         = "https://api.instagram.com/" + VERSION;
    public static final String ACCESS_TOKEN     = "5757951256.ec07a26.0918628b72644dafbf142c057ab6be58";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_USER_MEDIA = "users/self/media/recent/";
    public static final String URL_GET_RECENT_USER_MEDIA = KEY_GET_RECENT_USER_MEDIA + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=5757951256.ec07a26.0918628b72644dafbf142c057ab6be58
}
