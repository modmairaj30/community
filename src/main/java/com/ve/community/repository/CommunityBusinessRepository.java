package com.ve.community.repository;

import com.ve.community.models.CommunityBusiness;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityBusinessRepository extends JpaRepository<CommunityBusiness,Integer> {

	Optional<CommunityBusiness> findByCommunityIdNoAndDeletedFalse(Integer communityIdNo);
}
