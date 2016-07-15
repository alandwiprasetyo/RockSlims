package com.alandwiprasetyo.rockslims;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.InputStream;
import java.util.List;

/**
 * Created by alandwiprasetyo on 16/07/16.
 */
public abstract class AbstractService {
    List<NameValuePair> params;
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
    void setHttpGet(HttpGet httpGet){
        this.httpGet = httpGet;
    }
    void setHttpPost(HttpPost httpPost){
        this.httpPost = httpPost;
    }
    void setUrl(String url){
        this.url = url;
    }
    void setParams(List<NameValuePair> params){
        this.params = params;
    }
}
