package es.toni.struts.crud.service;

import es.toni.struts.crud.model.Country;
import es.toni.struts.crud.model.Person;

/**
 * Define methods a PersonService must implement
 * to provide services related to a Person class.
 * 
 * @author bruce phillips
 * @author antonio sánchez
 */
public interface PersonService {

    Person getPerson(Integer id);
    
    Person[] getAllPersons();

    void updatePerson(Person personBean);
    
    void insertPerson(Person personBean);
    
    void deletePerson(Integer id);
    
    Country[] getCountries();
    
    String[] getCarModels();
    
    String[] getSports();
    
    String[] getGenders();
}