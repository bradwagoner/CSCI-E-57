package wagoner.brad.harvard.crud.category;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateCategoryQuery extends SqlUpdate {

    public static String query = "UPDATE category SET name = :name WHERE id = :id;";

    public UpdateCategoryQuery(DataSource dataSource) {
        super(dataSource, UpdateCategoryQuery.query);
        super.declareParameter(new SqlParameter("id", Types.BIGINT));
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        compile();
    }
}
