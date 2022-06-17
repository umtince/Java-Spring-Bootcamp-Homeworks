package com.mobileactionbootcamp.uincehw2.cty.entity;

import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "CITY")
@Entity
public class CtyCity {
    @Id
    @SequenceGenerator(name = "CtyCity", sequenceName = "CTY_CITY_ID_SEQ")
    @GeneratedValue(generator = "CtyCity")
    private Long id;

    @Column(name = "CITY_NAME", length = 30, nullable = false)
    private String cityName;

    @Column(name = "PLATE_NUMBER", length = 30, nullable = false)
    private Long plateNumber;

    //fetchType.EAGER is required to make sure findByPlateNumber() works.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_COUNTRY")
    private CntCountry country;
}
