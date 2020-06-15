package es.toni.struts.crud.dao;

import es.toni.struts.crud.model.Country;

public interface CategoriaSupportDao {

    Country[] getCountries();
    
    String[] getCarModels();
    
    String[] getSports();
    
    String[] getGenders();
    
}
