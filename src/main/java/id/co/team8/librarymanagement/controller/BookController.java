package id.co.team8.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import id.co.team8.librarymanagement.service.BookService;
import id.co.team8.librarymanagement.vio.input.BookRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;
    
    @GetMapping("/get-all-book")
    ResponseEntity<ValueOutput> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/get-book-detail/{book-id}")
    ResponseEntity<ValueOutput> getBookDetail(@PathVariable("book-id") Integer bookId){
        return bookService.getBookDetail(bookId);
    }
    
    @PostMapping("/add-book")
    ResponseEntity<ValueOutput> addBook(@Validated @RequestBody BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }

    @PutMapping("/update-book")
    ResponseEntity<ValueOutput> updateBook(@Validated @RequestBody BookRequest bookRequest){
        return bookService.updateBook(bookRequest);
    }

    @DeleteMapping("/delete-book/{book-id}")
    ResponseEntity<ValueOutput> deleteBook(@PathVariable("book-id") Integer bookId){
        return bookService.deleteBook(bookId);
    }

}
