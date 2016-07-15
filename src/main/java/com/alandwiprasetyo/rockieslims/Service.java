package com.alandwiprasetyo.rockieslims;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by root on 15/07/16.
 */
public class Service extends AbstractService{

    protected void setParams(String key,String value){
        params.add(new BasicNameValuePair(key, value));
    }
    public void setResponseCode(String response){
        this.response = response;
    }
    public String getResponseCode(){
        return response;
    }
    public void setResponseMessage(String message){
        this.message = message;
    }
    public String getResponseMessage(){
        return message;
    }
    public String makeServiceCall() {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            if (method == Method.POST) {
                httpPost = new HttpPost(url);
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }

                httpResponse = httpClient.execute(httpPost);

            } else if (method == Method.GET) {
                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                httpGet = new HttpGet(url);
                httpResponse = httpClient.execute(httpGet);
            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();
        } catch (Exception e) {
            Log.e("Error", "Error: " + e.toString());
        }

        return response;
    }
}
