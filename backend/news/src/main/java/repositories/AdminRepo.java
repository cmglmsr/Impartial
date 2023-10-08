package repositories;

import model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {

    public Admin findAdminByMail(String mail);

}
