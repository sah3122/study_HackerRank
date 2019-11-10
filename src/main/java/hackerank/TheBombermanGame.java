package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TheBombermanGame {
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        boolean check = true;
        //String[] result = new String[row];
        char[][] charGrid = new char[row][col];
        char[][] temp = new char[row][col];
        char[][] result = new char[row][col];
        //
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j++) {
                result[i][j] = 'O';
                charGrid[i][j] = grid[i].charAt(j);
            }
        }

        if( n == 1) return grid;
        else if(n % 2 == 0) {
            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j++) {
                    result[i][j] = 'O';
                    //charGrid[i][j] = grid[i].charAt(j);
                }
            }
        }
        else if(n % 4 == 1) {
            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j++) {
                    if(charGrid[i][j] == 'O') {
                        result[i][j] = '.';
                        if(i >= 1) result[i - 1][j] = '.';
                        if(i <= row - 2) result[i + 1][j] = '.';
                        if(j >= 1) result[i][j - 1] = '.';
                        if(j <= col - 2) result[i][j + 1] = '.';
                    }
                }
            }

            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j++) {
                    charGrid[i][j] = result[i][j];
                    result[i][j] = 'O';
                }
            }

            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j++) {
                    if(charGrid[i][j] == 'O') {
                        result[i][j] = '.';
                        if(i >= 1) result[i - 1][j] = '.';
                        if(i <= row - 2) result[i + 1][j] = '.';
                        if(j >= 1) result[i][j - 1] = '.';
                        if(j <= col - 2) result[i][j + 1] = '.';
                    }
                }
            }

        }

        else {
            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j++) {
                    if(charGrid[i][j] == 'O') {
                        result[i][j] = '.';
                        if(i >= 1) result[i - 1][j] = '.';
                        if(i <= row - 2) result[i + 1][j] = '.';
                        if(j >= 1) result[i][j - 1] = '.';
                        if(j <= col - 2) result[i][j + 1] = '.';
                    }
                }
            }
        }


        String[] tt = new String[row];
        for(int j = 0; j < row; j++) {
            String str = "";
            for(int i = 0; i < col; i++) {
                str += result[j][i];
            }
            tt[j] = str;
        }


        return tt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
