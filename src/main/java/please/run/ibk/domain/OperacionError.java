package please.run.ibk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperacionError {
	  private int code;
	  private String message;
	  
	  public OperacionError(){
	    
	  }
	  
	  public  OperacionError (@JsonProperty("code") int code,
	      @JsonProperty("message") String message){
	    this.code=code;
	    this.message=message;
	  }

	  public int getCode() {
	    return code;
	  }

	  public void setCode(int code) {
	    this.code = code;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
}
