package com.hefshine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.entity.AdminRegi;

public interface AdminRegiRepository extends JpaRepository<AdminRegi, Integer> {
	Optional<AdminRegi> findOneByEmailAndPassword(String email, String password);
	AdminRegi findByEmail(String email);
}
