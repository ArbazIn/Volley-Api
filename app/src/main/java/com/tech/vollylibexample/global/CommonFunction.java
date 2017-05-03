package com.tech.vollylibexample.global;

import android.util.Log;

/**
 * Created by arbaz on 2/5/17.
 */

public class CommonFunction {

    //after project complete make true to false
    public static void printLog(String... msg) {
        if (true) {
            for (String string : msg) {
                Log.d("VolleyExample ", string);
            }

        }
    }
}
