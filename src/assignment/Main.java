package assignment;

/**
 *  Time complexity is o(n), for instance if the array is 9*9 it means the loop will execute 81 times.
 *   In this case the loop will be executed 400 times since it is 20*20.
 */
public class Main {

    String txt =
                    "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"+
                    "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"+
                    "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"+
                    "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"+
                    "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"+
                    "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"+
                    "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"+
                    "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"+
                    "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"+
                    "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"+
                    "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"+
                    "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"+
                    "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"+
                    "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"+
                    "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"+
                    "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"+
                    "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"+
                    "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"+
                    "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"+
                    "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";






    /**
     * Receive data as input and then transfer to a integer 2d array and populates the array with data
     * @param strTxt
     * @return intArray (2d array)
     */
    public int[][] populateTwoDimensionalArray(String strTxt){

        String[] strFirstArray= strTxt.split("\n");    //split the string where \n and create a array
        String twoDimensionalArray[][] = new String[strFirstArray.length][];

        int r=0;
        for(String str : strFirstArray){
            twoDimensionalArray[r++] = str.split(" ");  // split the string array between every object and create a 2d string array
        }
        /*
        for(int i=0; i< twoDimensionalArray.length; i++){
            for(int j=0; j< twoDimensionalArray[i].length; j++){
                System.out.print(twoDimensionalArray[i][j]+" ");
            }
            System.out.println();
        }
         */



        int[][] intPopulatedArray = new int[twoDimensionalArray.length][twoDimensionalArray[0].length];
        for(int i=0; i< twoDimensionalArray.length; i++){
            for(int j=0; j< twoDimensionalArray[0].length; j++){
                intPopulatedArray[i][j] = Integer.parseInt(twoDimensionalArray[i][j]);
            }
        }
        return intPopulatedArray;
    }


    /**
     * This method receive a 2d array as input which it uses to find highest possible product from the same row.
     * The array has 20 rows and 20 columns regarding data.
     * It starts from the first row to fourth row and every time compares first column of 4 rows and calculates the product of these elements and sets as current highest product. Then it goes to the next rows for instance [1..4] then [2..5] then [3..6]
     * Every time the product of these elements are calculated and compared to the current highest, if a new product is higher than the current highest then it becomes the new current highest product.
     * @param intArray
     * @return highestPossibleProduct
     */
    public int findHighestPossibleProductFromSameRow(int[][] intArray) {
        int highestPossibleProduct=0;
        int firstElem=0, secondElem=0, thirdElem=0, fourthElem=0;
        for(int row=0; row < intArray.length; row++){
            for(int col=0; col < intArray[row].length; col++){
                if((row <= intArray.length-4) && (highestPossibleProduct < intArray[row][col] * intArray[row+1][col] * intArray[row+2][col] * intArray[row+3][col])){
                    highestPossibleProduct = intArray[row][col] * intArray[row+1][col] * intArray[row+2][col] * intArray[row+3][col];
                    firstElem = intArray[row][col];
                    secondElem = intArray[row+1][col];
                    thirdElem = intArray[row+2][col];
                    fourthElem = intArray[row+3][col];
                }
            }
        }
        System.out.println("Highest possible product from same row: "+highestPossibleProduct+"\n"+firstElem+"\n"+secondElem+"\n"+thirdElem+"\n"+fourthElem+"\n");
        return highestPossibleProduct;
    }

    /**
     * This method receive a 2d array as input which it uses to find highest possible product from the same column.
     * The array has 20 rows and 20 columns regarding data.
     * It starts from the first row and every time compares 4 columns and calculates the product of these elements and sets as current highest product. Then it goes to the next columns for instance [1..4] then [2..5] then [3..6]
     * Every time the product of these elements are calculated and compared to the current highest, if a new product is higher than the current highest then it becomes the new current highest product.
     * @param intArray
     * @return highestPossibleProduct
     */
    public int findHighestPossibleProductFromSameColumn(int[][] intArray){
        int highestPossibleProduct=0;
        int firstElem=0, secondElem=0, thirdElem=0, fourthElem=0;
        for(int row=0; row< intArray.length; row++){
            for(int col=0; col< intArray[row].length; col++){
                if ((col <= intArray.length-4) && (highestPossibleProduct < intArray[row][col] * intArray[row][col + 1] * intArray[row][col + 2] * intArray[row][col + 3])) {
                        highestPossibleProduct = intArray[row][col] * intArray[row][col + 1] * intArray[row][col + 2] * intArray[row][col + 3];
                        firstElem = intArray[row][col];
                        secondElem = intArray[row][col + 1];
                        thirdElem = intArray[row][col + 2];
                        fourthElem = intArray[row][col + 3];
                }
            }
        }
        System.out.println("Highest possible product from same column: "+highestPossibleProduct+"\n"+firstElem+"  "+secondElem+"  "+thirdElem+"  "+fourthElem+"\n");
        return highestPossibleProduct;
    }

    /**
     * This method receive a 2d array as input which it uses to find highest possible product from diagonal.
     * The array has 20 rows and 20 columns regarding data.
     * Diagonal is means going from first row first column to second row second column and third row third column and so on.
     * Every time the product of these elements are calculated and compared to the current highest, if a new product is higher than the current highest then it becomes the new current highest product.
     * @param intArray
     * @return highestPossibleProduct
     */
    public int findHighestPossibleFromDiagonal(int[][] intArray){
        int highestPossibleProduct=0;
        int firstElem=0, secondElem=0, thirdElem=0, fourthElem=0;
        for(int row=0; row < intArray.length; row++){
            for(int col=0; col< intArray[row].length; col++){
                if((col <= intArray.length-4) && (row <= intArray.length-4) && (highestPossibleProduct < intArray[row][col] * intArray[row+1][col+1] * intArray[row+2][col+2] * intArray[row+3][col+3])){
                    highestPossibleProduct = intArray[row][col] * intArray[row+1][col+1] * intArray[row+2][col+2] * intArray[row+3][col+3];
                    firstElem = intArray[row][col];
                    secondElem = intArray[row+1][col+1];
                    thirdElem = intArray[row+2][col+2];
                    fourthElem = intArray[row+3][col+3];
                }
            }
        }
        System.out.println("Highest possible product from diagonal: "+highestPossibleProduct+"\n"+firstElem+"\n\t"+secondElem+"\n\t\t"+thirdElem+"\n\t\t\t"+fourthElem+"\n");
        return highestPossibleProduct;
    }

    /**
     * This method receive a 2d array as input which it uses to find highest possible product from anti diagonal.
     * The array has 20 rows and 20 columns regarding data.
     * Anti diagonal is going from fourth row first column to third row second column to second row third column and so on.
     * Every time the product of these elements are calculated and compared to the current highest, if a new product is higher than the current highest then it becomes the new current highest product.
     * @param intArray
     * @return highestPossibleProduct
     */
    public int findHighestPossibleFromAntiDiagonal(int[][] intArray){
        int highestPossibleProduct=0;
        int firstElem=0, secondElem=0, thirdElem=0, fourthElem=0;
        for(int row=0; row < intArray.length; row++){
            for(int col=0; col< intArray[row].length; col++){
                if((col >= 4) && (row <= intArray.length-4) && (highestPossibleProduct < intArray[row][col] * intArray[row+1][col-1] * intArray[row+2][col-2] * intArray[row+3][col-3])){
                    highestPossibleProduct = intArray[row][col] * intArray[row+1][col-1] * intArray[row+2][col-2] * intArray[row+3][col-3];
                    firstElem = intArray[row][col];
                    secondElem = intArray[row+1][col-1];
                    thirdElem = intArray[row+2][col-2];
                    fourthElem = intArray[row+3][col-3];
                }
            }
        }
        System.out.println("Highest possible product from anti diagonal: "+highestPossibleProduct+"\n\t\t\t"+firstElem+"\n\t\t"+secondElem+"\n\t"+thirdElem+"\n"+fourthElem+"\n");
        return highestPossibleProduct;
    }



    public static void main(String[] args) {
        Main main = new Main();

        int[][] populatedArray = main.populateTwoDimensionalArray(main.txt);


        int highestPossibleProduct=0, result=0;

        result = main.findHighestPossibleProductFromSameRow(populatedArray);
        if(highestPossibleProduct < result)
            highestPossibleProduct = result;


        result = main.findHighestPossibleProductFromSameColumn(populatedArray);
        if(highestPossibleProduct < result)
            highestPossibleProduct = result;


        result = main.findHighestPossibleFromDiagonal(populatedArray);
        if(highestPossibleProduct < result)
            highestPossibleProduct = result;


        result = main.findHighestPossibleFromAntiDiagonal(populatedArray);
        if(highestPossibleProduct < result)
            highestPossibleProduct = result;



        System.out.println("Highest possible product: "+highestPossibleProduct);

    }
}
