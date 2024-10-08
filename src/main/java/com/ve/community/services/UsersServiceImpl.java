package com.ve.community.services;

import com.ve.community.models.PermanentAddress;
import com.ve.community.models.PresentAddress;
import com.ve.community.models.ProfessionalDetails;
import com.ve.community.models.Users;
import com.ve.community.payloads.request.*;
import com.ve.community.payloads.response.UsersResponse;
import com.ve.community.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;



    // @Override
    //public List<Users> getAllUsers() {
  /*  @Override
    public List<UsersResponse> getAllUsers() {
        ModelMapper modelMapper= new ModelMapper();
        List<Users> list_users=usersRepository.findAll();
        List<UsersResponse> list_res =new ArrayList<>();
        modelMapper.map(modelMapper,list_res);
        return list_res;
    }*/
    // }
    @Override
    public UsersResponse getAllUsers() {

        List<Users> list_users = usersRepository.findAll();

        UsersResponse list_res = (UsersResponse) list_users.stream()
                .map(user -> modelMapper.map(user, UsersResponse.class))
                .collect(Collectors.toList());
        System.out.println("User :"+ list_users);
        return  list_res;
    }

    @Override
    public UsersResponse getUserByEmailId(String email, String password) {
        Users user = usersRepository.findByEmail(email)
                ;
        UsersResponse usersResponse = modelMapper.map(user, UsersResponse.class);
        return usersResponse;
    }
    @Override
    public String createUser(UsersRequest usersRequest) {
        Users user = modelMapper.map(usersRequest, Users.class);
        Users user1= usersRepository.save(user);
        String res="";
        if(user1!=null) {
        	res="Data Save Successfully";
        }
        else {
        	res="Fail to Save Data";
        }
        System.out.println("User1 : "+ user1);
        return res;
        }

    }



