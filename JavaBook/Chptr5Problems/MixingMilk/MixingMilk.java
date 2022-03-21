import java.io.*;
import java.util.*;

public class MixingMilk{
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
        
        InputReader fileReader = new InputReader("mixmilk.in");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        

        int amounts[] = new int[3];
        int capacities[] = new int[3];

        for(int i = 0; i < 3; i++){
            capacities[i] = fileReader.nextInt();
            amounts[i] = fileReader.nextInt();
        }
        
        int bucketBeingPoured = 0;
        int bucketBeingFilled = 1;

        for(int i = 0; i < 100; i++){

            if(bucketBeingPoured == 2){
                bucketBeingFilled = 0;
            } else if(bucketBeingPoured == 3){
                bucketBeingPoured = 0;
                bucketBeingFilled = bucketBeingPoured + 1; 
            } else{
                bucketBeingFilled = bucketBeingPoured + 1; 
            }

            if ((amounts[bucketBeingPoured] + amounts[bucketBeingFilled])> capacities[bucketBeingFilled]) {
                amounts[bucketBeingPoured] = amounts[bucketBeingPoured] + amounts[bucketBeingFilled] - capacities[bucketBeingFilled];
                amounts[bucketBeingFilled] = capacities[bucketBeingFilled];
            } else {
                amounts[bucketBeingFilled] += amounts[bucketBeingPoured];
                amounts[bucketBeingPoured] = 0;
            }

            
            bucketBeingPoured++;

        }
        for(int i = 0; i < 3; i++){
            pw.println(amounts[i]);
        }
        pw.close();
    }

}
