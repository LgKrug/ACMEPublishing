import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

import javax.management.openmbean.OpenDataException;


public class ACMEPublishing {
    
    private Biblioteca biblioteca;
    private Grupo grupo;
    private Scanner entrada = null;
    private Scanner in;
    private MenuFinal menu;


    public ACMEPublishing(){
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            entrada = new Scanner(streamEntrada); 
            PrintStream streamSaida =
            new PrintStream (new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida); 
            } catch (Exception e) {
            System.out.println(e);
            }
            entrada.useLocale(Locale.ENGLISH);

        this.biblioteca = new Biblioteca();
        this.grupo = new Grupo();
        this.in = new Scanner(System.in);
        this.menu = new MenuFinal();
    }

    public void executar(){
        String isbn;
        String titulo;
        int ano;
        int codigo;
        String nome;
        int opcao;


        do{
                isbn = entrada.nextLine();

                if(isbn.equals("-1"))
                    break;
                
                titulo = entrada.nextLine();
                ano = entrada.nextInt();
                entrada.nextLine();

            cadastraLivros(isbn,titulo,ano);
        }while(isbn != "-1");

        mostraLivrosCadastrados();

        do{
            codigo = entrada.nextInt();
            entrada.nextLine();

            if(codigo == -1)
                break;
            
            nome = entrada.nextLine();
            isbn = entrada.nextLine();

        cadastraAutor(codigo,nome,isbn);
        }while(codigo != -1);

        mostraAutoresCadastrados();

        do{
            codigo = entrada.nextInt();
            entrada.nextLine();
        

            if(codigo == -1)
                break;
        
            isbn = entrada.nextLine();

        addLivroAoAutor(codigo,isbn);
        }while(codigo != -1);

        mostraLivrosDoAutor();
        mostraAutroresDoLivro();
        mostraLivroComAutores();
        mostraAutoresComLivros();
        mostraLivrosAno();

        
        do{
            menu.executar();
            opcao = in.nextInt();

            switch(opcao){
                case 1:
                    codigo = in.nextInt();
                    in.nextLine();
                    nome = in.nextLine();
                    isbn = in.nextLine();
                    cadastraAutor(codigo, nome, isbn);
                    break;
            }
        }while(opcao == 0);
    }

    public void cadastraLivros(String isbn, String titulo, int ano){
        
        Livro livro = new Livro(isbn,titulo,ano);
        if(biblioteca.cadastraLivro(livro))
            System.out.println("1;" + livro.getIsbn() + ";" + livro.getTitulo() + ";" + livro.getAno());
    }

    public void mostraLivrosCadastrados() {
        System.out.println("2; " + biblioteca.quantidadeLivros());
    }

    public void cadastraAutor(int codigo, String nome, String isbn) {
       
            Autor autor = new Autor(codigo,nome,biblioteca.pesquisaLivro(isbn));

            if(grupo.cadastraAutor(autor))
            System.out.println("3;" + autor.getCodigo() + ";" + autor.getNome() + ";" + isbn);
    }

    public void mostraAutoresCadastrados(){
        System.out.println("4; " + grupo.quantidadeAutores());
    }

    public void addLivroAoAutor(int codigo, String isnb){

        if(grupo.autorExiste(codigo) && biblioteca.livroExiste(isnb)){
            grupo.pesquisaAutor(codigo).adicionaLivro(biblioteca.pesquisaLivro(isnb));

            System.out.println("5; " + grupo.pesquisaAutor(codigo).getCodigo() + "; " + grupo.pesquisaAutor(codigo).getNome() + 
            "; " + biblioteca.pesquisaLivro(isnb).getIsbn() + "; " + biblioteca.pesquisaLivro(isnb).getTitulo() + 
            "; " + biblioteca.pesquisaLivro(isnb).getAno());
        }
    }

    public void mostraLivrosDoAutor(){
        int codigo = entrada.nextInt();
        entrada.nextLine();
        if(grupo.autorExiste(codigo)){
            System.out.println(grupo.pesquisaAutor(codigo).livrosToString());
        }
    }

    public void mostraAutroresDoLivro(){
        String isbn = entrada.nextLine();
        if(biblioteca.livroExiste(isbn)){
            System.out.println(biblioteca.pesquisaLivro(isbn).AutoresToString());
        }
    }

    public void mostraLivroComAutores(){
        System.out.println(biblioteca.livrosComAutores()); 
    }

    public void mostraAutoresComLivros(){
        System.out.println(grupo.AutoresComLivros());
    }

    public void mostraLivrosAno() {
        int ano = entrada.nextInt();
        entrada.nextLine();
        System.out.println(biblioteca.livrosNoAno(ano));
       
    }

    
}