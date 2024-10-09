package com.ve.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ve.community.models.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {

}
