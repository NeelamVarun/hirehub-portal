package com.srm.hirehub.hirehub_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.srm.hirehub.hirehub_portal.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
	
	
	@Query(value = "select * from user where email= :email and password=:password", nativeQuery = true)
	public UserEntity getUserByMailAndPassword(String email, String password);
	
	@Query(value = "select * from user where email = :email",nativeQuery = true)
	public UserEntity getUserByEmail(String email);

}
