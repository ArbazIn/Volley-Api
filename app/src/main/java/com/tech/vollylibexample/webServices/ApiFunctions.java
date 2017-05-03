package com.tech.vollylibexample.webServices;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tech.vollylibexample.MainApplication;
import com.tech.vollylibexample.global.CommonFunction;
import com.tech.vollylibexample.listener.VolleyResponse;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by arbaz on 2/5/17.
 */

public class ApiFunctions {

    //For /**GET REQUEST**/
    public static void getServerDataByGetType(final VolleyResponse volleyResponse, final String url, final String tag, final Context mContext) {
        CommonFunction.printLog("URL =" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CommonFunction.printLog("SUCCESS RESPONSE =" + response);
                        volleyResponse.onSuccess(response, tag);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonFunction.printLog("ERROR RESPONSE =" + error.toString());
                        volleyResponse.onFailure(error.toString());
                    }
                }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> mHeaders = new HashMap<>();
//                mHeaders.put("username", CommonFunction.getDataFromSharedPref(mContext, "username"));
//                mHeaders.put("brandUsername", CommonFunction.getDataFromSharedPref(mContext, "brandUserName"));
//                mHeaders.put("authKey", CommonFunction.getDataFromSharedPref(mContext, "authKey"));
//
//                return mHeaders;
//            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(stringRequest, tag);
    }

    //For /**SIMPLE POST REQUEST **/
    public static void getServerDataByPostType(final VolleyResponse volleyResponse, final String url, final String tag, final Context mContext) {
        CommonFunction.printLog("URL =" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CommonFunction.printLog("SUCCESS RESPONSE =" + response);

                        volleyResponse.onSuccess(response, tag);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonFunction.printLog("ERROR RESPONSE =" + error.toString());

                        volleyResponse.onFailure(error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> mHeaders = new HashMap<>();
//                mHeaders.put("username", CommonFunction.getDataFromSharedPref(mContext, "username"));
//                mHeaders.put("brandUsername", CommonFunction.getDataFromSharedPref(mContext, "brandUserName"));
//                mHeaders.put("authKey", CommonFunction.getDataFromSharedPref(mContext, "authKey"));

                return mHeaders;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(stringRequest, tag);
    }

    //For /**JSON POST REQUEST **/
    public static void getServerDataByPostTypeJson(final VolleyResponse volleyResponse, final String url, final String tag, final String rawData) {
        CommonFunction.printLog("URL =" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CommonFunction.printLog("SUCCESS RESPONSE =" + response);
                        volleyResponse.onSuccess(response, tag);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonFunction.printLog("ERROR RESPONSE =" + error.toString());
                        volleyResponse.onFailure(error.toString());
                    }
                }) {


            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return rawData.getBytes();
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(stringRequest, tag);
    }

    //For /**PARAMS POST REQUEST **/
    public static void postWebService(final VolleyResponse volleyResponse, final String url, final String tag, final Context mContext, final Map<String, String> params) {
        CommonFunction.printLog("URL =" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        CommonFunction.printLog("SUCCESS RESPONSE =" + response);
                        volleyResponse.onSuccess(response, tag);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonFunction.printLog("ERROR RESPONSE =" + error.toString());
                        volleyResponse.onFailure(error.toString());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> mHeaders = new HashMap<>();
//                mHeaders.put("username", CommonFunction.getDataFromSharedPref(mContext, "username"));
//                mHeaders.put("brandUsername", CommonFunction.getDataFromSharedPref(mContext, "brandUserName"));
//                mHeaders.put("authKey", CommonFunction.getDataFromSharedPref(mContext, "authKey"));

                return mHeaders;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(stringRequest, tag);
    }


}
