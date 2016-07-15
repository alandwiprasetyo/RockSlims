package com.alandwiprasetyo.rockieslims;

/**
 * Created by root on 15/07/16.
 */

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import java.util.List;

public class RockTasks extends AsyncTask<String, Integer, String> implements ResponseListener {
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
        if(result != null) {
            Log.d("Result > ",result);
        }
        try {
            delegate.resultJson(result);
        }catch (Exception e){
            Log.i("", "onPostExecute: "+e.getMessage());
        }
    }

    @Override
    public void resultJson(String output) {

    }
}