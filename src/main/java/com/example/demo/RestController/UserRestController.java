package com.example.demo.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/backend")
public class UserRestController {
    //    public static final Logger logger = (Logger) LoggerFactory.getLogger(UserRestController.class);
    @Autowired
    private UserService userService;

    //Get all users
    @GetMapping(path = "/users", headers = "Accept=application/json")
    public ResponseEntity<List<User>> getUsers() {
//        logger.info("===============All users retrieving============");
        List<User> users = userService.getUsers();
        if (users.size() == 0) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //Get an user by id
    @GetMapping(path = "/users/{id}", headers = "Accept=application/json")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/add", headers = "Accept=application/json")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
//        logger.info("=======User is adding===============");
        userService.addUser(user);
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}", headers = "Accept=application/json")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(id, user);
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<Void>(header, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}", headers = "Accept=application/json")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<Void>(header, HttpStatus.NO_CONTENT);
    }
}
