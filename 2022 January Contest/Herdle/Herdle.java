import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class Herdle{
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
        ArrayList<Character> answer = new ArrayList<>();
        
        char[] guess = new char[9];
        String S = input.next();

        // get answer
        for(int i = 0; i < 3; i++){
            answer.add(S.charAt(i));
        }
        S = input.next();
        for(int i = 0; i < 3; i++){
            answer.add(S.charAt(i));
        }
        S = input.next();
        for(int i = 0; i < 3; i++){
            answer.add(S.charAt(i));
        }
        // get guess
        S = input.next();
        for(int i = 0; i < 3; i++){
            guess[i] = S.charAt(i);
        }
        S = input.next();
        for(int i = 0; i < 3; i++){
            guess[i + 3] = S.charAt(i);
        }
        S = input.next();
        for(int i = 0; i < 3; i++){
            guess[i + 6] = S.charAt(i);
        }
        
        int green = 0;
        int yellow = 0;
        
        ArrayList<Character> newAnswer = new ArrayList<>();
        ArrayList<Character> newGuess= new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(guess[i] == answer.get(i)){
                green++;
                continue;
            }
            newAnswer.add(answer.get(i));
            newGuess.add(guess[i]);
        }
        

        for(int i = 0; i < newGuess.size(); i++){
            int index = newAnswer.indexOf(newGuess.get(i));
            if( index != -1){
                yellow++;
                newAnswer.remove(index);
            }
        }
        System.out.println(green);
        System.out.print(yellow);
	}
}