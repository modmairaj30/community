package com.ve.community.services;

import com.ve.community.models.Users;
import com.ve.community.payloads.request.UsersRequest;
import com.ve.community.payloads.response.UsersResponse;
import com.ve.community.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UsersResponse> getAllUsers() {

        List<Users> list_users = usersRepository.findAll();

        List<UsersResponse> list_res = list_users.stream()
                .map(user -> modelMapper.map(user, UsersResponse.class))
                .collect(Collectors.toList());
        return  list_res;
    }



    //@Override
    // public Users
    // public Users createUser(Users user) {
    //   return usersRepository.save(user);
    //  }


    @Override
    public Users createUser(UsersRequest usersRequest) {
      /*  Users user = modelMapper.map(usersRequest, Users.class);
        return usersRepository.save(user);*/
        return null;
    }



}