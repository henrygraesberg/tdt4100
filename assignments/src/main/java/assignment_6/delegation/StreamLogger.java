package assignment_6.delegation;

import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
  private OutputStream stream;
  private String formatString = "%s, %s (%s)";

  public StreamLogger(OutputStream outputStream) {
    if(outputStream == null)
    throw new IllegalArgumentException("Cannot create a StreamLogger without an OutputStream");

  this.stream = outputStream;
  }

  void setFormatString(String formatString) {
    if(formatString == null)
      throw new IllegalArgumentException("Cannot set format to null");

    this.formatString = formatString;
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    String logMessage = String.format(this.formatString, severity, message, exception);

    try {
      this.stream.write(logMessage.getBytes());
      this.stream.flush();
    } catch (IOException e) {
      throw new IOError(e);
    }
  }
}
