package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.model.Article;

import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    @Autowired
    HomePageController(ArticleDao articledao) {
        this.articleDao = articledao;
    }

    @GetMapping("/home")
    public String recentAddArticles(Model model) {
        model.addAttribute("articles", articleDao.findFiveArticles());
        return "articles";
    }
}
