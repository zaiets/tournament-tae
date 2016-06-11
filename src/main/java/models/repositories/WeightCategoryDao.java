package models.repositories;


import models.entity.basic.WeightCategory;

import java.util.List;


public abstract class WeightCategoryDao implements IDao<WeightCategory> {
    public abstract WeightCategory read(int id);

    public abstract List<WeightCategory> getAll();


    /*
     * данные штуки понадобятся позже для административного управления
     */

    @Override
    public WeightCategory create(WeightCategory weightCategory) {
        //denied
        throw new Error();
    }

    @Override
    public WeightCategory update(int id, WeightCategory weightCategory) {
        //denied
        throw new Error();
    }

    @Override
    public WeightCategory delete(int id) {
        //denied
        throw new Error();
    }
}
