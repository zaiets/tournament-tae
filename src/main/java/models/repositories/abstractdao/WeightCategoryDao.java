package models.repositories.abstractdao;


import models.entity.basic.WeightCategory;
import models.repositories.IDao;

import java.util.List;


public abstract class WeightCategoryDao implements IDao<WeightCategory, Integer> {

    public abstract WeightCategory read(int id);

    public abstract List<WeightCategory> getAll();


    /*
     * данные штуки возможно понадобятся позже для административного управления?
     */

    @Override
    final public Integer create(WeightCategory weightCategory) {
        //denied
        throw new Error();
    }

    @Override
    final public WeightCategory update(int id, WeightCategory weightCategory) {
        //denied
        throw new Error();
    }

    @Override
    final public WeightCategory delete(int id) {
        //denied
        throw new Error();
    }
}
