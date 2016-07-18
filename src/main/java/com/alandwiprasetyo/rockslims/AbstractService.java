package com.alandwiprasetyo.rockslims;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alandwiprasetyo on 16/07/16.
 */
public abstract class AbstractService {
    List<NameValuePair> params = new ArrayList<>();
    HttpGet httpGet=null;
    HttpPost httpPost=null;
    String url;
    int method = Method.GET;
    InputStream is = null;
    String response = null;
    String message = null;

    void setMethod(int method){
        this.method = method;
    }
    void addHeader(String key,String value){
        this.httpGet.addHeader(key,value);
        this.httpPost.addHeader(key,value);
    }

    void setHttp(String url){
        this.httpGet = new HttpGet(url);
        this.httpPost = new HttpPost(url);
    }

    void addParams(String key,String value){
        params.add(new BasicNameValuePair(key, value));
    }
    void setUrl(String url){
        this.url = url;
    }
}
