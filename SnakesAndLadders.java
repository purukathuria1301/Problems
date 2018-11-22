package GraduateAlgorithms;

public class SnakesAndLadders {
	
	

	public static void boardGameSnL(int src, int dest, int []moves, int snakesLadders[]) {
		
		/*
		 * base case: 1. if source becomes the destination then you win, game ends
		 * 			  2. Moves finished, you lose	
		 */
		
		/*
		 * case 1: if the board is not open yet.
		 * open to the board when 1 or 6 comes on the dice
		 */
		
		/*
		 * case 2
		 * if board is open which means source is non zero. 
		 * 			-1. now do the snake/ladder move 
							OR
					-2.  do the normal move if no snake or ladder exists at the current source 
					
					make sure in 2. you dont go beyond destination.
		 */			
		
		/*
		 * TestCase: 
		 * int snl[] = new int[21];
		 * snl[3] = 17; ladder
		 * snl[7] = 11; ladder
		 * snl[13] = 5; snake
		 * snl[19] = 2;snake
		 * 		 
		 * 
		 * int moves[] = {2,5,3,4,6,3,4,3,5,1,2,3}; lose case
		 * int moves2[] = {2,5,3,4,6,3,4,3,5,1,1,6,5,2,3,5}; win case
		 *  int src = 0;
		 *  int dest = 20;
		 * 
		 * 
		 * 		 * */
		snakesLaddersUtility(src, dest, snakesLadders, moves, 0);

	}

	private static void snakesLaddersUtility(int src, int dest, int[] snl, int moves[], int mvidx) {
		if(src == dest){
			System.out.println("you win");
			return;
			
		}
		if(mvidx == moves.length){
			System.out.println("You lose standing here "+src);
			return;
		}
		
		
		if (src == 0) {
			// open if 1 or 6 arrives.
			if (moves[mvidx] == 1 || moves[mvidx] == 6) {
				src = 1;
				snakesLaddersUtility(src, dest, snl, moves, mvidx + 1);
			} else {
				src = 0;
				// stay at zero only, coz you havent arrived at your first 1 or
				// 6
				snakesLaddersUtility(src, dest, snl, moves, mvidx + 1);

			}
		} else {
			// board is open now:
			// that means src is a non zero value. so keep on taking the jump
			// moves

			if (snl[src] != 0) {
				// snake or ladder ki move, no change in move index
				snakesLaddersUtility(snl[src], dest, snl, moves, mvidx);
			} else {

				snakesLaddersUtility((src + moves[mvidx] <= dest) ? src + moves[mvidx] : src, dest, snl, moves,
						mvidx + 1);

			}
		}
	}

}
