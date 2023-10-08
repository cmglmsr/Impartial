package services.impl;

import model.Admin;
import org.springframework.stereotype.Service;
import repositories.AdminRepo;
import services.AdminService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
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
        object.getPassword();
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
}
