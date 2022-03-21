import java.io.*;
import java.util.*;

public class CircularBarn{
    static class InputReader {
        BufferedReader input;
        StringTokenizer tokenizer;

        public InputReader(String file) throws Exception{
            input = new BufferedReader(new FileReader(file));
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(input.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());

        }

        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }

        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }

    }
    public static int[] moveList (int[] cowRooms){
        int[] newCowRooms = new int[cowRooms.length];
        for(int i = 0; i < cowRooms.length - 1; i++){
            newCowRooms[i] = cowRooms[i+1];
        }
        newCowRooms[cowRooms.length - 1] = cowRooms[0];
        return newCowRooms;
    }
    public static void main(String[] args) throws Exception {
        
	    InputReader fileReader = new InputReader("cbarn.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int rooms = fileReader.nextInt();
        int[] cowRooms = new int[rooms];
        int[] solutions = new int[rooms]; 
        for(int i = 0; i < rooms; i++) {
            cowRooms[i] = fileReader.nextInt();
        }

        for(int i = 0; i < rooms; i++) {
            for(int j = 0; j < rooms; j++) {
                solutions[i] += cowRooms[j] * j;
            }
            cowRooms = moveList(cowRooms);
        }
        Arrays.sort(solutions);
        pw.println(solutions[0]);
        pw.close();
    }

}
