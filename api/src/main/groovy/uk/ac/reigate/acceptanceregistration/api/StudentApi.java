package uk.ac.reigate.acceptanceregistration.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.reigate.acceptanceregistration.dto.AcceptanceAndRegistrationDto;
import uk.ac.reigate.acceptanceregistration.service.AcceptanceAndRegistrationService;
import uk.ac.reigate.acceptanceregistration.service.StudentService;
import uk.ac.reigate.domain.acceptanceregistration.Student;

/**
 * This class is used to set up a collection of Student HTTP endpoints for the API.
 * 
 * @author vinaya.balakrishna
 *
 */
@RestController
public class StudentApi {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AcceptanceAndRegistrationService  acceptanceAndRegistrationService;

	/**
	 * This method is used to retrieve the Student object by LinkId.
	 * 
	 * @param linkId the linkId for the Student object retrieval.
	 * @return A ResponseEntity with the corresponding Student object.
	 */
	@GetMapping(value = "/api/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@RequestParam(name = "LinkId", required = true) String linkId) {
		return new ResponseEntity<Student>(studentService.getStudentByLinkId(linkId), HttpStatus.OK);
	}

	/**
	 * This method is used to update the Student Acceptance Registration details in
	 * the Student object.
	 * 
	 * @param id The studentId for the Student object to update.
	 * @param student the new data for the Student object.
	 * @return the newly update StudentDto object.
	 */
	@PostMapping(value = "/api/students/acceptance-registration")
	public ResponseEntity<?> updateAcceptanceRegistartion(@RequestBody(required = true) @Validated AcceptanceAndRegistrationDto student) {
		return new ResponseEntity<AcceptanceAndRegistrationDto>(acceptanceAndRegistrationService.saveAcceptanceAndRegistration(student), HttpStatus.OK);
	}
}
