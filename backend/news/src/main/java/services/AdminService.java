package services;

import model.Admin;

public interface AdminService extends services.CrudBase<Admin, Long> {

    public Admin findAdminByMail(String mail);

}

