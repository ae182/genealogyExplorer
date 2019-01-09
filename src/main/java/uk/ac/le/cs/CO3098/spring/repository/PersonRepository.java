package uk.ac.le.cs.CO3098.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.le.cs.CO3098.spring.domain.APerson;


@Repository
public interface PersonRepository extends CrudRepository<APerson,Integer> {
	
	public static final String FIND_APERSON = "SELECT * FROM APerson WHERE specialKey = ?1";
	public static final String FIND_PARENT = "SELECT fathersKey, mothersKey from APerson WHERE specialKey = ?1";
	public static final String FIND_FATHER = "SELECT fathersKey from APerson WHERE specialKey = ?1";
	public static final String SET_MOTHER_FATHER = "SET SQL_SAFE_UPDATES = 0; UPDATE ae182.APerson SET fathersKey=?1, mothersKey=?2 WHERE specialKey =?3";
	
	
	@Query(value = FIND_APERSON, nativeQuery = true)
	public APerson findAPersonBySpecialKey(String specialKey);
	
	@Query(value = FIND_PARENT, nativeQuery = true)
	public List<String> getParent(String specialKey);
	
	@Query(value = SET_MOTHER_FATHER, nativeQuery = true)
	public void setFatherAndMother(String fatherKey, String motherKey, String specialKey);
	
	
}
