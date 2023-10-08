package services;

import model.Visitor;

public interface VisitorService extends CrudBase<Visitor, Long>{
    public Visitor findByMail(String mail);

}
