package com.ve.community.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="advertisement")
public class Advertisement {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 @Column(name="advertisement_Name")
	 private String advertisementName;
	 @Column(name="image_url")
	 private String imageUrl;
	 @Column(name="link")
	 private String link;
	 
	 
	

}
