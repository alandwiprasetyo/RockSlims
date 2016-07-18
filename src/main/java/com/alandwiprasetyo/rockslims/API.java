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
    public void setData(int method, String url) {
        setMethod(method);
        setData(url);
    }

    @Override
    public void setData(String url) {
        setUrl(url);
        setHttp(url);
    }

    @Override
    public String getJson() {
        return makeServiceCall();
    }
}
