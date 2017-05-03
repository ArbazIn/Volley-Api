package com.tech.vollylibexample.listener;

/**
 * Created by arbaz on 2/5/17.
 */

public interface VolleyResponse {
    void onSuccess( String responseString, String requestType);

    void onFailure(String errorMessage);
}
