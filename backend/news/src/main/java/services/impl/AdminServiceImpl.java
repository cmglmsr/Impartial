package services.impl;

import model.Admin;
import model.BaseEntity;
import model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.AdminRepo;
import services.AdminService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    private PasswordEncoder encoder;

    public AdminServiceImpl(AdminRepo adminRepo, PasswordEncoder encoder) {
        this.adminRepo = adminRepo;
        this.encoder = encoder;
    }

    @Override
    public Admin findAdminByMail(String mail) {
        return adminRepo.findAdminByMail(mail);
    }

    @Override
    public Set<Admin> findAll() {
        Set<Admin> admins = new HashSet<>();
        adminRepo.findAll().forEach(admins::add);
        return admins;
    }

    @Override
    public Admin findById(Long aLong) {
        return adminRepo.findById(aLong).orElse(null);
    }

    @Override
    public Admin save(Admin object) {
        object.setPassword(encoder.encode(object.getPassword()));
        return adminRepo.save(object);
    }

    @Override
    public void delete(Admin object) {
        adminRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepo.deleteById(aLong);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findAdminByMail(username);
        return new UserDetailsImpl(admin);
    }
}
