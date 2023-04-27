package proyecto_Mysql.Mysql;

import java.util.Objects;

public class Pronostico {
	
	@Override
	public int hashCode() {
		return Objects.hash(empate, equipo1, equipo2, ganaEquipo1, ganaEquipo2);
	}
	public void equals(Pronostico obj) {
		if (obj.getEquipo1().equals(equipo1))
			return;
	
	}
	
	
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int ganaEquipo1;
	private int empate;
	private int ganaEquipo2;
	
	
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGanaEquipo1() {
		return ganaEquipo1;
	}
	public void setGanaEquipo1(int ganaEquipo1) {
		this.ganaEquipo1 = ganaEquipo1;
	}
	public int getEmpate() {
		return empate;
	}
	public void setEmpate(int empate) {
		this.empate = empate;
	}
	public int getGanaEquipo2() {
		return ganaEquipo2;
	}
	public void setGanaEquipo2(int ganaEquipo2) {
		this.ganaEquipo2 = ganaEquipo2;
	} 

	
	
	
	
	
}
