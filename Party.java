import java.util.*;
import java.io.*;

public class Party {
	
	private final static int partySize = 4;
	private PlayerCharacter [] players = new PlayerCharacter[ 4 ];
	private String partyName;
	private Scanner fileScanner;
	static Scanner userInput = new Scanner( System.in );
	PrintWriter out;

	public Party( String partyName, PlayerCharacter [] players ) {
		
		this.partyName = partyName;
		if( players.length <= partySize ) {
			this.players = players;
		}
	
	}

	public Party( String fileName ) throws Exception {

		fileScanner = new Scanner( new File( fileName ) );
		parseFile();

	}

	public Party() {
        players = new PlayerCharacter[ partySize ];
        createParty();
    }

	public void setWriteFile( String fileName ) throws Exception {
		out = new PrintWriter( new File( fileName ) );
		out.println( partyName );
		for( PlayerCharacter player : players ) {
			out.println( player );
		}
		out.close();
	}

	public void parseFile() throws Exception {
		this.partyName = fileScanner.nextLine();
		for( int i = 0; i < partySize; i++ ) {
			players[i] = PlayerCharacter.parseLine( fileScanner.nextLine() );
		}
	}

	public boolean charReroll( String name ) {
		for( PlayerCharacter player : players ) {
			if( player.getName().equals(name) ) {
				player.rerollChar( player );
				return true;
			}
		}
		return false;
	}

	private void createParty() {
		int knightCount = 0;
        int peasantCount = 0;
        int clericCount = 0;
        int mageCount = 0;
        int courtierCount = 0;

        System.out.println("Enter name of game");
        partyName = userInput.nextLine();
        
        for ( int i = 1; i <= partySize; i++ ){
            System.out.println("Enter type of PlayerCharacter #" + i + " (knight, peasant, cleric, mage, courtier)");
            String type = userInput.nextLine();
            if (type.toLowerCase().equals("knight")){
                knightCount++;
                if(knightCount > 2){
                    System.out.println("too many of given type please reenter");
                    i--;
                } else {
                    System.out.println("Enter name of PlayerCharacter");
                    String name = userInput.nextLine();
                    players[ i ] = new PlayerCharacter( name, type );
                }
            } else if (type.toLowerCase().equals("peasant")){
                peasantCount++;
                if(peasantCount > 2){
                    System.out.println("too many of given type please reenter");
                    i--;
                } else {
                    System.out.println("Enter name of PlayerCharacter");
                    String name = userInput.nextLine();
                    players[ i ] = new PlayerCharacter( name, type );
                }
            } else if (type.toLowerCase().equals("cleric")){
                clericCount++;
                if(clericCount > 2){
                    System.out.println("too many of given type please reenter");
                    i--;
                } else {
                    System.out.println("Enter name of PlayerCharacter");
                    String name = userInput.nextLine();
                    players[ i ] = new PlayerCharacter( name, type );
                }
            } else if (type.toLowerCase().equals("mage")){
                mageCount++;
                if(mageCount > 2){
                    System.out.println("too many of given type please reenter");
                    i--;
                } else {
                    System.out.println("Enter name of PlayerCharacter");
                    String name = userInput.nextLine();
                    players[ i ] = new PlayerCharacter( name, type );
                }
            } else if (type.toLowerCase().equals("courtier")){
                courtierCount++;
                if(courtierCount > 2){
                    System.out.println("too many of given type please reenter");
                    i--;
                } else {
                    System.out.println("Enter name of PlayerCharacter");
                    String name = userInput.nextLine();
                    players[ i ] = new PlayerCharacter( name, type );
                }
            }
        }
	}

}