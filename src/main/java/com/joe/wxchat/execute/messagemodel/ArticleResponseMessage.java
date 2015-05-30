package com.joe.wxchat.execute.messagemodel;

import java.util.List;

import com.joe.server.dao.entity.Article;
import com.joe.utils.LineSeparator;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespNewsMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.server.dao.entity.User;
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

    public static RespBaseMessage getArticleListTextMsg(User user, List<Article> articleList) {
        RespTextMessage textMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
        String ls = LineSeparator.Web;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("查询结果：").append(ls);
        if (articleList.size() > 0) {
            stringBuilder.append(String.format("<a herf='www.baidu.com'>共%03d页</a>，当前是<a herf='#'>第%03d页</a>。", user.getPageCounts() + 1, user.getPageNum() + 1)).append(ls).append(ls);
            for (Article article : articleList) {
                stringBuilder.append("<a herf='mail.163.com' color='blue'>").append(article.getId()).append("</a>：").append(article.getTitle()).append(ls).append(ls);
            }
            stringBuilder.append(ls).append("请输入“!@”+“编号” 如：“!@1” 查看详细内容。");
        } else {
            stringBuilder.append("未查到合适的数据。");
        }
        textMessage.setContent(stringBuilder.toString());
        return textMessage;
    }

    public static RespBaseMessage getDelTextMsg(User user, String context) {
        RespTextMessage textMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
        textMessage.setContent(context);
        return textMessage;
    }
}
