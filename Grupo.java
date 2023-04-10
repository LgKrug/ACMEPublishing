import java.util.ArrayList;

public class Grupo {
    private ArrayList<Autor> listaAutor;

    public Grupo(){
        this.listaAutor = new ArrayList<Autor>();
    }

    public ArrayList<Autor> getListaAutor(){
        return listaAutor;
    }

    public  boolean cadastraAutor(Autor autor){ 
        for(int i = 0; i < listaAutor.size(); i++){
            if(listaAutor.get(i).getCodigo() == autor.getCodigo()){
                return false;
            }
        }
        
        return listaAutor.add(autor);
    }

    public Autor pesquisaAutor(int codigo){
        for(Autor autor : listaAutor){
            if(autor.getCodigo() == codigo)
                return autor;
        }
        return null;
    }

    public int quantidadeAutores() {
        return listaAutor.size();
    }

    public boolean autorExiste(int codigo) {
        if(listaAutor.contains(pesquisaAutor(codigo)))
            return true;
        return false;
    }

    public String AutoresComLivros(int i){
    return listaAutor.get(i).getNome() + listaAutor.get(i).getIsbnLivrosEscritos();
    }
}
