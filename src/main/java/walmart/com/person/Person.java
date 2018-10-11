package walmart.com.person;

import org.springframework.data.annotation.Id;

/**
 * @author cahrens
 * 
 * Pojo used for both mongodb as well as REST interface
 *
 */
public class Person {

  @Id private String id;
  
  public Person() {}
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  
}