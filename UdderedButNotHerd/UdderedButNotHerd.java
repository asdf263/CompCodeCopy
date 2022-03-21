import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class UdderedButNotHerd{
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public InputReader(FileReader fr) {
            reader = new BufferedReader(fr);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
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

        public Character nextChar() { // reads in the next double
            return next().charAt(0);
        }
    }

   

    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		//InputReader input = new InputReader(new FileReader("sample.in"));
        InputReader input = new InputReader();

        String sCowphabet = input.next();
        String lettersHummed = input.next();
        String[] cowphabet = new String[26];
        int solution = 0;
        

        for(int i = 0; i < 26; i++){
            cowphabet[i] = Character.toString(sCowphabet.charAt(i));
        }
        int pastIndex = -1;
        for(int i = 0; i < lettersHummed.length(); i++){
            char curLetter = lettersHummed.charAt(i);
            int curIndex = Arrays.asList(cowphabet).indexOf(Character.toString(curLetter));
            
            
            if(pastIndex >= curIndex){
                solution++;
            }

            pastIndex = curIndex;

            
            
            
        }
        System.out.println(solution + 1);
    }
}