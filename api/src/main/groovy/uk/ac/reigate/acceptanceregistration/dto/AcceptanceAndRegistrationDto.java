package uk.ac.reigate.acceptanceregistration.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import uk.ac.reigate.domain.acceptanceregistration.LLDDHealthProblemCategory;
import uk.ac.reigate.domain.acceptanceregistration.Student;

public class AcceptanceAndRegistrationDto {

	@Getter
	@JsonProperty
	Integer id;

	@Getter
	@JsonProperty
	String linkId;

	@Getter
	@JsonProperty
	String legalFirstName;

	@Getter
	@JsonProperty
	String legalSurname;

	@Getter
	@JsonProperty
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/London")
	Date dob;

	@Getter
	@JsonProperty
	String schoolName;

	@Getter
	@JsonProperty
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/London")
	Date interviewDate;

	@Getter
	@JsonProperty(required = true)
	Integer ethnicityId;

	@Getter
	@JsonProperty
	Boolean offerAccepted;

	@Getter
	@JsonProperty
	String studentSignature;

	@Getter
	@JsonProperty
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/London")
	Date studentSignatureDate;

	@Getter
	@JsonProperty
	String parentSignature;

	@Getter
	@JsonProperty
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/London")
	Date parentSignatureDate;

	@Getter
	@JsonProperty
	Boolean lookedAfterChildOrAdopted;

	@Getter
	@JsonProperty
	Boolean childrenServicesInvolvedAtSchool;

	@Getter
	@JsonProperty
	Boolean otherSocialSupportIssues;

	@Getter
	@JsonProperty
	Boolean freeMealsWhileAtSchool;

	@Getter
	@JsonProperty
	Boolean parentsUniversityEducated;

	@Getter
	@JsonProperty
	Boolean ehcp;

	@Getter
	@JsonProperty
	Boolean contactByPost;

	@Getter
	@JsonProperty
	Boolean contactByEmail;

	@Getter
	@JsonProperty
	Boolean contactByPhone;

	@Getter
	@JsonProperty
	Integer llddHealthProblemId;

	@Getter
	@JsonProperty
	List<LLDDHealthProblemCategory> llddHealthProblemCategories;

	/**
	 * Default No Args constructor
	 */
	public AcceptanceAndRegistrationDto() {}
	
	/**
	 * Constructor to create a StudentDto object from a Student object.
	 * 
	 * @param student the Student object to use for construction.
	 */
	public AcceptanceAndRegistrationDto(Student student) {	
		this.id = student.getId();
		this.linkId = student.getLinkId();
		this.legalFirstName = student.getLegalFirstName();
		this.legalSurname = student.getLegalSurname();
		this.dob = student.getDob();
		this.schoolName = student.getSchoolName();
		this.interviewDate = student.getInterviewDate();
		this.ethnicityId = student.getEthnicity() != null ? student.getEthnicity().id : null;
		this.offerAccepted = student.getOfferAccepted();
		this.studentSignature = student.getStudentSignature();
		this.studentSignatureDate = student.getStudentSignatureDate();
		this.parentSignature = student.getParentSignature();
		this.parentSignatureDate = student.getParentSignatureDate();
		this.lookedAfterChildOrAdopted = student.getLookedAfterChildOrAdopted();
		this.childrenServicesInvolvedAtSchool = student.getChildrenServicesInvolvedAtSchool();
		this.otherSocialSupportIssues = student.getOtherSocialSupportIssues();
		this.freeMealsWhileAtSchool = student.getFreeMealsWhileAtSchool();
		this.parentsUniversityEducated = student.getParentsUniversityEducated();
		this.ehcp = student.getEhcp();
		this.contactByPost = student.getContactByPost();
		this.contactByEmail = student.getContactByEmail();
		this.contactByPhone = student.getContactByPhone();
		this.llddHealthProblemId = student.getLlddHealthProblem() != null ? student.getLlddHealthProblem().id : null;
	}

}
