package com.ve.community.repository;

import com.ve.community.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
