package com.vishnugan.bookstore.repo;

import com.vishnugan.bookstore.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findAllByYearOfPublicationInAndBookType ( Set<Integer> yop ,String bookType); // entity class and primary key type

    List<Book> findAllByBookType ( String bookType );

    String rawQuery = "select * from book where year_of_publication IN :yop";

    @Query ( value = rawQuery, nativeQuery = true )
    List<Book> findAllByYearOfPublicationIn (@Param ( "yop" ) Set<Integer> yop );

}
