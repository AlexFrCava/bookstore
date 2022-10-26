package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Bookstore;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	@RequestMapping(value= "/categorylist", method=RequestMethod.GET)
	public String categories(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
        return "addbook";
    }  
	@RequestMapping(value="/savecategory",method=RequestMethod.POST)
	public String save(Category category) {
		repository.save(category);
		return "redirect:/categorylist";
	}}