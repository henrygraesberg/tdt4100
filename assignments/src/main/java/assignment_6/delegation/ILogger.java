package assignment_6.delegation;

public interface ILogger {
  String ERROR = "error";
  String INFO = "info";
  String WARNING = "warning";

  void log(String severity, String message, Exception exception); 
}
