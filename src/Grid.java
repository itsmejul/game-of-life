public class Grid {
    boolean[][] fields;

    Grid(int fieldSize){
        fields = new boolean[fieldSize][fieldSize];
    }

    void setField(boolean newValue, int x, int y){
        fields[y][x] = newValue;
    }
    
    boolean getField(int x, int y){
        return fields[y][x];
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
