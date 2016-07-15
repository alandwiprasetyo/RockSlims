package com.alandwiprasetyo.rockslims;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import java.util.List;

/**
 * Created by alandwiprasetyo on 15/07/16.
 */
public class API extends Service implements TasksService {

    @Override
    public void setData(int method, String url, List<NameValuePair> params, HttpGet httpGet) {
        setMethod(method);
        setUrl(url);
        setParams(params);
        setHttpGet(httpGet);
    }

    @Override
    public void setData(int method, String url, List<NameValuePair> params, HttpPost httpPost) {
        setData(method,url);
        setParams(params);
        setHttpPost(httpPost);
    }

    @Override
    public void setData(int method, String url, HttpPost httpPost) {
        setData(method,url);
        setHttpPost(httpPost);
    }

    @Override
    public void setData(int method, String url, HttpGet httpGet) {
        setData(method,url);
        setHttpGet(httpGet);

    }

    @Override
    public void setData(int method, String url, List<NameValuePair> params) {
        setData(method,url);
        setParams(params);
    }

    @Override
    public void setData(int method, String url) {
        setMethod(method);
        setUrl(url);
    }

    @Override
    public void setData(String url) {
        setUrl(url);
        this.url = url;
    }

    @Override
    public String getJson() {
        return makeServiceCall();
    }
}
