package com.example.team.repository;

import com.example.team.model.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MenteeRepository extends JpaRepository<Mentee, Long> {

    Optional<Mentee> findByLoginId(String loginId);

}
