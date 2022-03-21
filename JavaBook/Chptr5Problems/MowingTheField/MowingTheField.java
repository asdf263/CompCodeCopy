import java.io.*;
import java.util.*;

public class MowingTheField{
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

    public static int getDirection(String direction){
        int num = 0;
        switch(direction){
            case "N":
                num = 1;
                break;
            case "S":
                num = -1;
                break;
            case "E":
                num = 2;
                break;
            case "W":
                num = -2;
                break;

        }
        return num;
    }

    public static void main(String[] args) throws Exception {
        
	    InputReader fileReader = new InputReader("mowing.in");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        int numOfMovements = fileReader.nextInt();

        String[] directions = new String[numOfMovements];
        int[] distances = new int[numOfMovements];
        int totalCutCells = 0;

        for(int i = 0; i < numOfMovements; i++){
            directions[i] = fileReader.next();
            distances[i] = fileReader.nextInt();
        }

        for (int i : distances) {
            totalCutCells += i;
        }
        totalCutCells += 1;
        int[][] cutCells = new int[totalCutCells][2];
        int lastCellCutTime = 0;
        int[] lastCellCut = {0, 0};
        int difference = -1;
        cutCells[0] = lastCellCut.clone();

        for(int movement = 0; movement < numOfMovements; movement++){
            int directionNum = getDirection(directions[movement]);
            int changedCord = 0;
            if(Math.abs(directionNum) == 1){
                changedCord = 1;
            } else {
                directionNum /= 2;
            }
            int loopTime = lastCellCutTime;
            for(int time = loopTime + 1; time <= distances[movement] + loopTime; time++){
                lastCellCut[changedCord] += directionNum;
                for(int i = 0; i < time; i++){
                    if(Arrays.equals(cutCells[i], lastCellCut)){
                        difference = time - i < difference ? time - i : difference;
                        if(difference == -1){
                            difference = time - i;
                        }
                        cutCells[i] = null;
                    } 
                }
                cutCells[time] = lastCellCut.clone();
                lastCellCutTime = time;
            }
        }
        pw.println(difference);
        pw.close();
    }
}