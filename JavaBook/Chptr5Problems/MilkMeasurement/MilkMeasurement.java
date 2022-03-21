import java.io.*;
import java.util.*;


public class MilkMeasurement{
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
        
	    InputReader fileReader = new InputReader("measurement.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int numOfMeasurements = fileReader.nextInt();
        int[] days = new int[numOfMeasurements];
        String[] names = new String[numOfMeasurements];
        int[] changes = new int[numOfMeasurements];
        int BessieOut = 7, ElsieOut = 7, MildredOut = 7;
        boolean bessieOn = true, elsieOn = true, mildredOn = true;
        int changesMade = 0;

        for(int i = 0; i < numOfMeasurements; i++){
            days[i] = fileReader.nextInt();
            names[i] = fileReader.next();
            changes[i] = fileReader.nextInt();
        }

        

        for(int i = 1; i <= 100; i++){
            for (int j = 0; j < numOfMeasurements; j++) {
                if(days[j] == i){
                    if(names[j].equals("Bessie")){
                        BessieOut += changes[j];
                    } else if(names[j].equals("Elsie")){
                        ElsieOut += changes[j];
                    } else {
                        MildredOut += changes[j];
                    }
                }
            }

            int greatestMilk = Math.max(BessieOut, Math.max(ElsieOut, MildredOut));
            boolean bessieOnNext = BessieOut == greatestMilk;
            boolean elsieOnNext = ElsieOut == greatestMilk;
            boolean mildredOnNext = MildredOut == greatestMilk;
            
            if(bessieOnNext != bessieOn || elsieOnNext != elsieOn || mildredOnNext != mildredOn){
                changesMade++;
            }

            bessieOn = bessieOnNext;
            elsieOn = elsieOnNext;
            mildredOn = mildredOnNext;
        }
         

        pw.println(changesMade);
        pw.close();
    }
}












/*
import java.io.*;
import java.util.*;


public class MilkMeasurement{
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

    public static int cowtoNumber (String cow) {
        if(cow.equals("Bessie")){
            return 1;
        } else if (cow.equals("Elsie")){
            return 2;
        } else{
            return 3;
        }
    }

    //public static int getKeyfromValue (String value, Set<>){
        
       // return 0;
   // }

    public static int getKeyByValue(Map<Integer, String> map, String value) {
        for (M<Integer, String> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        
	    InputReader fileReader = new InputReader("measurement.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int numOfMeasurements = fileReader.nextInt();
        int[][] measurements = new int[numOfMeasurements][3];
        int[] days = new int[numOfMeasurements];


        SortedMap<Integer, String> cowOutputs = new TreeMap();
        cowOutputs.put(7, "Bessie");
        cowOutputs.put(7, "Mildred");
        cowOutputs.put(7, "Elsie");
        System.out.println(cowOutputs.entrySet());
        
        

        int changesMade = 0;

        for(int i = 0; i < numOfMeasurements; i++){
            measurements[i][0] = fileReader.nextInt();
            days[i] = measurements[i][0];
            measurements[i][1] = cowtoNumber(fileReader.next());
            measurements[i][2] = fileReader.nextInt();
        }
        Arrays.sort(days);
        
        int currentDayIndex = 0;
        for(int i = 0; i < numOfMeasurements; i++){
            
            DAYSEARCH: for(int j = 0; j < numOfMeasurements; j++){
                if(days[i] == measurements[j][0]){
                    currentDayIndex = j;
                    break DAYSEARCH;
                }
            }

            String leadingCow = cowOutputs.get(cowOutputs.lastKey());
            
            switch(measurements[currentDayIndex][1]){
                case 1:
                    cowOutputs.containsValue("Bessie");
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            
             
        }
    
        pw.println(changesMade);
        pw.close();
    }
}
*/




