package com.hbdemos.switchlibrary.repository;

import com.hbdemos.switchlibrary.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICheckoutsRepository extends JpaRepository<CheckoutEntity, Long> {}
