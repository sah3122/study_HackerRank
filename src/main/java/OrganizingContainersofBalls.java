import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrganizingContainersofBalls {
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int length = container.length;
        int containerSum = 0;
        int ballTypeSum = 0;
        List<Integer> containerList = new ArrayList<>();
        List<Integer> ballTypeList = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++){
                containerSum += container[i][j];
            }
            containerList.add(containerSum);
            containerSum = 0;
            for(int j = 0; j < length; j++) {
                ballTypeSum += container[j][i];
            }
            ballTypeList.add(ballTypeSum);
            ballTypeSum = 0;
        }

        for (Integer integer : ballTypeList) {
            containerList.remove(integer);
        }

        return containerList.size() == 0 ? "Possible" : "Impossible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
