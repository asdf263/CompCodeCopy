
import java.util.*;
import java.util.prefs.PreferencesFactory;
import java.io.*;

public class AirCownditioning{
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
        int[] preferredTemps = new int[N];
        int[] currentTemps = new int[N];
        boolean cowsAreSatisfied = false;
        int solution = 0;

        for(int i = 0; i < N; i++){
            preferredTemps[i] = input.nextInt();
        }
        for(int i = 0; i < N; i++){
            currentTemps[i] = input.nextInt();
        }
        boolean positive = false;
        if(preferredTemps[0] - currentTemps[0] > 0 ){
            positive = true;
        }
        boolean reset = false;
        while(!Arrays.equals(currentTemps, preferredTemps)){
            //go through each unsatisfied cow and once we reach the end of each cow we will add the minimum addible value to each, then repeat
            ArrayList<Integer> cowsInARow = new ArrayList<Integer>();
            ArrayList<Integer> differences = new ArrayList<Integer>();
            for(int i = 0; i < N; i++){
                    
                    boolean cont = false;
                    boolean curPositive = preferredTemps[i] - currentTemps[i] > 0;
                    if(reset == true){
                        positive = curPositive;
                        reset = false;
                    }
                    if(curPositive  == positive){
                        cont = true;
                    }

                    if(currentTemps[i] != preferredTemps[i] && cont){
                        cowsInARow.add(currentTemps[i]);
                        differences.add(preferredTemps[i] -  currentTemps[i]); 
                    } else if(cowsInARow.size() > 0){
                        Collections.sort(differences);
                        int minIncrease = 0;
                        if(positive == true){
                            minIncrease = differences.get(0);
                        } else{
                            minIncrease = differences.get(differences.size() - 1);
                        }
                        for(int j = 0; j < cowsInARow.size(); j++){
                            currentTemps[i - j - 1] += minIncrease;
                        }
                        solution += Math.abs(minIncrease);
                        cowsInARow.clear();
                        differences.clear();
                        if(cont == true){
                            reset = true;
                        }
                    }

                    if(cont == false){
                        cowsInARow.add(currentTemps[i]);
                        differences.add(preferredTemps[i] -  currentTemps[i]); 
                        positive = curPositive;
                    }
                

            }
            if(cowsInARow.size() > 0){
                Collections.sort(differences);
                        int minIncrease = 0;
                        if(positive == true){
                            minIncrease = differences.get(0);
                        } else{
                            minIncrease = differences.get(differences.size() - 1);
                        }
                for(int j = 0; j < cowsInARow.size(); j++){
                    currentTemps[N - j - 1] += minIncrease;
                }
                solution += Math.abs(minIncrease);
                cowsInARow.clear();
                
                reset = true;
            }
   
        }
        System.out.println(solution);
	}
}