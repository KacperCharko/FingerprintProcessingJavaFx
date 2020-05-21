package minutia;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class produceImageFromArray {
    public static WritableImage produceImage(int[][] array, Image image){
        int x = array.length;
        int y = array[1].length;

        WritableImage writableImage = new WritableImage(image.getPixelReader(),x,y);

        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for (int i =0; i<x; i++){
            for (int j = 0; j<y; j++){
                if(array[i][j]>1){
               pixelWriter.setColor(i,j,Color.BLUE);
                for(int a = j-4; a< j + 4; a++ ){
                        pixelWriter.setColor(i-4,a,Color.BLUE);
                        pixelWriter.setColor(i+4,a,Color.BLUE);
                    }
                    for(int a1 = i-4; a1< i + 4; a1++ ){
                        pixelWriter.setColor(a1,j-4,Color.BLUE);
                        pixelWriter.setColor(a1,j+4,Color.BLUE);
                    }
            }}
        }



//        for (int i =0; i<y; i++){
//            System.out.println();
//            for (int j = 0; j<x; j++){
//                System.out.print(array[i][j]);
//                if(array[i][j] == 0){
//                    pixelWriter.setColor(j,i, Color.BROWN);
//                }
//                else if(array[i][j] == 1){
//                    pixelWriter.setColor(i,j,Color.LAVENDER);
//                }
//                else if (array[i][j] > 1){
//                    for(int a = j-4; a< j + 4; a++ ){
//                        pixelWriter.setColor(i-4,a,Color.BLUE);
//                        pixelWriter.setColor(i+4,a,Color.BLUE);
//                    }
//                    for(int a1 = x=4; a1< i + 4; a1++ ){
//                        pixelWriter.setColor(a1,j-4,Color.BLUE);
//                        pixelWriter.setColor(a1,j+4,Color.BLUE);
//                    }
//                }
//            }
//        }
        return  writableImage;
    }
}
