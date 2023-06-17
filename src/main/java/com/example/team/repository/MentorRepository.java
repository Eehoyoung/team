package com.example.team.repository;

import com.example.team.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor,Long> {

    Optional<Mentor> findByLoginId(String loginId);

}
