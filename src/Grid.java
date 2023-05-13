import java.util.Random;

public class Grid {
    boolean[][] fields;
    Random rand = new Random();
    
    Grid(int fieldSize){
        fields = new boolean[fieldSize][fieldSize];
    }

    void setField(boolean newValue, int x, int y){
        fields[y][x] = newValue;
    }
    
    boolean getField(int x, int y){
        return fields[y][x];
    }

    void initializeGridRandom(int startPercentage){
        for(boolean[] line : fields){
            for(boolean field : line){
                int randomInt = rand.nextInt(100);
                if(randomInt < startPercentage){
                    field = true;
                } else {
                    field = false;
                }
            }
        }
    }

    void printGrid(){
        String s = "";
        for(boolean[] line : fields){
            for(boolean field : line){
                if(field){
                    s += "x";
                } else {
                    s += "o";
                }
            }
            s+="\n";
        }
        System.out.println(s);
    }
}
