package com.tech.vollylibexample.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tech.vollylibexample.R;
import com.tech.vollylibexample.global.CommonFunction;
import com.tech.vollylibexample.listener.VolleyResponse;
import com.tech.vollylibexample.webServices.Api;
import com.tech.vollylibexample.webServices.ApiFunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements VolleyResponse {


    private Context mContext;
    private android.widget.Button getData;
    private android.widget.Button postData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.postData = (Button) findViewById(R.id.postData);
        this.getData = (Button) findViewById(R.id.getData);
        mContext = MainActivity.this;


        //Get Data button
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiFunctions.getServerDataByGetType(MainActivity.this, Api.MainUrl + Api.GetCountry, Api.GetCountryTag, mContext);
            }
        });
        //post data button
        postData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("countryId",1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ApiFunctions.getServerDataByPostTypeJson(MainActivity.this, Api.MainUrl + Api.GetState, Api.GetStateTag, jsonObject.toString());
            }
        });

        //Api Call Using Params HashMap
        /**
         *  private Map<String, String> params = new HashMap<>();
         *  params.put(timeStamp, defaultTimeStamp);
         params.put(isFirstTime, String.valueOf(CommonFunction.getBooleanDataFromSharedPref(SettingsActivity.this, isFirstTime, true)));

         ServerConnectionVolley.postWebService(SettingsActivity.this, Constant.API_DATA_OFFLINE, ServiceTagEnum.DATA_OFFLINE.toString(), SettingsActivity.this, params);
         */

    }


    @Override
    public void onSuccess(String responseString, final String requestType) {
        CommonFunction.printLog(responseString);
        if (requestType == Api.GetCountryTag) {
            try {
                JSONObject jsonObject = new JSONObject(responseString);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject getFirst = jsonArray.getJSONObject(i);
                    //CommonFunction.printLog(getFirst.);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (requestType == Api.GetStateTag) {

        }
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (requestType == Api.GetCountryTag) {
                    Toast.makeText(MainActivity.this, "Country Api Call Success", Toast.LENGTH_SHORT).show();
                } else if (requestType == Api.GetStateTag) {
                    Toast.makeText(MainActivity.this, "State Api Call Success", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onFailure(String errorMessage) {
        CommonFunction.printLog(errorMessage);

    }
}
