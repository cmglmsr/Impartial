package services.impl;

import model.UserDetailsImpl;
import model.Visitor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.VisitorRepo;
import services.VisitorService;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepo visitorRepo;

    private final PasswordEncoder encoder;
    public VisitorServiceImpl(VisitorRepo visitorRepo, PasswordEncoder encoder) {
        this.visitorRepo = visitorRepo;
        this.encoder = encoder;
    }

    @Override
    public Set<Visitor> findAll() {
        Set<Visitor> visitors = new HashSet<>();
        visitorRepo.findAll().forEach(visitors::add);
        return visitors;
    }

    @Override
    public Visitor findById(Long aLong) {
        return visitorRepo.findById(aLong).orElse(null);
    }

    @Override
    public Visitor save(Visitor object) {
        object.setPassword(encoder.encode(object.getPassword()));
        return visitorRepo.save(object);
    }

    @Override
    public void delete(Visitor object) {
        visitorRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitorRepo.deleteById(aLong);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Visitor visitor = visitorRepo.findByMail(username);
        return new UserDetailsImpl(visitor);
    }

    @Override
    public Visitor findByMail(String mail) {
        return visitorRepo.findByMail(mail);
    }
}
