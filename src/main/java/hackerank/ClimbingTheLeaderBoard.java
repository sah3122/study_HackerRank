package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        List<Integer> scoreList = new ArrayList<>();
        for (int score : scores) {
            scoreList.add(score);
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> uniqueValues = new TreeSet<>();
        for (Integer integer1 : scoreList) {
            if (uniqueValues.add(integer1)) {
                list.add(integer1);
            }
        }
        Collections.reverse(list);
        scoreList = list;



        int index = 0;
        int resultIndex = 0;

        for(int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        for(int i = 0; i < alice.length; i++ ) {
            while (index < scoreList.size()) {
                if(alice[i] < scoreList.get(index)) {
                    result[resultIndex] = scoreList.size() - index + 1;
                    resultIndex++;
                    break;
                }
                index++;
            }
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            //bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                //bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
