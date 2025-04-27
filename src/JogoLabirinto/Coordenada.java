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
    
    // aqui usamos um metodo que carrega 3 informaç?e: a linha, a coluna e a matrix
// a ser verificada
    public boolean testeAcessoLab (int linha, int coluna, int[][]matrix){
        if ( matrix[linha][coluna] == 1){ System.out.println("Parede"); 
        } else if (matrix[1][0] == 2){ System.out.println("entrada");
        } else {System.out.println("sei la"); }
        return true;
    }
    
    public boolean passoFrente (int linha, int coluna, int[][]matrix, Cobra cb){
        if ( matrix[linha][coluna+1] == 1){ 
            System.out.println("Parede"); 
            return false;
        } else if ( matrix[linha][coluna+1] == 0){
            System.out.println("Rua"); 
            cb.Passo(new Coordenada (linha, coluna+1));
            Coordenada coord = cb.Topo();
            System.out.println(coord);
        }
        return true;
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
