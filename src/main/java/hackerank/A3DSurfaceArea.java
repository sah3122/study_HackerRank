package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A3DSurfaceArea {
    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        int rowLength = A.length;
        int colLength = A[0].length;
        int left = 0;
        int right = 0;
        int front = 0;
        int back = 0;
        int up = colLength * rowLength;
        int down = colLength * rowLength;
        int result = 0;

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j ++) {
                if(j == 0){
                    left += A[i][j];
                }
                else {
                    if(A[i][j] > A[i][j - 1]) left += A[i][j] - A[i][j - 1];
                }
            }
        }

        for(int i = 0; i < colLength; i++) {
            for(int j = 0; j < rowLength; j ++) {
                if(j == 0){
                    back += A[j][i];
                }
                else {
                    if(A[j][i] > A[j - 1][i]) back += A[j][i] - A[j - 1][i];
                }
            }
        }

        for(int i = rowLength - 1; i >= 0; i--) {
            for(int j = colLength - 1; j >= 0; j--) {
                if(j == colLength - 1) {
                    right += A[i][j];
                }
                else {
                    if(A[i][j] > A[i][j + 1]) left += A[i][j] - A[i][j + 1];
                }

            }
        }

        for(int i = colLength - 1; i >= 0; i--) {
            for(int j = rowLength - 1; j >= 0; j--) {
                if(j == rowLength - 1) {
                    up += A[j][i];
                }
                else {
                    if(A[j][i] > A[j + 1][i]) up += A[j][i] - A[j + 1][i];
                }

            }
        }

        result = right + left + up + down + front + back;

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
