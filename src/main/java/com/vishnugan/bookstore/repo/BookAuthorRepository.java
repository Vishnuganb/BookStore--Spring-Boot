package com.vishnugan.bookstore.repo;

import com.vishnugan.bookstore.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAuthorRepository extends CrudRepository<BookAuthor,Long> {

    List<BookAuthor> findAllByBookId ( Long bookId );
}
