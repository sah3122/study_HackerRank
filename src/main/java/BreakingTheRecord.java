import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BreakingTheRecord {
    // Complete the breakingRecords function below.
    private static final int MAX_INDEX = 0;
    private static final int MIN_INDEX = 1;
    static int[] breakingRecords(int[] scores) {
        int[] resultList = {0, 0};
        int min = scores[0];
        int max = scores[0];
        for (int score : scores) {
            if(min > score) {
                min = score;
                resultList[MIN_INDEX]++;
            }
            if(max < score) {
                max = score;
                resultList[MAX_INDEX]++;
            }
        }
        return resultList;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
