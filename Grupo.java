import java.util.ArrayList;

public class Grupo {
    private ArrayList<Autor> listaAutor;

    public Grupo(){
        this.listaAutor = new ArrayList<Autor>();
    }

    public  boolean cadastraAutor(Autor autor){ 
        for(int i = 0; i < listaAutor.size(); i++){
            if(listaAutor.get(i).getCodigo() == autor.getCodigo()){
                return false;
            }
        }
        
        listaAutor.add(autor);
        return true;
    }

    public Autor pesquisaAutor(int codigo){
        for(Autor autor : listaAutor){
            if(autor.getCodigo() == codigo)
                return autor;
        }
        return null;
    }
}
