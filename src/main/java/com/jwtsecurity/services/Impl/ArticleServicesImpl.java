package com.jwtsecurity.services.Impl;

import com.jwtsecurity.dao.ArticleDao;
import com.jwtsecurity.model.Article;
import com.jwtsecurity.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LadyLady on 2019-04-26.
 */
@Service
public class ArticleServicesImpl implements ArticleServices {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public Article findArticle(Integer id) {


        return articleDao.findOne(id);


    }

    @Override
    public boolean deleteArticle(Integer id) {

        try {
            articleDao.delete(id);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Article updateArticle(Article article) {

        if (article.getId() == null) {
            return null;
        }

        return articleDao.save(article);
    }

    @Override
    public Article addArticle(Article article) {
        return articleDao.save(article);
    }
}
