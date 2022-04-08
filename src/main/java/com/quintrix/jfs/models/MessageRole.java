package com.quintrix.jfs.models;

public class MessageRole {

  private String message;
  private String role;


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "MessageRole [message=" + message + ", role=" + role + "]";
  }


}
