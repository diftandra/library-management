package id.co.team8.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.team8.librarymanagement.enums.ErrorOutput;
import id.co.team8.librarymanagement.model.BookCategory;
import id.co.team8.librarymanagement.repository.BookCategoryRepository;
import id.co.team8.librarymanagement.utils.Helpers;
import id.co.team8.librarymanagement.vio.input.BookCategoryRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@Service
public class BookCategoryService {
    
    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public ResponseEntity<ValueOutput> getAllBookCategory(){
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();
        return Helpers.createResponse(ErrorOutput.OK, bookCategories);
    }

    public ResponseEntity<ValueOutput> getBookCategoryDetail(Integer bookCategoryId){
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(bookCategoryId);
        return Helpers.createResponse(ErrorOutput.OK, bookCategory);
    }

    public ResponseEntity<ValueOutput> addBookCategory(BookCategoryRequest bookCategoryRequest){
        BookCategory bookCategory = new BookCategory();
        bookCategory.setBookCategoryName(bookCategoryRequest.getBookCategoryName());
        bookCategory.setIsAvailable(bookCategoryRequest.getIsAvailable());
        bookCategoryRepository.saveAndFlush(bookCategory);

        return Helpers.createResponse(ErrorOutput.OK, null);

    }

    @Transactional
    public ResponseEntity<ValueOutput> updateBookCategory(BookCategoryRequest bookCategoryRequest){
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(bookCategoryRequest.getBookCategoryId());
        if(bookCategory.isPresent()){
            bookCategory.get().setBookCategoryName(bookCategoryRequest.getBookCategoryName());
            bookCategory.get().setIsAvailable(bookCategoryRequest.getIsAvailable());
            bookCategoryRepository.saveAndFlush(bookCategory.get());
        }
        
        return Helpers.createResponse(ErrorOutput.OK, null);

    }

    public ResponseEntity<ValueOutput> deleteBookCategory(Integer bookCategoryId){
        bookCategoryRepository.deleteById(bookCategoryId);
        return Helpers.createResponse(ErrorOutput.OK, null);
    }

}
