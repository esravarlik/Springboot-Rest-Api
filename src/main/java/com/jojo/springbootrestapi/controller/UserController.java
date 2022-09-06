package com.jojo.springbootrestapi.controller;

import com.jojo.springbootrestapi.dto.UserDto;
import com.jojo.springbootrestapi.entity.User;
import com.jojo.springbootrestapi.service.UserService;
import com.jojo.springbootrestapi.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){

        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody UserDto user){
        UserDto resultUser = userService.updateUser(id, user);
        return ResponseEntity.ok(resultUser);

    }

    @DeleteMapping("/remote/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> pagination(@RequestParam int currentPage, @RequestParam int pageSize){
        return ResponseEntity.ok(userService.pagination(currentPage, pageSize));
    }

    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>> pagination(Pageable pageable){
        return ResponseEntity.ok(userService.pagination(pageable));
    }

    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>> slice(Pageable pageable){
        return ResponseEntity.ok(userService.slice(pageable));
    }

    @GetMapping("/pagination/v3")
    public ResponseEntity<CustomPage<UserDto>> customPagination(Pageable pageable){
        return ResponseEntity.ok(userService.customPagination(pageable));
    }

}
