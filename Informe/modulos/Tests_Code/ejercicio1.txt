package tp2.exercises;

import java.util.List;

public class Exercise1 {
	private static int[][] matriz;
	private static int[]  mejores;
	
	public  Exercise1(int pisos,List<Portal> portales) {
		pisos++;
		matriz = new int[pisos][pisos];
		mejores = new int[pisos];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (j == i){
					matriz[i][j] = 0;
				} else {
					matriz[i][j] = -2;
				}
			}
		}
		
		for (int i = 0; i < portales.size(); i++) {
			matriz[(Integer) portales.get(i).getDesde()][(Integer) portales.get(i).getHasta()] = -1;
		}				
	}
	
	static int solve() {
		for (int i = 0; i < matriz.length -1; i++) {
			if (matriz[i][matriz.length-1] == -1){
				matriz[i][matriz.length-1] = 1;
				mejores[i] = 1;
			} else {
				mejores[i] = -2;
			}
		}
		
		for (int i = matriz.length -2; i >= 0; i--) {
			for (int j = matriz.length - 2; j > i; j--) {
				if (matriz[i][j] == -1 && mejores[j] > 0 ){
					matriz[i][j] = mejores[j] + 1;
					mejores[i] = Math.max(mejores[i], matriz[i][j]);
				}
			}
		}
		return mejores[0];	
	}
}
