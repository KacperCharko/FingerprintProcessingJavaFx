package k3m;

import javafx.scene.image.Image;

import java.util.List;

import static utils.utils.getColor;

public class ArrayOfZerosAndOnes {
   public static int[][] getArrayFromImage(Image image) {

       int x = (int)image.getWidth();
       int y = (int)image.getHeight();

       int[][] array = new int [y][x];
       for (int i = 0; i < y; i++) {
           for (int j = 0; j < x; j++) {
               int[] RGB = getColor(image,i,j);
               if(RGB[0] > 0)
                   array[i][j] = 0;
               else
                   array[i][j] = 1;
           }
       }
       return array;
   }

}
