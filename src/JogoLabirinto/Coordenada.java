package JogoLabirinto;
//@author Marcus Machine
public class Coordenada {
    
    public int linha;
    public int coluna;
    public int valor;
    
    public Coordenada (){}
    
    public Coordenada (int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public Coordenada (int linha, int coluna, int valor){
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }
    
    public int getLinha() {
        return linha;
    }
    public int getColuna() {
        return coluna;
    }
    public int getValor() {
        return valor;
    }
    
    @Override
    public String toString(){
        return "(" + linha + ", " + coluna + ")";
    }
    
    
}
