package com.joe.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * Created by zhouwd on 15-5-17.
 */
public class HttpUtils {


    public static String get(String url) {
        try {
            HttpGet request = new HttpGet(url);

            HttpResponse response = HttpClients.createDefault().execute(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                return EntityUtils.toString(response.getEntity());
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String post(String url, String param) {
        try {
            HttpPost request = new HttpPost(url);
            request.setEntity(new StringEntity(param));
            HttpResponse response = HttpClients.createDefault().execute(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                return EntityUtils.toString(response.getEntity());
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
