import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class LonelyPhoto{
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
        int N = input.nextInt();
        String sComb = input.next();
        char[] cows = new char[N];
        for(int i = 0; i < N; i++){
            cows[i] = sComb.charAt(i);
        }
        int solution = 0;

        for(int i = 0; i < N - 2; i++){
            int G = 0;
            int H = 0;
            for(int j = i; j < N; j++){
                if(cows[j] == 'G'){
                    G++;
                } else{
                    H++;
                }
                if(G >= 2 && H >= 2){
                    break;
                }
                if(j >= i + 2 && (G == 1 || H == 1))
                    solution++;
            }
        }
        System.out.println(solution);


	}
}