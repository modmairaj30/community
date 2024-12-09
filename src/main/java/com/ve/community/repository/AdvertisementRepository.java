package com.ve.community.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ve.community.models.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {

	Optional<Advertisement> findByIdAndDeletedFalse(Integer id);

	

}
