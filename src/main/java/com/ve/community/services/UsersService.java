package com.ve.community.services;

import java.util.List;

import com.ve.community.models.LifePartnerProfile;
import com.ve.community.models.Users;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;

public interface UsersService {
	 List<UsersResponse> getAllUsers();
    //UsersResponse getAllUsers();
    UsersResponse getUserByEmailId(String email, String password);
    String createUser(UsersRequest usersRequest);
    void deleteUser(Integer id);
    void updateUser(Integer id, UsersRequest usersRequest);
    Users getUserById(Integer id);
}