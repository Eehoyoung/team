package com.example.team.model;

import com.example.team.dto.Position;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long mentorId;

    @Column
    private String loginId;

    @Column
    private String loginPw;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private Position position;

    public Mentor(String name, String loginId, String loginPw) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    @Builder
    public Mentor(Long mentorId, String loginId, String loginPw, String name, String email, String phoneNumber,Position position) {
        this.mentorId = mentorId;
        this.loginId = loginId;
        this.name = name;
        this.loginPw = loginPw;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
    }
}
