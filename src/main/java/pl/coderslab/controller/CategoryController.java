package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Category;

@Controller
public class CategoryController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categoryList")
    public String findAll(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categoryList";
    }

    //dodawanie:
    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }
    @PostMapping("/addCategory")
    public String addCategory(Category category){
        categoryDao.save(category);
        return "redirect:/categoryList";
    }

    //edycja:
    @GetMapping("/category/edit/{id}")
    public String editCategory(Model model, @PathVariable Long id){
        Category byId = categoryDao.findById(id);
        model.addAttribute("category", byId);
        return "categoryForm";
    }
    @PostMapping("/category/edit/{id}")
    public String editCategory(Category category){
        categoryDao.update(category);
        return "redirect:/categoryList";
    }

    //usuwanie:
    @GetMapping("/category/remove/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryDao.delete(categoryDao.findById(id));
        return "redirect:/categoryList";
    }
}
