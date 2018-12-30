package uk.ac.le.cs.CO3098.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.le.cs.CO3098.spring.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
	

}
