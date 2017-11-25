package please.run.ibk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class PromartResponse {

	  private int responseCode;
	  private String responseDescription;
	  private PromartError error;
	  
	  public PromartResponse() {
	    
	  }

	  public PromartResponse(@JsonProperty("responseCode") int responseCode,
	      @JsonProperty("responseDescription") String responseDescription,
	      @JsonProperty("error") PromartError error) {
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

	  public PromartError getError() {
	    return error;
	  }

	  public void setError(PromartError error) {
	    this.error = error;
	  }

}
