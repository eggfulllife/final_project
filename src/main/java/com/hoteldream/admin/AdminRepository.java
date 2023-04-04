package com.hoteldream.admin;

import com.hoteldream.domain.Admin;
import com.hoteldream.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAdminIDAndAdminPW(Long adminID, String adminPW);


}
