package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {
    // Complete the encryption function below.
    static String encryption(String s) {
        int length = s.length();

        int row = (int)Math.floor(Math.sqrt(length));
        int column = (int)Math.ceil(Math.sqrt(length));
        if((row * column) < length) row++;
        char[][] chars = new char[row][column];
        int index = 0;
        String result = "";

        for(int i = 0; i <row; i++) {
            for (int j = 0; j < column; j++){
                if(index >= length) {
                    break;
                }
                chars[i][j] = s.charAt(index);
                index++;
            }
        }

        for (int j = 0; j < column; j++){
            for(int i = 0; i < row; i++) {
                if(chars[i][j] != 0) result += chars[i][j];
            }
            result += " ";
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scanner.nextLine();

        String result = encryption("chillout");


        scanner.close();
    }
}
