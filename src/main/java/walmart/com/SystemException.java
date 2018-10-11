package walmart.com;

public class SystemException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 8264406298036817918L;

  public SystemException() {}
  
  public SystemException(Throwable t) {
    super(t);
  }

}