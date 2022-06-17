package com.mobileactionbootcamp.uincehw2.dst.entity;

import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "DISTRICT")
@Entity
public class DstDistrict {
    @Id
    @SequenceGenerator(name = "DstDistrict", sequenceName = "DST_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "DstDistrict")
    private Long id;

    @Column(name = "DISTRICT_NAME" ,length = 30, nullable = false)
    private String districtName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CITY")
    private CtyCity city;
}
