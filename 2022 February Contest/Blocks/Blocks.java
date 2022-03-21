import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class Blocks{
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

    static ArrayList<ArrayList<Integer>> setsGenerated = new ArrayList<ArrayList<Integer>>();
    private static void generateSets(int timesIterated, int limit, ArrayList<Integer> curSubSet){
        if(limit == timesIterated){
            setsGenerated.add(curSubSet);
            return;
        }
        timesIterated++;

        ArrayList<Integer> one = (ArrayList<Integer>)curSubSet.clone();
        one.add(timesIterated);
        generateSets(timesIterated, limit, one);
        generateSets(timesIterated, limit, (ArrayList<Integer>)curSubSet.clone());
    }
    static ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
    private static void generatePermutations(int timesIterated, int limit, ArrayList<Integer> curPermutation, int edgesPerNode){
        if(timesIterated == limit){
            permutations.add(curPermutation);
            return;
        }
        timesIterated++;

        for(int i = 1; i <= edgesPerNode; i++){
            ArrayList<Integer> curCurPermutation = (ArrayList<Integer>)curPermutation.clone();
            curCurPermutation.add(i);
            generatePermutations(timesIterated, limit, curCurPermutation, edgesPerNode);
        }
        
    }
    
   
    public static void main(String[] args) throws IOException{
        // Step 1, read input, parse input into your data structure
		InputReader input = new InputReader(new FileReader("sample.in"));
        //InputReader input = new InputReader();
        
























        
        /*int N = input.nextInt();
        char[][] blocks = new char[4][6];
        String[] words = new String[N];
        for(int i = 0; i < 4; i++){
            String yes = input.next();
            for(int j = 0; j < 6; j++){
                blocks[i][j] = yes.charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            words[i] = input.next();
        }
        
        ArrayList<String> PossibleWords = new ArrayList<>();
        
        generateSets(0, 4, new ArrayList<Integer>());

            
        
        generatePermutations(0, 4, new ArrayList<Integer>(), 6);
        ArrayList<ArrayList<Integer>> fourCubePerms = (ArrayList<ArrayList<Integer>> )permutations.clone();
        permutations.clear();
        generatePermutations(0, 3, new ArrayList<Integer>(), 6);
        ArrayList<ArrayList<Integer>> threeCubePerms = (ArrayList<ArrayList<Integer>> )permutations.clone();
        permutations.clear();
        generatePermutations(0, 2, new ArrayList<Integer>(), 6);
        ArrayList<ArrayList<Integer>> twoCubePerms = (ArrayList<ArrayList<Integer>> )permutations.clone();
        permutations.clear();
        generatePermutations(0, 1, new ArrayList<Integer>(), 6);
        ArrayList<ArrayList<Integer>> oneCubePerms = (ArrayList<ArrayList<Integer>> )permutations.clone();
        
        ArrayList<ArrayList<ArrayList<Integer>>> cubeperms = new ArrayList<ArrayList<ArrayList<Integer>>>();
        
    
        cubeperms.add(oneCubePerms);
        cubeperms.add(twoCubePerms);
        cubeperms.add(threeCubePerms);
        cubeperms.add(fourCubePerms);
        


        for(int i = 0; i < setsGenerated.size(); i++){
           
            for(int j = 0; j < cubeperms.get(setsGenerated.get(i).size() - 1).size(); j++){
                String word = "";
                for(int k = 0; k < setsGenerated.get(i).size(); k++){
                    word = word + "" + blocks[setsGenerated.get(i).get(k) - 1][cubeperms.get(setsGenerated.get(i).size() - 1).get(j).get(k) - 1];
                }
                PossibleWords.add(word);
            }
            
        }
        System.out.println("");
*/

        




        
        /*
        char[][] Blocks = new char[4][6];
        ArrayList<String> PossibleWords = new ArrayList<>();
        
        int N = input.nextInt();
        for(int i = 0; i < 4; i++){
            String sBlock = input.next();
            for(int j = 0; j < 6; j++){
                Blocks[i][j] = sBlock.charAt(j);
            }
        }

        MAINLOOP: for(int i = 0; i < N; i++){
            String ScurWord = input.next();
            int wordLength = ScurWord.length();
            char[] curWord = new char[wordLength];
            ArrayList<Integer> firstBlockContains = new ArrayList<>();
            ArrayList<Integer> secondBlockContains = new ArrayList<>();
            ArrayList<Integer> thirdBlockContains = new ArrayList<>();
            ArrayList<Integer> fourthBlockContains = new ArrayList<>();
            for(int j = 0; j < wordLength; j++){
                curWord[j] = ScurWord.charAt(j);
            }
            int[] contains = new int[wordLength];
            
            for(int j = 0; j < wordLength; j++){
                contains[j] = 90000;
                if(contains(Blocks[0], curWord[j])){
                    firstBlockContains.add(j);
                    contains[j] += 1000;
                }
                if(contains(Blocks[1], curWord[j])){
                    secondBlockContains.add(j);
                    contains[j] += 200;
                }
                if(contains(Blocks[2], curWord[j])){
                    thirdBlockContains.add(j);
                    contains[j] += 30;
                }
                if(contains(Blocks[3], curWord[j])){
                    fourthBlockContains.add(j);
                    contains[j] += 4;
                }
            }
            
            int SimilarValues = 0;



            for(int a = 0; a < firstBlockContains.size(); a++){
                for(int b = 0; b < secondBlockContains.size(); b++){
                    for(int c = 0; c < thirdBlockContains.size(); c++){
                        for(int d = 0; d < fourthBlockContains.size(); d++){
                            int[] values = new int[4];
                            values[0] = firstBlockContains.get(a);
                            values[1] = secondBlockContains.get(b);
                            values[2] = thirdBlockContains.get(c);
                            values[3] = fourthBlockContains.get(d);

                            int SimilarValues = 0;
                            for(int j = 0; j < 3; j++){
                                for(int k = j + 1; k < 4; k++){
                                    if(values[j] == values[k]){
                                        SimilarValues++;
                                    }
                                }
                            }
                            if(4 - SimilarValues == wordLength){
                                System.out.println("YES");
                                continue MAINLOOP;
                            }

                        }
                    }
                }
            }
            
            System.out.println("NO");

            
        }
        */

        
	}
}