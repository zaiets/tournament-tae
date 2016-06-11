package models.repositories.daos;


import models.entity.basic.WeightCategory;
import models.repositories.WeightCategoryDao;
import models.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeightCategoryDaoImpl extends WeightCategoryDao {
    public WeightCategoryDaoImpl() {}

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public WeightCategory read(int id) {
        return hibernateUtil.selectById(id, WeightCategory.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WeightCategory> getAll() {
        return hibernateUtil.selectAll(WeightCategory.class);
    }

}
