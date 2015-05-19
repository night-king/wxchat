package com.joe.wxchat.entity.message.resp;

import java.util.Date;
import java.util.List;

import com.joe.wxchat.utils.Constants;

/**
 * 多图文消息， 
 * 单图文的时候 Articles 只放一个就行了 
 * @author Caspar.chen 
 */  
public class RespNewsMessage extends RespBaseMessage {
    /** 
     * 图文消息个数，限制为10条以内 
     */  
    private int ArticleCount=5;
    /** 
     * 多条图文消息信息，默认第一个item为大图 
     */  
    private List<RespArticleMessage> Articles;

    public RespNewsMessage(String fromUser,String toUser) {
        setToUserName(toUser);
        setFromUserName(fromUser);
        setCreateTime(new Date().getTime());
        setMsgType(Constants.RESP_MESSAGE_TYPE_ARTICLES);
    }

    public int getArticleCount() {
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
  
    public List<RespArticleMessage> getArticles() {
        return Articles;  
    }  
  
    public void setArticles(List<RespArticleMessage> articles) {
        Articles = articles;  
    }

    /**
     * 图文消息
     *
     */
    public static class RespArticleMessage {

        /**
         * 图文消息名称
         */
        private String Title;

        /**
         * 图文消息描述
         */
        private String Description;

        /**
         * 图片链接，支持JPG、PNG格式，<br>
         * 较好的效果为大图640*320，小图80*80
         */
        private String PicUrl;

        /**
         * 点击图文消息跳转链接
         */
        private String Url;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return null == Description ? "" : Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getPicUrl() {
            return null == PicUrl ? "" : PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public String getUrl() {
            return null == Url ? "" : Url;
        }

        public void setUrl(String url) {
            Url = url;
        }
    }
}