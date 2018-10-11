package walmart.com.person;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import walmart.com.NotFoundException;
import walmart.com.SystemException;

/**
 * @author cahrens
 * 
 * Controller with route info
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

  private final PersonRepositoryReactive repository;
  
  public PersonController(PersonRepositoryReactive repository) {
    this.repository = repository;
  }
  
  @GetMapping
  Flux<Person> getAll() {
    return repository.findAll();
  }
  
  @PostMapping
  Mono<Person> add(@RequestBody Person person) {
    return repository.save(person);
  }
  
  @PutMapping("/{id}")
  Mono<Person> update(@PathVariable("id") String id, @RequestBody Person person) {
    Person found = repository.findById(id).block();
    if(found == null) {
      return Mono.error(new NotFoundException("NOT FOUND"));
    }
    try {
      BeanUtils.copyProperties(found, person);
    }catch(Exception e) {
      throw new SystemException(e);
    }
    found.setId(id);
    
    return repository.save(found);
  }
  
  @DeleteMapping("/{id}")
  Mono<Void> delete(@PathVariable("id") String id) {
    Person found = repository.findById(id).block();
    if(found == null) {
      return Mono.error(new NotFoundException("NOT FOUND"));
    }
    return repository.deleteById(id);
  }
}
