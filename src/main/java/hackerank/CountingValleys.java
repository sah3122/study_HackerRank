package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        boolean flag = false;
        int count = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'D') {
                result += -1;
            }

            if(s.charAt(i) == 'U') {
                result += 1;
            }

            if(result == 0 && flag) count++;

            if(result < 0) flag = true;
            else flag = false;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s = scanner.nextLine();

            int result = countingValleys(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
