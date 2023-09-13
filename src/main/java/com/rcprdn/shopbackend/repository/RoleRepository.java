package com.rcprdn.shopbackend.repository;

import com.rcprdn.shopbackend.entity.ERole;
import com.rcprdn.shopbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
