import java.util.*;

public class Character {
	
	private String [] charTypes = { "Knight", "Peasant", "Cleric", "Mage", "Courtier" };
	private int [] rankNums = new int[ 5 ];
	private String [] abilityNames = { "strength", "toughness", "intelligence", "magic", "influence" };
	private Random rand = new Random();
	private String name;
	private String type;

	public Character( String name, String type, int [] rankNums ) {
		this.name = name;
		this.type = type;
		this.rankNums = rankNums;
	}

	public Character( String name, int[] rankNums ) {
		this.name = name;
		this.rankNums = rankNums;
	}

	public Character( String name, String type ) {
		this.name = name;
		this.type = type;
		this.rankNums = createRankings( getIndex( charTypes, type ) );
	}

	public int[] createRankings( int typePos ) {
		int[] tempRanks = new int[ 5 ];
		boolean isValid = true;
		while( isValid ) {

			for( int i = 0; i < 5; i++ ) {
				if( typePos == i ) {
					tempRanks[ i ] = ( 7 + ( int )( Math.random() * ( 10 - 7 ) + 1 ) );
				}
				else {
					tempRanks[ i ] = ( 1 + ( int )( Math.random() * ( 6 - 1 ) + 1 ) );
				}
			}

			isValid = checkValid( tempRanks );

		}
		return tempRanks;
	}

	private boolean checkValid( int[] tempRanks ) {
		int scoreSum = 0;
		for( int i : tempRanks ) 
			sum += i;
		return ( sum <= 28 && sum >= 8 );
	}

	private int getIndex( String[] s, String v ) {
      for ( int i = 0; i < s.length; i++ ) {
              if ( v.equals( s[ i ] ) ) { return i; }
          }
		return -1;
	}

	private int getIntIndex( int[] arr, int x ) {
		for( int i = 0; i < arr.length; i++ ) {
			if( x == arr[ i ] ) {
				return i;
			}
		}
		return -1;
	}

	private int getLargest( int[] arr ) {
		int max = arr[ 0 ];
		for( int i = 1; i < arr.length; i++ ) {
			if( arr[ i ] > max ) {
				max = arr[ i ];
			}
		}

		return max;
	}

	public String toString() {
        return name + "," + type + "," + rankNums[0] + "," + rankNums[1] + "," + rankNums[2] + "," + rankNums[3] + "," + rankNums[4];
    }

    public static Character parseLine( String line ) {
    	String[] arr = line.split( "," );
    	int[] scores = new int[5];
    	for( int i = 1; i < arr.length; i++ ) {
    		scores[ i - 1 ] = arr[ i ];
    	}
    	return new Character( arr[0], scores );
    }

    public boolean rerollChar( Character player ) {
    	int largest = getLargest( player.getRankNums() );
    	int index = getIntIndex( player.getRankNums(), largest );
    	this = new Character( player.getName(), charTypes[ index ] );
    }

    public String getName { return name; }
    public int[] getRankNums { return rankNums; }


}