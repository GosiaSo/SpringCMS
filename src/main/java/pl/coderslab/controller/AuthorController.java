package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import javax.validation.Valid;

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
        return "/author/authorList";
    }
    @GetMapping("/addAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "/author/authorForm";
    }
    @PostMapping("/addAuthor")
    public String addAuthor(@Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "/author/authorForm";
        }
        authorDao.save(author);
        return "redirect:/authorList";
    }

    @GetMapping("/author/edit/{id}")
    public String editAuthor(Model model, @PathVariable Long id){
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "/author/authorForm";
    }
    @PostMapping("/author/edit/{id}")
    public String editAuthor(@Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "/author/authorForm";
        }
        authorDao.update(author);
        return "redirect:/authorList";
    }

    //usuwanie:
    @GetMapping("/author/confirm/{id}")
    public String deleteAuthor(Model model, @PathVariable Long id){
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "/author/authorConfirm";
    }

    @GetMapping("/author/remove/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorDao.delete(authorDao.findById(id));
        return "redirect:/authorList";
    }
}
