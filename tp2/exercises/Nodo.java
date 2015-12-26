package tp2.exercises;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private List<Nodo> vecinos;
	private int id;
	private boolean visitado;
	private int longitud;
	private String coordenada;
	public Nodo(int id) {
		this.id = id;
		vecinos = new ArrayList<Nodo>();
		visitado = false;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public void setVisitado() {
		this.visitado = true;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public boolean getVisitado(){
		return this.visitado;
	}
	
	public int getId() {
		return id;
	}
	public void addVecino(Nodo vecino) {
		vecinos.add(vecino);
	}
	public List<Nodo> getVecinos() {
		return vecinos;
	}
	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
	public String getCoordenada() {
		return coordenada;
	}
	
	@Override public String toString() {
		  String string;
		  string = "id:" + this.getId() + ",cantVecinos : " 
		  + this.getVecinos().size() + ", longitud  : " + this.getLongitud()
		  + "coordenada: " + this.getCoordenada();
		  return string;
	  }
}
