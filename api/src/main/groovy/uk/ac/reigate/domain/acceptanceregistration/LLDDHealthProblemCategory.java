package uk.ac.reigate.domain.acceptanceregistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "lldd_health_problem_category", schema = "acceptanceandregistration")
public class LLDDHealthProblemCategory {
  
  @Id
  @Column(name = "lldd_health_problem_category_id")
  @JsonProperty
  Integer id;
  
  @Column(name = "code")
  @JsonProperty
  String code;
  
  @Column(name = "description")
  @JsonProperty
  String description;
  
  /**
   * Default NoArgs constructor.
   */
  public LLDDHealthProblemCategory() {};
  
  /**
   * This constructor is used to create an LLDD Health Problem Category.  
   * 
   * @param id
   * @param code
   * @param description
   */
  public LLDDHealthProblemCategory(int id, String code, String description) {
    this.id = id;
    this.code = code;
    this.description = description;
  }


  
}
