package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmasSupercomputer {
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int[] directions = {1, -1, 1, -1};
        int min = -1;
        int max = 0;
        int[][] minList = new int[15][2];
        int[][] maxList = new int[15][2];

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j++) {
                boolean plusLoop = true;
                while(plusLoop) {
                    int rowIndex = i;
                    int colIndex = j;
                    int count = 1;
                    if(grid[rowIndex].charAt(colIndex) != 'G') break;
                    if(rowIndex == 0 || colIndex == 0 || rowIndex == row - 1 || colIndex == col -1) break;
                    if(grid[rowIndex - count].charAt(colIndex) == 'G' && grid[rowIndex + count].charAt(colIndex) == 'G' && grid[rowIndex].charAt(colIndex  - count) == 'G' && grid[rowIndex].charAt(colIndex  + count) == 'G') {
                        count++;
                    }


                }
            }
        }

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
