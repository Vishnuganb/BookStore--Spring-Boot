package com.vishnugan.bookstore.validator;

import com.vishnugan.bookstore.common.Error;
import com.vishnugan.bookstore.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {
    public List<Error> validateCreateBookRequest ( Book book ) {

        List<Error> errors = new ArrayList<> (  );

        // validate the book name
        if (book.getName () == null || book.getName ().isEmpty ()) {
            Error error = new Error ( "name", "Book name is null" );
            errors.add ( error );
        }

        // validate the book year of publication
        if (book.getYearOfPublication () == null) {
            errors.add ( new Error ( "yearOfPublication", " year of publication is required" ) );
        }

        // validate the book type
        if (book.getBookType () == null || book.getBookType ().isEmpty ()) {
            errors.add ( new Error ( "bookType", "Book type is required" ) );
        }

        return errors;
    }
}
