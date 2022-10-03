package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Bookstore;
import hh.swd20.bookstore.domain.BookstoreRepository;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.Category;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner Bookstore(BookstoreRepository repository) {
		return (args) -> {
			
			log.info("save books");
			repository.save(new Bookstore("The Hobbit", "Tolkien", 1937,"383123",13));
			
			log.info("all books");
			for (Bookstore bookstore : repository.findAll()) {
				log.info(bookstore.toString());
			}

		};
	}
	public CommandLineRunner Category(CategoryRepository repository) {
		return (args) -> { 
			log.info("new categories");
			repository.save(new Category ("12345","scifi"));
			repository.save(new Category ("54321","comic"));
			
			log.info("all categories");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			
		}
		
		};
	
}
}
