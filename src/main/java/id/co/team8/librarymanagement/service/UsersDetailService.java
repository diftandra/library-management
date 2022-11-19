package id.co.team8.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.co.team8.librarymanagement.model.MyUserDetail;
import id.co.team8.librarymanagement.model.User;
import id.co.team8.librarymanagement.repository.UsersRepository;

public class UsersDetailService implements UserDetailsService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No User Found with username : "+username);
        }
        return new MyUserDetail(user);
    }
    
}
