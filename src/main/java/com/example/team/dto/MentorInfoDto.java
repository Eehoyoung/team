package com.example.team.dto;

import com.example.team.model.Mentee;
import com.example.team.model.Mentor;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MentorInfoDto {

    private Long mentorId;

    private String loginId;

    private String loginPw;

    private String name;

    private String email;

    private String phoneNumber;

    private Position position;

    @Builder
    public MentorInfoDto (Long mentorId, String loginId, String loginPw, String name, String email, String phoneNumber, Position position){
        this.mentorId = mentorId;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;

    }

    public Mentor toEntity(){
        return Mentor.builder()
                .mentorId(mentorId)
                .loginId(loginId)
                .loginPw(loginPw)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .position(position)
                .build();
    }
}
