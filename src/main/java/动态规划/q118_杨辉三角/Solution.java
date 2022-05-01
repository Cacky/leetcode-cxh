package 动态规划.q118_杨辉三角;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找规律，动态规划 o(n^2)
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }


    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {

            if (i == 1) {
                List<Integer> line = Arrays.asList(1);
                result.add(line);
            } else if (i == 2) {
                List<Integer> line = Arrays.asList(1, 1);
                result.add(line);
            } else {
                List<Integer> beforeLine = result.get(i - 2);
                List<Integer> line = new ArrayList<>(i);
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        line.add(1);
                    } else {
                        line.add(beforeLine.get(j) + beforeLine.get(j - 1));
                    }
                }
                result.add(line);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().generate2(5));
    }
}
