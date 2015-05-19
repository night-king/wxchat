package com.joe.web.controller;

import com.joe.server.dao.entity.Article;
import com.joe.server.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by zhouwd on 15-5-16.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertArticle(Article article) {
        if(articleService.insertArticle(article)==1){
            return "1";
        }
        return "0";
    }

//
//    @RequestMapping(value = "/query",method = RequestMethod.POST)
//    @ResponseBody
//    public List<Article> queryArticle(Integer pageNum,Integer pageRow,String queryStr) {
//        return articleService.queryArticleList(pageNum, pageRow, queryStr);
//    }



}
