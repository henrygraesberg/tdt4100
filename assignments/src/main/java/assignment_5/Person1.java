package assignment_5;

public class Person1 implements Named {
  private String givenName, familyName;

  public Person1(String givenName, String familyName) {
    this.givenName = givenName;
    this.familyName = familyName;
  }

  public void setGivenName(String name) {
    this.givenName = name;
  }

  public void setFamilyName(String name) {
    this.familyName = name;
  }

  public void setFullName(String name) {
    String[] nameSplit = name.split(" ");

    this.givenName = nameSplit[0];
    this.familyName = nameSplit[1];
  }

  public String getGivenName() {
    return this.givenName;
  }

  public String getFamilyName() {
    return this.familyName;
  }

  public String getFullName() {
    return this.givenName + " " + this.familyName;
  }
}
