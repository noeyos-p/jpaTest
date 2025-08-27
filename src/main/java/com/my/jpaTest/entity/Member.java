package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String memberId;
    private String name;

    // 팀 정보를 갖는 연관관계를 구성
    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", team=" + team.getTeamName() +
                '}';
    }
}