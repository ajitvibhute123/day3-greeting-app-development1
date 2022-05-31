package com.bz.greetingappdevelopment.repository;

import com.bz.greetingappdevelopment.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<User,Long> {

}