package JogoLabirinto;
//@author Marcus Machine

public class Labirinto {
    private int[][] labirinto;
    
// construtor ja cria um laberinto
    public Labirinto(int num){
        if (num == 1){ criarLabirinto3x5(); }
        if (num == 2){ criarLabirinto5x5(); }
    }
    
    //labirinto de codigo 1
    public boolean criarLabirinto3x5 (){
        labirinto = new int[][]{
            {1,1,1,1,1},
            {2,0,0,0,3},
            {1,1,1,1,1}
        };
        return true;
    }
    
    //labirinto de codigo 2
    public boolean criarLabirinto5x5 (){
        labirinto = new int[][]{
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,0,1,0,1},
            {1,2,1,3,1}
        };
        return true;
    }

    
    public int[][] getLabirinto() {
        return labirinto;
    }
    
}
