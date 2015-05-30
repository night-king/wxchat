package com.joe.wxchat.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class Test {
    private static String post(String url, String param) {
        try {
            HttpPost request = new HttpPost(url);
            request.setEntity(new StringEntity(param, "UTF-8"));
            HttpResponse response = HttpClients.createDefault().execute(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                return inputStream2String(response.getEntity().getContent());
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }

    public static String inputStream2String(InputStream in) throws IOException {
        StringBuilder out = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String content = URLEncoder.encode(str, "UTF-8");
        String content = "!+";
        String param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
//        String url = "http://121.42.146.121:8080/wxdemo/wxchat.do";
        String url = "http://127.0.0.1:8080/wxchat.do";
        System.out.println(post(url, param));
        content = "这是一个测试3";
        param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
        post(url, param);
        content = "这是内容3";
        param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
        post(url, param);
        content = "！>";
        param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
        post(url, param);
        content = "！$";
        param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
        System.out.println(post(url, param));
        content = "！%";
        param = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + content + "]]></Content><MsgId>1234567890123456</MsgId></xml>";
        System.out.println(post(url, param));

//        System.out.println(5/4);
    }
}
