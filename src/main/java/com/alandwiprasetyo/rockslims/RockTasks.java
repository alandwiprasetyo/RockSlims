package com.alandwiprasetyo.rockslims;

/**
 * Created by alandwiprasetyo on 15/07/16.
 */

import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.util.List;

public class RockTasks extends AsyncTask<String, Integer, String>  {
    public ResponseListener delegate =null;
    API api = new API();

    public RockTasks(int method, String url){
        api.setData(method,url);
    }

    public RockTasks(String url){
        api.setData(url);
    }

    public RockTasks setDelegate(ResponseListener delegate) {
        this.delegate = delegate;
        return this;
    }
    @Override
    protected String doInBackground(String... arg) {
        return api.getJson();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        delegate.resultJson(result,getResponseCode(),getResponseMessage());
    }

    public RockTasks addHeader(String key, String value) {
        api.addHeader(key, value);
        return this;
    }

    public RockTasks setBody(String key, String value) {
        api.addParams(key, value);
        return this;
    }

    public String getResponseCode(){
        return api.response;
    }
    public String getResponseMessage(){
        return api.message;
    }
}