package services;

import model.Admin;

public interface AdminService extends CrudBase<Admin, Long> {

    public Admin findAdminByMail(String mail);

}

