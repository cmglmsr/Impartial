package services.impl;

import model.Visitor;
import org.springframework.stereotype.Service;
import repositories.VisitorRepo;
import services.VisitorService;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepo visitorRepo;

    public VisitorServiceImpl(VisitorRepo visitorRepo) {
        this.visitorRepo = visitorRepo;
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
}
