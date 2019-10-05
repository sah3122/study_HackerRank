import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {
    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        int sum = 0;
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            stack.add(i);

            if(i >= m - 1 && sum == d) {
                result++;
            }

            if(i >= m- 1) {
                sum -= s.get(stack.get(0));
                stack.remove(0);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(result);
        bufferedReader.close();
    }
}
