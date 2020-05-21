package k3m;

import javafx.scene.image.Image;

import java.util.List;

import static utils.utils.getColor;

public class ArrayOfZerosAndOnes {
   public static int[][] getArrayFromImage(Image image) {

       int y = (int)image.getWidth();
       int x = (int)image.getHeight();

       int[][] array = new int [y][x];
       for (int i = 0; i < x; i++) {
           for (int j = 0; j < y; j++) {
               int[] RGB = getColor(image,i,j);
               if(RGB[0] > 0)
                   array[j][i] = 0;
               else
                   array[j][i] = 1;
           }
       }
       return array;
   }

}
