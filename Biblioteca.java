import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> listaLivro;
    private ArrayList<Livro> listaLivroAno;

    public Biblioteca(){
        this.listaLivro = new ArrayList<Livro>();
    }

    public ArrayList<Livro> getListaLivro(){
        return listaLivro;
    }

    public  boolean cadastraLivro(Livro livro) {
        for(int i = 0; i < listaLivro.size(); i++){
            if(listaLivro.get(i).getIsbn().equals(livro.getIsbn()) ){
                return false;
            }
        }
        
        listaLivro.add(livro);
        return true;
    }

    public Livro pesquisaLivro(String isbn){
        for(Livro livro : listaLivro){
            if(livro.getIsbn().equals(isbn))
                return livro;
        }
        return null;
    }

    public ArrayList<Livro> pesquisaLivro(int ano) {
        listaLivroAno = new ArrayList<Livro>();
        int cont = 0; 

        for(int i = 0; i < listaLivro.size(); i++){
            if(listaLivro.get(i).getAno() == ano){
                listaLivroAno.add(listaLivro.get(i));
                cont++;
            } 
        }

        if(cont == 0) return null;
        return listaLivroAno;
    }

    public int quantidadeLivros() {
        return listaLivro.size();
    }

    public boolean livroExiste(String isbn) {
        if(listaLivro.contains(pesquisaLivro(isbn)))
            return true;
        return false;
    }

    public String livrosComAutores(int i){
        return listaLivro.get(i).getTitulo();
    }

    public String livrosNoAno(int ano) {
        String aux = "";
        for(int i=0; i<pesquisaLivro(ano).size(); i++) {
            aux = aux + "10; " + pesquisaLivro(ano).get(i).getIsbn() + "; " + pesquisaLivro(ano).get(i).getAno() + "; " + pesquisaLivro(ano).get(i).getAno() + "\n";
    }
    return aux;
    }
}
