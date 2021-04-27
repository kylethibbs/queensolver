package queens;

// Created by
public class QueenSolver {
    int n = 5; // size of board.
    boolean board[][] = new boolean[n][n];  // true if has queen
    int nSafeSpotsConsidered = 0;
    int nSolutions;

    public void clearBoard(){
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board[1].length; j++){
                board[i][j] = false;
            }
        }
    }

    public void printBoard() { 
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board[1].length; j++){
                if (board[i][j] == true){
                    System.out.print(" X ");
                }
                else{
                    System.out.print(" - ");
                }                    
            }
            System.out.print("\n");
        }
     
    }

    // Returns true if ok to put queen in given spot.
    // Handles the case when the spot is already filled (that's considered ok).
    public boolean isSafeToPutQueenHere(int hereR, int hereC){
        boolean safe = true;

        for(int i = 0; i < board.length; i++){
            if(board[i][hereC]==true){
                safe = false;
            }
        }

        for(int i = 0; i < board[1].length; i++){
            if(board[hereR][i]==true){
                safe = false;
            }
        }

        int tempC = hereC;
        int tempR = hereR;
        while(tempC >= 0 && tempR >= 0){
            System.out.println(tempC);
            System.out.println(tempR);

            if(board[tempR][tempC]==true){
                safe = false;
            }
            tempC--;
            tempR--;
        }

        tempC = hereC;
        tempR = hereR;
        while(tempC <= board[1].length-1 && tempR <= board.length-1){
            System.out.println(tempC);
            System.out.println(tempR);

            if(board[tempR][tempC]==true){
                safe = false;
            }
            tempC++;
            tempR++;
        }

        return safe;
    }

    public void solveByBruteForce() {
    }

    public void solveByBruteForcePruning() {
    }

    public boolean solveRecursivelyPutQueenInThisColumn(int c) {
        
        return true;
    }

    public static void main(String[] args) {
        QueenSolver solver = new QueenSolver();

        // Test Case: printBoard()
        System.out.println("Print board test case:");
        solver.board[0][0] = true;
        solver.board[1][1] = true;
        solver.board[2][1] = true;
        solver.printBoard();

        // Test Case: clearBoard()
        System.out.println("Clear board test case:");
        solver.clearBoard();
        solver.printBoard();

        // Test Case: isSafeToPutQueenHere
        System.out.println("Safe spot test case:");
        solver.clearBoard();
        System.out.println(solver.isSafeToPutQueenHere(4,4) == true ? "1 Passed" : "1 Failed");
        solver.board[4][4] = true;
        System.out.println(solver.isSafeToPutQueenHere(4,4) == false ? "2 Passed" : "2 Failed");
        System.out.println(solver.isSafeToPutQueenHere(1,1) == false ? "3 Passed" : "3 Failed");
        System.out.println(solver.isSafeToPutQueenHere(4,0) == false ? "4 Passed" : "4 Failed");
        System.out.println(solver.isSafeToPutQueenHere(0,4) == false ? "5 Passed" : "5 Failed");
        System.out.println(solver.isSafeToPutQueenHere(0,4) == false ? "6 Passed" : "6 Failed");
        // System.out.println(solver.isSafeToPutQueenHere(2,6) == false ? "7 Passed" : "7 Failed");
        // System.out.println(solver.isSafeToPutQueenHere(5,3) == false ? "8 Passed" : "8 Failed");
        // System.out.println(solver.isSafeToPutQueenHere(6,6) == false ? "9 Passed" : "9 Failed");

        // Test Case: brute force without pruning
        System.out.println("Brute force without pruning:");
        solver.clearBoard();
        solver.solveByBruteForce();
        System.out.println("Numbers spots that were checked if safe for a queen: " +
                solver.nSafeSpotsConsidered);
        System.out.println("Numbers of solutions: " +
                solver.nSolutions);

        // Test Case: brute force with pruning
        System.out.println("Brute force with pruning:");
        solver.clearBoard();
        solver.solveByBruteForcePruning();
        System.out.println("Numbers spots that were checked if safe for a queen: " +
                solver.nSafeSpotsConsidered);
        System.out.println("Numbers of solutions: " +
                solver.nSolutions);

        // Test Case: brute force recursively pruning
        System.out.println("Recursion:");
        solver.clearBoard();
        solver.solveRecursivelyPutQueenInThisColumn(0);
        System.out.println("Numbers spots that were checked if safe for a queen: " +
                solver.nSafeSpotsConsidered);
        System.out.println("Numbers of solutions: " +
                solver.nSolutions);
    }
}