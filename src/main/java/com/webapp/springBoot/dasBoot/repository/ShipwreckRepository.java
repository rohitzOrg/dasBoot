package com.webapp.springBoot.dasBoot.repository;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.springBoot.dasBoot.entity.ShipwreckTable;

@Repository
@Qualifier(value = "shipwreckRepository")
public interface ShipwreckRepository extends JpaRepository<ShipwreckTable, Long>{
//for ShipwreckTable
}