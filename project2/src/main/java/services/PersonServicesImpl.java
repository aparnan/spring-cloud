package services;

import org.springframework.stereotype.Service;

import hello.Person;
import hello.PersonRepository;

@Service
public class PersonServicesImpl implements PersonServices{

	private PersonRepository personRepository;
	
	public void setPersonRepository(final PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Iterable<Person> listAllPersons() {
		
		return personRepository.findAll();
	}

	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findOne(id);
	}

	public Person saveProduct(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
