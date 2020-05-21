package minutia;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import k3m.ArrayOfZerosAndOnes;
import k3m.Point;
import main.PrimaryController;

import java.util.ArrayList;

public class minutiaDetection {

    public static Image detect(Image image){

        int[][] array = ArrayOfZerosAndOnes.getArrayFromImage(image);
        ArrayList<Point> arrayList = new ArrayList<>();


       System.out.println(array.length);
        System.out.println(array[0].length);
        for(int i = 15; i <array.length-15; i++){
            for (int j=15; j< array[0].length-15; j++) {
                if(array[i][j] >0)
                array = lookForMinutia(i,j,array,arrayList);

            }

        }
        array = minutiaReduction.reduceMinutia(array,arrayList);
        Image fianl = produceImageFromArray.fianlImg(array,image);
        PrimaryController.fin=fianl;
        return produceImageFromArray.produceImage(array,image);
    }

    private static int[][] lookForMinutia(int i, int j, int[][] array, ArrayList<Point> list) {
        int big = 9;
        int small = 5;
        int x = i-4;
        int y = j + 4;

        int xm = i-2;
        int ym = j+2;

        int countB = 0;
        int countM = 0;

        for(int a = x; a< x + big; a++ ){
            if(array[a][y] > 0)
                countB++;
            if(array[a][y+big] > 0)
                countB++;
        }
        for(int a1 = y; a1< y + big; a1++ ){
            if(array[x][a1] > 0)
                countB++;
            if(array[x+big][a1] > 0)
                countB++;
        }

        for(int b = xm; b< xm + small; b++ ){
            if(array[b][ym] > 0)
                countM++;
            if(array[b][ym+small] > 0)
                countM++;
        }
        for(int b1 = ym; b1< ym + small; b1++ ){
            if(array[xm][b1] > 0)
                countM++;
            if(array[xm+small][b1] > 0)
                countM++;
        }
        if(countB == 3 && countM ==3){
            array[i][j] = 3;
            list.add(new Point(i,j));
           // System.out.println("[i,j] = " +"["+ i+"," + j+ "]");
        }
        return  array;
    }
}
