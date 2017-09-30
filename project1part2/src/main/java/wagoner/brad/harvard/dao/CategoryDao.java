package wagoner.brad.harvard.dao;

import wagoner.brad.harvard.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * Return a list of all of the categories.
     *
     * @return
     */
    List<Category> getAllCategories();

    /**
     * Get the Category represented by the provided id.
     *
     * @param id
     * @return
     */
    Category getCategoryById(Long id);

    /**
     * Persist the provided Category and return the id assigned to it.
     *
     * @param category
     * @return
     */
    Long createCategory(Category category);

    /**
     * Align the persisted Category with the provided Category.
     *
     * @param category
     */
    void updateCategory(Category category);

    /**
     * Delete the Category represented by the id provided.
     *
     * @param categoryId
     */
    void deleteCategory(Long categoryId);
}
