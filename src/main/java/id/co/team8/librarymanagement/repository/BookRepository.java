package id.co.team8.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.team8.librarymanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
