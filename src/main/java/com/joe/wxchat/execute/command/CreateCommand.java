package com.joe.wxchat.execute.command;

import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.flow.ArticleFlow;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class CreateCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleFlow articleFlow = new ArticleFlow();
        articleFlow.setCurrentStep(ArticleFlow.STEP_1);
        user.setArticleFlow(articleFlow);

        return articleFlow.getCurrentTipTextMsg(user);
    }
}
