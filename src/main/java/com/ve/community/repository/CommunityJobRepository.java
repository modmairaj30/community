package com.ve.community.repository;

import com.ve.community.models.CommunityJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CommunityJobRepository extends JpaRepository<CommunityJob,Integer> {


    Optional<CommunityJob> findByCommunityIdNoAndIsDeletedFalse(Integer communityIdNo);
}
