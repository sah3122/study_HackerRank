package hackerank;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        final int MAX = 100;
        int ary[] = new int[MAX];
        int count = 0;

        for(int i = 0; i < a.size(); i ++) {
            ary[a.get(i)]++;
        }

        for(int i = 1; i < MAX; i ++) {
            count = Math.max(count, ary[i] + ary[i-1]);
        }

        return count;
    }
}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
