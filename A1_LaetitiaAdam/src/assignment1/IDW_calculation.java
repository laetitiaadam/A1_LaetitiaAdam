//Assignment 1, Practice Software Development
//Due date: 30th of December, 2025
//Author: Laetitia Adam

package assignment1;

import java.util.Arrays; //this class helps to convert Array into readable text

//constructor for IDW_calculation class
public class IDW_calculation {
	
	
//method for IDW calculation taken from task sheet	
public static double[][] idw(double[][] data) {
	
	//Declaring and assigning variables for the 2D result array
	//Row is taking the total number of rows of the input array, Col is taking the number of columns of the first row
	int row = data.length;
	int col = data[0].length;
	
	//result is a newly created 2D array based on the previously identified number of rows and columns. It is assuming that all rows have the same number of columns. 
	double [][] result = new double [row][col];
	
	//for loop iterates through all values in the 2D input array
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

