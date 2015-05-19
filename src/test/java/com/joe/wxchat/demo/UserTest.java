package com.joe.wxchat.demo;

import com.joe.wxchat.utils.TokenUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * NOTE:Test user session.
 * Created by zhouwd on 15-5-16.
 */
public class UserTest {
    public static void main(String[] args) {
        TokenUtils.Token token = TokenUtils.getInstantToken();
        System.out.println(token);

        token = TokenUtils.getInstantToken();
        System.out.println(token);

        try {
            Thread.sleep(5000);
            TokenUtils.Token token1 = TokenUtils.getInstantToken();
            System.out.println(token1);
            Thread.sleep(20000);
            TokenUtils.Token token2 = TokenUtils.getInstantToken();
            System.out.println(token2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String get(String url) {
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

}
