package hh.swd20.bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Bookstore;
import hh.swd20.bookstore.domain.BookstoreRepository;

@ExtendWith(SpringExtension.class)
	@DataJpaTest
	public class BookstoreRepositoryTest {
	@Autowired private BookstoreRepository repository;
	
	@Test 
	public void findByTitleShouldReturnBookstore() {
		List <Bookstore> books =repository.findByTitle("The Hobbit");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Tolkien");
	}
	@Test
	public void createNewBook() {
		Bookstore bookstore= new Bookstore("Fellowship of the ring", "Tolkien", 1937,"383123",15);
		repository.save(bookstore);
		assertThat(bookstore.getId()).isNotNull();
	}
}
