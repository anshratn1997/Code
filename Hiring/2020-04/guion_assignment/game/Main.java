package game;

import java.io.*;
import java.util.*;
import java.math.*;
class Main {

    private BufferedReader br;

    Main(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            new Main().solve(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void solve(int n) throws IOException {
        System.out.println("Please Enter y/n to play the game");
        boolean is_game_on = (br.readLine()).charAt(0) == 'y' ? true : false;

        while(is_game_on) {
            char[][] board = get_random_board(n);
            boolean[][] revealed_board = new boolean[n][n];

            print_board(board, revealed_board, false);
            System.out.println("Enter your move");

            int revealed_location_count = 0;

            while (true) {
                if (revealed_location_count == 56) { // 8*8 - number_of_mines_placed
                    System.out.println("**Congratulation you have won the game.**");
                    break;
                }
            
                String input = br.readLine();
                try {
                    if (board[input.charAt(1) - 48 - 1][input.charAt(0) - 65] == 'm') {
                        System.out.println("**Sorry you hit a mine**");
                        print_board(board, revealed_board, true);
                        break;
                    } else {
                        revealed_board[input.charAt(1) - 48 - 1][input.charAt(0) - 65] = true;
                        print_board(board, revealed_board, false);
                   }
                   revealed_location_count++;
                   System.out.println("Enter your next move");
                } catch(ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please enter correct move");
                }

            }

            System.out.println("Are you want to play again?(y/n)");
            is_game_on = (br.readLine()).charAt(0) == 'y' ? true : false;
        }
    }

    private void print_board(char[][] board, boolean[][] revealed_board, boolean reveal_complete_board) {
        for(int i = 0; i < board[0].length; i++ ) {
            for(int j = 0; j < board[0].length; j++ ) {
                if (!reveal_complete_board && revealed_board[i][j] == false) {
                    System.out.print("* ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private char[][] get_random_board(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < 8; i++ ) {
            for( int j = 0; j< 8; j++ ){
                board[i][j] = '0';
            }
        }
        Set<String> unique_mine_location = new HashSet<String>();
        while(unique_mine_location.size() != n) {
            int x = (int)(Math.random() * n) + 0;
            int y = (int)(Math.random() * n) + 0;
            String location = String.valueOf(x) + ":"  +  String.valueOf(y); 
            if (unique_mine_location.contains(location)) {
                continue;
            } else {
                unique_mine_location.add(location);
                board[x][y] = 'm';
            }
        }

        return update_board_with_mines_count(board);
    }

    private char[][] update_board_with_mines_count(char[][] board) {

        int dx[] = {-1 ,1, -1, 1, 0, 0, 1, -1};
        int dy[] = {-1 ,1, 1, -1, 1, -1, 0, 0};

        for(int i = 0; i < board[0].length; i++ ) {
            for( int j = 0; j < board[0].length; j++ ) {
                int count = 0;
                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (valid(x, y, board[0].length) && board[x][y] == 'm') {
                        count++;
                    }
                }
                if (count > 0) {
                    board[i][j] = String.valueOf(count).charAt(0);
                }
            }
        }
        return board;
    }

    private boolean valid(int x, int y, int n) {
        if (x >= 0 && x < n && y >= 0 && y < n)
            return true;
        return false;
    }
} 