package com.esad.smartsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esad.smartsl.domain.entity.UserRole;
import com.esad.smartsl.enums.UserRoleName;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>, QuerydslPredicateExecutor<UserRole> {

	@Modifying
	@Query("update UserRole ur set ur.isDeleted = true where ur.id = :id")
	void deleteUserRole(@Param("id") Integer id);

	@Query("select ur from UserRole ur where ur.isDeleted = false and ur.name = :name")
	UserRole checkUserRoleExistByName(@Param("name") UserRoleName name);

}
