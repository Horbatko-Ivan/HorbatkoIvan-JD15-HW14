package org.goit.hw16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("checkstyle:MissingJavadocType")
@SpringBootApplication
public class HorbatkoIvanJd15Hw16Application {

  private static final Logger logger = LoggerFactory.getLogger(HorbatkoIvanJd15Hw16Application.class);

  public static void main(String[] args) {
    SpringApplication.run(HorbatkoIvanJd15Hw16Application.class, args);
    logger.info("Application has started successfully.");
  }
}
