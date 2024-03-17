package org.goit.hw15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("checkstyle:MissingJavadocType")
@SpringBootApplication
public class HorbatkoIvanJd15Hw14Application {

  private static final Logger logger = LoggerFactory.getLogger(HorbatkoIvanJd15Hw14Application.class);

  public static void main(String[] args) {
    SpringApplication.run(HorbatkoIvanJd15Hw14Application.class, args);
    logger.info("Application has started successfully.");
  }
}
