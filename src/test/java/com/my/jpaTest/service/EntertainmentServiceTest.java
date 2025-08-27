package com.my.jpaTest.service;

import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import com.my.jpaTest.entity.Member;
import com.my.jpaTest.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class EntertainmentServiceTest {
    @Autowired
    EntertainmentService entertainmentService;

    @Test
    @DisplayName("MemberAndTeam Insert Test")
    void initDataTest() {
        entertainmentService.initData();
    }

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("지수가 속한 걸그룹 이름과 엔터테인트 회사 이름 출력하기.")
    void findTeamNameAndEntertainmentName() {
        IdolMember jisu = em.find(IdolMember.class, "지수");
        System.out.println("팀 이름 : " + jisu.getGirlGroup().getGirlGroupName());
        System.out.println("소속사 이름 : " + jisu.getGirlGroup().getEntertainment().getEntertainmentName());
    }

    @Test
    @DisplayName("blackPink 멤버 리스트 출력하기.")
    void findBlackPinkMemberList() {
        GirlGroup girlGroup = em.find(GirlGroup.class, "blackPink");
        List<IdolMember> idolMembers = girlGroup.getIdolMembers();
        for (IdolMember m : idolMembers) {
            System.out.println(m.getIdolMemberName());
        }
    }
}