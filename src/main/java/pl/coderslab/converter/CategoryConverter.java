package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryRepository categoryDao;

    @Override
    public Category convert(String source) {
        return categoryDao.findCategoryById(Long.parseLong(source));
    }
}
