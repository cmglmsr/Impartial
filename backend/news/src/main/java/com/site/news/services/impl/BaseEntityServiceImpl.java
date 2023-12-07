package com.site.news.services.impl;

import com.site.news.enums.UserType;
import com.site.news.model.Admin;
import com.site.news.model.BaseEntity;
import com.site.news.model.User;
import com.site.news.repositories.AdminRepo;
import com.site.news.repositories.BaseEntityRepo;
import com.site.news.repositories.UserRepo;
import com.site.news.services.BaseEntityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BaseEntityServiceImpl implements BaseEntityService {

    private final BaseEntityRepo baseEntityRepo;
    private final UserRepo userRepo;
    private final AdminRepo adminRepo;

    public BaseEntityServiceImpl(BaseEntityRepo baseEntityRepo, UserRepo userRepo, AdminRepo adminRepo) {
        this.baseEntityRepo = baseEntityRepo;
        this.userRepo = userRepo;
        this.adminRepo = adminRepo;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        object.setPassword(encoder.encode(object.getPassword()));
        switch (object.getType()){
            case ROLE_USER:
                User user = new User(object.getId(), object.getMail(), object.getPassword(), object.getType());
                return userRepo.save(user);
            case ROLE_ADMIN:
                Admin admin = new Admin(object.getId(), object.getMail(), object.getPassword(), object.getType());
                return adminRepo.save(admin);
            default:
                return baseEntityRepo.save(object);
        }
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
