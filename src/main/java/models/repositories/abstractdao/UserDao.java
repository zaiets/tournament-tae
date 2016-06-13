package models.repositories.abstractdao;


import models.entity.site.User;
import models.repositories.IDao;

import java.util.List;


public abstract class UserDao implements IDao<User, Integer> {

    public abstract User read(int id);

    public abstract List<User> getAll();

    public abstract Integer create(User user);

    public abstract User update(int id, User user);

    public abstract User delete(int id);
}
