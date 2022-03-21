import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class Drought{
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

    private static Integer getLargest(int[] array){
        int[] clone = array.clone();
        Arrays.sort(clone);
        return clone[clone.length - 1];
    }
    private static int getSecondLargest(int[] array){
        int[] clone = array.clone();
        Arrays.sort(clone);
        return clone[clone.length - 2];
    }

    private static int getSmallest(int[] array){
        int[] clone = array.clone();
        Arrays.sort(clone);
        return clone[0];
    }

    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		InputReader input = new InputReader(new FileReader("sample.in"));
        //InputReader input = new InputReader();

        int T = input.nextInt();
        int[] solution = new int[T];

        ITERATIONLOOP: for(int t = 0; t < T; t++){
            int N = input.nextInt();
            int[] hungerLevels = new int[N];
            for(int i = 0; i < N; i++){
                hungerLevels[i] = input.nextInt();
            }   
            
            for(int l = 0; l < 10000; l++){
                int[] curHungerLevels = hungerLevels.clone();
                for(int i = 0; i < N -1 ; i++){
                    curHungerLevels[i] -= curHungerLevels[i] - i;
                    curHungerLevels[i + 1] -= curHungerLevels[i] - i;
                }
                boolean allequal = true;
                for(int i = 0; i < N; i++){
                    if(curHungerLevels[i] != l){
                        allequal = false;
                    }
                }
                
            }
        }





































        // ---------------------------------------------------------------ATTEMPT 1------------------------------------------------------------
        /*MAIN: for(int i = 0; i < T; i++){
            int N = input.nextInt();
            int[] cows = new int[N];
            int largest = 0;
            int smallest = 999999999;
            for(int j = 0; j < N; j++){
                cows[j] = input.nextInt();
                if(cows[j] > largest){
                    largest = cows[j];
                }
                if(cows[j] < smallest){
                    smallest = cows[j];
                }
            }

            if(cows[0] == largest && cows[1] != largest){
                solution[i] = -1;
                continue MAIN;
            }
            if(cows[N - 1] == largest && cows[N -2] !=largest){
                solution[i] = -1;
                continue MAIN;
            }

           

            ITERATION: while(true){
                for(int j = 0; j < N ; j++){
                    if(cows[j] < 0){
                        solution[i] = -1;
                        break ITERATION;
                    }
                    if(j != N-1 ||cows[j] == cows[ j + 1]){
                        if(j == N - 2){
                            break ITERATION;
                        }
                    } 
                    
                }

                largest = getLargest(cows);

                for(int j = 0; j < N-1; j++){
                    if(cows[j] == largest){
                        int dif = cows[j] - Math.max(cows[j + 1], cows[ j - 1]);
                        
                        cows[j] -= dif;
                        if(cows[j + 1] > cows[j - 1]){
                            cows[j + 1]-= dif;
                        } else{
                            cows[j - 1]-= dif;
                        }
                        solution[i]+=dif*2;
                    }
                }  
            }


        }
        for (int j : solution) {
            System.out.println(j);
        }*/
	}
}