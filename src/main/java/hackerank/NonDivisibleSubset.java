package hackerank;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        Set<Integer> collect = s.stream().collect(Collectors.toSet());
        Set<Integer> collect2 = s.stream().collect(Collectors.toSet());

        Set<Integer> divisible = new HashSet<>();
        Set<Integer> nonDivisible = new HashSet<>();

        for (Integer integer : collect) {
            collect2 = s.stream().collect(Collectors.toSet());
            collect2.remove(integer);
            boolean isDivisible = true;
            for (Integer integer1 : collect2) {
                if((integer + integer1) % k != 0) {
                    isDivisible = false;
                    break;
                }
            }

            if(isDivisible) {
                divisible.add(integer);
            }
        }

        System.out.println(divisible.toString());
        System.out.println(nonDivisible.toString());

        return (collect.size() - divisible.size()) > divisible.size() ? collect.size() - divisible.size() :  divisible.size() ;
    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt("15");

        int k = Integer.parseInt("7");

        List<Integer> s = Stream.of("278 576 496 727 410 124 338 149 209 702 282 718 771 575 436".replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.nonDivisibleSubset(k, s);
        System.out.println(result);
        bufferedReader.close();
    }
}