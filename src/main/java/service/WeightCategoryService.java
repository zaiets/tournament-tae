package service;


import models.entity.basic.WeightCategory;

import java.util.List;


public interface WeightCategoryService {
    WeightCategory read(int id);
    List<WeightCategory> getAll();
}
