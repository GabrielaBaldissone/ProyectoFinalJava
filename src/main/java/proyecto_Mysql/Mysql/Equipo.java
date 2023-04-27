package proyecto_Mysql.Mysql;

import java.util.Objects;

public class Equipo {

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre);
	}
	public boolean equals(Equipo equi) {
		if (equi.getNombre().equals(nombre))
			return true;
		else  return false;
	
	} 
	
	
	
	private String nombre; 
	private String descripcion;
	
	 public String getNombre()
     {   	 
    	 return this.nombre;
     }
     public void setNombre(String nom)
     
     {  	 
    	 this.nombre = nom;   	 
     }
	
     
	 public String getDescripcion()
     {   	 
    	 return this.descripcion;
     }
     public void setDescripcion(String descri)
     
     {  	 
    	 this.descripcion = descri;   	 
     }
     
}

