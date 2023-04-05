package com.hoteldream.account;

import com.hoteldream.domain.Business;
import com.hoteldream.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
