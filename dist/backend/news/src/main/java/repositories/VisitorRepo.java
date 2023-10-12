package repositories;

import model.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends CrudRepository<Visitor, Long> {
    public Visitor findByMail(String mail);
}
