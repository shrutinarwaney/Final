import java.util.*;
import java.io.*;

public class Party {
	
	private final static int partySize = 4;
	private Character [] players = new Character[ 4 ];
	private String partyName;
	private Scanner fileScanner;
	private Scanner userInput = new Scanner( System.in );
	PrintWriter out;

	public Party( String partyName, Character [] players ) {
		
		this.partyName = partyName;
		if( players.length <= partySize ) {
			this.players = players;
		}
	
	}

	public Party( String fileName ) throws Exception {

		fileScanner = new Scanner( new File( fileName ) );
		parseFile();

	}

	public void setWriteFile( String fileName ) {
		out = new PrintWriter( new File( fileName ) );
		out.println( partyName );
		for( Character player : players ) {
			out.println( player );
		}
		out.close();
	}

	public void parseFile() throws Exception {
		this.partyName = fileScanner.nextLine();
		for( int i = 0; i < partySize; i++ ) {
			players[i] = Character.parseLine( fileScanner.nextLine() );
		}
	}

	public boolean charReroll( String name ) {
		for( Character player : players ) {
			if( player.getName().equals(name) ) {
				player.rerollChar( player );
				return true;
			}
		}
		return false;
	}

}