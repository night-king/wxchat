package com.joe.wxchat.execute.command;

import java.util.Map;

import com.joe.server.dao.entity.Article;
import com.joe.server.service.ArticleService;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.flow.ArticleFlow;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;

/**
 * NOTE:
 * Created by zhouwd on 15-5-18.
 */
public class SaveCommand extends com.joe.wxchat.execute.AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleService articleService = getArticleServiceBean();
        RespTextMessage textMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
        Article article = new Article();
        String content = user.getArticleFlow().checkStep();
        if (content != null) {
            textMessage.setContent(content);
        } else {
            Map<Integer, String> articleFlowMap = user.getArticleFlow().getStepContentMap();
            article.setTitle(articleFlowMap.get(ArticleFlow.STEP_1));
            article.setContent(articleFlowMap.get(ArticleFlow.STEP_2));
            articleService.insertArticle(article);
            user.setOperType(User.OPER_NONE);
            textMessage.setContent("保存成功，请输入“!%”+关键字进行查询或输入“!+”继续添加");
        }
        return textMessage;
    }
}
