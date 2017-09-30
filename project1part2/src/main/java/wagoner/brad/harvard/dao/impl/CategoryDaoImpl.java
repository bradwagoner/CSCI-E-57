package wagoner.brad.harvard.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import wagoner.brad.harvard.crud.category.CreateCategoryQuery;
import wagoner.brad.harvard.crud.category.DeleteCategoryQuery;
import wagoner.brad.harvard.crud.category.GetAllCategoriesQuery;
import wagoner.brad.harvard.crud.category.GetCategoryByIdQuery;
import wagoner.brad.harvard.crud.category.UpdateCategoryQuery;
import wagoner.brad.harvard.dao.CategoryDao;
import wagoner.brad.harvard.domain.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CreateCategoryQuery createCategoryQuery;
    @Autowired
    private DeleteCategoryQuery deleteCategoryQuery;
    @Autowired
    private GetAllCategoriesQuery getAllCategoriesQuery;
    @Autowired
    private GetCategoryByIdQuery getCategoryByIdQuery;
    @Autowired
    private UpdateCategoryQuery updateCategoryQuery;

    /**
     * Return a list of all of the categories.
     *
     * @return
     */
    @Override
    public List<Category> getAllCategories() {
        return this.getGetAllCategoriesQuery().execute();
    }

    /**
     * Get the Category represented by the provided id.
     *
     * @param id
     * @return
     */
    @Override
    public Category getCategoryById(Long id) {
        Map<String, Object> parameterSource = new HashMap<>();
        parameterSource.put("categoryId", id);

        return this.getGetCategoryByIdQuery().findObjectByNamedParam(parameterSource);
    }

    /**
     * Persist the provided Category and return the id assigned to it.
     *
     * @param category
     * @return
     */
    @Override
    public Long createCategory(Category category) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        Map<String, Object> parameterSource = new HashMap<>();
        parameterSource.put("name", category.getName());

        this.getCreateCategoryQuery().updateByNamedParam(parameterSource, keyHolder);

        return keyHolder.getKey().longValue();
    }

    /**
     * Align the persisted Category with the provided Category.
     *
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        Map<String, Object> parameterSource = new HashMap<>();
        parameterSource.put("name", category.getName());
        parameterSource.put("id", category.getId());

        this.getUpdateCategoryQuery().updateByNamedParam(parameterSource);
    }

    /**
     * Delete the Category represented by the id provided.
     *
     * @param categoryId
     */
    @Override
    public void deleteCategory(Long categoryId) {
        Map<String, Object> parameterSource = new HashMap<>();
        parameterSource.put("id", categoryId);

        this.getDeleteCategoryQuery().updateByNamedParam(parameterSource);
    }

    public static Category getCategoryFromResultSet(ResultSet result) throws SQLException {
        Category category = new Category();

        category.setId(result.getLong("id"));
        category.setName(result.getString("name"));

        return category;
    }

    public CreateCategoryQuery getCreateCategoryQuery() {
        return createCategoryQuery;
    }

    public void setCreateCategoryQuery(CreateCategoryQuery createCategoryQuery) {
        this.createCategoryQuery = createCategoryQuery;
    }

    public DeleteCategoryQuery getDeleteCategoryQuery() {
        return deleteCategoryQuery;
    }

    public void setDeleteCategoryQuery(DeleteCategoryQuery deleteCategoryQuery) {
        this.deleteCategoryQuery = deleteCategoryQuery;
    }

    public GetAllCategoriesQuery getGetAllCategoriesQuery() {
        return getAllCategoriesQuery;
    }

    public void setGetAllCategoriesQuery(GetAllCategoriesQuery getAllCategoriesQuery) {
        this.getAllCategoriesQuery = getAllCategoriesQuery;
    }

    public GetCategoryByIdQuery getGetCategoryByIdQuery() {
        return getCategoryByIdQuery;
    }

    public void setGetCategoryByIdQuery(GetCategoryByIdQuery getCategoryByIdQuery) {
        this.getCategoryByIdQuery = getCategoryByIdQuery;
    }

    public UpdateCategoryQuery getUpdateCategoryQuery() {
        return updateCategoryQuery;
    }

    public void setUpdateCategoryQuery(UpdateCategoryQuery updateCategoryQuery) {
        this.updateCategoryQuery = updateCategoryQuery;
    }
}
