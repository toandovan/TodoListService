package com.example.todolistservice.service;

import com.example.todolistservice.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("AuthService")
public interface TodoUtil {

    @RequestMapping(method = RequestMethod.POST, value = "/auth/getUserData")
    ResponseEntity<UserDto> getUserData(@RequestBody String jwtToken);
}