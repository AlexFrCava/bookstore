package hh.swd20.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource//*(ja uudet importit)
public interface BookstoreRepository extends CrudRepository<Bookstore, Long> {
		List<Bookstore> findByTitle(@Param("title") String title); //*
}
