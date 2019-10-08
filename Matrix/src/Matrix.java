import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int rows, columns;
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Type in the number of rows: ");
        rows = reader.nextInt();
        System.out.print("Type in the number of columns: ");
        columns = reader.nextInt();

        int matrix [][];

        matrix = askInfo(rows, columns);
        printMatrix(matrix);
        countSum(matrix);
    }
    
    private static int[][] askInfo(int rows, int columns) {
    	int matrix [][] = new int[rows][columns];
    	Scanner reader = new Scanner(System.in);
    	
    	for(int i = 0; i < rows; i++) {
    	    for(int j = 0; j < columns; j++) {
    	        System.out.print("Type in the element " + (j + 1) + " of the row  " + (i + 1) + ": ");
    	        matrix[i][j] = reader.nextInt();
    	    }
    	}
    	return matrix;
    }
    
    private static void printMatrix(int [][] matrix) {
    	System.out.println("\nMatrix:");
    	for(int i = 0; i < matrix.length; i++) {
    	    for(int j = 0; j < matrix[i].length; j++) System.out.print(matrix[i][j] + "\t");    	    
    	    System.out.println();
    	}
    }
    
    private static void countSum(int [][] matrix) {
    	int sum = 0;
    	for(int i = 0; i < matrix.length; i++)
    	    for(int j = 0; j < matrix[i].length; j++) sum = sum + matrix[i][j];     	        	    
    	System.out.println("\nSum of the elements of the matrix: " + sum);
    }   
}