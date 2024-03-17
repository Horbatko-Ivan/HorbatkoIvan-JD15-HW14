package org.goit.hw15.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Controller
public class TestController {

  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  @GetMapping("/test")
  public String test() {
    logger.info("Accessing test page.");
    return "test";
  }
}
