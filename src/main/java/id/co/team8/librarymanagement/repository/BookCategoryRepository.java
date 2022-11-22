package id.co.team8.librarymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.team8.librarymanagement.model.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

    @Query(	value = "SELECT LPAD(CAST (NEXTVAL('LIBRARY.SQ_CATEGORY_CODE') AS VARCHAR), 3, '0')",
			nativeQuery = true )
	String getSqCategoryCode();
}
