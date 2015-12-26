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
import java.util.Random;
import java.util.StringTokenizer;

import org.junit.Test;

public class TestEj1 {

   @Test
   public void fileWritingRunTest() throws IOException {
      // Con este test se lee el archivo de entrada proporcioando por la catedra 
      //    y se genera la salida
      BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej1.in" ) ) );
      BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp2Ej1.test.out" ) );
      
      String line;
      while ( ( line = is.readLine() ) != null ) {
         os.append( run( line, is.readLine() ) ).append( '\n' );
      }
      os.close();
      
   }

   @Test
   public void fileTestingRunTest() throws IOException {
      // Con este test se compara un archivo de entrada con el formato de la catedra 
      //    contra otro archivo con valores esperados
      BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej1.in" ) ) );
      BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp2Ej1.out" ) ) );
      
      String line;
      while ( ( line = source.readLine() ) != null ) {
         assertEquals( control.readLine(), run( line, source.readLine() ) );
      }
      
   }

   private String run( String a, String b ) {
      return String.valueOf( new Exercise1( Integer.parseInt( a ), parsePortales( b ) ).solve() );
   }

	private List<Portal> parsePortales( String line ) {
      ArrayList portales = new ArrayList();

      StringTokenizer st = new StringTokenizer( line, ";" );
      while ( st.hasMoreTokens() ) {
         StringTokenizer portal = new StringTokenizer( st.nextToken(), " " );
         portales.add( new Portal( Integer.parseInt( portal.nextToken() ), 
                                   Integer.parseInt( portal.nextToken() ) ) );
      }

      return portales;
   }

   @Test
	public void test1() {
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 10 ) );
		
		assertEquals( 1, new Exercise1( 10, portales ).solve() );
	}

   @Test
   public void test2() {
      ArrayList portales = new ArrayList();
      portales.add( new Portal( 0, 6 ) );
      portales.add( new Portal( 2, 7 ) );
      portales.add( new Portal( 3, 8 ) );
      portales.add( new Portal( 6, 10 ) );

      assertEquals( 2, new Exercise1( 10, portales ).solve() );
   }

   @Test
   public void test2b() {
      ArrayList portales = new ArrayList();
      portales.add( new Portal( 0, 3 ) );
      portales.add( new Portal( 3, 10 ) );
      portales.add( new Portal( 3, 5 ) );
      portales.add( new Portal( 5, 6 ) );
      portales.add( new Portal( 6, 10 ) );

      assertEquals( 4, new Exercise1( 10, portales ).solve() );
   }

   @Test
   public voidtest2c(){
   	ArrayList portales = new ArrayList();
   	portales.add (new Portal (0,5));
   	portales.add (new Portal (1,6));
   	portales.add (new Portal (2,7));
   	portales.add (new Portal (5,9));

   	assertEquals (2, new Exercise1 (10, portales).solve());
   }


   @Test
   public void test3() {
      ArrayList portales = new ArrayList();
      portales.add( new Portal( 0, 1 ) );
      portales.add( new Portal( 1, 2 ) );
      portales.add( new Portal( 2, 10 ) );

      assertEquals( 3, new Exercise1( 10, portales ).solve() );
   }
   @Test
   public void test3i() {
      ArrayList portales = new ArrayList();
      portales.add( new Portal( 2, 10 ) );
      portales.add( new Portal( 1, 2 ) );
      portales.add( new Portal( 0, 1 ) );

      assertEquals( 3, new Exercise1( 10, portales ).solve() );
   }

	@Test
	public void test4() {
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 3, 8 ) );
		portales.add( new Portal( 6, 10 ) );
		portales.add( new Portal( 2, 7 ) );
		portales.add( new Portal( 0, 6 ) );

		assertEquals( 2, new Exercise1( 10, portales ).solve() );
	}
	
	@Test
	public void generateBestCase() {
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 3, 8 ) );
		portales.add( new Portal( 6, 10 ) );
		portales.add( new Portal( 2, 7 ) );
		portales.add( new Portal( 0, 6 ) );
		Exercise1 ex =new Exercise1( 1000, portales );
		for (int i = 0; i < 10; i++) {
			ex.solve();
		}
		String string;
		double tiempo ;
		double[] tiempos;
		System.out.println("BEST CASE EX1-----");
		
		
		for (int i = 1; i < 2000; i++) {
			tiempos = new double[5];
			portales = new ArrayList();
			ex = new Exercise1(i, portales);
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				ex.solve();
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
		}
	}
	
	
	@Test
	public void generateWorstCase() {
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 3, 8 ) );
		portales.add( new Portal( 6, 10 ) );
		portales.add( new Portal( 2, 7 ) );
		portales.add( new Portal( 0, 6 ) );
		Exercise1 ex =new Exercise1( 1000, portales );
		for (int i = 0; i < 10; i++) {
			ex.solve();
		}
		String string;
		double tiempo ;
		double[] tiempos;
		System.out.println("WORST CASE EX1-----");
		portales = new ArrayList();
		
		for (int i = 1; i < 2000; i++) {
			tiempos = new double[5];
			
			for (int j = 0 ; j < i ; j++){
				portales.add( new Portal(j , i ) );
			} 
			ex = new Exercise1(i, portales);
			for (int j = 0; j < tiempos.length; j++) {
				tiempo = System.nanoTime();
				ex.solve();
				tiempo = System.nanoTime() - tiempo;
				tiempos[j] = tiempo;
			}
			
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
		}
	}

	@Test
	   public void averageCaseTest() {
		   double tiempo ;
		   double[] tiempos = null;
		   System.out.println();
		   System.out.println("AVERAGE CASE EX1-----");
		   Random randomGenerator = new Random();
			
		   
		  for (int i = 4; i < 2000; i++) {
			
			  
			tiempos = new double[5];		  
			for (int l = 0; l < 5; l++){
				ArrayList portales = new ArrayList();
				int portals = i + 1;
				  
				//esto obliga a que se generen portales entre todos los pisos
				int anterior = 0;
				while (anterior != i) {
					int p1  = anterior;
					int p2  = randomGenerator.nextInt((i - anterior)) + anterior + 1;
					
//					  System.out.println("conecte :" + p1 + "con : " + p2 +"vale" +i);
					if (p2 < i){
					  portales.add( new Portal( anterior, p2 ) );
					}
					anterior = p2;
				}
				  
				for (int j = 0; j < portals; j++) {
					int p1  = (int) randomGenerator.nextInt(portals);
					int p2  = (int) randomGenerator.nextInt(portals);
//					System.out.println("conecte :" + p1 + "con : " + p2);
					portales.add( new Portal( p1, p2 ) );
				}
				
				Exercise1 ex = new Exercise1( 2000, portales );
				tiempo = System.nanoTime();
				ex.solve();
				tiempo = System.nanoTime() - tiempo;
				tiempos[l] = tiempo;
			  }
			System.out.print(Math.round( obtenerPromedio(tiempos) ) + ";");
		  }
	   }
	
	public double obtenerPromedio(double[] tiempos){
		Arrays.sort(tiempos);
		double promedio = 0;
		for (int i = 2; i < tiempos.length -1; i++) {
			promedio += tiempos[i];
		}
		return (promedio/3)/1000;
	}
}
