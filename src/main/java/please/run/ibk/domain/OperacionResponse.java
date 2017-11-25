package please.run.ibk.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class OperacionResponse {

	  private int responseCode;
	  private String responseDescription;
	  private OperacionError error;
	  
	  public OperacionResponse() {
	    
	  }

	  public OperacionResponse(@JsonProperty("responseCode") int responseCode,
	      @JsonProperty("responseDescription") String responseDescription,
	      @JsonProperty("error") OperacionError error) {
	    this.responseCode = responseCode;
	    this.responseDescription = responseDescription;
	    this.error = error;
	  }

	  public int getResponseCode() {
	    return responseCode;
	  }

	  public void setResponseCode(int responseCode) {
	    this.responseCode = responseCode;
	  }

	  public String getResponseDescription() {
	    return responseDescription;
	  }

	  public void setResponseDescription(String responseDescription) {
	    this.responseDescription = responseDescription;
	  }

	  public OperacionError getError() {
	    return error;
	  }

	  public void setError(OperacionError error) {
	    this.error = error;
	  }

}
