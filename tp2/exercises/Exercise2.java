package tp2.exercises;

import java.util.List;

public class Exercise2 {
	private Grafo2 grafo;
	private int piso;

	public Exercise2(int pisos, int longitud, List<Portal<Baldoza>> portales) {
		piso = pisos;
		Baldoza p = portales.get(0).getDesde();
		grafo = new Grafo2(portales, pisos, longitud);

	}

	public int solve() {
		return grafo.solve("0,0", piso + "," + piso, 0);
	}

	public int solveNoOptimizado() {
		return grafo.solveNoOptimizado("0,0", piso + "," + piso, 0);
	}

}
