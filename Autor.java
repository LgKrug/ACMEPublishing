import java.util.ArrayList;

public class Autor {
    
    private int codigo;
    private String nome;
    private ArrayList<Livro> livrosEscritos;

    public Autor(int codigo, String nome, Livro livro) {
        this.codigo = codigo;
        this.nome = nome;
        this.livrosEscritos = new ArrayList<Livro>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public  boolean adicionaLivro(Livro livro) {
        if (livrosEscritos.contains(livro)) 
            return false;
        return livrosEscritos.add(livro);
    }

    public ArrayList<Livro> pesquisaLivros() {
        return livrosEscritos;
    }
}



