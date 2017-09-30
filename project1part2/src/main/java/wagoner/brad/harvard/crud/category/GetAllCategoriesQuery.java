package wagoner.brad.harvard.crud.category;

import org.springframework.jdbc.object.MappingSqlQuery;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.dao.impl.CategoryDaoImpl;
import wagoner.brad.harvard.domain.Book;
import wagoner.brad.harvard.domain.Category;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllCategoriesQuery extends MappingSqlQuery<Category> {

    public static String query = "SELECT id, name"
            + " FROM category";

    public GetAllCategoriesQuery(DataSource dataSource) {
        super(dataSource, GetAllCategoriesQuery.query);
        compile();
    }

    @Override
    protected Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CategoryDaoImpl.getCategoryFromResultSet(rs);
    }
}
