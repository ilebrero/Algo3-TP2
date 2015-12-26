package tp2.exercises;


public class Vertice<T extends Comparable> implements Comparable<Vertice>{
	private T nodo1;
	private T nodo2;
	private int peso;
	private int id;
	
	public Vertice(T nodo1,T nodo2, int  peso) {
		this.nodo1 = nodo1;
		this.nodo2 = nodo2;
		this.peso = peso;
	}
	
	public T getNodo1() {
		return nodo1;
	}
	
	public T getNodo2() {
		return nodo2;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int  getId() {
		return id;
	}
	@Override
	public int compareTo(Vertice other) {
		if (other.getPeso() < this.getPeso()) {
			return 1;
		} else if (other.getPeso() > this.getPeso()){
			return -1;
		}
		return 0;
	}
	
  @Override public String toString() {
		  String string;
		  string = "Nodo1:" + this.getNodo1() + ", Nodo2 : " 
		  + this.getNodo2() + ", Peso : " + this.getPeso();
		  return string;
	  }

}
