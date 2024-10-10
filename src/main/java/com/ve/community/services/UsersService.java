package com.ve.community.services;

import java.util.List;

import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;

public interface UsersService {
	 List<UsersResponse> getAllUsers();
    //UsersResponse getAllUsers();
    UsersResponse getUserByEmailId(String email, String password);
    String createUser(UsersRequest usersRequest);
    //void deleteUser(Integer id);
}
