package com.mobileactionbootcamp.uincehw2.nei.entity;

import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "NEIGHBORHOOD")
@Entity
public class NeiNeighborhood {
    @Id
    @SequenceGenerator(name = "NeiNeighborhood", sequenceName = "NEI_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "NeiNeighborhood")
    private Long id;

    @Column(name = "NEIGHBORHOOD_NAME", length = 30, nullable = false)
    private String neighborhoodName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_DISTRICT")
    private DstDistrict district;

}
