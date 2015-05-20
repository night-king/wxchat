package com.joe.server.service;

import java.util.List;

import com.joe.server.dao.ArticleDao;
import com.joe.server.dao.entity.Article;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NOTE:Article
 * Created by zhouwd on 15-5-16.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public int queryCounts(String queryStr) {
        return articleDao.queryCounts(queryStr);
    }

    public List<Article> queryArticleList(User user) {
        return articleDao.queryArticleList(user.getPageNum(), Constants.RESP_MESSAGE_ARTICLES_PAGENUM, user.getQueryContent());
    }

    public List<Article> queryArticleList(int currentPageNum, String content) {
        return articleDao.queryArticleList(currentPageNum, Constants.RESP_MESSAGE_ARTICLES_PAGENUM, content);
    }

    public Article queryArticleDetail(int id) {
        return articleDao.queryArticleDetail(id);
    }

    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    public int delArticle(int id) {
        return articleDao.deleteAriticle(id);
    }
}
