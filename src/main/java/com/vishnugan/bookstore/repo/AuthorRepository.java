package com.vishnugan.bookstore.repo;

import com.vishnugan.bookstore.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
