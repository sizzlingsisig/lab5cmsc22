package lab5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException{
        generate();
    }   

    private static int rng(int max){
        int randomRes = (int)(Math.random()*(max));
        return randomRes;
    }

    private static void generateFile(File myFile, int[][] matrix) throws IOException{
        myFile.createNewFile();
        FileWriter fWriter = new FileWriter(myFile);
        String sToWrite = "";

        for(int rowNum = 0; rowNum < matrix.length; rowNum++){
            for(int colNum = 0; colNum < matrix[rowNum].length; colNum++){
                sToWrite += matrix[rowNum][colNum];
                if(colNum < matrix[rowNum].length-1){
                    sToWrite += ",";
                }
            }
            if(rowNum < matrix.length-1){
                sToWrite += "\n";
            }
        }
        fWriter.write(sToWrite);
        fWriter.close();
    }

    public static void generate() throws IOException{
        File myDir = new File("MatrixSrc");
        myDir.mkdir();
        File matrixAFile = new File(myDir, "MatrixA.csv");
        File matrixBFile = new File(myDir, "MatrixB.csv");

        int[][] matrixA,matrixB;
        
        int sizeRng = rng(5);
        System.out.println(sizeRng);
        switch(sizeRng){
            case 1: matrixA = new int[10][10];
                    matrixB = new int[10][10];
                    break;
            case 2: matrixA = new int[20][20];
                    matrixB = new int[20][20];
                    break;
            case 3: matrixA = new int[2][5];
                    matrixB = new int[5][2];
                    break;
            case 4: matrixA = new int[5][10];
                    matrixB = new int[10][5];
                    break;
            default: matrixA = new int[30][30];
                     matrixB = new int[30][30];
                     break;
        }

        for(int rowNumA = 0; rowNumA < matrixA.length; rowNumA++){
            for(int colNumA = 0; colNumA < matrixA[rowNumA].length; colNumA++){
                matrixA[rowNumA][colNumA] = rng(21)-10;
            }
        }

        for(int rowNumB = 0; rowNumB < matrixB.length; rowNumB++){
            for(int colNumB = 0; colNumB < matrixB[rowNumB].length; colNumB++){
                matrixB[rowNumB][colNumB] = rng(21)-10;
            }
        }

        generateFile(matrixAFile,matrixA);
        generateFile(matrixBFile,matrixB);
    }
}