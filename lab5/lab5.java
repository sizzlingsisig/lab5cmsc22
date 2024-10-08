package lab5;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class lab5 {
	//creates Matrix object and initializes the attributes
    public static class Matrix{
        public int[][] matrix;
        public int rows;
        public int columns;
        //constructor for Matrix
        public Matrix(int[][] matrix, int rows, int columns) {
            this.matrix = matrix;
            this.rows = rows;
            this.columns = columns;
        }
    }
    public static void main(String[] args) {
    	//generate random numbers
        try {
            Generator.generate();
        } 
        //catch Input Output exceptions 
        catch (IOException e) {
            System.out.println("An error has occured");
        }
        //reads random numbers in matrix A and B, then takes them as matrices
        Matrix matrixA = createMatrixFromFile("MatrixSrc/MatrixA.csv");
        Matrix matrixB = createMatrixFromFile("MatrixSrc/MatrixB.csv");
        //get the matrix sum
        Matrix matrixSum = matrixAddition(matrixA,matrixB);
        //writes matrix sum to a csv file if it can be added. Prints error message if they cannot be added 
        if (matrixSum != null) {
            writeMatrixToCSV(matrixSum, "MatrixSum.csv");
        }
        else{
            System.out.println("Matrices cannot be added because they have different dimensions");
        }
        //get the matrix difference
        Matrix matrixDifference = matrixSubtraction(matrixA,matrixB);
        //writes matrix sum to a csv file if it can be subtracted. Prints error message if they cannot be added 
        if (matrixDifference != null) {
            writeMatrixToCSV(matrixDifference, "MatrixDifference.csv");
        }
        else{
            System.out.println("Matrices cannot be added because they have different dimensions");
        }
        //initializes matrices after scalar multiplication
        Matrix scalarMatrixA = scalarMultiplication(matrixA,10);
        Matrix scalarMatrixB = scalarMultiplication(matrixB,10);
        //writes matrices to csv file
        writeMatrixToCSV(scalarMatrixA, "MatrixScalarProductA.csv");
        writeMatrixToCSV(scalarMatrixB, "MatrixScalarProductB.csv");
        //transposes matrices
        Matrix transposedMatrixA = matrixTransposition(matrixA);
        Matrix transposedMatrixB = matrixTransposition(matrixB);
        //writes matrices to csv
        writeMatrixToCSV(transposedMatrixA, "MatrixATransposed.csv");
        writeMatrixToCSV(transposedMatrixB, "MatrixBTransposed.csv");
        //initializes matrix product
        Matrix multipliedMatrix = matrixMultiplication(matrixA, matrixB);
        if (multipliedMatrix != null) {
            writeMatrixToCSV(multipliedMatrix, "MatrixProduct.csv");
        }
        else{
            System.out.println("Matrices cannot be multiplied because their dimensions are incompatible.");
        }
    }
    //method to write matrix to csv files
    public static void writeMatrixToCSV(Matrix matrix, String filename) {
    	//makes a folder if the folder does not exist
        File folder = new File("MatrixOperationResults");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //writes the array contents into the 2d array 
        try (FileWriter writer = new FileWriter("MatrixOperationResults"+"/"+filename)) {
            for (int i = 0; i < matrix.rows; i++) {
                for (int j = 0; j < matrix.columns; j++) {
                	//writes current element into file followed by comma
                    writer.write(matrix.matrix[i][j] + ",");
                }
                //writes into next line
                writer.write("\n");
            }
        } 
        catch (IOException e) {
            System.out.println("File writing error");
        }
    }
    //method to create matrix from file
    public static Matrix createMatrixFromFile(String filePath) {
    	//initialization
        try (FileReader reader = new FileReader(filePath)) {
            Scanner scan = new Scanner(reader);
            //creates array list that stores rows 
            ArrayList<String> rows = new ArrayList<>();
            //adds lines of file and adds each of the read lines to the arraylist
            while (scan.hasNextLine()) {
                rows.add(scan.nextLine());
            }
            scan.close();
            //get number of rows and columns
            int rowSize = rows.size();
            //splits first line of code into an array and gets the length
            int colSize = rows.get(0).split(",").length;
            //initializes the matrix
            int[][] matrix = new int[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) {
            	//splits rows into array based on commas
                String[] row = rows.get(i).split(",");
                for (int j = 0; j < colSize; j++) {
                	//converts the split row array into an integer and adds it to the matrix
                	matrix[i][j] = Integer.parseInt(row[j]);    
                }
            }
            return new Matrix(matrix, rowSize, colSize);
        } 
        catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }
    public static Matrix matrixAddition(Matrix matrixA, Matrix matrixB) {
    	//if dimensions are not the same then return null
        if (matrixA.rows != matrixB.rows || matrixA.columns != matrixB.columns) {
            return null;
        }
        //initializes added matrix
        int[][] addedMatrix = new int[matrixA.rows][matrixA.columns];
        //adds matrices on a specific index
        for (int i = 0; i < matrixA.rows; i++) {
            for (int j = 0; j < matrixA.columns; j++) {
                addedMatrix[i][j] = matrixA.matrix[i][j] + matrixB.matrix[i][j];
            }
        }
        //returns matrix sum
        return new Matrix(addedMatrix, matrixA.rows, matrixA.columns);
    }
    public static Matrix matrixSubtraction(Matrix matrixA, Matrix matrixB) {
    	//returns null if dimensions are not the same
        if (matrixA.rows != matrixB.rows || matrixA.columns != matrixB.columns) {
        	return null;
        }
        //initializes subtracted matrix
        int[][] subtractedMatrix = new int[matrixA.rows][matrixA.columns];
        //subtracts elements at index [i][j]
        for (int i = 0; i < matrixA.rows; i++) {
            for (int j = 0; j < matrixA.columns; j++) {
                subtractedMatrix[i][j] = matrixA.matrix[i][j] - matrixB.matrix[i][j];
            }
        }
        //returns subtracted matrix
        return new Matrix(subtractedMatrix, matrixA.rows, matrixA.columns);
    }
    public static Matrix scalarMultiplication(Matrix matrix, int number) {
    	//initializes scalar matrix
        int[][] scalarMatrix = new int[matrix.rows][matrix.columns];
        //sets the element in scalarmatrix at [i][j] into the matrix at [i][j] * number
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                scalarMatrix[i][j] = matrix.matrix[i][j] * number;
            }
        }
        //returns scalar matrix
        return new Matrix(scalarMatrix, matrix.rows, matrix.columns);
    }
    public static Matrix matrixTransposition(Matrix matrix) {
    	//initializes transposed matrix
        int[][] transposedMatrixA = new int[matrix.columns][matrix.rows];
        //transposes matrix by switching the indices
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                transposedMatrixA[j][i] = matrix.matrix[i][j];
            }
        }
        //returns the transposed matrix
        return new Matrix(transposedMatrixA, matrix.columns, matrix.rows);
    }

    public static Matrix matrixMultiplication(Matrix matrixA, Matrix matrixB) {
    	//returns null if 
        if (matrixA.columns != matrixB.rows) {
            return null;
        }
        //initializes multiplied matrix
        int[][] multipliedMatrix = new int[matrixA.rows][matrixB.columns];
        
        for (int i = 0; i < matrixA.rows; i++) {
            for (int j = 0; j < matrixB.columns; j++) {
            	//iterates over columns of matrix A, k is column index 
                for (int k = 0; k < matrixA.columns; k++) {
                    multipliedMatrix[i][j] += matrixA.matrix[i][k] * matrixB.matrix[k][j];
                }
            }
        }

        return new Matrix(multipliedMatrix, matrixA.rows, matrixB.columns);
    }
}