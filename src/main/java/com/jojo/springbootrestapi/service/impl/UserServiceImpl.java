package com.jojo.springbootrestapi.service.impl;

import com.jojo.springbootrestapi.advice.UserNotFound;
import com.jojo.springbootrestapi.dto.UserDto;
import com.jojo.springbootrestapi.entity.User;
import com.jojo.springbootrestapi.repository.UserRepository;
import com.jojo.springbootrestapi.service.UserService;
import com.jojo.springbootrestapi.util.CustomPage;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return modelMapper.map(user.get(), UserDto.class);
        }throw new UserNotFound("User not found");
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resultUser = userRepository.findById(id);
        if(resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdateAt(new Date());
            resultUser.get().setUpdatedBy("Admin");
            return  modelMapper.map(userRepository.save(resultUser.get()),UserDto.class);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> deleteUser = userRepository.findById(id);
        if(deleteUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Page<User> pagination(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Slice<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPagination(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        UserDto[] dtos = modelMapper.map(data.getContent(), UserDto[].class);
        return new CustomPage<UserDto>(data, Arrays.asList(dtos));
    }

}
