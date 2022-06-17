package com.mobileactionbootcamp.uincehw2.adr.entity;

import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ADDRESS")
@Entity
public class AdrAddress {
    @Id
    @SequenceGenerator(name = "AdrAddress", sequenceName = "ADR_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AdrAddress")
    private Long id;


    /**
     * ManyToOne relations does not have CascadeType.REMOVE
     * in order to prevent cascading unwanted deletions when an adress
     * gets deleted from the ADDRESS table.
     * */


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.DETACH,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "FK_COUNTRY")
    private CntCountry country;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.DETACH,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "FK_CITY")
    private CtyCity city;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.DETACH,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "FK_DISTRICT")
    private DstDistrict district;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.DETACH,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "FK_NEIGHBORHOOD")
    private NeiNeighborhood neighborhood;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
                                                    CascadeType.MERGE,
                                                    CascadeType.DETACH,
                                                    CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    @JoinColumn(name = "FK_STREET")
    private StrStreet street;

    @Column(name = "APARTMENT_NUMBER", length = 30, nullable = false)
    private Long apartmentNumber;

    @Column(name = "DOOR_NUMBER", length = 30, nullable = false)
    private Long doorNumber;

}
