package com.alandwiprasetyo.rockieslims;

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
    public RockTasks(int method, String url, List<NameValuePair> params, HttpGet httpGet){
        api.setData(method,url,params,httpGet);
    }
    public RockTasks(int method, String url, List<NameValuePair> params, HttpPost httpPost){
        api.setData(method,url,params,httpPost);
    }
    public RockTasks(int method, String url, HttpPost httpPost){
        api.setData(method,url,httpPost);
    }
    public RockTasks(int method, String url, HttpGet httpPost){
        api.setData(method,url,httpPost);
    }
    public RockTasks(int method, String url, List<NameValuePair> params){
        api.setData(method,url,params);

    }
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
        delegate.resultJson(result);
    }

}