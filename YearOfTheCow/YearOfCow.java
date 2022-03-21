import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class YearOfCow {
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
    private static int getZodiacNum(String zodiac){
        int solution = 0;
        switch(zodiac){
            case "Ox":
                solution = 1;
                break;
            case "Tiger":
                solution = 2;
                break;
            case "Rabbit":
                solution = 3;
                break;
            case "Dragon":
                solution = 4;
                break;
            case "Snake":
                solution = 5;
                break;
            case "Horse":
                solution = 6;
                break;

            case "Goat":
                solution = 7;
                break;
            case "Monkey":
                solution = 8;
                break;
            case "Rooster":
                solution = 9;
                break;
            case "Dog":
                solution = 10;
                break;
            case "Pig":
                solution = 11;
                break;
            case "Rat":
                solution = 12;
                break;

        }
        return solution;
    }
   

    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
        InputReader input = new InputReader();
        //InputReader input = new InputReader(new FileReader("sample.in"));
        
        int cowNum = input.nextInt();
        int[] cowYears = new int[cowNum + 1];
        cowYears[0] = 5000;
        String[] cowNames = new String[cowNum + 1];
        cowNames[0] = "Bessie";
        int[] zodiacs = new int[cowNum + 1];
        zodiacs[0] = 1;
        
        for(int i = 0; i < cowNum; i++){
            //digest info
            String[] words = new String[8];
            for(int j = 0; j < 8; j++){
                words[j] = input.next();
            }
            
            cowNames[i + 1] = words[0];
            int comparedCowIndex = Arrays.asList(cowNames).indexOf(words[7]);
            int comparedDate = cowYears[comparedCowIndex]; 
            int numZodiac = getZodiacNum(words[4]);
            int difference = 0;
            zodiacs[i + 1] = numZodiac;
            
            if(words[3].equals("next")){
                if(zodiacs[comparedCowIndex] < numZodiac){
                    difference = numZodiac - zodiacs[comparedCowIndex];
                } else{
                    difference = (12 - zodiacs[comparedCowIndex]) + numZodiac;
                }
            } else{
                if(zodiacs[comparedCowIndex] > numZodiac){
                    difference = -(zodiacs[comparedCowIndex] - numZodiac);
                } else{
                    difference = -((12 - numZodiac) + zodiacs[comparedCowIndex]);
                }
            }
            cowYears[i + 1] = comparedDate + difference;
 
            if(Arrays.asList(cowNames).contains("Elsie")){
                break;
            } 
        }
        int solution = Math.abs(5000 - cowYears[Arrays.asList(cowNames).indexOf("Elsie")]);

        



        // Step 3, output
        System.out.println(solution);
    }
}  
