package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GirlGroup {
    @Id
    private String girlGroupId;
    private String girlGroupName;

    @ManyToOne
    @JoinColumn(name = "entertainmentId")
    private Entertainment entertainment;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "girlGroup", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<IdolMember> idolMembers = new ArrayList<>();
}
