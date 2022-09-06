package com.jojo.springbootrestapi.service;

import com.jojo.springbootrestapi.dto.UserDto;
import com.jojo.springbootrestapi.entity.User;
import com.jojo.springbootrestapi.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto user);

    public List<UserDto> getUsers();

    public UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);

    Page<User> pagination(int currentPage, @RequestParam int pageSize);

    Page<User> pagination(Pageable pageable);

    Slice<User> slice(Pageable pageable);

    CustomPage<UserDto> customPagination(Pageable pageable);
}
