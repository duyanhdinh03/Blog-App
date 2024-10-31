package com.springboot.blog.service;

import com.springboot.blog.payload.Dto.LoginDto;
import com.springboot.blog.payload.Dto.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
