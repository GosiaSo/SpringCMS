package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.dao.ArticleDao;


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
        return "/author/articles";
    }
}
