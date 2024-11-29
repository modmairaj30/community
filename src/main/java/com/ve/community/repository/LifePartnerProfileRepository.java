package com.ve.community.repository;

import com.ve.community.models.LifePartnerProfile;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LifePartnerProfileRepository extends JpaRepository<LifePartnerProfile,Integer> {
	Optional<LifePartnerProfile> findByCommunityIdNoAndDeletedFalse(Integer communityIdNo);
}
