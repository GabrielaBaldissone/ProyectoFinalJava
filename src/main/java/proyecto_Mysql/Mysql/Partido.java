package proyecto_Mysql.Mysql;

import java.util.Objects;

public class Partido {

	private proyecto_Mysql.Mysql.Equipo equipo1;
	private proyecto_Mysql.Mysql.Equipo equipo2; 
	private int golesEquipo1;
	private int golesEquipo2;
	
	public proyecto_Mysql.Mysql.Equipo getequipo1()
    {   	 
   	 return this.equipo1;
    }
    public void setequipo1(proyecto_Mysql.Mysql.Equipo equi1)
    
    { 
   	 this.equipo1 = equi1;   	 
    }
	
    
    public proyecto_Mysql.Mysql.Equipo getequipo2()
    {   	 
   	 return this.equipo2;
    }
    public void setequipo2(proyecto_Mysql.Mysql.Equipo equipo2)
    
    {  	 
   	 this.equipo2 = equipo2;  
    }
    
    
    
    public int getGol1()
    {   	 
   	 return this.golesEquipo1;
    }
    public void setGol1(int gol1)
    
    {  	 
   	 this.golesEquipo1 = gol1;   	 
    }
	
    
	 public int getGol2()
    {   	 
   	 return this.golesEquipo2;
    }
    public void setGol2(int gol2)
    
    {  	 
   	 this.golesEquipo2 = gol2;   	 
    }
    
    
	@Override
	public int hashCode() {
		return Objects.hash(equipo1, equipo2, golesEquipo1, golesEquipo2);
	}
	public void equals(Partido objeto) {
		if (objeto.getequipo1().equals(equipo1))
			return ;
		if (objeto == null)
			return;
	}
    
    
	
}
