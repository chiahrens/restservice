package walmart.com.person;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryReactiveTest {

  @Autowired
  PersonRepositoryReactive repository;
  
  @After
  public void cleanup() {
    repository.deleteAll().block();
  }

  @Test
  public void givenValue_whenFindAllByValue_thenFindAccount() {
    repository.save(new Person("John", "Doe")).block();
    Flux<Person> accountFlux = repository.findAll();

    List<Person> list = accountFlux.collectList().block();

    assertThat(list).hasSize(1);
    assertThat(list.get(0).getFirstName()).isEqualTo("John");
    assertThat(list.get(0).getLastName()).isEqualTo("Doe");
  }

}
