package id.co.team8.librarymanagement.service;

import id.co.team8.librarymanagement.model.Book;
import id.co.team8.librarymanagement.vio.input.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.co.team8.librarymanagement.enums.ErrorOutput;
import id.co.team8.librarymanagement.utils.Helpers;
import id.co.team8.librarymanagement.model.MyUserDetail;
import id.co.team8.librarymanagement.model.User;
import id.co.team8.librarymanagement.repository.UsersRepository;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsersDetailService implements UserDetailsService{

    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<ValueOutput> getAllUser(){
        List<User> books = usersRepository.findAll();
        return Helpers.createResponse(ErrorOutput.OK, books);
    }

    public ResponseEntity<ValueOutput> getUserDetail(Integer bookId){
        Optional<User> book = usersRepository.findById(bookId);
        return Helpers.createResponse(ErrorOutput.OK, book);
    }

    public ResponseEntity<ValueOutput> addUser(User userRequest){
        User user = new User();
        user.setUserId(userRequest.getUserId());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        user.setEnabled(userRequest.getEnabled());
        usersRepository.saveAndFlush(user);

        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    @Transactional
    public ResponseEntity<ValueOutput> updateUser(User userRequest){
        Optional<User> user = usersRepository.findById(userRequest.getUserId());
        if(user.isPresent()){
            user.get().setUserId(userRequest.getUserId());
            user.get().setUsername(userRequest.getUsername());
            user.get().setPassword(userRequest.getPassword());
            user.get().setRole(userRequest.getRole());
            user.get().setEnabled(userRequest.getEnabled());
            usersRepository.saveAndFlush(user.get());
        }

        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    public ResponseEntity<ValueOutput> deleteUser(Integer bookId){
        usersRepository.deleteById(bookId);
        return Helpers.createResponse(ErrorOutput.OK, null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No User Found with username : "+username);
        }
        return new MyUserDetail(user);
    }
    
}
