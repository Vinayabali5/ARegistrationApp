package uk.ac.reigate.acceptanceregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ac.reigate.acceptanceregistration.dto.AcceptanceAndRegistrationDto;
import uk.ac.reigate.domain.acceptanceregistration.Student;

@Service
public class AcceptanceAndRegistrationService {

	@Autowired
	StudentService studentService;

	@Autowired
	EthnicityService ethnicityService;
	
	@Autowired
	LLDDHealthProblemService llddHealthProblemService;
	
	/**
	 * This method is used to update the student acceptance registration form.
	 * 
	 * @param acceptanceAndRegistrationDto
	 * @param studentId
	 * @return
	 */
	public AcceptanceAndRegistrationDto saveAcceptanceAndRegistration(AcceptanceAndRegistrationDto acceptanceAndRegistrationDto) {
		Student student = studentService.getStudentById(acceptanceAndRegistrationDto.getId());
		student.setOfferAccepted(acceptanceAndRegistrationDto.getOfferAccepted());
		if (acceptanceAndRegistrationDto.getOfferAccepted()) {
			student.setEthnicity(acceptanceAndRegistrationDto.getEthnicityId() != null ? ethnicityService.getById(acceptanceAndRegistrationDto.getEthnicityId()) : null);
			student.setStudentSignature(acceptanceAndRegistrationDto.getStudentSignature());
			student.setStudentSignatureDate(acceptanceAndRegistrationDto.getStudentSignatureDate());
			student.setParentSignature(acceptanceAndRegistrationDto.getParentSignature());
			student.setParentSignatureDate(acceptanceAndRegistrationDto.getParentSignatureDate());
			student.setLookedAfterChildOrAdopted(acceptanceAndRegistrationDto.getLookedAfterChildOrAdopted());
			student.setChildrenServicesInvolvedAtSchool(acceptanceAndRegistrationDto.getChildrenServicesInvolvedAtSchool());
			student.setOtherSocialSupportIssues(acceptanceAndRegistrationDto.getOtherSocialSupportIssues());
			student.setFreeMealsWhileAtSchool(acceptanceAndRegistrationDto.getFreeMealsWhileAtSchool());
			student.setParentsUniversityEducated(acceptanceAndRegistrationDto.getParentsUniversityEducated());
			student.setEhcp(acceptanceAndRegistrationDto.getEhcp());
			student.setContactByPost(acceptanceAndRegistrationDto.getContactByPost());
			student.setContactByEmail(acceptanceAndRegistrationDto.getContactByEmail());
			student.setContactByPhone(acceptanceAndRegistrationDto.getContactByPhone());
			student.setLlddHealthProblem(acceptanceAndRegistrationDto.getLlddHealthProblemId() != null ? llddHealthProblemService.getById(acceptanceAndRegistrationDto.getLlddHealthProblemId()) : null);
		}
		return new AcceptanceAndRegistrationDto(studentService.save(student));
	}
}