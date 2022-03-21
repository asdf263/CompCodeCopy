import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class Acowdemia3{
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

    private static int[][] checkAdjacents(char[][] pGrid, char checkedChar, int i, int j){
        int[][] adjacentSlots = new int [4][2];
        if(pGrid[i + 1][j] == 'C'){
            adjacentSlots[0][0] = i + 1; 
            adjacentSlots[0][1] = j;
        }
        if(pGrid[i][j + 1] == 'C'){
            adjacentSlots[1][0] = i; 
            adjacentSlots[1][1] = j + 1;
        }
        if(pGrid[i - 1][j] == 'C'){
            adjacentSlots[2][0] = i  - 1; 
            adjacentSlots[2][1] = j;
        }
        if(pGrid[i ][j - 1] == 'C'){
            adjacentSlots[3][0] = i; 
            adjacentSlots[3][1] = j - 1;
        }
        return adjacentSlots;
    }

    private static int getValidSpots(int[][] pAdjacentSpots){
        int solution = 0;
        for(int i = 0; i < 4; i++){
            if(pAdjacentSpots[i][0] != 0){
                solution++;
            }
        }
        return solution;
    }
    private static void printGrid(char[][] pAdjacentSpots){
        
        for(int i = 0; i < pAdjacentSpots.length; i++){
            for(int j = 0; j< pAdjacentSpots[i].length; j++){
                System.out.print(pAdjacentSpots[i][j]);
            }
            System.out.print("");
        }
        
    }

    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		InputReader input = new InputReader(new FileReader("sample.in"));
        //InputReader input = new InputReader();
        int length = input.nextInt();
        int width = input.nextInt();
        int solution = 0;
        char[][] grid = new char[1010][1010];
        for(int i = 0; i < length; i++){
            String curLine = input.next();
            for(int j = 0; j < width; j++){
                grid[i + 5][j + 5] = curLine.charAt(j);
            }
        }
        int gLength = length + 5;
        int gWidth = width + 5;
        // check all grass blocks and check adjacent cows, look at the amount of grass blocks near the adjacent cows and based of that pair up the cows
        int[][] friendedCows = new int[10000][2];
        
        for(int i = 5; i < gLength + 5; i++){
            YES: for(int j = 5; j < gWidth + 5; j++){
                if(grid[i][j] != 'G'){
                    continue;
                } 
                int[][] adjacentSlots = new int[4][2];
                //check the grass near it
                adjacentSlots = checkAdjacents(grid, 'C', i, j);
                int validSpots = getValidSpots(adjacentSlots);
                
                
                if(validSpots == 2){
                    int[][] twoadjacentslots =  new int[2][2];
                    int b = 0;
                    for(int k  = 0; k < 4; k++){
                        if(adjacentSlots[k][0] != 0){
                            twoadjacentslots[b][0] = adjacentSlots[k][0];
                            twoadjacentslots[b][1] = adjacentSlots[k][1];
                            b++;
                        }
                    }
                    if()
                    
                }
                if(validSpots >= 2){
                    
                    grid[i][j] = '.';
                    
                   solution++;
                    continue;
                }

                //check the cows near for other grass
                /*int smallest = 100;
                int secondsmallest = 100;
                for(int k = 0; k < 4; k++){
                    if(adjacentSlots[k][0] == 0){
                        continue;
                    }
                    int[][] adjacentGrass = checkAdjacents(grid, 'G', adjacentSlots[k][0], adjacentSlots[k][1]);
                    int curAmount = getValidSpots(adjacentGrass);
                    
                }*/
            }
        }
        System.out.print(solution);
        /* 
        GGGGG..GG
        GCGCGCGCG
        GGGGG..GG
        */ 
	}
}