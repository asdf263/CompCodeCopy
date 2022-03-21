import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class NonTransitiveDice{
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

    private static int compareTwoDice(int[] firstDice, int[] secondDice){
        int firstWins = 0;
        int secondWins = 0;
        int result = 0;
        int tie = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(firstDice[i] > secondDice[j]){
                    firstWins++;
                } else if(firstDice[i] == secondDice[j]){
                    tie++;
                } else{
                    secondWins++;
                }
            }
        }
        if(firstWins > secondWins){
            result = 1;
        } else if(firstWins < secondWins){
            result = -1;
        } else{
            result = 0;
        }

        
        return result;
    }

    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		//InputReader input = new InputReader(new FileReader("sample.in"));
        InputReader input = new InputReader();
        int T = input.nextInt();
        String[] solution = new String[T];
        
        

        
        MAIN: for(int i = 0; i < T; i++){
            int[] firstDice = {input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()};
            int[] secondDice = {input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()};
            Arrays.sort(firstDice);
            Arrays.sort(secondDice);
            int[] greaterDice = new int[4];
            int[] lesserDice = new int[4];
            if(compareTwoDice(firstDice, secondDice) == -1){
                greaterDice = secondDice;
                lesserDice = firstDice;
            } else{
                greaterDice = firstDice;
                lesserDice = secondDice;
            } 

            
            solution[i] = "no";
            if(compareTwoDice(firstDice, secondDice) == 0){
                continue MAIN;
            }
            GIGALOOP: for(int a = 1; a <= 10; a++){
                for(int b = 1; b <= 10; b++){
                    for(int c = 1; c <= 10; c++){
                        for(int d = 1; d <= 10; d++){
                            int[] curDice = {a, b, c, d};
                            Arrays.sort(curDice);
                            int lesserComparison = compareTwoDice(lesserDice, curDice);
                            int greaterComparison = compareTwoDice(greaterDice, curDice);
                            if(lesserComparison == 1 && greaterComparison == -1){
                                solution[i] = "yes";        
                                break GIGALOOP;      
                            }
                            

                        }
                    }
                }
            }
            
        }

        for (int i  = 0; i < T - 1; i++) {
            System.out.println(solution[i]);
        }
        System.out.print(solution[T - 1]);
        
	}
}