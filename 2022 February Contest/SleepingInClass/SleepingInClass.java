import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class SleepingInClass{
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
		InputReader input = new InputReader(new FileReader("sample.in"));
        //InputReader input = new InputReader();
        
        int T = input.nextInt();
        for(int t = 0; t < T; t++){
            int N = input.nextInt();
            ArrayList<Integer> logs = new ArrayList<>();
            for(int i = 0; i < N; i++){
                logs.add(input.nextInt());
            }
            while(true){
                int solution = 0;
                boolean yes = true;
                for(int i = 0; i < N; i++){
                    if(logs.get(i) != logs.get(i)){
                        yes = false;
                    }
                }
                if(yes){
                    System.out.println(solution);
                    break;
                }
                Collections.sort(logs);
                int smallest = logs.get(0);
                ArrayList<Integer> newLog = new ArrayList<Integer>();
                for(int i = 0; i < N; i++){
                    if(logs.get(i) != smallest){
                        continue;
                    }
                    
                    


                }
                
                
            }

        }
	}
}