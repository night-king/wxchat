package com.joe.wxchat.execute.command;

import java.util.Map;

import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.flow.ArticleFlow;

/**
 * NOTE:
 * Created by zhouwd on 15-5-18.
 */
public class UpdateCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleFlow articleFlow = user.getArticleFlow();

        Map<Integer, String> contentMap = articleFlow.getStepContentMap();
        contentMap.put(articleFlow.getCurrentStep(), user.getCurrentContent());
        if (articleFlow.getCurrentStep() < ArticleFlow.STEP_4) {
            articleFlow.setCurrentStep(articleFlow.getCurrentStep() + 1);
        }
        return articleFlow.getCurrentTipTextMsg(user);
    }
}
