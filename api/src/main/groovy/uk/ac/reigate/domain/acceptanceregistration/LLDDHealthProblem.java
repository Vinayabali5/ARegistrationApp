package uk.ac.reigate.domain.acceptanceregistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "lldd_health_problem", schema = "acceptanceandregistration")
public class LLDDHealthProblem {
  
  @Id
  @Column(name = "lldd_health_problem_id")
  @JsonProperty(value = "id")
  public Integer id;
  
  @Column(name = "code")
  @JsonProperty(value = "code")
  public String code;
  
  @Column(name = "description")
  @JsonProperty(value = "description")
  public String description;
  
  @Column(name = "short_description")
  @JsonProperty(value = "short_description")
  public String shortDescription;

  /**
   * Default NoArgs constructor.
   */
  public LLDDHealthProblem() {};
  
  /**
   * This constructor is used to create an LLDD Health Problem. The description field is passed through as the short descrtipion. 
   * 
   * @param id
   * @param code
   * @param description
   */
  public LLDDHealthProblem(Integer id, String code, String description) {
    this(id, code, description, description);
  }

  /**
   * This constructor is used to create an LLDD Health Problem. 
   * 
   * @param id
   * @param code
   * @param description
   */
  public LLDDHealthProblem(Integer id, String code, String description, String shortDescription) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.shortDescription = shortDescription;
  }


}
