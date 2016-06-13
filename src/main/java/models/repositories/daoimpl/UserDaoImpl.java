package models.repositories.daoimpl;


import models.entity.site.User;
import models.repositories.abstractdao.UserDao;
import models.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public final class UserDaoImpl extends UserDao {
    @Autowired
    private HibernateUtil hibernateUtil;

    public UserDaoImpl () {    }

    @Override
    public User read(int id) {
        return hibernateUtil.selectById(id, User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        return hibernateUtil.selectAll(User.class);
    }

    @Override
    public Integer create(User user) {
        return (Integer)hibernateUtil.create(user);
    }

    @Override
    public User update(int id, User user) {
        return hibernateUtil.update(user);
    }

    @Override
    public User delete(int id) {
        return hibernateUtil.delete(id, User.class);
    }
}
