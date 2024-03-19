package org.goit.hw16.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Configuration
public class SecurityConfig {

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.withUsername("user")
            .password("$2a$10$HYcEAgg9kjuX0GlHMSp33.Rm8j.gWVE.tuYcrBMc4/EnPiI3EtptS")
            .roles("USER")
            .build());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
