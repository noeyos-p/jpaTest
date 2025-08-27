package com.my.jpaTest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdolMember {
    @Id
    private String idolMemberId;
    private String idolMemberName;

    @ManyToOne
    @JoinColumn(name = "girlGroupId")
    private GirlGroup girlGroup;
}
