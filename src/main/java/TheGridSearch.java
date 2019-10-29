import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TheGridSearch {
    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        for (int i = 0; i < G.length; i++) {
            if(G[i].contains(P[0]) && G.length - i >= P.length) {
                int num = -1;
                int loopCount = 0;
                while((num = G[i].indexOf(P[0], num + 1)) >= 0) {
                    loopCount++;
                }
                num = -1;
                for(int j = 0; j < loopCount; j++) {
                    num = G[i].indexOf(P[0], num + 1);

                    for(int k = 0; k < P.length; k++) {
                        if(G[i + k].contains(P[k]) & (G[i+k].indexOf(P[k], num) == num)) {
                            if(k == P.length - 1) return "YES";
                            else if(k + i >= G.length - 1) return "NO";
                        } else {
                            break;
                        }
                    }
                }


            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
