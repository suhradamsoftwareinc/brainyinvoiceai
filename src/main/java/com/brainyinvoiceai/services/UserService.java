package com.brainyinvoiceai.services;


import java.util.List;

import com.brainyinvoiceai.dto.UserDto;
import com.brainyinvoiceai.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
