package hh.swd20.bookstore.web;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Bookstore;
import hh.swd20.bookstore.domain.BookstoreRepository;

@CrossOrigin//*
@Controller

public class BookstoreController {
	@Autowired
	private BookstoreRepository repository;
	@RequestMapping(value= "/booklist", method = RequestMethod.GET)
	public String books(Model model) {
		model.addAttribute("books", repository.findAll());
        return "booklist";		
		
		}
	
	
	@RequestMapping(value="/books",method=RequestMethod.GET)//* uudet RESTit (get all)
	public @ResponseBody List<Bookstore> bookListRest() {
		return (List<Bookstore>) repository.findAll();
	}
	@RequestMapping(value="/books/{id}",method=RequestMethod.GET)//*(get by id)
	public @ResponseBody Optional<Bookstore> findBookstoreRest(@PathVariable("id") Long bookId)
	{ return repository.findById(bookId);
	}
	
	@RequestMapping(value="/books",method=RequestMethod.POST)//*(save new book)
	public @ResponseBody Bookstore saveBookstoreRest(@RequestBody Bookstore bookstore)
	{ return repository.save(bookstore);
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

	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    @PreAuthorize("hasAuthority('ADMIN')")
	    public String deleteBook(@PathVariable("id") Long id, Model model) {
	    	repository.deleteById(id); 
	        return "redirect:/booklist";
}
	    @RequestMapping(value="/edit/{id}")
	    public String showEditedBook(@PathVariable("id")Long id,Model model) {
	    	model.addAttribute("bookstore",repository.findById(id));
	    	model.addAttribute("author",repository.findAll());
	    	model.addAttribute("year",repository.findAll());
	    	model.addAttribute("isbn",repository.findAll());
	    	model.addAttribute("price",repository.findAll());
	    	return "editbooks.html";
	
	    }
}