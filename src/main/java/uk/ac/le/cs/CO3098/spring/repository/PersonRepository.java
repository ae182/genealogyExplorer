package uk.ac.le.cs.CO3098.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.le.cs.CO3098.spring.domain.APerson;
import uk.ac.le.cs.CO3098.spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<APerson,Integer> {
	
	public static final String FIND_APERSON = "SELECT * FROM APerson WHERE specialKey = ?1";
	public static final String FIND_PARENT = "SELECT fathersKey, mothersKey from APerson WHERE specialKey = ?1";
	
	public static final String FIND_FATHER = "SELECT fathersKey from APerson WHERE specialKey = ?1";
	
	
	@Query(value = FIND_APERSON, nativeQuery = true)
	public APerson findAPersonBySpecialKey(String specialKey);
	
	@Query(value = FIND_PARENT, nativeQuery = true)
	public List<String> getParent(String specialKey);
	
	
}
