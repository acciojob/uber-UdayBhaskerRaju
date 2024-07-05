package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.driver.model.Cab;

import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

    @Query(value = "select * from cab where available = true limit 1", nativeQuery = true)
    Optional<Cab> getRandomAvailableCab();

}
