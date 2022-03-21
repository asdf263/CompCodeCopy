import java.io.*;
import java.util.*;

public class LostCow{
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

    public static void main(String[] args) throws Exception {
        
	    InputReader fileReader = new InputReader("lostcow.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        int johnPos = fileReader.nextInt();
        int bessiePos = fileReader.nextInt();
        int orgJohnPos = johnPos;
        int change = 1;
        int solution = 0;

        boolean bessieFound = false;
        while(!bessieFound){
            johnPos += change;
            if(Math.min(orgJohnPos, johnPos) <= bessiePos && bessiePos <= Math.max(orgJohnPos, johnPos) ) {
                solution += Math.abs(orgJohnPos-bessiePos);
                break;
            } else{
                solution += Math.abs(change)*2;
            }
            change = change * -2;
            johnPos = orgJohnPos;
        }
        pw.println(solution);
        pw.close();
    }

}
