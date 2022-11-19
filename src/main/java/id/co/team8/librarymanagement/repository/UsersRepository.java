package id.co.team8.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.team8.librarymanagement.model.User;

public interface UsersRepository extends JpaRepository<User, Integer>{

    User findByUsername(String username);
    
}
