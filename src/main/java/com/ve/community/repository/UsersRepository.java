package com.ve.community.repository;

import com.ve.community.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query(value = "SELECT u FROM Users u WHERE u.email=:email")
    Users findByEmail(@Param("email")String email);
}
