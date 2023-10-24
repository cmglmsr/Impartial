package com.site.news.services.impl;

import com.site.news.model.BaseEntity;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.services.BaseEntityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BaseEntityServiceImpl implements BaseEntityService {

    private final BaseEntityRepo baseEntityRepo;

    public BaseEntityServiceImpl(BaseEntityRepo baseEntityRepo) {
        this.baseEntityRepo = baseEntityRepo;
    }

    @Override
    public Set<BaseEntity> findAll() {
        Set<BaseEntity> baseEntities = new HashSet<>();
        baseEntityRepo.findAll().forEach(baseEntities::add);
        return baseEntities;
    }

    @Override
    public BaseEntity findById(Long aLong) {
        Optional<BaseEntity> entity = baseEntityRepo.findById(aLong);
        return entity.orElse(null);
    }

    @Override
    public BaseEntity save(BaseEntity object) {
        return baseEntityRepo.save(object);
    }

    @Override
    public void delete(BaseEntity object) {
        baseEntityRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        baseEntityRepo.deleteById(aLong);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return baseEntityRepo.findByMail(username);
    }
}
