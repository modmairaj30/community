package com.ve.community.services;

import com.ve.community.models.PermanentAddress;
import com.ve.community.models.PresentAddress;
import com.ve.community.models.ProfessionalDetails;
import com.ve.community.models.Users;
import com.ve.community.payloads.request.*;
import com.ve.community.payloads.response.UsersResponse;
import com.ve.community.repository.PermanentAddressRepository;
import com.ve.community.repository.PresentAddressRepository;
import com.ve.community.repository.ProfessionalDetailsRepository;
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
    public List<UsersResponse> getAllUsers() {

        List<Users> list_users = usersRepository.findAll();

        List<UsersResponse> list_res = list_users.stream()
                .map(user -> modelMapper.map(user, UsersResponse.class))
                .collect(Collectors.toList());
        return  list_res;
    }
//    @Override
//    public UsersResponse getAllUsers() {
//
//        List<Users> list_users = usersRepository.findAll();
//
//        UsersResponse list_res = (UsersResponse) list_users.stream()
//                .map(user -> modelMapper.map(user, UsersResponse.class))
//                .collect(Collectors.toList());
//        System.out.println("User :"+ list_users);
//        return  list_res;
//    }

    @Override
    public UsersResponse getUserByEmailId(String email, String password) {
        Users user = usersRepository.findByEmail(email);
        if(user==null) {
        	return null;
        }
        UsersResponse usersResponse = modelMapper.map(user, UsersResponse.class);
        return usersResponse;
    }

/*
 * @Override public String createUser(UsersRequest usersRequest) { Users user =
 * modelMapper.map(usersRequest, Users.class); Users user1=
 * usersRepository.save(user); String res=""; if(user1!=null) {
 * res="Data Save Successfully"; } else { res="Fail to Save Data"; }
 * System.out.println("User1 : "+ user1); return res;
 * 
 * 
 * }}
 */
   
    @Override
    public String createUser(UsersRequest usersRequest) {
        // Directly map the request object to the user entity using ModelMapper
        Users user = modelMapper.map(usersRequest, Users.class);

        // Save the user
        Users savedUser = usersRepository.save(user);

        // Return result
        return savedUser != null ? "Data Saved Successfully" : "Failed to Save Data";
    }

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Users existingUser = usersRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
		    
		    usersRepository.delete(existingUser);
	}

	@Override
	public void updateUser(Integer id, UsersRequest usersRequest) {
		Users existinguser = usersRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
		    
		    // Use ModelMapper to map updated fields from the request to the existing entity
		    modelMapper.map(usersRequest, existinguser);

		    // Save the updated entity
		    usersRepository.save(existinguser);
		
	}

	@Override
	public Users getUserById(Integer id) {
		return usersRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("user not found for ID: " + id));


	
	}}


