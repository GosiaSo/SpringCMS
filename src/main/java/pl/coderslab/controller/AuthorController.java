package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/authorList")
    public String findAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "authorList";
    }
    @GetMapping("/addAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "authorForm";
    }
    @PostMapping("/addAuthor")
    public String addAuthor(Author author){
        authorDao.save(author);
        return "redirect:/authorList";
    }

    @GetMapping("/author/edit/{id}")
    public String editAuthor(Model model, @PathVariable Long id){
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "authorForm";
    }
    @GetMapping("/author/edit/{id}")
    public String editAuthor(Author author){
        authorDao.update(author);
        return "redirect:/authorList";
    }

    //usuwanie:
    @GetMapping("/author/confirm/{id}")
    public String deleteAuthor(Model model, @PathVariable Long id){
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "authorConfirm";
    }

    @GetMapping("/author/remove/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorDao.delete(authorDao.findById(id));
        return "redirect:/authorList";
    }
}
