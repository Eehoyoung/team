package com.example.team.dto;

import com.example.team.model.Mentee;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenteeInfoDto {

    private Long menteeId;

    private String loginId;

    private String loginPw;

    private String name;

    private String email;

    private String phoneNumber;

    private Position position;

    @Builder
    public MenteeInfoDto (Long menteeId, String loginId, String loginPw, String name, String email, String phoneNumber, Position position){
        this.menteeId = menteeId;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
    }

    public Mentee toEntity(){
        return Mentee.builder()
                .menteeId(menteeId)
                .loginId(loginId)
                .loginPw(loginPw)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .position(position)
                .build();
    }
}
