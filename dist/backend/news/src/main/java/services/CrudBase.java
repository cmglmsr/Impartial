package services;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface CrudBase<T, ID> extends UserDetailsService {

        Set<T> findAll();

        T findById(ID id);

        T save(T object);

        void delete(T object);

        void deleteById(ID id);
}
