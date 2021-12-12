package net.javaguidesspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguidesspringboot.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
