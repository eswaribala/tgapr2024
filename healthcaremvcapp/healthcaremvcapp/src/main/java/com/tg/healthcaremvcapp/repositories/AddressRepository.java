package com.tg.healthcaremvcapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.healthcaremvcapp.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
