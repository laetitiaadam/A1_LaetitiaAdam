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
	for (int x = 0; x < row; x++) {
		for (int y = 0; y < col; y++) {
			
			//declare and assign variable for each value at x,y position
			double value = data[x][y];
			
			//check if value is NOT NaN and then copy to result
			if (!Double.isNaN(value)) {
				result [x][y] = value;
			}
			
			//check if value IS NaN and calculate euclidian distance and IDW interpolation
			else {
				double weightedSum = 0.0;
				double weightTotal = 0.0;
				
				//iterate through the array again but skip NaN values, same for-loop as before with different variable names
				for (int x_notNAN = 0; x_notNAN < row; x_notNAN++) {
					for (int y_notNAN = 0; y_notNAN < col; y_notNAN++) {
						
						//declare and assign variable to not NAN values
						double neighbor_notNAN = data[x_notNAN][y_notNAN];
						
						//skip NAN values
						if (Double.isNaN(neighbor_notNAN))
							continue;
						
						//calculate euclidian distance from value to all neighbors that are not NAN with the formula provided in the task sheet
						//Math.sqrt takes the square root, Math.pow takes the base and exponent
						double distance = Math.sqrt(Math.pow(x - x_notNAN, 2) + Math.pow(y - y_notNAN, 2));
						
						//if distance is zero, the loop continues
						if (distance == 0)
							continue;
						
						//calculate weight according to formula weight = 1 / distance²
						double weight = 1.0 / Math.pow(distance, 2);
						
						//NUMERATOR: multiply weight with neighbor and add it, += does assign and add the value of the expression at once
						weightedSum += weight * neighbor_notNAN;
						
						//DENOMINATOR: take sum off all weights
						weightTotal += weight;
					}
				}
			}
			
			//has to be replaced by array with interpolated values!!!
			result[x][y] = data[x][y];
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

