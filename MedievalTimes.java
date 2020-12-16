import java.util.*;
import java.io.*;

public class MedievalTimes {

	public static void main(String[] args) {
		Scanner userInput = new Scanner( System.in );
		System.out.println( "Welcome to medieval times!" );

		while( true ) {

			showMenu();
			System.out.print( "Enter option: " );
			int userOption = userInput.nextInt();

			switch( userOption ) {

				case 1:
					makeParty();
					break;
				case 2:
					validate();
					break;
				case 3:
					reroll();
					break;
				case 4:
					System.exit( 1 );
				default:
					System.out.println( "Not a valid input" );
					break;

			}

		}

	}

	 public static void showMenu() {
        System.out.println( "\nCreate new game (1) \nValidate/load save file (2) \nReroll existing character (3) \nQuit (4)" );  
    }

    public static void makeParty() {

    	Scanner userInput = new Scanner( System.in );

    	Party party = new Party();
    	System.out.print( "What file to save to? (include .txt): " );
    	String fileName = userInput.nextLine();
    	try {
    		party.setWriteFile( fileName );
    		System.out.println( "Game is created!" );
    	}
    	catch( Exception e ) {
    		System.out.println( "oops something went wrong" );
    	}

    }

    public static void validate() {

    	Scanner userInput = new Scanner( System.in );
    	System.out.print( "Enter a file to validate: " );
    	String fileName = userInput.nextLine();
    	try {
    		Party test = new Party( fileName );
    		System.out.println( "Validated" );
    	}
    	catch( IOException e ) {
    		System.out.println( "Not a file" );
    	}
    	catch( Exception e ) {
    		System.out.println( "Not a medieval times file" );
    		e.printStackTrace();
    	}

    }

    public static void reroll() {

    	Scanner userInput = new Scanner( System.in );
    	System.out.print( "Enter the file name where the game is: " );
    	String fileName = userInput.nextLine();
    	try {
    		Party test = new Party( fileName );
    		System.out.print( "Enter the name of the chatacter to randomize: " );
    		String characterName = userInput.nextLine();
    		
    		if( test.charReroll( characterName ) ) {
    			System.out.println( "Rerolled" );
    		} else {
    			System.out.println( "oops did not reroll" );
    		}
    	}
    	catch( IOException e ) {
    		System.out.println( "Not a file" );
    	}
    	catch( Exception e ) {
    		System.out.println( "Not a medieval times file" );
    		e.printStackTrace();
    	}


    }

}