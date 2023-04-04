package com.hoteldream.review;

import com.hoteldream.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReport(int report);
}

