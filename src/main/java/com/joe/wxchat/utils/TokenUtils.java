package com.joe.wxchat.utils;

import java.util.Date;

import com.joe.utils.HttpUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * Created by zhouwd on 15-5-17.
 */
public class TokenUtils {

    private static Token token;

    private Token getToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0d387c7bc9373328&secret=5fc2494ac032b7dba7147a983c398230";
        String result = HttpUtils.get(url);
        System.out.println(result);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(result, Token.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized Token getInstantToken() {
        if (token == null || token.getLastUpdateTime() + 7000000 < new Date().getTime()) {
            token = new TokenUtils().getToken();
            token.setLastUpdateTime(new Date().getTime());
        }
        return token;
    }

    public static class Token {
        private String access_token;
        private String expires_in;
        private long lastUpdateTime;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(String expires_in) {
            this.expires_in = expires_in;
        }

        public long getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "access_token='" + access_token + '\'' +
                    ", expires_in='" + expires_in + '\'' +
                    ", lastUpdateTime=" + lastUpdateTime +
                    '}';
        }
    }
}
