package minutia;

import k3m.Point;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class minutiaReduction {


    public static int[][] reduceMinutia(int[][] array, ArrayList<Point> list){

        for (Point point: list) {

            for (Point p : list) {

                if (!point.equals(p))
                if ( Point2D.distance(point.x, point.y, p.x, p.y) < 20) {
                    point.value = 0;


                }
            }
        }
        for (Point point: list){
            if(point.value ==0)
            {
                array[point.x][point.y] = 2;
            }
            else
            {
                array[point.x][point.y] = 3;
            }
        }



        return array;
    }
}
