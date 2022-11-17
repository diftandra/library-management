package id.co.team8.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.team8.librarymanagement.enums.ErrorOutput;
import id.co.team8.librarymanagement.model.Book;
import id.co.team8.librarymanagement.repository.BookRepository;
import id.co.team8.librarymanagement.utils.Helpers;
import id.co.team8.librarymanagement.vio.input.BookRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<ValueOutput> getAllBook(){
        List<Book> books = bookRepository.findAll();
        return Helpers.createResponse(ErrorOutput.OK, books);
    }

    public ResponseEntity<ValueOutput> getBookDetail(Integer bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return Helpers.createResponse(ErrorOutput.OK, book);
    }

    public ResponseEntity<ValueOutput> addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setBookDescription(bookRequest.getBookDescription());
        book.setBookAuthor(bookRequest.getBookAuthor());
        book.setBookNumber(bookRequest.getBookNumber());
        book.setPublisher(bookRequest.getPublisher());
        book.setBookImage(bookRequest.getBookImage());
        book.setIsAvailable(bookRequest.getIsAvailable());
        bookRepository.saveAndFlush(book);

        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    @Transactional
    public ResponseEntity<ValueOutput> updateBook(BookRequest bookRequest){
        Optional<Book> book = bookRepository.findById(bookRequest.getBookId());
        if(book.isPresent()){
            book.get().setBookName(bookRequest.getBookName());
            book.get().setBookDescription(bookRequest.getBookDescription());
            book.get().setBookAuthor(bookRequest.getBookAuthor());
            book.get().setBookNumber(bookRequest.getBookNumber());
            book.get().setPublisher(bookRequest.getPublisher());
            book.get().setBookImage(bookRequest.getBookImage());
            book.get().setIsAvailable(bookRequest.getIsAvailable());
            bookRepository.saveAndFlush(book.get());
        }
        
        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    public ResponseEntity<ValueOutput> deleteBook(Integer bookId){
        bookRepository.deleteById(bookId);
        return Helpers.createResponse(ErrorOutput.OK, null);
    }
    
}
