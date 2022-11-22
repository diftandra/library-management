package id.co.team8.librarymanagement.controller;

import id.co.team8.librarymanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import id.co.team8.librarymanagement.service.UsersDetailService;
import id.co.team8.librarymanagement.vio.output.template.ValueOutput;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UsersDetailService userService;

    @GetMapping("/get-all-user")
    ResponseEntity<ValueOutput> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/get-user-detail/{book-id}")
    ResponseEntity<ValueOutput> getUserDetail(@PathVariable("user-id") Integer userId) {
        return userService.getUserDetail(userId);
    }

    @PostMapping("/add-user")
    ResponseEntity<ValueOutput> addUser(@Validated @RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update-user")
    ResponseEntity<ValueOutput> updateUser(@Validated @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete-user/{user-id}")
    ResponseEntity<ValueOutput> deleteUser(@PathVariable("user-id") Integer userId) {
        return userService.deleteUser(userId);
    }
}
