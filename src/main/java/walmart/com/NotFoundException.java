package walmart.com;

public class NotFoundException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = -7458318644444931393L;
  
  private String message;
  
  public NotFoundException() {}
  
  public NotFoundException(String message) {
    this.setMessage(message);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
