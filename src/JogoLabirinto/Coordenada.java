package JogoLabirinto;
//@author Marcus Machine
public class Coordenada {
    
    public int linha;
    public int coluna;
    
    public Coordenada (int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }
    public int getColuna() {
        return coluna;
    }
}
