package com.mobileactionbootcamp.uincehw2.cty.dao;

import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CtyCityDao extends JpaRepository<CtyCity,Long> {
}
