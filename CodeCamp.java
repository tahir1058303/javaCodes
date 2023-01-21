import java.util.*;
import java.awt.*;
public class CodeCamp{

    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1.
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        int result = -1;
        // check preconditions
        ArrayList<Point> upperleftcoord = new ArrayList<>();
        if (city == null || city.length == 0 || city[0].length == 0
                || !isRectangular(city) ) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getValueOfMostValuablePlot. The parameter may not be null," +
                    " must value at least one row and at least" +
                    " one column, and must be rectangular.");
        }
        //Generate coordination of all possible upper left conners
        //For the current upperleft conner generate the 
        // the coordinates of all possible lower left corners
        // then calculate maximum of all plots
        else{                                                                               
            int rowsize = city.length;
            int columnssize = city[0].length;
            int currentmax = maximum(new Point(0,0), new Point(rowsize-1,columnssize-1), city);
            //Generating Upperleft corners
            for(int i=0; i< rowsize; i++){                                     

                for(int j=0; j<columnssize; j++){
                    upperleftcoord.add(new Point(i,j));
                }

            }
            //Generating lowerleft corners for each upper corner and then calculating values of plots
            for (Point point : upperleftcoord) {
                for(int i= (int)point.getX(); i < rowsize; i++){
                    for(int j=(int)point.getY(); j < columnssize;j++){
                        int value = maximum(point, new Point(i,j) , city);

                        if(value > currentmax){
                            currentmax = value;
                        }
                    }
                }
            }

            result = currentmax;
                                                                                    
        }

        return result;
    }

    // Function to calculate maximum between upper corner and lower corner of plot
    public static int maximum(Point up,Point lower,int[][] array){
        int max=0;
        for(int i=(int)up.getX(); i<= lower.getX(); i++){
            for(int j=(int)up.getY(); j<=lower.getY();j++){
                max += array[i][j];
            }
        }
        return max;
    }

    // Function to check is incoming array is rectangular
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isRectangular. Parameter may not be null and must contain" +
                    " at least one row.");
        }
        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null)
                    && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }

    public static void main(String[] args) {
        String newline = "\n";
        int expected,actual;

        int[][] city = { { 0, -2, -7, 0, -1 }, 
                         { 9, 2, -6, 2, 0 }, 
                         { -4, 1, -4, 1, 0 },
                         { -1, 8, 0, -2, 1 }, 
                         { -10, 1, 1, -5, -6 }, 
                         { -15, -1, 1, 5, 4 } };

        expected = 15;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 34 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 34, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 34, getValueOfMostValuablePlot");
        }
        
        // test 35, getValueOfMostValuablePlot
        city[4][1] = 6;
        expected = 17;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 35 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 35, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 35, getValueOfMostValuablePlot");
        }
        
        // test 36, getValueOfMostValuablePlot
        city = new int[][] { { 1 } };
        expected = 1;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println("\nTest 36 getValueOfMostValuablePlot: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 36, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 36, getValueOfMostValuablePlot");
        }
        
        // test 37, getValueOfMostValuablePlot
        city = new int[][] { { 1, 2, 3, 4, 5, 6, 7 } };
        expected = 28;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 37 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 37, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 37, getValueOfMostValuablePlot");
        }
        
        // test 38, getValueOfMostValuablePlot
        city = new int[][] { {-10, -10, -10, -5}, 
                             {-15, -15, -10, -10}, 
                             {-5, -10, -20, -5},
                             {-5, -5, -10, -20 }};

        expected = -5;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println("\nTest 38 getValueOfMostValuablePlot: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 38, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 38, getValueOfMostValuablePlot");
        }


        
    }



}