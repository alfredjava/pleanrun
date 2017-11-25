package please.run.ibk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import please.run.ibk.domain.OperacionError;
import please.run.ibk.domain.ResponseUbicacion;
import please.run.ibk.domain.Tienda;
import please.run.ibk.util.ResponseConstants;
@RestController
public class OperacionController {


    public static String path = System.getProperty("user.dir");
    

	@Autowired
	private Environment env;
	@Autowired
	private RestClient restClient;

    
    
    @ResponseBody
    @RequestMapping(value = "/listarTienda", method = RequestMethod.POST)
    public ResponseUbicacion listaTienda(@RequestBody Map<String, Object> requestUbicacion){
    	
    	String url="https://api.us.apiconnect.ibmcloud.com/interbankperu-uat/pys-servicios-internos/ms/ubicacionhorario";

    	ResponseUbicacion responseUbicacion=new ResponseUbicacion();
    	String response = "";
    	
    	try{
    		response = restClient.executeRestClientPost(requestUbicacion,url,"7599476f-ed64-4908-a971-8023aa7787d6");
	    	if(response == null){
	    		OperacionError error = new OperacionError(ResponseConstants.VALUE_ERROR_GENERIC_CODE, env.getProperty("msg.error.occurred.ms"));
	        	int responseCode = ResponseConstants.VALUE_ERROR_GENERIC_CODE;
	        	String responseDescription = env.getProperty("msg.error.occurred.ms");	        	
	        	
	        	return null;
			}else{

				
				ObjectMapper mapper = new ObjectMapper();
				List<Tienda> map = new ArrayList<Tienda>();
				map = mapper.readValue(response, new TypeReference<List<Tienda>>(){});
				responseUbicacion.setListaTienda(map);				
				
				System.out.println("REST PromartController - login - INICIO- Satisfactorio");
				
			} 
    		
    	}catch (Exception e) {
			// TODO: handle exception
		}

    	return responseUbicacion;
    }
    
}
