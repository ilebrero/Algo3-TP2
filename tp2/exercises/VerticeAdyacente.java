package tp2.exercises;

public class VerticeAdyacente {
    private int nodo;
    private int peso;
    private int pesoYaRecorrido;
    
    public VerticeAdyacente(int nodo, int peso) {
        this.nodo = nodo;
        this.peso = peso;
        this.pesoYaRecorrido = Integer.MAX_VALUE;
    }

    public int getNodo() {
		return nodo;
	}

	public int getPeso() {
		return peso;
	}

    public int getPesoYaRecorrido() {
        return pesoYaRecorrido;
    }

    public int setPesoYaRecorrido(int peso) {
        return this.pesoYaRecorrido = peso;
    }
}
