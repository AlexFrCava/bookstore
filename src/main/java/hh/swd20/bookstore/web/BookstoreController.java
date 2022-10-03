package hh.swd20.bookstore.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Bookstore;
import hh.swd20.bookstore.domain.BookstoreRepository;

@Controller

public class BookstoreController {
	@Autowired
	private BookstoreRepository repository;
	@RequestMapping(value= "/booklist", method = RequestMethod.GET)
	public String books(Model model) {
		model.addAttribute("books", repository.findAll());
        return "booklist";		
		
		}
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String addBook(Model model){
	    	model.addAttribute("bookstore", new Bookstore());
	        return "addbook";
	    }     
	    
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Bookstore bookstore){
	        repository.save(bookstore);
	        return "redirect:/booklist";
	    }

	    @RequestMapping(value = "/delete/{title}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("title") String title, Model model) {
	    	repository.deleteById(title); 
	        return "redirect:/booklist";
}
	    @RequestMapping(value="/edit/{id}")
	    public String showEditedBook(@PathVariable("id")String title,Model model) {
	    	model.addAttribute("bookstore",repository.findById(title));
	    	model.addAttribute("author",repository.findAll());
	    	model.addAttribute("year",repository.findAll());
	    	model.addAttribute("isbn",repository.findAll());
	    	model.addAttribute("price",repository.findAll());
	
	    }
}