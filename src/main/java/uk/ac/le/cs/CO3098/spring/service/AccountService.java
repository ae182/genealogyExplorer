package uk.ac.le.cs.CO3098.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.le.cs.CO3098.spring.domain.Account;
import uk.ac.le.cs.CO3098.spring.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Object findAllAccounts(){
		return accountRepository.findAll();
	}
	
	
	public Account findById(Integer i){
		return accountRepository.findOne(i);
	}
	
	public void deleteById(Integer id){
		 accountRepository.delete(id);;
	}
	
	
	public void save(Account a){
		accountRepository.save(a);
	}

}
