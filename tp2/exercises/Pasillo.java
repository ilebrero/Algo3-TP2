package tp2.exercises;

public class Pasillo implements Comparable<Pasillo> {

	private int extremo1;
	private int extremo2;
	private int longitud;

	public Pasillo( int e1, int e2, int l ) {
		setExtremo1( e1 );
		setExtremo2( e2 );
		setLongitud( l );
	}

	public int compareTo( Pasillo other ) {
		if ( lessThan( other ) ) {
			return -1;
		} else if ( other.lessThan( this ) ) {
			return 1;
		} else {
		   return 0;
		}
   }

   public boolean lessThan( Pasillo otro ) {
      if ( getLongitud() != otro.getLongitud() ) {
         return getLongitud() > otro.getLongitud();
      } else if ( getExtremo1() != otro.getExtremo1() ) {
         return getExtremo1() < otro.getExtremo1();
      } else {
         return getExtremo2() < otro.getExtremo2();
      }
   }

	// Accessors
   public int getExtremo1() {                   return extremo1;        }
   public void setExtremo1( int extremo ) {     extremo1 = extremo;     }

   public int getExtremo2() {                   return extremo2;        }
   public void setExtremo2( int extremo ) {     extremo2 = extremo;     }

   public int getLongitud() {                   return longitud;        }
   public void setLongitud( int l ) {           longitud = l;           }
   
}