package com.alandwiprasetyo.rockslims;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.util.List;

/**
 * Created by alandwiprasetyo on 15/07/16.
 */
public interface TasksService {
    void setData(int method, String url);
    void setData(String url);
    String getJson();
}
