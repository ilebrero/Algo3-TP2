package tp2.exercises;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grafo2 {
//	private Map<String, Nodo> nodos;
	private Nodo[][] nodos;
	private List<Nodo> nodosFantasmas;
	private int idVertices;
	private int nodoFantasma = 0;
	private int mts;
	private Boolean[] pisosUsados;
	public Grafo2(List<Portal<Baldoza>> portales, int pisos, int mts) {
		this.mts = mts;
		pisosUsados = new Boolean[pisos + 1];
		for (int i = 0; i < pisosUsados.length; i++) {
			pisosUsados[i] = false;
		}
		nodos = new Nodo[pisos+1][mts+1];
		nodosFantasmas = new LinkedList<Nodo>();
		
		idVertices = 0;
		
		for (int i = 0; i < portales.size() ; i++) {
			Portal<Baldoza> portal = portales.get(i);		
			Baldoza b1 = (Baldoza) portal.getDesde();
			Baldoza b2 = (Baldoza) portal.getHasta();
			connect(b1,b2);
		}
	}
	
	private void connect(Baldoza b1, Baldoza b2) {
		checkFloor(b1);
		checkFloor(b2);	
		
		addNodo("FANTASMA", nodoFantasma);
		connect(b1.getPiso() + "," + b1.getMetros() , "FANTASMA,"+ nodoFantasma);
		connect("FANTASMA,"+ nodoFantasma , b2.getPiso() + "," + b2.getMetros());
		nodoFantasma++;		
	}

	

	private void checkFloor(Baldoza b2){
		if (!pisosUsados[b2.getPiso()]){
			pisosUsados[b2.getPiso()] = true;
			for (int j = 0; j <= mts; j++) {
				addNodo(b2.getPiso(), j);
			}
			for (int j = 0; j < mts; j++) {
					int k = j + 1;
					connect(b2.getPiso()+","+j, b2.getPiso()+","+k);
			}
		}
	}
	private void connect(String string, String string2) {
		Nodo a = getNodo(string);
		Nodo b = getNodo(string2);
		if (! a.getVecinos().contains(b)){
			a.addVecino(b);
		}
		if (! b.getVecinos().contains(a)){
			b.addVecino(a);
		}
	}

	public void addVertice(Baldoza b1, Baldoza b2, int peso ) {
		Vertice<Baldoza> vertice = new Vertice<Baldoza>(b1, b2, peso);
		vertice.setId(idVertices);
		idVertices++;
	}
	private Nodo addNodo(String string, int nodoFantasma) {
		nodosFantasmas.add(nodoFantasma,new Nodo(idVertices));
		idVertices++;
		nodosFantasmas.get(nodoFantasma).setCoordenada("FANTASMA,"+nodoFantasma);
		return nodosFantasmas.get(nodoFantasma);
	}
	public Nodo addNodo(int piso, int mts){
		if (nodos[piso][mts] == null) {
			nodos[piso][mts] = new Nodo(idVertices);
			idVertices++;
			nodos[piso][mts].setCoordenada(piso+","+mts);
		}
		return nodos[piso][mts];
	}
	public Nodo getNodo(String string){
		String[] dato = string.split(",");
		if (dato[0].equals("FANTASMA")){
			return nodosFantasmas.get(Integer.parseInt(dato[1]));
		} else {
			return nodos[Integer.parseInt(dato[0])][Integer.parseInt(dato[1])];
		}
		
	}

	public int solve(String n1, String n2, int i) {	
		solve(getNodo(n1),getNodo(n2),0);
		return getNodo(n2).getLongitud();
	}
	
	public int solveNoOptimizado(String n1, String n2, int i) {	
		solveNoOptimizado(getNodo(n1),getNodo(n2),0);
		return getNodo(n2).getLongitud();
	}

	private int solve(Nodo nodo, Nodo nodo2, int i) {
		LinkedList<Nodo> cola = new LinkedList<Nodo>();
		cola.addFirst(nodo);
		nodo.setVisitado();
		boolean found = false;;
		while(! cola.isEmpty() && !found){
			Nodo actual;
			actual = cola.pop();
			List<Nodo> vecinos = actual.getVecinos();		
			for (int k = 0; k < vecinos.size() ; k++) {
				Nodo vecinoActual = vecinos.get(k);
				
				if (!vecinoActual.getVisitado()){
					vecinoActual.setVisitado();
					vecinoActual.setLongitud(actual.getLongitud()+1);
					cola.push(vecinoActual);
					if (vecinoActual.getId() == nodo2.getId()) {
						found = true;
					}
				}
			}	
		}
		return nodo2.getLongitud();	
	}
	
	private int solveNoOptimizado(Nodo nodo, Nodo nodo2, int i) {
		LinkedList<Nodo> cola = new LinkedList<Nodo>();
		cola.addFirst(nodo);
		nodo.setVisitado();
		while(! cola.isEmpty()){
			Nodo actual;
			actual = cola.pop();
			List<Nodo> vecinos = actual.getVecinos();		
			for (int k = 0; k < vecinos.size() ; k++) {
				Nodo vecinoActual = vecinos.get(k);
				
				if (!vecinoActual.getVisitado()){
					vecinoActual.setVisitado();
					vecinoActual.setLongitud(actual.getLongitud()+1);
					cola.push(vecinoActual);
				}
			}	
		}
		return nodo2.getLongitud();	
	}
}
