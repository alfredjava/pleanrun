package please.run.ibk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import please.run.ibk.domain.ResponseUbicacion;
import please.run.ibk.domain.Tienda;
@RestController
public class OperacionController {


    public static String path = System.getProperty("user.dir");
    

	@Autowired
	private Environment env;
	@Autowired
	private RestClient restClient;

    
    
	
    @ResponseBody
    @RequestMapping(value = "/getCliente", method = RequestMethod.GET)
    public Map<String,Object> getCliente(@RequestParam String dni){    	
    	String url="https://api.us.apiconnect.ibmcloud.com/interbankperu-uat/pys-servicios-internos/ms/clientes?"
    			+ "numeroDocumento="+dni;
    	Map<String,Object> mapCliente=new HashMap<String,Object>();
    	String response = "";
    	
    	try{
    		response = restClient.executeRestClientGET(url,env.getProperty("ibm.cliente.id"));
	    	if(response != null && response.length()>0){
				
				ObjectMapper mapper = new ObjectMapper();
				mapCliente = mapper.readValue(response, new TypeReference<Map<String,Object>>(){});
					
				System.out.println("REST OperacionController - login - INICIO- Satisfactorio");				
			}else{
				mapCliente.put("error", "error en el api");
			}
    		
    	}catch (Exception e) {
    		mapCliente.put("error", "error en el api");
		}
    	return mapCliente;
    }
	
	
	
	
    @ResponseBody
    @RequestMapping(value = "/listarTienda", method = RequestMethod.POST)
    public ResponseUbicacion listaTienda(@RequestBody Map<String, Object> requestUbicacion){    	
    	String url="https://api.us.apiconnect.ibmcloud.com/interbankperu-uat/pys-servicios-internos/ms/ubicacionhorario";
    	ResponseUbicacion responseUbicacion=new ResponseUbicacion();
    	String response = "";
    	
    	try{
    		response = restClient.executeRestClientPOST(requestUbicacion,url,env.getProperty("ibm.cliente.id"));
	    	if(response != null){
				
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
