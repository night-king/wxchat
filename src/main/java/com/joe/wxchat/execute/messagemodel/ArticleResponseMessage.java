package com.joe.wxchat.execute.messagemodel;

import java.util.List;

import com.joe.server.dao.entity.Article;
import com.joe.utils.LineSeparator;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespNewsMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.wxchat.entity.user.User.User;
import com.joe.wxchat.utils.Constants;

/**
 * NOTE:
 * Created by zhouwd on 15-5-18.
 */
public class ArticleResponseMessage {

    public static RespBaseMessage getDefaultNewsMsg(User user, List<Article> articleList) {
        RespNewsMessage newsMessage = new RespNewsMessage(Constants.SERVER_ID, user.getUserName());
        for (Article article : articleList) {
            RespNewsMessage.RespArticleMessage respArticleMessage = new RespNewsMessage.RespArticleMessage();
            respArticleMessage.setTitle(article.getTitle());
            respArticleMessage.setPicUrl("");
            respArticleMessage.setUrl("" + article.getId());
        }
        return newsMessage;
    }

    public static RespBaseMessage getDefaultTextMsg(User user, List<Article> articleList) {
        RespTextMessage textMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
        String ls = LineSeparator.Web;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入“!@”+“编号” 如：“!@1” 查看详细内容").append(ls);
        for (Article article : articleList) {
            stringBuilder.append(article.getId()).append("：").append(article.getTitle()).append(ls);
        }
        stringBuilder.append(String.format("共%d%d页，当前是<a color='blue'>第%d%d</a>页", user.getPageCounts(), 1, user.getPageNum(), 1));
        textMessage.setContent(stringBuilder.toString());
        return textMessage;
    }

}
