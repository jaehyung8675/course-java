/*Name: Jaehyung Kim
ID Number: 47248972
Lab 5-Fall 2018*/

import java.util.Random; // program uses class Random

public class BatterUp4 {

	// initializing players and store names
	static String[] players = {"Odor", "Choo", "Gallo", "Andrus", "Profar", "Mazara", "Colon", "Minor", "Guzman"}; 
	static int[] playerLocation = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
	static int score = 0;
	
	public static void main(String[] args) {
		
		int outs = 0; // initialize outs
		
		// while loop until 3 outs
		while ( outs < 3 ) {
			
			for ( int i = 0; i < players.length; i++ ) {
				
				System.out.printf("SCORE: %d\n", score);
				System.out.printf("%s is at bat with %d outs\n", players[i], outs);
				
				playerLocation[i] = 0;
				
				// if the player's turn over by strike out, increment outs value
				if ( batterTakeTurn() == true ) {
					outs++;
					playerLocation[i] = -1;
				}
				
				// if outs equal three, break out of loop
				if ( outs == 3 ) 
					break;
				
				System.out.println();
			} // end for loop
		} // end while loop
							
		System.out.printf("%d outs - next team!", outs); // display 3 outs and next team
		
		
	} // end main method
	
	// declaration of method movePlayers
	public static void movePlayers ( int x ) {
	
		for ( int i = 0; i < playerLocation.length; i++ ) { 
			
			
			if ( playerLocation[i] != -1 ) {
				playerLocation[i] += x; 
				
				if ( playerLocation[i] > 3) {
					score++;
					System.out.printf("%s scored!!\n", players[i]);
					playerLocation[i] = -1;
				}
			} // end if 
		} // end for loop
	} // end method movePlayers
	
	// declaration of method boolean battertaketurn
	public static boolean batterTakeTurn() {
		
		int ball = 0; // initialize ball
		int strike = 0; // initialize strike
		
		while ( true ) {
			
			int batting = bat(); // execute bat method and stores each return value generated  
				
				// if else to print the results of swing of the bat  
				if ( batting == 1 ) {
		
					System.out.print(" Single!\n");
					movePlayers(1);
					break; // terminate loop
					
				} else if ( batting == 2 ) {
					
					System.out.print(" Double!\n");
					movePlayers(2);
					break; // terminate loop
					
				} else if ( batting == 3 ) {
					
					System.out.print(" Triple!\n");
					movePlayers(3);
					break; // terminate loop
					
				} else if ( batting == 4 ) {
					
					System.out.print(" Home run!\n");
					movePlayers(4);
					break; // terminate loop
					
				} else if ( batting == -1 ) {
					System.out.print(" Strike!\n");
					strike++;
					
						// if 3 strike, terminate loop 
						if ( strike == 3 ) {
							System.out.println("  Strike out!!");
							return true;
						} // end if nested another if...else
					
				} else {
					
					System.out.print(" Ball!\n");
					ball++;
						
						// if 4 ball, terminate loop 
						if ( ball == 4 ) {
							System.out.println("  Walk");
							movePlayers(1);
							break;
						} // end if nested another if...else
				} // end if loop
		} // end while 
		
		return false;
		
	} // end method batterTakeTurn
	
	// declaration of method bat
	public static int bat() {
		
		Random randomNumbers = new Random(); // random number generator
		
		// pick random integer from 1 to 6
		int rollOne = 1 + randomNumbers.nextInt(6);
		int rollTwo = 1 + randomNumbers.nextInt(6);
		
		// print two roll values
		System.out.printf("  Rolled %d %d ", rollOne, rollTwo);
		
		int sum = rollOne + rollTwo; // initialize the total to store the sum of two values
		
		// if else to return the value based on the table
		if ( rollOne == 1 && rollTwo == 1 ) {
			return 1;
		} else if ( rollOne == 2 && rollTwo == 2 ) {
			return 2;
		} else if ( rollOne == 3 && rollTwo == 3 ) {
			return 3;
		} else if ( sum % 2 == 0 ) {
			return -1;
		} else {
			return -2;
		}
	} // end method bat
	

} // end class BatterUp4