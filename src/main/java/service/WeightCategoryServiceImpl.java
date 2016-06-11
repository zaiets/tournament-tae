package service;

import models.entity.basic.WeightCategory;
import models.repositories.WeightCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WeightCategoryServiceImpl implements WeightCategoryService {

    public WeightCategoryServiceImpl() {

    }

    @Autowired
    private WeightCategoryDao weightCategoryDao;

    @Override
    public WeightCategory read(int id) {
        return weightCategoryDao.read(id);
    }

    @Override
    public List<WeightCategory> getAll() {
        return weightCategoryDao.getAll();
    }
}
