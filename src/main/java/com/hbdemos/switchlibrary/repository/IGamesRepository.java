package com.hbdemos.switchlibrary.repository;

import com.hbdemos.switchlibrary.entity.SwitchGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGamesRepository extends JpaRepository<SwitchGameEntity, Long> {}
