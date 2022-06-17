package com.mobileactionbootcamp.uincehw2.adr.dao;

import com.mobileactionbootcamp.uincehw2.adr.entity.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrAddressDao extends JpaRepository<AdrAddress,Long> {
}
