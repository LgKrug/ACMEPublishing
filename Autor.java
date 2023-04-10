import java.rmi.server.RemoteStub;
import java.util.ArrayList;

public class Autor {
    
    private int codigo;
    private String nome;
    private ArrayList<Livro> livrosEscritos;

    public Autor(int codigo, String nome, Livro livro) {
        this.codigo = codigo;
        this.nome = nome;
        this.livrosEscritos = new ArrayList<Livro>();
        livrosEscritos.add(livro);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Livro> getLivros() {
        return livrosEscritos;
    }
    public boolean livroJaEscrito(String isnb) {
        for( int i = 0; i <livrosEscritos.size(); i++){
            if(livrosEscritos.get(i).getIsbn().equals(isnb)){
                return true;
            }
        }
        return false;
    }

    public String getIsbnLivrosEscritos() {
        String aux = "";
        for( int i=0; i<livrosEscritos.size(); i++){
            aux = aux  + livrosEscritos.get(i).getIsbn() + "; ";
        }

        return aux;
    }

    public  boolean adicionaLivro(Livro livro) {
        if (livrosEscritos.contains(livro)) 
            return false;
        else
            return livrosEscritos.add(livro);
    }

    public ArrayList<Livro> pesquisaLivros() {
        return livrosEscritos;
    }

    public String livroToString(int i){
        return getCodigo() + " " + getNome() + " " + livrosEscritos.get(i).getIsbn() + " " + livrosEscritos.get(i).getTitulo() + " " + livrosEscritos.get(i).getAno();
    }
    
    public boolean livros2Mais() {
        return (livrosEscritos.size() > 1);
    }
}



