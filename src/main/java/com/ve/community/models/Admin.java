package com.ve.community.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="admin")
@Data
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
	 @Column(name="email")
	 		 
	 private String email;
	 @Column(name="mobile_no")
	 private String mobileNo;
	 @Column(name="username")
	 private String username;
	 @Column(name="activate")
	 private boolean activate;
	

}
