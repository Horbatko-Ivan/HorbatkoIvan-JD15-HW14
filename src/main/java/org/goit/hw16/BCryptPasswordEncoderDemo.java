package org.goit.hw16;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings({"checkstyle:MissingJavadocType", "checkstyle:AbbreviationAsWordInName"})
public class BCryptPasswordEncoderDemo {

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public static void main(String[] args) {
    String password = "jdbcDefault";
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode(password);

    System.out.println("Original password: " + password);
    System.out.println("Hashed password: " + hashedPassword);
  }
}
