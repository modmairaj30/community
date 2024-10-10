package com.ve.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ve.community.models.Admin;



public interface AdminRepository extends JpaRepository<Admin,Integer> {

}