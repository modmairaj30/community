package com.ve.community.services;

import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;

public interface UsersService {
    UsersResponse getAllUsers();
    UsersResponse getUserByEmailId(String email, String password);
    String createUser(UsersRequest usersRequest);
    //void deleteUser(Integer id);
}
