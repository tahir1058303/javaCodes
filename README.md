## **_getValueOfMostValuablePlot_**  Program in _Java_

For this problem a 2d array of `ints` represents the value of each block in a city. Each element in the array is a city block. The value of a block could be negative indicating the block is a liability to own. Complete a method that finds the value of the most valuable contiguous sub rectangle in the city represented by the 2d array. The sub rectangle must be at least 1 by 1. (If all the values are negative "the most valuable" rectangle would be the negative value closest to 0.) Note, for this method you may assume the given 2d array of ints will not cause your method to overflow or underflow the Java int data type.


 Implement a brute force approach that examines each possible sub matrix independently. The brute force approach is typically O(N6) which is acceptable for this assignment. The brute force approach is still complicated, but use helper methods to break the problem down into smaller, more manageable pieces. 
