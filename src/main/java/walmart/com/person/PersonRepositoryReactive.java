package walmart.com.person;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author cahrens
 * 
 * Magical interface that will give you all the basic crud methods to mongodb
 *
 */
public interface PersonRepositoryReactive extends ReactiveMongoRepository<Person, String> {

}