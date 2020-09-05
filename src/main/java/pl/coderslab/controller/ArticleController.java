package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Article;

@Controller
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;

    @Autowired
    public ArticleController(ArticleDao articleDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/articleList")
    public String findAll(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "/author/articles";
    }
    @GetMapping("/articleAdd")
    public String displayForm(Model model){
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("article", new Article());
        return "articleForm";
    }
}
