
package uk.ac.reigate.domain.acceptanceregistration;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student", schema = "acceptanceandregistration")
public class Student {
  
  @Id
  @Column(name = "student_id", updatable = false)
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  Integer id;
  
  @Column(name = "link_id", updatable = false) 
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  String linkId;
  
  @Column(name = "legal_first_name", updatable = false)
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  String legalFirstName;
  
  @Column(name = "legal_surname", updatable = false)
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  String legalSurname;
  
  @Column(name = "dob", updatable = false)  
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
  Date dob;
  
  @Column(name = "school_name", updatable = false) 
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  String schoolName;
  
  @Column(name = "interview_date", updatable = false)  
  @Getter
  @JsonProperty(access = Access.READ_ONLY)
  @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT")
  Date interviewDate;
  
  @OneToOne
  @JoinColumn(name = "ethnicity_id", updatable = true)
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  public Ethnicity ethnicity;
  
  @Column(name = "offer_accepted")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean offerAccepted;
  
  @Column(name = "student_signature")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  String studentSignature;
  
  @Column(name = "student_signature_date")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Date studentSignatureDate;
  
  @Column(name = "parent_signature")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  String parentSignature;
  
  @Column(name = "parent_signature_date")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Date parentSignatureDate;
  
  @Column(name = "looked_after_child_or_adopted")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean lookedAfterChildOrAdopted;
  
  @Column(name = "children_services_involved_at_school")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean childrenServicesInvolvedAtSchool;
  
  @Column(name = "other_social_support_issues")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean otherSocialSupportIssues;
  
  @Column(name = "free_meals_while_at_school")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean freeMealsWhileAtSchool;
  
  @Column(name = "parents_university_educated")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean parentsUniversityEducated;
  
  @Column(name = "ehcp")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean ehcp;
  
  @Column(name = "contact_by_post")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean contactByPost;
  
  @Column(name = "contact_by_email")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean contactByEmail;
  
  @Column(name = "contact_by_phone")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  Boolean contactByPhone;
  
  @OneToOne
  @JoinColumn(name = "lldd_health_problem_id")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  public LLDDHealthProblem llddHealthProblem;
  
  @ManyToMany
  @JoinTable(name = "student_lldd_health_problem_category", schema = "acceptanceandregistration")
  @Getter
  @Setter
  @JsonProperty(access = Access.WRITE_ONLY)
  List<LLDDHealthProblemCategory> llddHealthProblemCategories;
  
  /**
   * Default NoArgs constructor
   */
  public Student() {}
  
  /**
   * This constructor is used to create a basic student from the core fields.
   * 
   * @param id
   * @param linkId
   * @param legalFirstName
   * @param legalSurname
   * @param schoolName
   * @param interviewDate
   */
  public Student(Integer id, String linkId, String legalFirstName, String legalSurname, String schoolName, Date interviewDate) {
    super();
    this.id = id;
    this.linkId = linkId;
    this.legalFirstName = legalFirstName;
    this.legalSurname = legalSurname;
    this.schoolName = schoolName;
    this.interviewDate = interviewDate;
  }
  
}
