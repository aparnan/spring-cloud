package services;

import hello.Person;

public interface PersonServices {
	Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person saveProduct(Person person);
}
