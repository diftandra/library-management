package id.co.team8.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.team8.librarymanagement.service.BookCategoryService;
import id.co.team8.librarymanagement.vio.input.BookCategoryRequest;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@RestController
@RequestMapping("/book-category")
public class BookCategoryController {
    
    @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping("/get-all-book-category")
    ResponseEntity<ValueOutput> getAllBookCategory(){
        return bookCategoryService.getAllBookCategory();
    }

    @GetMapping("/get-book-category-detail/{book-category-id}")
    ResponseEntity<ValueOutput> getBookCategoryDetail(@PathVariable("book-category-id") Integer bookCategoryId){
        return bookCategoryService.getBookCategoryDetail(bookCategoryId);
    }
    
    @PostMapping("/add-book-category")
    ResponseEntity<ValueOutput> addBookCategory(@Validated @RequestBody BookCategoryRequest bookCategoryRequest){
        return bookCategoryService.addBookCategory(bookCategoryRequest);
    }

    @PutMapping("/update-book-category")
    ResponseEntity<ValueOutput> updateBookCategory(@Validated @RequestBody BookCategoryRequest bookCategoryRequest){
        return bookCategoryService.updateBookCategory(bookCategoryRequest);
    }

    @DeleteMapping("/delete-book-category")
    ResponseEntity<ValueOutput> deleteBookCategory(@PathVariable("book-category-id") Integer bookCategoryId){
        return bookCategoryService.deleteBookCategory(bookCategoryId);
    }

}
