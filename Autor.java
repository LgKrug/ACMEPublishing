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
        return livrosEscritos.add(livro);
    }

    public ArrayList<Livro> pesquisaLivros() {
        return livrosEscritos;
    }

    public String livrosToString(){
        String aux = "";
        for(int i =0; i < livrosEscritos.size(); i++){
            aux = aux + "6; " + getCodigo() + " " + getNome() + " " + livrosEscritos.get(i).getIsbn() + " " + livrosEscritos.get(i).getTitulo() + " " + livrosEscritos.get(i).getAno() + "\n";
        }
        return aux;
    }
    
    public boolean livros2Mais() {
        return (livrosEscritos.size() > 1);
    }
}



