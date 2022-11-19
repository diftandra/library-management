package id.co.team8.librarymanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.team8.librarymanagement.enums.ErrorOutput;
import id.co.team8.librarymanagement.model.Book;
import id.co.team8.librarymanagement.model.BookTransaction;
import id.co.team8.librarymanagement.repository.BookRepository;
import id.co.team8.librarymanagement.repository.BookTransactionRepository;
import id.co.team8.librarymanagement.utils.Helpers;
import id.co.team8.librarymanagement.vio.input.BookTransactionRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@Service
public class BookTransactionService {
    
    @Autowired
    BookTransactionRepository bookTransactionRepository;

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<ValueOutput> borrowBook(BookTransactionRequest bookTransactionRequest){
        BookTransaction bookTransaction = new BookTransaction();
        bookTransaction.setBookTransactionType("BTRX001"); //BTRX001 - Borrow Book
        bookTransaction.setBookId(bookTransactionRequest.getBookId());
        bookTransaction.setBookBorrowerName(bookTransactionRequest.getBookBorrowerName());
        bookTransaction.setBookBorrowerPhone(bookTransactionRequest.getBookBorrowerPhone());
        bookTransaction.setBookBorrowDate(bookTransactionRequest.getBookBorrowDate());

        bookTransactionRepository.saveAndFlush(bookTransaction);

        Optional<Book> book = bookRepository.findById(bookTransactionRequest.getBookId());
        book.get().setIsAvailable(false);

        bookRepository.saveAndFlush(book.get());

        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    public ResponseEntity<ValueOutput> returnBook(BookTransactionRequest bookTransactionRequest){
        Optional<BookTransaction> bookTransaction = bookTransactionRepository.findById(bookTransactionRequest.getBookTransactionId());
        bookTransaction.get().setBookTransactionType("BTRX002"); //BTRX002 - Return Book
        bookTransaction.get().setBookReturnDate(bookTransactionRequest.getBookReturnDate());

        bookTransactionRepository.saveAndFlush(bookTransaction.get());

        Optional<Book> book = bookRepository.findById(bookTransactionRequest.getBookId());
        book.get().setIsAvailable(true);

        bookRepository.saveAndFlush(book.get());

        return Helpers.createResponse(ErrorOutput.OK, null);
    }

}
