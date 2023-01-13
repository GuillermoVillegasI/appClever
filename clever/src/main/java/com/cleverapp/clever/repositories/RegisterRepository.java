package com.cleverapp.clever.repositories;

import com.cleverapp.clever.entities.Register;
import com.cleverapp.clever.entities.enumeration.BusinessLocation;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

    @Transactional
    @Query("SELECT r FROM Register r WHERE r.date >= :dateFrom AND r.date <= :dateTo  AND ( r.employee.firstName LIKE :descriptionFilter OR r.employee.lastName LIKE  :descriptionFilter ) AND r.businessLocation = :businessLocation ")
    List<Register> findByDateBetweenWithFilter(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("descriptionFilter") String descriptionFilter, @Param("businessLocation") BusinessLocation businessLocation);

    @Transactional
    @Query("SELECT r FROM Register r WHERE r.date >= :dateFrom AND r.date <= :dateTo AND r.businessLocation = :businessLocation ")
    List<Register> findByDateBetween(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("businessLocation") BusinessLocation businessLocation);

}
