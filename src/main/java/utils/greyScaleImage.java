package utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import static utils.utils.getColor;

public class greyScaleImage {
    public static WritableImage returnGrayScaleImage (WritableImage image){
        double x = image.getWidth();
        double y = image.getHeight();

        PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(
                pixelReader,
                (int)image.getWidth(),
                (int)image.getHeight());

        PixelWriter writer = writableImage.getPixelWriter();

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                int[] RGB = getColor(image,i,j);
                int color = (RGB[0]+RGB[1]+RGB[2])/3;
                writer.setColor(j,i, Color.rgb(color,color,color));
            }
        }

        return writableImage;
    }

}
