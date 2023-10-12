package services;

import model.User;

public interface UserService extends CrudBase<User, Long> {

    public User findUserByMail(String mail);

}
