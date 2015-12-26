package tp2.exercises;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.junit.Test;

import tp2.exercises.Baldoza;
import tp2.exercises.Exercise2;
import tp2.exercises.Portal;

public class TestEj2 {


   @Test
   public void fileWritingRunTest() throws IOException {
      // Con este test se lee el archivo de entrada proporcioando por la catedra 
      //    y se genera la salida
      BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.in" ) ) );
      //BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej2.test.out" ) );
      BufferedWriter os = new BufferedWriter( new FileWriter( "Tp2Ej2.test.out"  ) );
      String line;
      while ( ( line = is.readLine() ) != null ) {
         os.append( run( line, is.readLine() ) ).append( '\n' );
      }
      os.close();
      is.close();
      
   }

   @Test
   public void fileTestingRunTest() throws IOException {
      // Con este test se compara un archivo de entrada con el formato de la catedra 
      //    contra otro archivo con valores esperados
      BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.in" ) ) );
      BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej2.out" ) ) );
      
      String line;
      while ( ( line = source.readLine() ) != null ) {
         assertEquals( control.readLine(), run( line, source.readLine() ) );
      }
      
      source.close();
      control.close();
      
      
   }

   private String run( String a, String b ) {
      StringTokenizer datos = new StringTokenizer( a, " " );
      
      return String.valueOf( new Exercise2( Integer.parseInt( datos.nextToken() ), 
                                             Integer.parseInt( datos.nextToken() ), 
                                             parsePortales( b ) ).solve() );
   }

   private List<Portal<Baldoza>> parsePortales( String line ) {
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();

      StringTokenizer st = new StringTokenizer( line, ";" );
      while ( st.hasMoreTokens() ) {
         StringTokenizer portal = new StringTokenizer( st.nextToken(), " " );
         portales.add( new Portal<Baldoza>( new Baldoza( Integer.parseInt( portal.nextToken() ), 
                                                Integer.parseInt( portal.nextToken() ) ), 
                                   new Baldoza( Integer.parseInt( portal.nextToken() ), 
                                                Integer.parseInt( portal.nextToken() ) ) ) );
      }

      return portales;
   }

	@Test
	public void test0() {
		ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		portales.add( new Portal<Baldoza>( new Baldoza( 0, 10 ), new Baldoza( 10, 1 ) ) );

		assertEquals( 21, new Exercise2( 10, 10, portales ).solve() );
	}
//
   @Test
   public void test1() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 2 ), new Baldoza( 2, 3 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 4 ), new Baldoza( 3, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 1 ), new Baldoza( 4, 5 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 4, 3 ), new Baldoza( 5, 2 ) ) );

      assertEquals( 17, new Exercise2( 5, 5, portales ).solve() );
   }

   @Test
   public void test2() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 2 ), new Baldoza( 2, 3 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 4 ), new Baldoza( 3, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 1 ), new Baldoza( 4, 5 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 4, 3 ), new Baldoza( 5, 2 ) ) );

      assertEquals( 17, new Exercise2( 5, 5, portales ).solve() );
   }
   @Test
   public void test3() {
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 1 ), new Baldoza( 1, 2 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 1, 2 ), new Baldoza( 3, 1 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 2, 3 ), new Baldoza( 4, 0 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 3, 4 ), new Baldoza( 2, 1 ) ) );

      assertEquals( 18, new Exercise2( 4, 4, portales ).solve() );
   }
   
   @Test
   public void test4() { 
      
      ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 0 ), new Baldoza( 0, 4 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 0, 4 ), new Baldoza( 4, 0 ) ) );
      portales.add( new Portal<Baldoza>( new Baldoza( 4, 0 ), new Baldoza( 4, 4 ) ) );

      assertEquals( 6, new Exercise2(4, 4, portales ).solve() );
   }
   
   @Test
   public void bestCaseTest() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("BEST CASE -----");
	   
	   for (int i = 4; i < 1000; i++) {		  
		   tiempos = new double[5];		
		
			for (int l = 0; l < 5; l++){
				ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
				portales = generateBestCasePortals(i);
				
				tiempo = System.nanoTime();
				new Exercise2( i, i, portales ).solve();
				tiempo = System.nanoTime() - tiempo;
	
				tiempos[l] = tiempo;
			  }
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	   }
	   System.out.println();
   }
   
   @Test
   public void worstCaseTest() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("WORST CASE -----");
	   
	   for (int i = 4; i < 1000; i++) {
		   tiempos = new double[5];		
		
		   for (int l = 0; l < 5; l++){
			   ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
			   portales = generateWorstCasePortals(i);
			   
			   tiempo = System.nanoTime();
			   new Exercise2( i, i, portales ).solve();
			   tiempo = System.nanoTime() - tiempo;
				
			   tiempos[l] = tiempo;
			}
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	  }
	  System.out.println();
   }
   
   @Test
   public void averageCaseTest() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("AVERAGE CASE -----");
	   
	  for (int i = 4; i < 1000; i++) {
		tiempos = new double[5];		
		
		for (int l = 0; l < 5; l++){
			ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
			portales = generateAverageCasePortals(i);
			
			tiempo = System.nanoTime();
			new Exercise2( i, i, portales ).solve();
			tiempo = System.nanoTime() - tiempo;
			
			tiempos[l] = tiempo;
		}
		System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	  }
	  System.out.println();
   }
   
   @Test
   public void bestCaseTestNoOptimizado() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("BEST CASE NO OPTIMIZADO-----");
	   
	   for (int i = 4; i < 1000; i++) {		  
		   tiempos = new double[5];		
		
			for (int l = 0; l < 5; l++){
				ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
				portales = generateBestCasePortals(i);
				
				tiempo = System.nanoTime();
				new Exercise2( i, i, portales ).solveNoOptimizado();
				tiempo = System.nanoTime() - tiempo;
	
				tiempos[l] = tiempo;
			  }
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	   }
	   System.out.println();
   }
   
   @Test
   public void worstCaseTestNoOptimizado() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("WORST CASE NO OPTIMIZADO-----");
	   
	   for (int i = 4; i < 1000; i++) {
		   tiempos = new double[5];		
		
		   for (int l = 0; l < 5; l++){
			   ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
			   portales = generateWorstCasePortals(i);
			   
			   tiempo = System.nanoTime();
			   new Exercise2( i, i, portales ).solveNoOptimizado();
			   tiempo = System.nanoTime() - tiempo;
				
			   tiempos[l] = tiempo;
			}
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	  }
	  System.out.println();
   }
   
   @Test
   public void averageCaseTestNoOptimizado() {
	   double tiempo ;
	   double[] tiempos = null;
	   System.out.println("AVERAGE CASE NO OPTIMIZADO-----");
	   
	  for (int i = 4; i < 1000; i++) {
		tiempos = new double[5];		
		
		for (int l = 0; l < 5; l++){
			ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
			portales = generateAverageCasePortals(i);
			
			tiempo = System.nanoTime();
			new Exercise2( i, i, portales ).solveNoOptimizado();
			tiempo = System.nanoTime() - tiempo;
			
			tiempos[l] = tiempo;
		}
		System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
	  }
	  System.out.println();
   }
   
   /*@Test
	public void generateAllBestCase() {
		for (int i = 0; i < 1000000; i++) {
			tp1.main.Main.testCatedraEj2Params("1 4 8 7 6 8 1 2 4 5 6 8 4 3");
		}

		double tiempo ;
		double[] tiempos = null;
		System.out.println("WORST CASE -----");
		String string;
		for (int i = 0; i < 1000; i += 2) {
			string = "2";
			for (int j = 0; j < i ; j++) {
				if (j % 2 == 0){
					string = string + " 1";
				} else {
					string = string + " 3";
				}
			}
			tiempos = new double[5];
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				tp1.main.Main.testCatedraEj2Params(string);
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			System.out.println(obtenerPromedio(tiempos) + ";");
		}	
		System.out.println("--------------");
	}
   */
   public double obtenerPromedio(double[] tiempos){
		Arrays.sort(tiempos);
		double promedio = tiempos[0];
		for (int i = 2; i < tiempos.length -1; i++) {
			promedio += tiempos[i];
		}
		promedio = promedio/3/1000;		
		
		return promedio;
	}
   

   /*------------------- Generadores de portales -----------------------*/
   
   public ArrayList<Portal<Baldoza>> generateBestCasePortals(int i){
	   ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
	   int portals = (int) ( Math.random() * 100 % i ) + 1;
		  
	    portales.add( new Portal<Baldoza>( new Baldoza( 0, 1 ), new Baldoza( i, i ) ) );
		
		for (int j = 0; j < portals; j++) {
			int p1  = (int) ( Math.random() * 100 % (i+1) );
			int p2  = (int) ( Math.random() * 100 % (i+1) );
			int p1m = (int) ( Math.random() * 100 % (i+1) );
			int p2m = (int) ( Math.random() * 100 % (i+1) );
			 
		    portales.add( new Portal<Baldoza>( new Baldoza( p1, p1m ), new Baldoza( p2, p2m ) ) );
		}
		
		return portales; 
   }
   
   public ArrayList<Portal<Baldoza>> generateWorstCasePortals(int i){
	    ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>(); 
	    int portals = (int) ( Math.random() * 100 % i );
	   
	    portales.add( new Portal<Baldoza>( new Baldoza( i-1, 0 ), new Baldoza( i, 0 ) ) );
		//esto obliga a que se generen portales entre todos los pisos
		int anterior = 0;
		while (anterior != i-1) {
			int p1  = anterior;
			int p2  = (int) ( Math.random() * 100 % (i) );
			int p1m = (int) ( Math.random() * 100 % (i+1) );
			int p2m = (int) ( Math.random() * 100 % (i+1) );
			  
			portales.add( new Portal<Baldoza>( new Baldoza( p1, p1m ), new Baldoza( p2, p2m ) ) );
			anterior++;
		}
		
		for (int j = 0; j < portals; j++) {
			int p1  = (int) ( Math.random() * 100 % (i+1) );
			int p2  = (int) ( Math.random() * 100 % (i+1) );
			int p1m = (int) ( Math.random() * 100 % (i+1) );
			int p2m = (int) ( Math.random() * 100 % (i+1) );
			 
		    portales.add( new Portal<Baldoza>( new Baldoza( p1, p1m ), new Baldoza( p2, p2m ) ) );
		}
		
		return portales;
   }
   
   public ArrayList<Portal<Baldoza>> generateAverageCasePortals(int i){
	   ArrayList<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
	   int portals = (int) ( Math.random() * 100 % i ) + 1;
		  
		//esto obliga a que se generen portales entre todos los pisos
		int anterior = 0;
		while (anterior != i) {
			int p1  = anterior;
			int p2  = (int) ( Math.random() * 100 % (i - anterior - 1) ) + anterior + 1;
			int p1m = (int) ( Math.random() * 100 % (i+1) );
			int p2m = (int) ( Math.random() * 100 % (i+1) );
			  
			portales.add( new Portal<Baldoza>( new Baldoza( p1, p1m ), new Baldoza( p2, p2m ) ) );
			anterior = p2;
		}
		  
		for (int j = 0; j < portals; j++) {
			int p1  = (int) ( Math.random() * 100 % (i+1) );
			int p2  = (int) ( Math.random() * 100 % (i+1) );
			int p1m = (int) ( Math.random() * 100 % (i+1) );
			int p2m = (int) ( Math.random() * 100 % (i+1) );
			 
		    portales.add( new Portal<Baldoza>( new Baldoza( p1, p1m ), new Baldoza( p2, p2m ) ) );
		}
		
		return portales;
   }
   
}