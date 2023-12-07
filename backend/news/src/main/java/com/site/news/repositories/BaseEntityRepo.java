package com.site.news.repositories;

import com.site.news.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepo extends JpaRepository<BaseEntity, Long> {
    BaseEntity findByMail(String mail);
}
