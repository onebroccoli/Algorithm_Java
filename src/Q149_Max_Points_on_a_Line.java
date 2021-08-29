import java.util.HashMap;

/*
Given an array of 2D coordinates of points (all the coordinates are integers),
find the largest number of points that can be crossed by a single line in 2D space.

Assumptions

The given array is not null and it has at least 2 points
Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points
on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
 */
/*
Solution:
1. define Point class

 */

/*
Laicode: create class point
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

public class Q149_Max_Points_on_a_Line {
    public int most(Point[] points){
        //points cannot be null, length >=2
        if (points == null || points.length < 2){
            return 0;
        }
        int result = 0;
        //we use each pair of points to form a line
        for (int i = 0; i < points.length; i++){
            //any line can be represented by a point and a slope
            //take the point as seed and try to find all possible slopes
            Point seed = points[i];
            //record the points with same <x, y>
            int same = 1;
            //record the points with same x, for the special case of inifite slope
            int sameX = 0;
            //record maximum number of points on the same line crossing the seed point
            int most = 0;
            //a map with all possible slopes
            HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
            for (int j = 0; j < points.length; j++){
                if (i == j){
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y){
                    //handle the points with same <x, y>
                    same++;
                } else if (tmp.x == seed.x){
                    //handle the points with same x
                    sameX++;
                } else {
                    //otherwise, just calculate the slope and increment the counter for the calculated slope
                    double slope = ((tmp.y - seed.y)+0.0)/(tmp.x - seed.x);
                    if (!cnt.containsKey(slope)){
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }

}
 */


//leetcode
class Q149_Max_Points_on_a_Line {
    public int maxPoints(int[][] points) {

        if (points == null || points.length == 0){
            return 0;
        }
        if (points.length == 1){
            return 1;
        }
        int result = 0;
        //we use each pair of points to form a line
        for (int i = 0; i < points.length; i++){
            //any line can be represented by a point and a slope
            //take the point as seed and try to find all possible slopes
            int[] seed = points[i];
            //record the points with same <x, y>
            int same = 1;
            //record the points with same x, for the special case of inifite slope
            int sameX = 0;
            //record maximum number of points on the same line crossing the seed point
            int most = 0;
            //a map with all possible slopes
            HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
            for (int j = 0; j < points.length; j++){
                if (i == j){
                    continue;
                }
                int[] tmp = points[j];
                if (tmp[0] == seed[0] && tmp[1] == seed[1]){
                    //handle the points with same <x, y>
                    same++;
                } else if (tmp[0] == seed[0]){
                    //handle the points with same x
                    sameX++;
                } else {
                    //otherwise, just calculate the slope and increment the counter for the calculated slope
                    double slope = ((tmp[1] - seed[1])+0.0)/(tmp[0] - seed[0]);
                    if (!cnt.containsKey(slope)){
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }

}

