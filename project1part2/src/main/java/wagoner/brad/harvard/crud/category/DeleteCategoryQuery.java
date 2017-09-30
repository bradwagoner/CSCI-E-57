package wagoner.brad.harvard.crud.category;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class DeleteCategoryQuery extends SqlUpdate {

    public static String query = "DELETE FROM category WHERE id = :id;";

    public DeleteCategoryQuery(DataSource dataSource) {
        super(dataSource, DeleteCategoryQuery.query);
        super.declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }
}
