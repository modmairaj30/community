package com.ve.community.services;

import com.ve.community.models.Users;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;

import java.util.List;

public interface UsersService {
    UsersResponse getAllUsers();
    UsersResponse getUserByEmailId(String email, String password);
    Users createUser(UsersRequest usersRequest);
    //void deleteUser(Integer id);
}
