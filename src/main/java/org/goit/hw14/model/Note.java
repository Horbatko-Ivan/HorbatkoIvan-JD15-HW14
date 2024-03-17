package org.goit.hw14.model;

import lombok.Getter;

@Getter
@SuppressWarnings("checkstyle:MissingJavadocType")
public class Note {

  private Long id;
  private String title;
  private String content;

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
