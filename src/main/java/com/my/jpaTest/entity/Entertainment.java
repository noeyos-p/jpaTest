package com.my.jpaTest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entertainment {
    @Id
    private String entertainmentId;
    private String entertainmentName;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "entertainment", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<GirlGroup> girlGroups = new ArrayList<>();
}
