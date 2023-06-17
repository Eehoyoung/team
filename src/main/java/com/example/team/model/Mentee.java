package com.example.team.model;

import com.example.team.dto.Position;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PipedReader;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mentee")
public class Mentee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long menteeId;

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
    public Mentee(String name, String loginId, String loginPw) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    @Builder
    public Mentee(Long menteeId, String loginId, String loginPw, String name, String email, String phoneNumber, Position position) {
        this.menteeId = menteeId;
        this.loginId = loginId;
        this.name = name;
        this.loginPw = loginPw;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
    }

}
