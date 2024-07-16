package LCHard;

/* package whatever; // don't place package name! */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/* Name of the class has to be "Main" only if the class is public. */
class Solution {
    int[] parent;
    int[] rank;
    int nrows;
    int ncols;

    public static void main(String args[]) throws IOException {
        Solution sol = new Solution();
        int m = 100;
        int n = 100;
//        String currentDirectory = System.getProperty("user.dir");
//
//        // Print the current working directory
//        System.out.println("Current working directory: " + currentDirectory);
        File file = new File("src/LCHard/input.txt");
        // Create a Scanner object to read the file
        Scanner scanner = new Scanner(file);
        List<List<Integer>> positions2 = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            positions2.add(Arrays.stream(line.split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
        }
        int[][] positions = new int[positions2.size()][2];
        for(int i = 0; i < positions2.size(); i++){
            positions[i][0] = positions2.get(i).get(0);
            positions[i][1] = positions2.get(i).get(1);
        }
        sol.numIslands2(m, n, positions);
    }

    private static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) throws IOException {
        ncols = n;
        nrows = m;
        parent = new int[n * m];
        rank = new int[n * m];
        Arrays.fill(parent, -1);

        List<Integer> ans = new ArrayList<>();

        String fileName = "src/LCHard/output.txt";

        FileWriter fileWriter = new FileWriter(fileName);

        int count = 0;
        for(int[] pos : positions){
            int index = index(pos[0], pos[1]);
            if(parent[index] != -1){
                ans.add(count);
                continue;
            }
            parent[index] = index;
            rank[index] = 1;
            count += 1;
            Set<Integer> parents = new HashSet<>();
            String data1 = String.format("x: %d, y: %d, index: %d, count: %d", pos[0], pos[1], index, count);
            fileWriter.append(data1 + "\n");
            for(int[] direction : directions){
                int newX = pos[0] + direction[0];
                int newY = pos[1] + direction[1];
                if(isValid(newX, newY) && parent[index(newX, newY)] != -1){
                    int indexN = index(newX, newY);
                    int parentN = find(indexN);
                    parents.add(parentN);
                    data1 = String.format("newX: %d, newY: %d, index: %d, parent: %d", newX, newY, indexN, parentN);
                    fileWriter.append(data1 + "\n");
                    union(pos, newX, newY);
                }
            }
            fileWriter.append("\n");
            count -= parents.size();
            ans.add(count);
        }

        return ans;
    }

    private void union(int[] pos, int newX, int newY){
        int parent1 = find(index(newX, newY));
        int parent2 = find(index(pos[0], pos[1]));
        if(parent1 == parent2){
            return;
        }
        if(rank[parent1] >= rank[parent2]){
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }
        else{
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

    }

    private int find(int index){
        if(parent[index] != index){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    int index(int row, int col){
        return row * ncols + col;
    }

    private boolean isValid(int x, int y){
        return x >= 0 && y >=0 && x < nrows && y < ncols;
    }
}