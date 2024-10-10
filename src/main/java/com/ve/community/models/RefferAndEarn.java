
package com.ve.community.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="reffer_earn")
public class RefferAndEarn {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="refferal_name")
	private String referralName;
	
	 @Column(name="user_email")
	 private String userEmail;
	    
	 @Column(name="user_id")
	 private String userId;
}
