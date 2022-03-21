import java.io.*;
import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class StuckInaRut {
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
        int N = input.nextInt();
        boolean[] isFacingNorth = new boolean[N];
        int[][] cowCords = new int[N][2];
        for(int i = 0; i < N; i++){
            if(input.nextChar() == 'N'){
                isFacingNorth[i] = true;
            } else{
                isFacingNorth[i] = false;
            }
            cowCords[i][0] = input.nextInt();
            cowCords[i][1] = input.nextInt();
        }
        // differences 
        // cows involved
        // cords of event
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //--------------------------------------------------------------Attempt 3------------------------------------------------------------------------------------------
        /*
        InputReader input = new InputReader();
        int N = input.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        char[] directions = new char[N];
        int[] xCords = new int[N];
        int[] yCords = new int[N];
        int solution[] = new int[N];
        for(int i = 0; i < N; i++){
            directions[i] = input.nextChar();
            xCords[i] = input.nextInt();
            yCords[i] = input.nextInt();
        }
        if(N == 1){
            System.out.print("Infinity");
            System.exit(0);
        }
        int[][] stuckAreas = new int[1000][2];
        int lstuckAreas = 0;

 

        
        
        //loops through until there are no more interceptions to be made
        int time = 0;
        for(int k = 0; k <= N; k++){
            int smallestDifference = 999999999;
            int[] curNorthFacingCow = new int[2];
            int[] curEastFacingCow = new int[2];
            int curEIndex = 0;
            int curNIndex = 0;
            for(int i = 0; i < N; i++){
                if(solution[i] != 0){
                    continue;
                }
                CHECKLOOP: for(int j = 0; j < N; j++){
                    if(directions[i] == directions[j] || (solution[i] != 0 && solution[j] != 0))
                        continue;
                    // logic to get the pairs
                    int[] nCords = new int[2];
                    int[] eCords = new int[2];
                    int nIndex = 0;
                    int eIndex = 0;
                    if(directions[i] == 'N'){
                        nIndex = i;
                        eIndex = j;
                    } else{
                        nIndex = j;
                        eIndex = i;
                    }
                    
                    nCords[0] = xCords[nIndex];
                    nCords[1] = yCords[nIndex];
                    eCords[0] = xCords[eIndex];
                    eCords[1] = yCords[eIndex];
                    for(int l = 0; l < lstuckAreas; l++){
                        if(stuckAreas[l][0] == nCords[0] && stuckAreas[l][1] == eCords[1]){
                            continue CHECKLOOP;
                        }
                    }
                    
                    if(eCords[1] - nCords[1] == nCords[0] - eCords[0]){
                        continue;
                    }
                    if(eCords[1] < nCords[1] || nCords[0] < eCords[0]){
                        continue;
                    }
                    
                    int curDifference = Math.max(eCords[1] - nCords[1], nCords[0] - eCords[0]);
                    
                    
                    if(curDifference < smallestDifference){
                        curEastFacingCow = eCords;
                        curNorthFacingCow = nCords;
                        smallestDifference = curDifference;
                        curEIndex = eIndex;
                        curNIndex = nIndex;
                    }
                } 
            }
            // see which pair dies and update solution
            if(smallestDifference == 999999999){
                break;
            }
            time = smallestDifference;
            if(curEastFacingCow[1] - curNorthFacingCow[1] > curNorthFacingCow[0] - curEastFacingCow[0]){
                solution[curNIndex] = time;
            } else{
                solution[curEIndex] = time;
            }

            stuckAreas[lstuckAreas][1] = curEastFacingCow[1];
            stuckAreas[lstuckAreas][0] = curNorthFacingCow[0];
            lstuckAreas++;

            
            

        }

        for (int i  = 0; i < N - 1; i++) {
            if(solution[i] == 0){
                System.out.println("Infinity");
            } else{
                System.out.println(solution[i]);
            }

        }
        
        if(solution[N-1] == 0){
            System.out.print("Infinity");
        } else{
            System.out.print(solution[N-1]);
        }
        



*/
        

        














//---------------------------------------------------------------------------Atempt 2------------------------------------------------------------------------------------------






























        /*int N = input.nextInt();
        int [][] startingCords = new int[N][2];
        char[] directions = new char[N];
        int nNorthFacingCows = 0;
        int nEastFacingCows = 0;
        

        for(int i = 0; i < N; i++){
            directions[i] = input.nextChar();
            startingCords[i][0] = input.nextInt();
            startingCords[i][1] = input.nextInt();
            
            if(directions[i] == 'N'){
                nNorthFacingCows++;
            }
        }
        nEastFacingCows = directions.length - nNorthFacingCows;
        int[][] northFacingCows = new int[nNorthFacingCows][2];
        int[][] eastFacingCows = new int[nEastFacingCows][2];
        int NCO = 0;
        int ECO = 0;
        int[][] importantEvents = new int[5000][2];
        int IEN = 0;

        for(int i = 0; i < N; i++){
            if(directions[i] == 'N'){
                northFacingCows[NCO][0] = startingCords[i][0];
                northFacingCows[NCO][1] = startingCords[i][1];
                NCO++;
            } else{
                eastFacingCows[ECO][0] = startingCords[i][0];
                eastFacingCows[ECO][1] = startingCords[i][1];
                ECO++;
            }
        }
        int[][] differences = new int[5000][2];
        int DEN = 0;

        for(int i = 0; i < NCO; i++){
            for(int j = 0; j < ECO; j++){
                if(northFacingCows[i][0] > eastFacingCows[j][0]&& northFacingCows[i][1] < eastFacingCows[j][1]){
                    importantEvents[IEN][0] = northFacingCows[i][0];
                    importantEvents[IEN][1] = eastFacingCows[j][1];
                        
                    differences[DEN][0] = importantEvents[IEN][0] - eastFacingCows[j][0];
                    differences[DEN][1] = importantEvents[IEN][1] - northFacingCows[i][1];      
                    DEN++;  
                    IEN++;   
                }
            }
        }
        boolean[] eastCowStopped = new boolean[ECO];
        boolean[] northCowStopped = new boolean[NCO];
        String[] solutions = new String[N];
        int[] timesStoppedEast = new int[ECO];
        int[] timesStoppedNorth = new int[NCO];

        for(int i = 0; i < IEN; i++){
            int nextEventIndex = 0;
            int curSmallestEvent = 2147483647;
            for(int j = 0; j < DEN; j++){
                int squaresAway  = Math.max(differences[j][0], differences[j][1]);
                if(curSmallestEvent > squaresAway){
                    nextEventIndex = j;
                    curSmallestEvent = squaresAway;
                }
            }
            if(differences[nextEventIndex][0] == differences[nextEventIndex][1]){
                differences[nextEventIndex][1]= 2147483647;
                differences[nextEventIndex][0]= 2147483647;
                continue;
            }
            int curNorthCow = 0;
            int curEastCow = 0;

            for(int j = 0; j < ECO; j++){
                if(importantEvents[nextEventIndex][1] == eastFacingCows[j][1]) {
                    curEastCow = j;
                }  
            }
            for(int j = 0; j < NCO; j++){
                if(importantEvents[nextEventIndex][0] == northFacingCows[j][0]) {
                    curNorthCow = j;
                }
            }
            if(eastCowStopped[curEastCow] == true){
                differences[nextEventIndex][1]= 2147483647;
                differences[nextEventIndex][0]= 2147483647;
                continue;
            }
            if(northCowStopped[curNorthCow] == true){
                differences[nextEventIndex][1]= 2147483647;
                differences[nextEventIndex][0]= 2147483647;
                continue;
            }
            

            if(differences[nextEventIndex][0] > differences[nextEventIndex][1]){
                eastCowStopped[curEastCow] = true;
                timesStoppedEast[curEastCow] = differences[nextEventIndex][0];
            } else{
                northCowStopped[curNorthCow] = true;
                timesStoppedNorth[curNorthCow] = differences[nextEventIndex][1];
            }
            differences[nextEventIndex][1]= 2147483647;
            differences[nextEventIndex][0]= 2147483647;   
        }
        int ECS = 0;
        int NCS = 0;
        for(int i = 0; i < N; i++){
            if(directions[i] == 'E'){
                if(eastCowStopped[ECS] == true){
                    solutions[i] = Integer.toString(timesStoppedEast[ECS]);
                } else{
                    solutions[i] = "Infinity";
                }
                ECS++;
            } else{
                if(northCowStopped[NCS] == true){
                    solutions[i] = Integer.toString(timesStoppedNorth[NCS]);
                } else{
                    solutions[i] = "Infinity";
                }
                NCS++;
            }
            
        }
        
        for(int i = 0; i < N-1 ; i++){
            System.out.println(solutions[i]);
        }
        System.out.print(solutions[N-1]);*/
        
        
        
        
        
        
        
        
        
//-------------------------------==============----------------------Atempt One---------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*int cowNum = input.nextInt();
        int[][] intrestingEvents = new int[100000][2];
        int[][] startingCords = new int[cowNum][2];
        char[] directions = new char[cowNum];
        int eventsLength = 0;
        int[] differences = new int[100000];
        int lDifferences = 0;

        for(int i = 0; i < cowNum; i++){
            directions[i] = input.nextChar();
            startingCords[i][0] = input.nextInt();
            startingCords[i][1] = input.nextInt();
        }

        for(int i = 0; i < cowNum; i++){
            char curDirection = directions[i];
            for(int j = i + 1; j < cowNum; j++){
                if(directions[i] == directions[j]){
                    continue;
                }
                if(curDirection == 'N'){
                    if(startingCords[i][1] < startingCords[j][1] && startingCords[i][0] > startingCords[j][0]){
                        intrestingEvents[eventsLength][0] = startingCords[i][0];
                        intrestingEvents[eventsLength][1] = startingCords[j][1];
                        
                        differences[lDifferences] = Math.max(intrestingEvents[eventsLength][1] - startingCords[i][1], intrestingEvents[eventsLength][0] - startingCords[j][0]);
                        lDifferences++;
                        eventsLength++;
                    }
                } else{
                    if(startingCords[j][1] < startingCords[i][1] && startingCords[j][0] > startingCords[i][0]){
                        intrestingEvents[eventsLength][0] = startingCords[j][0];
                        intrestingEvents[eventsLength][1] = startingCords[i][1];
                        
                        differences[lDifferences] = Math.max(intrestingEvents[eventsLength][1] - startingCords[j][1], intrestingEvents[eventsLength][0] - startingCords[i][0]);
                        lDifferences++;
                        eventsLength++;
                    }
                }
            }
        }

        for(int i = 0; i < eventsLength; i++){
            int iRecentEvent = 0;
            int curSmallestEvent = 999999999;
            //get most recent event
            for(int j = 0; j < lDifferences; j++){
                if(curSmallestEvent > differences[j]){
                    iRecentEvent = j;
                    curSmallestEvent = differences[j];
                }
            }
            System.out.println(iRecentEvent);
            int northIndex = 0;
            int eastIndex
            for(int j = 0; j < startingCords.length; j++){

            }


            differences[iRecentEvent] = 999999999;
            
            
            
        }*/

        //find the intresting events/intersections and sort them by the time in which each one happens
        // Step 3, output
        System.out.println();
    }
}  
