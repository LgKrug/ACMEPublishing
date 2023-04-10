import java.util.ArrayList;

public class Livro {
    
    private String isbn;
    private String titulo;
    private int ano;
    private ArrayList<Autor> autores;

    public Livro(String isbn, String titulo, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        autores = new ArrayList<Autor>();
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getAno() {
        return ano;
    }

    public ArrayList<Autor> getAutorList() {
        return autores;
    }

    public boolean adicionaAutor(Autor autor){
        if(autores.contains(autor)) 
            return false;
        else{
            autores.add(autor);
            return true;
        }
    }

    public String AutoresToString(int i ){
    return  autores.get(i).getNome();
    }

    public boolean Autores2Mais() {
        return (autores.size() > 1);
    }

}
