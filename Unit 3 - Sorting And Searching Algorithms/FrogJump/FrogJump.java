public class FrogJump {
    public static void main(String args[]) {
        new FrogJump();
    }
    char board[] = {'x', 'x', 'x', 'x', '_', 'y', 'y', 'y', 'y'};

    public boolean valid(int pos1, int pos2) {
        if(board[pos1] == '_') {
            return false;
        } else if(board[pos2] != '_') {
            return false;
        } else if(pos1 + 1 == pos2) {
            return true;
        } else if(pos2 + 1 == pos1) {
            return true;
        } else if (pos1 + 2 == pos2) {
            return true;
        } else if(pos2 + 2 == pos1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean done() {
        if(board[0] != 'y') {
            return false;
        } else if(board[1] == 'y') {
            return false;
        } else if(board[2] == 'y') {
            return false;
        } else if(board[3] == 'y') {
            return false;
        } else if(board[4] == '_') {
            return false;
        } else if(board[5] == 'x') {
            return false;
        } else if(board[6] == 'x') {
            return false;
        } else if(board[7] == 'x') {
            return false;
        } else if(board[8] == 'x') {
            return false;
        } else {
            return true;
        }
    }

    public FrogJump() {
        int moves = 0;
        while(!done()) {
            System.out.println("\nYou have taken " + moves + " moves.\n");
            for(int i = 0; i < board.length; i++) {
                System.out.print("[" + i + "]");
            }
            System.out.println();
            for(int i = 0; i < board.length; i++) {
                System.out.print(" " + board[i] + " ");
            }
            int pos1 = IO.inputInt("\n\nFrog Position: ");
            int pos2 = IO.inputInt("Position Jumps to: ");

            while(!valid(pos1, pos2)) {
                System.out.println("\nError, enter again.");
                pos1 = IO.inputInt("Frog Position: ");
                pos2 = IO.inputInt("Position Jumps to: ");
            }

            char temp = board[pos1];
            board[pos1] = board[pos2];
            board[pos2] = temp;
            moves++;
        }
    }
}