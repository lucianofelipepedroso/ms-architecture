package com.luciano.felipe.arqoauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.felipe.arqoauth.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Permission findByDescription(String description);
}
