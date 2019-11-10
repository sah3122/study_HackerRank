package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BonAppetit {
    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        List<Integer> anna = new ArrayList<>(bill);

        anna.remove(k);

        int annaAndBill = anna.stream().mapToInt(Integer::intValue).sum() / 2;

        if(annaAndBill == b) System.out.println("Bon Appetit");
        else System.out.println(b - annaAndBill);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
