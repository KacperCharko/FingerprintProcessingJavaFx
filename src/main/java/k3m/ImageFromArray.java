package k3m;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.awt.*;

public class ImageFromArray {
    public static WritableImage getImageFromArray(int[][] array){
        int x = array.length;
        int y = array[1].length;

        WritableImage writableImage = new WritableImage(x,y);

        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int i =0; i<y; i++){
            for (int j = 0; j<x; j++){
                if(array[j][i] == 0){
                    pixelWriter.setColor(j,i, Color.WHITE);
                }
                else{
                    pixelWriter.setColor(j,i,Color.BLACK);
                }
            }
        }
        return  writableImage;
    }
}
