package com.example.team.service;

import com.example.team.dto.MentorInfoDto;
import com.example.team.dto.Position;
import com.example.team.model.Mentor;
import com.example.team.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService{

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    @Transactional
    public Long joinMentor(MentorInfoDto mentorInfoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        mentorInfoDto.setLoginPw(encoder.encode(mentorInfoDto.getLoginPw()));
        mentorInfoDto.setPosition(Position.MENTOR);
        return mentorRepository.save(mentorInfoDto.toEntity()).getMentorId();
    }

    @Transactional(readOnly = true)
    public boolean doubleCheckMentorId(String loginId) {
        Optional<Mentor> findMentor = mentorRepository.findByLoginId(loginId);
        return findMentor.isEmpty();
    }
}
