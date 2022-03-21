import java.nio.file.DirectoryIteratorException;
import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class Acowdemia {
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
    
   /* public static void main(String[] args) throws IOException {
        // Step 1, read input, parse input into your data structure
        // InputReader input = new InputReader(new FileReader("sample.in"));
        InputReader input = new InputReader();
        int pNum = input.nextInt();
        int cNum = input.nextInt();

        String[] cows = new String[cNum];
        String[] papers = new String[cNum];
        char[][] solution = new char[cNum][cNum];
        for (int i = 0; i < cNum; i++) {
            for (int j = 0; j < cNum; j++) {
                solution[i][j] = '?';
            }
        }

        for (int i = 0; i < cNum; i++) {
            cows[i] = input.next();
        }

        for (int i = 0; i < pNum; i++) {

            List<Integer> seniorityIndexes = new ArrayList<Integer>();

            String previousString = "";

            ArrayList<String> curJuniorCows = new ArrayList<String>();
            ArrayList<String> curCowsPast = new ArrayList<String>();

            for (int j = 0; j < cNum; j++) {

                papers[j] = input.next();
                if (papers[j].compareTo(previousString) <= 0) {
                    curJuniorCows.clear();
                    curJuniorCows.addAll(curCowsPast);
                }
                curCowsPast.add(papers[j]);
                previousString = papers[j];

                int curIndexMain = Arrays.asList(cows).indexOf(papers[j]);
                solution[curIndexMain][curIndexMain] = 'B';
                // loop through each junior cow and make cur cow more senior than them
                for (int k = 0; k < curJuniorCows.size(); k++) {
                    String curName = curJuniorCows.get(k);
                    int curIndexLoop = Arrays.asList(cows).indexOf(curName);
                    solution[curIndexLoop][curIndexMain] = '0';
                    solution[curIndexMain][curIndexLoop] = '1';
                }
            }
        }

        for (int i = 0; i < cNum; i++) {
            for (int j = 0; j < cNum; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println("");
        }

    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        Map<String, Integer> members = new HashMap<>();
        tokenizer = new StringTokenizer(in.readLine());
        for (int a = 0; a < n; a++) {
            members.put(tokenizer.nextToken(), a);
        }
        char[][] answer = new char[n][n];
        for (int a = 0; a < n; a++) {
            Arrays.fill(answer[a], '?');
            answer[a][a] = 'B';
        }
        for (int j = 0; j < k; j++) {
            tokenizer = new StringTokenizer(in.readLine());
            String[] publication = new String[n];
            for (int x = 0; x < n; x++) {
                publication[x] = tokenizer.nextToken();
            }
            for (int x = 0; x < n; x++) {
                boolean alphabetical = true;
                for (int y = x + 1; y < n; y++) {
                    if (publication[y - 1].compareTo(publication[y]) > 0) {
                        alphabetical = false;
                    }
                    if (!alphabetical) {
                        int a = members.get(publication[x]);
                        int b = members.get(publication[y]);
                        answer[a][b] = '0';
                        answer[b][a] = '1';
                    }
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int a = 0; a < n; a++) {
            out.append(answer[a]).append('\n');
        }
        System.out.print(out);
    }
}