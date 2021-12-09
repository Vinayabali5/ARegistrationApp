package uk.ac.reigate.acceptanceregistration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.reigate.acceptanceregistration.service.EthnicityService;
import uk.ac.reigate.domain.acceptanceregistration.Ethnicity;

/**
 * This class is used to set up a collection of Ethnicity HTTP endpoints for the
 * API.
 * 
 * @author vinaya.balakrishna
 *
 */
@RestController
public class EthnicityApi {

	@Autowired
	private EthnicityService ethnicityService;

	/**
	 * This method is used to retrieve the list of ethnicities.
	 * 
	 * @return A ResponseEntity with the list of ethnicities.
	 */
	@GetMapping(value = "api/ethnicities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ethnicity>> getEthnicities() {
		List<Ethnicity> list = ethnicityService.getEthnicities();
		return new ResponseEntity<List<Ethnicity>>(list, HttpStatus.OK);
	}

	/**
	 * This method is used to retrieve the Ethnicity object by id
	 * 
	 * @param id The id for the Ethnicity object retrieve.
	 * @return A ResponseEntity with the corresponding Ethnicity object.
	 */
	@GetMapping(value = "api/ethnicity/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ethnicity> getById(@PathVariable("id") Integer id) {
		Ethnicity ethnicity = ethnicityService.getById(id);
		return new ResponseEntity<Ethnicity>(ethnicity, HttpStatus.OK);
	}
}
