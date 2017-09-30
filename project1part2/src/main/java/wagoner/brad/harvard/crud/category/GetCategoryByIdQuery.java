package wagoner.brad.harvard.crud.category;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import wagoner.brad.harvard.dao.impl.BookDaoImpl;
import wagoner.brad.harvard.dao.impl.CategoryDaoImpl;
import wagoner.brad.harvard.domain.Book;
import wagoner.brad.harvard.domain.Category;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class GetCategoryByIdQuery extends MappingSqlQuery<Category> {

    public static String query = "SELECT id, name"
            + " FROM category "
            + "WHERE category.id = :categoryId";

    public GetCategoryByIdQuery(DataSource dataSource) {
        super(dataSource, GetCategoryByIdQuery.query);
        super.declareParameter(new SqlParameter("categoryId", Types.BIGINT));
        compile();
    }

    @Override
    protected Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CategoryDaoImpl.getCategoryFromResultSet(rs);
    }
}
