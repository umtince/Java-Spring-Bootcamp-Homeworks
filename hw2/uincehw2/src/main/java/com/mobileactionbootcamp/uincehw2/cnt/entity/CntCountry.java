package com.mobileactionbootcamp.uincehw2.cnt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "COUNTRY")
public class CntCountry {
    @Id
    @SequenceGenerator(name = "CntCountry", sequenceName = "CNT_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "CntCountry")
    private Long id;

    @Column(name = "COUNTRY_NAME", length = 30, nullable = false)
    private String countryName;

    @Column(name = "COUNTRY_CODE", length = 30, nullable = false)
    private String countryCode;

}
