import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class QueensAttack {
    // Complete the queensAttack function below.


    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[] row = new int[] {  0,  1, 1, 1, 0, -1, -1, -1 };
        int[] col = new int[] { -1, -1, 0, 1, 1,  1,  0, -1 };
        int result = 0;
        Set<String> obsatcleString = new TreeSet<>();
        for(int i = 0; i < k; i++) {
            String obstacle = "";
            obstacle += "" + (obstacles[i][0] - 1) + "" + (obstacles[i][1] - 1);
            obsatcleString.add(obstacle);
        }


        for(int i = 0; i < 8; i ++) {
            int rowIndex = r_q - 1 + row[i];
            int colIndex = c_q - 1 + col[i];

            while(rowIndex >= 0 && rowIndex < n && colIndex >= 0 && colIndex < n) {
                if(obsatcleString.contains((rowIndex + "" + colIndex))) break;
                rowIndex += row[i];
                colIndex += col[i];
                result ++;
            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);


        scanner.close();
    }
}
