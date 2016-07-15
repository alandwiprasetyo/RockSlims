package com.alandwiprasetyo.rockieslims;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.util.List;

/**
 * Created by root on 15/07/16.
 */
public interface TasksService {
    void setData(int method, String url, List<NameValuePair> params, HttpGet httpGet);
    void setData(int method, String url, List<NameValuePair> params, HttpPost httpPost);
    void setData(int method, String url, HttpPost httpPost);
    void setData(int method, String url, HttpGet httpPost);
    void setData(int method, String url, List<NameValuePair> params);
    void setData(int method, String url);
    void setData(String url);
    String getJson();
}
