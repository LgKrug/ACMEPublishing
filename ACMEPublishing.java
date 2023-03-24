import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEPublishing {
    
    private Scanner entrada;
    private Biblioteca biblioteca;
    private Grupo grupo;


    public ACMEPublishing(){
        this.entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        this.biblioteca = new Biblioteca();
        this.grupo = new Grupo();
    }

    public void executar(){
        int entradaTeste = 0;

        while(entradaTeste == 0){
            cadastraLivros();
            mostraLivrosCadastrados();
            cadastraAutor();
        }
        
    }

    public void cadastraLivros(){
        String isbn;
        String titulo;
        int ano;
        do{
            isbn = entrada.nextLine();
            titulo = entrada.nextLine();
            ano = entrada.nextInt();
            entrada.nextLine();

            if(isbn.equals(null) || titulo.equals(null) || ano <= 0)
                System.out.println("Erro na entrada de dados do livro");
        }while(isbn.equals(null) || titulo.equals(null) || ano <= 0);

        Livro livro = new Livro(isbn,titulo,ano);
        if(biblioteca.cadastraLivro(livro))
            System.out.println("1;" + livro.getIsbn() + ";" + livro.getTitulo() + ";" + livro.getAno());
        else
            System.out.println("Erro ao cadastrar o livro");
    }

    public void mostraLivrosCadastrados() {
        System.out.println("2; " + biblioteca.quantidadeLivros());
    }

    public void cadastraAutor() {
        int codigo = entrada.nextInt();
        entrada.nextLine();
        String nome = entrada.nextLine();
        String isbn = entrada.nextLine();

        if(biblioteca.pesquisaLivro(isbn) == null)
            System.out.println("Livro não encontrado");
        else{
            Autor autor = new Autor(codigo,nome,biblioteca.pesquisaLivro(isbn));

            if(grupo.cadastraAutor(autor))
            System.out.println("3;" + autor.getCodigo() + ";" + autor.getNome() + ";" + isbn);
            else
            System.out.println("Erro ao cadastrar o autor");
        }
        


    }
}
