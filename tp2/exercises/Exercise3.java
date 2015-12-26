package tp2.exercises;

import java.util.ArrayList;

public class Exercise3 {
	private Grafo grafo;
	private UnionFind union;
	
	public Exercise3(java.util.List<Pasillo> pasillos) {
		grafo = new Grafo();
		for (int i = 0; i < pasillos.size(); i++) {
			Pasillo pasillo = pasillos.get(i);
			grafo.addVertice(pasillo.getExtremo1(), pasillo.getExtremo2(), pasillo.getLongitud());
		}
		union = new UnionFind(grafo.getVertices().size() + 0);
	}
	public int solve() {
		ArrayList<Vertice> vertices = grafo.getSortedVertices();
		int i = 0;
		int peso = 0;
		while (i < vertices.size()) {
			if (union.find((Integer)vertices.get(i).getNodo1()) != union.find((Integer)vertices.get(i).getNodo2())){
				union.union((Integer)vertices.get(i).getNodo1(),(Integer) vertices.get(i).getNodo2());
				peso += vertices.get(i).getPeso();
			}
			i++;
		}
		return -((grafo.getPeso()*-1) - peso);
	}
}
