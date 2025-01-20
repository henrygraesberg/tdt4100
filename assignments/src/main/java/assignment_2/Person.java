package assignment_2;

import java.util.Date;

public class Person {
  private String name, email;
  private Date birthday;
  private char gender;

  public Person(String name, String email, Date birthday, char Gender) {
    setName(name);
    setEmail(email);
    setBirthday(birthday);
    setGender(gender);
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public char getGender() {
    return this.gender;
  }

  public void setName(String name) {
    String[] nameSplit = name.split(" ");
    
    if(nameSplit.length != 2) throw new IllegalArgumentException("Name must consist of first and last name");

    this.name = name;
  }

  public void setEmail(String email) {
    if(email == null) {
      this.email = email;
      return;
    }

    IllegalArgumentException argumentError = new IllegalArgumentException("Email must match the format firstname.lastname@domain.countrycode");

    String[] emailSplit = email.split("@");
    boolean isTwoAts = emailSplit.length == 2;

    if(!isTwoAts) throw argumentError;

    String[] emailNameSplit = emailSplit[0].split(".");
    String[] personNameSplit = this.name.split(" ");
    boolean isTwoNames = emailNameSplit.length == 2;
    boolean firstNameMatches = emailNameSplit[0].equals(personNameSplit[0]);
    boolean lastNameMatches = emailNameSplit[1].equals(personNameSplit[1]);

    if(!(isTwoNames && firstNameMatches && lastNameMatches))
      throw argumentError;
    
    String[] ccTLDs = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};

    String[] domainSplit = emailSplit[1].split(".");
    boolean hasTLD = false;

    for (String tld : ccTLDs) {
      if(tld.equals(domainSplit[domainSplit.length - 1])) {
        hasTLD = true;
        break;
      }
    }

    if(!hasTLD) throw argumentError;

    this.email = email;
  }

  public void setBirthday(Date birthday) {
    Date today = new Date();

    if(birthday.after(today))
      throw new IllegalArgumentException("Birthday cannot be after the current time");
    
    this.birthday = birthday;
  }

  public void setGender(char gender) {
    
  }
}
