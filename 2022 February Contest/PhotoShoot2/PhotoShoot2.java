import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.util.spi.CurrencyNameProvider;
import java.io.*;

public class PhotoShoot2{
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

   
    private static void swap(int[] array, int fromPos,  int ToPos){
        int yes = array[fromPos];
        array[fromPos] = array[ToPos];
        array[ToPos] = yes;

    }
    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		InputReader input = new InputReader(new FileReader("sample.in"));
        //InputReader input = new InputReader();
        
        int N = input.nextInt();
        ArrayList<Integer> curOrder = new ArrayList<>();
        ArrayList<Integer> desiredOrder = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            curOrder.add(input.nextInt());
        }
        for(int i = 0; i < N; i++){
            desiredOrder.add(input.nextInt());
        }   
        int solution = 0;
        for(int i = 0; i < N; i++){
            if(desiredOrder.get(0) == curOrder.get(0)){
                desiredOrder.remove(0);
                curOrder.remove(0);
                continue;
            }
            int desiredFirstNum = desiredOrder.get(0);
            curOrder.remove(curOrder.indexOf(desiredFirstNum));
            desiredOrder.remove(0);
            solution++;

            
        }

       /* int N = input.nextInt();
        int[] curOrder =  new int[N];
        int[] desiredOrder = new int[N];        
        for(int i = 0; i < N; i++){
            curOrder[i] = input.nextInt();
        }
        for(int i = 0; i < N; i++){
            desiredOrder[i] = input.nextInt();
        }   
        int solution = 0;
        int yes = 0;
        MAIN: for(int i = 0; i < N; i++){
            int index = 0;
            for(int j = i; j < N; j++){
                if(curOrder[j] == desiredOrder[i]){
                    if(j == i){
                        continue MAIN;
                    }
                    index = j;
                    solution++;
                }
            }

            for(int j = index; j > i ; j--){
                swap(curOrder, j, j - 1);
            }
        }        */


       

        System.out.print(solution);

	}
}