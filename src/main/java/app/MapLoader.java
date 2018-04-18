package app;

import app.model.Coord2D;
import app.model.Scenery;

public class MapLoader {

    public static Scenery textToMap(StringBuffer stringBuffer, int maxWidth, int maxHeight) {

        Scenery scenery = new Scenery();
        scenery.map = new char[maxWidth][maxHeight];

        int currentRow =0;
        int currentColumn =0;
        for(int strPosition=0; strPosition< stringBuffer.length(); strPosition++) {
            switch (stringBuffer.charAt(strPosition)) {
                case '\n':
                    currentRow++;
                    currentColumn =-1;
                    break;
                case 'X':
                    scenery.map[currentColumn][currentRow] = stringBuffer.charAt(strPosition);
                    break;
                case 'S':
                    scenery.startPosition = new Coord2D(currentColumn, currentRow);
                    scenery.map[currentColumn][currentRow] = stringBuffer.charAt(strPosition);
                    break;
                case 'E':
                    scenery.endPosition = new Coord2D(currentColumn, currentRow);
                    scenery.map[currentColumn][currentRow] = stringBuffer.charAt(strPosition);
                    break;
                default:
                    scenery.map[currentColumn][currentRow] = ' ';
                    break;
            }
            currentColumn++;
        }

        return scenery;
    }

}
