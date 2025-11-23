

package assignment1;

import java.util.Arrays;

public class IDW_calculation {
	
	
	
public static double[][] idw(double[][] data) {
	
	int row = data.length;
	int col = data[0].length;
	
	double [][] result = new double [row][col];
	
	for (int rowNumber = 0; rowNumber < row; rowNumber++) {
		for (int colNumber = 0; colNumber < col; colNumber++) {
			result[rowNumber][colNumber] = data[rowNumber][colNumber];
		}
	}
	
	
	return result;
}

public static void main (String[] args) {
	
	double[][] grid = {
			{1.0, Double.NaN, 3.0},
			{Double.NaN, Double.NaN, 2.0},
			{4.0, 5.0, Double.NaN}
	};
	
	double[][] interpolatedGrid = idw(grid);
	System.out.println(Arrays.deepToString(interpolatedGrid));
	}
}

