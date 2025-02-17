package assignment_5;

public class Person2 implements Named {
  private String name;

  public Person2(String name) {
    this.name = name;
  }

  public void setGivenName(String name) {
    this.name = name + " " + this.name.split(" ")[1];
  }

  public void setFamilyName(String name) {
    this.name = this.name.split(" ")[0] + " " + name;
  }

  public void setFullName(String name) {
    this.name = name;
  }

  public String getGivenName() {
    return this.name.split(" ")[0];
  }

  public String getFamilyName() {
    return this.name.split(" ")[1];
  }

  public String getFullName() {
    return this.name;
  }
}
