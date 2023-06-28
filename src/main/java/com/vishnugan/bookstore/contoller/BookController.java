package com.vishnugan.bookstore.contoller;

import com.vishnugan.bookstore.common.APIResponse;
import com.vishnugan.bookstore.dto.BookDTO;
import com.vishnugan.bookstore.entity.Book;
import com.vishnugan.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public List<Book> getBooks(@RequestParam(value = "yearOfPublications",required = false) Set<Integer> yop,
                               @RequestParam(value = "bookType",required = false) String bookType) {

//        List<Book> bookList = Arrays.asList (
//                new Book(1, "Java", "Java Desc", 2019, "Programming"),
//                new Book(2, "Python", "Python Desc", 2019, "Programming"),
//                new Book(3, "Spring", "Spring Desc", 2019, "Framework"),
//                new Book(4, "Hibernate", "Hibernate Desc", 2019, "Framework")
//        );

        return bookService.getbooks(yop,bookType);
    }

    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){// @RequestBody is used to convert the json object to java object
        return bookService.createBook(book);
    }
    // RequestBody is used to convert the json object to java object

    @RequestMapping(value = "/books/{id}")
    public BookDTO getBookById( @PathVariable("id") Long bookId, @RequestParam(value = "authorData",required = false) boolean authorData){
        return bookService.getBookById(bookId,authorData);
    }

    @RequestMapping(value = "/books",method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book incomigBook){
       return  bookService.updateBook(incomigBook);
    }

    @RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE)
    public String deletebookById(@PathVariable("id") Long bookId){
        return bookService.deletebookById(bookId);
    }

    @GetMapping("/raw/books")
    public APIResponse getBooksByRawQuery( @RequestParam(value = "yop") Set<Integer> yop){
        return bookService.getBooksByRawQuery(yop);
    }

    @GetMapping("/caughtException")
    public APIResponse getCaughtException( @RequestParam(value = "number") Integer yop){
        return bookService.getCaughtException(yop);
    }

}
