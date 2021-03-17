package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@SpringBootApplication
public class OrmLearnApplication {

	
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	
	public static void main(String[] args) throws CountryNotFoundException {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);


		LOGGER.info("Start of test GetAllCountries");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("<****************************** AllCountries List ******************************");
	


		LOGGER.info("find a country with  country code.");
		Country country1 = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country1);
		LOGGER.info("<****************************** Find a country with code(IN--India)  ******************************");LOGGER.info("find a country with code.");
		Country country11 = countryService.findCountryByCode("AF");
		LOGGER.debug("Country:{}", country11);
		LOGGER.info("<****************************** Find a country with code(AF-- Afghanistan)  ******************************");
		
		
		
		LOGGER.info("Add a new Country swraj");
		Country country2 = new Country("SR","Swaraj");
		countryService.addCountry(country2);
		Country newcountry=countryService.findCountryByCode("SR");
		LOGGER.debug("Country:{}", newcountry);
		LOGGER.info("****************************** End of adding new country ******************************");
		
		
		
		LOGGER.info("Adding a new country.");
		countryService.updateCountry("SR","Swarajaym");
		Country countryupdate = countryService.findCountryByCode("SR");
		LOGGER.debug("Country:{}", countryupdate);
		LOGGER.info("****************************** END of adding ******************************");
		
		
		
		LOGGER.info("Deleting a contry with country  code");
		Country countrydelete = countryService.findCountryByCode("SR");
		LOGGER.debug("Country:{}", countrydelete);
		countryService.deleteCountry("SR");
		LOGGER.info("****************************** End of deleting country ******************************");
		
		
		
		LOGGER.info("Add a new Country swraj");
		Country country4 = new Country("SR","Swaraj");
		countryService.addCountry(country4);
		Country newcountry1=countryService.findCountryByCode("SR");
		LOGGER.debug("Country:{}", newcountry1);
		LOGGER.info("****************************** End of adding again ******************************");
		
		


		}
	

	
}
	
	
	
	
	
	
	
	
	

