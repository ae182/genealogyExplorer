package uk.ac.le.cs.CO3098.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.ac.le.cs.CO3098.spring.domain.APerson;


@Repository
public interface PersonRepository extends CrudRepository<APerson,Integer> {
	
	public static final String FIND_APERSON = "SELECT * FROM APerson WHERE specialKey = ?1";
	public static final String FIND_PARENT = "SELECT fathersKey, mothersKey from APerson WHERE specialKey = ?1";
	public static final String FIND_FATHER = "SELECT fathersKey from APerson WHERE specialKey = ?1";
	public static final String SET_MOTHER_FATHER = "UPDATE ae182.APerson SET fathersKey=:fathersKey, mothersKey=:mothersKey WHERE specialKey =:specialKey";
	
	//SET SQL_SAFE_UPDATES = 0; 
	@Query(value = FIND_APERSON, nativeQuery = true)
	public APerson findAPersonBySpecialKey(String specialKey);
	
	@Query(value = FIND_PARENT, nativeQuery = true)
	public List<String> getParent(String specialKey);
	
	
	@Modifying
	@Query(value = SET_MOTHER_FATHER, nativeQuery = true)
	@Transactional
	public void setFatherAndMother(@Param("fathersKey")String fathersKey, @Param("mothersKey")String mothersKey, @Param("specialKey")String specialKey);
	
	
}
