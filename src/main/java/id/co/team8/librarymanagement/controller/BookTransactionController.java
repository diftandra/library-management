package id.co.team8.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.team8.librarymanagement.service.BookTransactionService;
import id.co.team8.librarymanagement.vio.input.BookTransactionRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@RestController
@RequestMapping("/book-transaction")
public class BookTransactionController {
    
    @Autowired
    BookTransactionService bookTransactionService;

    @PostMapping("/borrow")
    ResponseEntity<ValueOutput> borrowBook(@Validated @RequestBody BookTransactionRequest bookTransactionRequest){
        return bookTransactionService.borrowBook(bookTransactionRequest);
    }

    @PostMapping("/return")
    ResponseEntity<ValueOutput> returnBook(@Validated @RequestBody BookTransactionRequest bookTransactionRequest){
        return bookTransactionService.returnBook(bookTransactionRequest);
    }

}
