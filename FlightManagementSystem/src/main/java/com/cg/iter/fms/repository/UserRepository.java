package com.cg.iter.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.iter.fms.dto.User;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);


}
