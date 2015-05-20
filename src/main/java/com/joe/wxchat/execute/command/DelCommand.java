package com.joe.wxchat.execute.command;

import com.joe.server.dao.entity.User;
import com.joe.server.service.ArticleService;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.messagemodel.ArticleResponseMessage;
import com.joe.wxchat.utils.OpertionConstants;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class DelCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleService articleService = getArticleServiceBean();
        String idStr = user.getCurrentContent().replace(OpertionConstants.OPER_DEL, "");
        String context;
        try {
            int id = Integer.valueOf(idStr);
            if (articleService.delArticle(id) == 1) {
                context = "删除成功。";
            } else {
                context = "不存在该记录。可能该记录已经被删除。";
            }
            return ArticleResponseMessage.getDelTextMsg(user, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
