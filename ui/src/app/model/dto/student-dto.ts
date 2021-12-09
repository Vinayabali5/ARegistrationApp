import { Ethnicity } from "../ethnicity";
import { LLDDHealthProblem } from "../lldd-health-problem";
import { Student } from "../student"

export class StudentDTO {
 public id: number;
 public linkId: string;
 public legalSurname: string;
 public legalFirstName: string;
 public dob: Date;
 public schoolName: string;
 public ethnicity: Ethnicity;
 public interviewDate: Date;

 public offerAccepted: Boolean;
 public studentSignature: string;
 public studentSignatureDate: Date;
 public parentSignature: string;
 public parentSignatureDate: Date;
 public lookedAfterChildOrAdopted: Boolean;
 public childrenServicesInvolvedAtSchool: Boolean;
 public otherSocialSupportIssues: Boolean;
 public freeMealsWhileAtSchool: Boolean;
 public parentsUniversityEducated: Boolean;
 public ehcp: Boolean;
 public contactByPost: Boolean;
 public contactByEmail: Boolean;
 public contactByPhone: Boolean;
 public llddHealthProblem: LLDDHealthProblem;

 constructor(data: Student){
     this.id = data.id;
     this.linkId = data.linkId;
     this.legalSurname = data.legalSurname;
     this.legalFirstName = data.legalFirstName;
     this.dob = data.dob;
     this.schoolName = data.schoolName;
     this.ethnicity = data.ethnicity;
     this.interviewDate = data.interviewDate;
     this.offerAccepted = data.offerAccepted;
     this.studentSignature = data.studentSignature;
     this.parentSignature = data.parentSignature;
     this.studentSignatureDate = data.studentSignatureDate;
     this.parentSignatureDate = data.parentSignatureDate;
     this.lookedAfterChildOrAdopted = data.lookedAfterChildOrAdopted;
     this.childrenServicesInvolvedAtSchool = data.childrenServicesInvolvedAtSchool;
     this.otherSocialSupportIssues = data.otherSocialSupportIssues;
     this.freeMealsWhileAtSchool = data.freeMealsWhileAtSchool;
     this.parentsUniversityEducated = data.parentsUniversityEducated;
     this.ehcp = data.ehcp;
     this.contactByEmail = data.contactByEmail;
     this.contactByPhone = data.contactByPhone;
     this.contactByPost = data.contactByPost;
     this.llddHealthProblem = data.llddHealthProblem;

 }
}