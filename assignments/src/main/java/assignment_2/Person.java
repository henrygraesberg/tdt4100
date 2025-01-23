package assignment_2;

import java.util.Calendar;
import java.util.Date;

public class Person {
  private String name, email, ssn;
  private Date birthday;
  private char gender;

  public Person() {}
  public Person(String name, String email, Date birthday, char gender) {
    setName(name);
    setEmail(email);
    setBirthday(birthday);
    setGender(gender);
  }
  public Person(String name, String email, Date birthday, char gender, String ssn) {
    this(name, email, birthday, gender);
    this.setSSN(ssn);
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

  public String getSSN() {
    return this.ssn;
  }

  public void setName(String name) {
    String[] nameSplit = name.split(" ");
    
    if(nameSplit.length != 2) throw new IllegalArgumentException("Name must consist of first and last name");
    for (String nameString : nameSplit) {
      if(nameString.length() < 2) throw new IllegalArgumentException("First and last name must be at least 2 characters long each");
      
      if(!nameString.matches("[a-zA-Z]+")) throw new IllegalArgumentException("Names must consist only of letters");
    }

    this.name = name;
  }

  public void setEmail(String email) {
    if(email == null) {
      this.email = email;
      return;
    }

    IllegalArgumentException argumentError = new IllegalArgumentException("Email must match the format firstname.lastname@domain.countrycode");

    String[] emailSplit = email.split("@");
    boolean hasAt = emailSplit.length == 2;

    if(!hasAt) throw argumentError;


    String[] emailNameSplit = emailSplit[0].split("\\.");
    String[] personNameSplit = this.name.split(" ");
    boolean isTwoNames = emailNameSplit.length == 2;

    if(!isTwoNames) throw new IllegalArgumentException();

    boolean firstNameMatches = emailNameSplit[0].equals(personNameSplit[0].toLowerCase());
    boolean lastNameMatches = emailNameSplit[1].equals(personNameSplit[1].toLowerCase());

    if(!(firstNameMatches && lastNameMatches)) throw argumentError;
    
    String[] ccTLDs = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};

    String[] domainSplit = emailSplit[1].split("\\.");
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
    char[] validGender = {'M', 'F', '\0'};
    boolean valid = false;

    for (char c : validGender) {
      if(c == gender) valid = true;
    }

    if(!valid) throw new IllegalArgumentException("Gender must be M, F or null (\\n)");

    this.gender = gender;
  }

  private int weightedSum(int[] numbers, int[] weights) {
    if(numbers.length != weights.length)
      throw new IllegalArgumentException("Numbers array and weights array must be the same length");
    
    int sum = 0;

    for(int i = 0; i < numbers.length; i++) {
      sum += numbers[i] * weights[i];
    }

    return sum;
  }
  private int weightedSum(String[] numbers, int[] weights) {
    int[] converted = new int[numbers.length];
    
    for(int i = 0; i < numbers.length; i++) {
      converted[i] = Integer.valueOf(numbers[i]);
    }

    return weightedSum(converted, weights);
  }

  private boolean validateSSN(String ssn) {
    final int[] F = {3, 7, 6, 1, 8, 9, 4, 5, 2};
    final int[] G = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

    int k1WeightedSum = weightedSum(ssn.substring(0, 9).split(""), F);
    int k2WeightedSum = weightedSum(ssn.substring(0, 10).split(""), G);

    int k1 = 11 - (k1WeightedSum % 11);
    k1 = k1 == 11 ? 0 : k1;

    int k2 = 11 - (k2WeightedSum % 11);
    k2 = k2 == 11 ? 0 : k2;

    boolean k1Valid = k1 == Integer.valueOf(ssn.substring(9, 10));
    boolean k2Valid = k2 == Integer.valueOf(ssn.substring(10, 11));

    return k1Valid && k2Valid;
  }

  public void setSSN(String ssn) {
    if(ssn.length() != 11)
      throw new IllegalArgumentException("SSN must be 11 digits");

    if(this.getBirthday() == null)
      throw new UnsupportedOperationException("Cannot set SSN of a person without a birthday");

    Calendar birthday = Calendar.getInstance();
    birthday.setTime(this.getBirthday());

    String birthdayDate = String.valueOf(birthday.get(Calendar.DAY_OF_MONTH));
    birthdayDate = birthdayDate.length() == 2 ? birthdayDate : "0" + birthdayDate;

    String birthdayMonth = String.valueOf(birthday.get(Calendar.MONTH) + 1); //Calendar.MONTH bruker nullindeksering hvor januar er måned 0, derav + 1
    birthdayMonth = birthdayMonth.length() == 2 ? birthdayMonth : "0" + birthdayMonth;

    String[] birtdayYearSplit = String.valueOf(birthday.get(Calendar.YEAR)).split("");
    String birthdayYear = birtdayYearSplit[birtdayYearSplit.length - 2] + birtdayYearSplit[birtdayYearSplit.length - 1]; //Siden moderne norske pesronnummere først ble tatt i bruk i 1964, kan vi anta at ingen født før år 10 har et personnummber, og bruke de to siste sifferene i årstallet uten å treffe på ett unntak

    String birthdayString = birthdayDate + birthdayMonth + birthdayYear;
    String ssnBirthday = ssn.substring(0, 6);

    if(!birthdayString.equals(ssnBirthday))
      throw new IllegalArgumentException(String.format("SSN birthday does not match %s's birthday", this.getName()));

    Integer ssnGenderControl = Integer.valueOf(ssn.substring(8, 9));
    switch(this.getGender()) {
      case '\0':
        throw new UnsupportedOperationException("Cannot set the SSN of a person without a gender");
      case 'F':
        if(ssnGenderControl % 2 != 0)
          throw new IllegalArgumentException("The 9th digit of an SSN must be an even number for a female");
        break;
      case 'M':
        if(ssnGenderControl % 2 == 0)
          throw new IllegalArgumentException("the 9th digit of an SSN must be an odd number for a male");
    }

    if(!validateSSN(ssn))
      throw new IllegalArgumentException("SSN is not a valid SSN");

    this.ssn = ssn;
  }
}
