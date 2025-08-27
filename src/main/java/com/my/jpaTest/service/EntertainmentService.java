package com.my.jpaTest.service;

import com.my.jpaTest.entity.Entertainment;
import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EntertainmentService {
    @Autowired
    EntityManager em;

    public void initData() {
        Entertainment starship = Entertainment.builder()
                .entertainmentId("starship")
                .entertainmentName("스타쉽")
                .build();

        Entertainment yg = Entertainment.builder()
                .entertainmentId("YG")
                .entertainmentName("와이지")
                .build();

        GirlGroup ive = GirlGroup.builder()
                .girlGroupId("ive")
                .girlGroupName("아이브")
                .entertainment(starship)
                .build();

        GirlGroup blackPink = GirlGroup.builder()
                .girlGroupId("blackPink")
                .girlGroupName("블랙핑크")
                .entertainment(yg)
                .build();

        IdolMember ahn = IdolMember.builder()
                .idolMemberId("안유진")
                .idolMemberName("유진")
                .girlGroup(ive)
                .build();

        IdolMember jang = IdolMember.builder()
                .idolMemberId("장원영")
                .idolMemberName("원영")
                .girlGroup(ive)
                .build();

        IdolMember jeny = IdolMember.builder()
                .idolMemberId("제니")
                .idolMemberName("쩨니")
                .girlGroup(blackPink)
                .build();

        IdolMember jisu = IdolMember.builder()
                .idolMemberId("지수")
                .idolMemberName("지수다")
                .girlGroup(blackPink)
                .build();

        ahn.setGirlGroup(ive);
        jang.setGirlGroup(ive);
        jeny.setGirlGroup(blackPink);
        jeny.setGirlGroup(blackPink);

        ive.getIdolMembers().add(ahn);
        ive.getIdolMembers().add(jang);
        blackPink.getIdolMembers().add(jeny);
        blackPink.getIdolMembers().add(jisu);

        ive.setEntertainment(starship);
        blackPink.setEntertainment(yg);

        starship.getGirlGroups().add(ive);
        yg.getGirlGroups().add(blackPink);

        em.persist(starship);
        em.persist(yg);
    }
}
