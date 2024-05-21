package com.example.sendemail.repository;

import com.example.sendemail.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Integer> {
}
