package id.co.team8.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.team8.librarymanagement.model.BookTransaction;

@Repository
public interface BookTransactionRepository extends JpaRepository<BookTransaction, Integer>{
    
}
