package com.joe.wxchat.execute.command;

import java.util.List;

import com.joe.server.dao.entity.Article;
import com.joe.server.service.ArticleService;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.flow.ArticleFlow;
import com.joe.wxchat.execute.messagemodel.ArticleResponseMessage;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class NextCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleService articleService = getArticleServiceBean();
        if (user.getOperType() == User.OPER_ADD) {
            ArticleFlow articleFlow = user.getArticleFlow();
            String content = articleFlow.checkStep();
            if (content != null) {
                RespTextMessage respTextMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());
                respTextMessage.setContent(content);
                return respTextMessage;
            }

            if (articleFlow.getCurrentStep() < ArticleFlow.STEP_4) {
                articleFlow.setCurrentStep(articleFlow.getCurrentStep() + 1);
            }
            return articleFlow.getCurrentTipTextMsg(user);
        } else if (user.getOperType() == User.OPER_QUERY) {
            if (user.getPageNum() < user.getPageCounts()) {
                user.setPageNum(user.getPageNum() + 1);
            }
            List<Article> articleList = articleService.queryArticleList(user);
            return ArticleResponseMessage.getArticleListTextMsg(user, articleList);
        }
        return DefaultResponseTextMessage.getAskTextMsg(user);
    }
}
