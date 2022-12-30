package com.hbdemos.switchlibrary.repository;

import com.hbdemos.switchlibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<UserEntity, Long> {}
