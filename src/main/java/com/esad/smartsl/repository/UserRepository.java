package com.esad.smartsl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esad.smartsl.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {

//    @Query("select u.password from User u where u.id=:id")
//    String getUserPassword(@Param("id") int id);
//
	@Query("select u from User u where u.isDeleted = false and u.username like %:username% and u.email like %:email%")
	Page<User> searchUser(@Param("username") String username, @Param("email") String email, Pageable pageable);

	@Query("select u from User u where u.isDeleted = false and u.email = :email")
	User findByEmail(@Param("email") String email);

	@Modifying
	@Query("update User u set u.isDeleted = true where u.id = :id")
	void deleteUser(@Param("id") Integer id);

}
