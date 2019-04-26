package com.jwtsecurity.controller;

import com.jwtsecurity.bo.ResponseMessage;
import com.jwtsecurity.model.Article;
import com.jwtsecurity.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LadyLady on 2019-04-19.
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleServices articleServices;


    @GetMapping("{id}")
    public ResponseMessage getArticle(@PathVariable Integer id) {
        Article article = articleServices.findArticle(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(article);
        return responseMessage;

    }


    @PutMapping("{id}")
    public ResponseMessage updateArticle(@RequestBody Article article, @PathVariable Integer id) {

        article.setId(id);

        Article updateArticle = articleServices.updateArticle(article);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(updateArticle);
        return responseMessage;

    }

    @PostMapping
    public ResponseMessage addNewArticle(@RequestBody Article article) {

        final Article addArticle = articleServices.addArticle(article);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(addArticle);
        return responseMessage;

    }

    @DeleteMapping("{id}")
    public ResponseMessage deleteArticle(@PathVariable Integer id) {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("失败");
        if (articleServices.deleteArticle(id)) {
            responseMessage.setMessage("成功");
        }


        responseMessage.setStrutsCode("");
        responseMessage.setData(null);
        return responseMessage;

    }
}
