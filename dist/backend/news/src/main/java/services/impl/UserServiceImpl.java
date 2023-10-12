package services.impl;

import model.User;
import model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.UserRepo;
import services.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    private final PasswordEncoder encoder;
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        return userRepo.findById(aLong).orElse(null);
    }

    @Override
    public User save(User object) {
        object.setPassword(encoder.encode(object.getPassword()));
        return userRepo.save(object);
    }

    @Override
    public void delete(User object) {
        userRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Override
    public User findUserByMail(String mail) {
        return userRepo.findUserByMail(mail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByMail(username);
        return new UserDetailsImpl(user);
    }
}
