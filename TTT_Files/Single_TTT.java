import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 0 1 2
// 3 4 5
// 6 7 8

public class Single_TTT {
    // globals
    static int player_move = -1;
    static int computer_move = -1;
    static Scanner scan = new Scanner(System.in);
    static List<String> board = new ArrayList<String>();

    // return the bool to stop game and print winning statement
    static boolean check_for_win(List<String> board) {
        // varis for counting
        int player_counter = 0;
        int computer_counter = 0;
        // int adder;

        // looking for vertical wins

        for (int a = 0; a < 3; a++) {
            player_counter = 0;
            computer_counter = 0;
            for (int x = 0; x < 3; x++) {
                int spot = a + (3 * x);
                if (board.get(spot) == "X") {
                    player_counter += 1;
                } else if (board.get(spot) == "O") {
                    computer_counter += 1;
                }
            }
            if (computer_counter == 3) {
                System.out.println("The Computer Wins!");
                return true;
            } else if (player_counter == 3) {
                System.out.println("You Win!");
                return true;
            }
        }

        // looking for horizontal wins
        for (int b = 0; b < 3; b++) {
            player_counter = 0;
            computer_counter = 0;
            for (int y = 0; y < 3; y++) {
                // adder = a*3;
                int spot = (3 * b) + y;
                if (board.get(spot) == "X") {
                    player_counter += 1;
                } else if (board.get(spot) == "O") {
                    computer_counter += 1;
                }
            }
            if (computer_counter == 3) {
                System.out.println("The Computer Wins!");
                return true;
            } else if (player_counter == 3) {
                System.out.println("You Win!");
                return true;
            }
        }

        // looking for the diagonal wins
        if (board.get(0) == "X" & board.get(4) == "X" & board.get(8) == "X") {
            System.out.println("You Win!");
            return true;
        }
        if (board.get(2) == "X" & board.get(4) == "X" & board.get(6) == "X") {
            System.out.println("You Win!");
            return true;
        }

        if (board.get(0) == "O" & board.get(4) == "O" & board.get(8) == "O") {
            System.out.println("The Computer Wins!");
            return true;
        }
        if (board.get(2) == "O" & board.get(4) == "O" & board.get(6) == "O") {
            System.out.println("The Computer Wins!");
            return true;
        }
        // return if nothing happens
        return false;
    }

    // prints the board every turn
    static void print_board(List<String> board) {
        System.out.println("[ " + board.get(0) + " " + board.get(1) + " " + board.get(2) + " ]");
        System.out.println("[ " + board.get(3) + " " + board.get(4) + " " + board.get(5) + " ]");
        System.out.println("[ " + board.get(6) + " " + board.get(7) + " " + board.get(8) + " ]");
    }

    // gets the user input and checks for dups.
    static void get_player_move() {
        System.out.println("It's Your Turn!");
        System.out.print("Input your move! (123,456,789):");

        // System.out.println(board);

        // checks for input duplications
        player_move = (scan.nextInt() - 1);
        while (board.get(player_move) == "X" | board.get(player_move) == "O" | player_move > 9) {
            System.out.println("Enter Again, that spots taken!:");
            player_move = (scan.nextInt() - 1);
        }
        board.set(player_move, "X");
        player_move = -1;
    }

    static void get_computer_move() {
        System.out.println("The Computer is going");
        // System.out.println(board);

        // checks for input duplications
        int rand = (int) (Math.random() * 8);
        while (board.get(rand) == "X" | board.get(rand) == "O") {
            rand = (int) (Math.random() * 8);
        }
        board.set((int) rand, "O");
    }

    public static void main(String[] args) throws InterruptedException {
        // declarations
        boolean game = true;
        // List<String> board = new ArrayList<String>();
        int turn_counter;

        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("Player is X, Computer is O.");

        // initializing List with all 0s
        for (int i = 0; i < 9; i++) {
            board.add("-");
        }
        turn_counter = 0;

        // main game loop
        while (game == true) {
            System.out.println();

            if (turn_counter % 2 == 1) {
                get_player_move();
            }
            if (turn_counter % 2 == 0) {
                get_computer_move();
            }

            Thread.sleep(1000);
            turn_counter += 1;
            print_board(board);
            if (check_for_win(board) | (turn_counter > 9)) {
                Thread.sleep(5000);
                break;
            }
        }

    }
}