package com.vishnugan.bookstore.service;

import com.vishnugan.bookstore.common.APIResponse;
import com.vishnugan.bookstore.common.BadRequestException;
import com.vishnugan.bookstore.common.Error;
import com.vishnugan.bookstore.data.BookData;
import com.vishnugan.bookstore.dto.AuthorDTO;
import com.vishnugan.bookstore.dto.BookDTO;
import com.vishnugan.bookstore.entity.Author;
import com.vishnugan.bookstore.entity.Book;
import com.vishnugan.bookstore.entity.BookAuthor;
import com.vishnugan.bookstore.repo.BookAuthorRepository;
import com.vishnugan.bookstore.repo.BookRepository;
import com.vishnugan.bookstore.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

//    static List<Book> bookList = Arrays.asList (
//            new Book(1, "Java", "Java Desc", 2019, "Programming"),
//            new Book(2, "Python", "Python Desc", 2019, "Programming"),
//            new Book(3, "Spring", "Spring Desc", 2019, "Framework"),
//            new Book(4, "Hibernate", "Hibernate Desc", 2019, "Framework")
//    );

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookValidator bookValidator;

    public List<Book> getbooks ( Set<Integer> yop, String bookType) {
        List<Book> bookList = new ArrayList<> ( );
        if (yop == null && bookType == null) {
            bookRepository.findAll ( ).forEach ( book -> bookList.add ( book ) );
        } else if (yop != null && bookType == null) {
            return bookRepository.findAllByYearOfPublicationIn(yop);
        } else if (yop == null && bookType != null) {
            return bookRepository.findAllByBookType ( bookType );
        } else {
            return bookRepository.findAllByYearOfPublicationInAndBookType ( yop, bookType );
        }

        return bookList;
    }

    public Book createBook ( Book book ) {

        // validate the book data
        List<Error> errors = bookValidator.validateCreateBookRequest ( book );

        // if there are errors, return the errors
        if (errors.size () > 0) {
            throw new BadRequestException ("Bad Request",errors);
        }

        return bookRepository.save ( book );
    }

    public BookDTO getBookById ( Long bookId , boolean authorData) {

        Book book;
        List<BookAuthor> bookAuthors = null;
        book = bookRepository.findById ( bookId ).get ();
        if (authorData) {
            bookAuthors = bookAuthorRepository.findAllByBookId ( bookId );
        }
        BookDTO bookDTO = new BookDTO ( );

        // Set the bookDTO values from book entity
        bookDTO.setId ( book.getId ( ) );
        bookDTO.setName ( book.getName ( ) );
        bookDTO.setDesc ( book.getDesc ( ) );
        bookDTO.setYearOfPublication ( book.getYearOfPublication ( ) );
        bookDTO.setBookType ( book.getBookType ( ) );

        // get the author list from bookAuthors
        List<AuthorDTO> authorDTOList = new ArrayList<> ();

        if (bookAuthors != null) {
            for (BookAuthor bookAuthor : bookAuthors) {
                Author author = bookAuthor.getAuthor ( );

                AuthorDTO authorDTO = new AuthorDTO ( );
                authorDTO.setId ( author.getId ( ) );
                authorDTO.setName ( author.getName ( ) );
                authorDTO.setGender ( author.getGender ( ) );

                authorDTOList.add ( authorDTO );
            }

            // set the author list to bookDTO
            bookDTO.setAuthors ( authorDTOList );
        }
        return bookDTO;
    }

    public Book updateBook ( Book incomigBook ) {
        return bookRepository.save ( incomigBook );
    }

    public String deletebookById ( Long bookId ) {
        bookRepository.deleteById ( bookId );
        return "Book Deleted Successfully";
    }

    public APIResponse getBooksByRawQuery ( Set<Integer> yop ) {

        APIResponse apiResponse = new APIResponse ( );
        // do the raw query
        List<Book> bookList = bookRepository.findAllByYearOfPublicationIn ( yop );

//        Map data = new HashMap ( );
//        data.put ( "books", bookList );//key, value

        // set the data to bookData
        BookData bookData = new BookData ( );// ithu object ai create pannanum athiku thaan ipidi panrom
        bookData.setBooks ( bookList );

        // set the apiResponse
        apiResponse.setData ( bookData );
        return apiResponse;
    }

    public APIResponse getCaughtException ( Integer yop ) {

        int result = 1000 / yop;

        APIResponse response = new APIResponse ( );
        response.setData ( result );

        return response;
    }
}


