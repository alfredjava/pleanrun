package please.run.ibk.domain;

public class RequestUbicacion {
private String operation;
private String zona;
private String provincia;
private String direccion;
private String distrito;
private String instante;
private String dia;
private int latitud;
private int longitud;
public String getOperation() {
	return operation;
}
public void setOperation(String operation) {
	this.operation = operation;
}
public String getZona() {
	return zona;
}
public void setZona(String zona) {
	this.zona = zona;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getDistrito() {
	return distrito;
}
public void setDistrito(String distrito) {
	this.distrito = distrito;
}
public String getInstante() {
	return instante;
}
public void setInstante(String instante) {
	this.instante = instante;
}
public String getDia() {
	return dia;
}
public void setDia(String dia) {
	this.dia = dia;
}
public int getLatitud() {
	return latitud;
}
public void setLatitud(int latitud) {
	this.latitud = latitud;
}
public int getLongitud() {
	return longitud;
}
public void setLongitud(int longitud) {
	this.longitud = longitud;
}





}
