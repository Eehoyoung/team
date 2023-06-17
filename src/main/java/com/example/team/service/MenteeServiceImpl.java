package com.example.team.service;

import com.example.team.dto.MenteeInfoDto;
import com.example.team.dto.Position;
import com.example.team.model.Mentee;
import com.example.team.repository.MenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MenteeServiceImpl implements MenteeService{

    private final MenteeRepository menteeRepository;

    @Autowired
    public MenteeServiceImpl(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    @Override
    @Transactional
    public Long joinMentee(MenteeInfoDto menteeInfoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        menteeInfoDto.setLoginPw(encoder.encode(menteeInfoDto.getLoginPw()));
        menteeInfoDto.setPosition(Position.MENTEE);
        return menteeRepository.save(menteeInfoDto.toEntity()).getMenteeId();
    }

    @Transactional(readOnly = true)
    public boolean doubleCheckMenteeId(String loginId) {
        Optional<Mentee> findMentee = menteeRepository.findByLoginId(loginId);
        return !findMentee.isPresent();
    }

}
