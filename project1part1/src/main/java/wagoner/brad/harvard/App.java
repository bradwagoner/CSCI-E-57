package wagoner.brad.harvard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import wagoner.brad.harvard.domain.Category;

/**
 * CSCI E-57 Assignment-1.1 IoC/DI
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Running App.main()");

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/app-context.xml");
        context.refresh();

        Category romanceCategory = context.getBean("romanceCategory", Category.class);
        Category selfHelpCategory = context.getBean("selfHelpCategory", Category.class);
        Category dramaCategory = context.getBean("dramaCategory", Category.class);

        logger.info("Printing Category Set: \n" + selfHelpCategory.toString());
        logger.info("Printing Category List: \n" + romanceCategory.toString());
        logger.info("Printing Category Map: \n" + dramaCategory.toString());
    }
}
