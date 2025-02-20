package assignment_6.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringLogger implements ILogger {
  private ILogger logger;
  private String[] severities;

  public FilteringLogger(ILogger logger, String... severities) {
    this.logger = logger;
    this.severities = severities;
  }

  public boolean isLogging(String severity) {
    for (String string : severities) {
      if(severity.equals(string)) return true;
    }

    return false;
  }

  public void setIsLogging(String severity, boolean value) {
    List<String> severities = new ArrayList<String>(Arrays.asList(this.severities));
    
    if(value) {
      severities.add(severity);
    } else {
      severities.remove(severity);
    }

    this.severities = severities.toArray(new String[0]);
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    if(this.isLogging(severity)) logger.log(severity, message, exception);
  }
}
