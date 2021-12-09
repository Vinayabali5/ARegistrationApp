package uk.ac.reigate.acceptanceregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.reigate.acceptanceregistration.dto.AcceptanceAndRegistrationDto;
import uk.ac.reigate.acceptanceregistration.repository.StudentRepository;
import uk.ac.reigate.domain.acceptanceregistration.Student;

/**
 * This service is used to handle the data operation performed on the Student
 * data objects.
 * 
 * @author Michael Horgan
 *
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EthnicityService ethnicityService;
	
	@Autowired
	LLDDHealthProblemService llddHealthProblemService;

	/**
	 * This method is used to retrieve a Student from the supplied linkId.
	 * 
	 * @param linkId the linkId is a unique String field for each student.
	 * @return the Student data object that matches the supplied LinkId. If a
	 *         Student cannot be found with the supplied linkId then a null value is
	 *         returned.
	 */
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id);
	}

	/**
	 * This method is used to retrieve a Student from the supplied linkId.
	 * 
	 * @param linkId the linkId is a unique String field for each student.
	 * @return the Student data object that matches the supplied LinkId. If a
	 *         Student cannot be found with the supplied linkId then a null value is
	 *         returned.
	 */
	public Student getStudentByLinkId(String linkId) {
		return studentRepository.getByLinkId(linkId);
	}

	/**
	 * This method is used to save the supplied Student data to the database.
	 * 
	 * @param student the Student record to save.
	 * @return the saved Student record.
	 */
	public Student save(Student student) {
		return studentRepository.save(student);
	}	

}
