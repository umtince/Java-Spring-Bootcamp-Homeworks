package com.mobileactionbootcamp.uincehw2.str.entity;

import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "STREET")
@Entity
public class StrStreet {
    @Id
    @SequenceGenerator(name = "StrStreet", sequenceName = "STR_STREET_ID_SEQ")
    @GeneratedValue(generator = "StrStreet")
    private Long id;

    @Column(name = "STREET_NAME", length = 30, nullable = false)
    private String streetName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_NEIGHBORHOOD")
    private NeiNeighborhood neighborhood;

}
