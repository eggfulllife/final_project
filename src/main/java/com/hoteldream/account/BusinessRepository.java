package com.hoteldream.account;

import com.hoteldream.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByBuEmail(String email);
}
