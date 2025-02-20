package assignment_6.delegation;

public class DistributingLogger implements ILogger {
  private ILogger errorLogger, warningLogger, infoLogger;

  public DistributingLogger(ILogger errLogger, ILogger warnLogger, ILogger infoLogger) {
    this.errorLogger = errLogger;
    this.warningLogger = warnLogger;
    this.infoLogger = infoLogger;
  }

  public void setLogger(String severity, ILogger logger) {
    switch (severity) {
      case ILogger.ERROR:
        this.errorLogger = logger;
        break;
      case ILogger.WARNING:
        this.warningLogger = logger;
        break;
      case ILogger.INFO:
        this.infoLogger = logger;
        break;
      default:
        throw new IllegalArgumentException("Severity does not have a logger"); 
    }
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    switch (severity) {
      case ILogger.ERROR:
        errorLogger.log(severity, message, exception);
        break;
      case ILogger.WARNING:
        warningLogger.log(severity, message, exception);
        break;
      case ILogger.INFO:
        infoLogger.log(severity, message, exception);
        break;
      default:
        throw new IllegalArgumentException("Severity does not have a logger");
    }
  }
}
