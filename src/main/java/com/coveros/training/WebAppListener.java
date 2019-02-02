package com.coveros.training;

import com.coveros.training.persistence.PersistenceLayer;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppListener implements ServletContextListener {

  @Override
  public void contextInitialized ( ServletContextEvent sce ) {
    Flyway flyway = Flyway.configure()
        .schemas("ADMINISTRATIVE", "LIBRARY", "AUTH")
        .dataSource("jdbc:h2:~/training", "sa", "sa")
        .load();
    flyway.clean();
    flyway.migrate();

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // do nothing
  }

}