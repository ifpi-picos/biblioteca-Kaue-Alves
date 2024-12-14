import dominios.Emprestimo;
import dominios.Livro;
import dominios.Usuario;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("hello world!!");
        Livro listaDeLivros[] = new Livro[100];

        int contadorDeLivros = 0;

        // Livro livro = new Livro("Antoine de Saint-Exupéry", "O Pequeno Príncipe",
        // "Gallimard", 1943);

        Usuario pessoa = new Usuario("Alexa", "09789213432", "teste@gmail.com");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1 - Cadastrar Livro\n2 - Listar todos os livros\n3 - Listar livros emprestados e disponiveis\n4 - Listar histórico de emprestimos do usuario\n5 - Pegar livro emprestado\n6 - Devolver livro\n7 - Sair\n");
            String op = scanner.nextLine();

            switch (op) {
                case "1":
                    System.out.println("Digite o titulo do livro");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro");
                    String autor = scanner.nextLine();
                    System.out.println("Digite a editora do livro");
                    String editora = scanner.nextLine();
                    System.out.println("Digite o ano do livro");
                    int ano = scanner.nextInt();
                    Livro livro = new Livro(titulo, autor, editora, ano);

                    listaDeLivros[contadorDeLivros] = livro;
                    contadorDeLivros++;

                    for (int i = 0; i < contadorDeLivros; i++) {
                        System.out.println(listaDeLivros[i]);
                    }
                    break;

                case "2":

                    for (int i = 0; i < contadorDeLivros; i++) {
                        System.out.println("Titulo: " + listaDeLivros[i].getTitulo() + " Autor: "
                                + listaDeLivros[i].getAutor() + " Editora: " + listaDeLivros[i].getEditora() + " Ano: "
                                + listaDeLivros[i].getAno());
                    }

                    break;

                case "3":
                    System.out.println("Livros emprestados: \n\n");

                    for (int i = 0; i < contadorDeLivros; i++) {
                        if (listaDeLivros[i].getEmprestado() == true) {
                            System.out.println("Titulo: " + listaDeLivros[i].getTitulo() + " Autor: "
                                    + listaDeLivros[i].getAutor() + " Editora: " + listaDeLivros[i].getEditora()
                                    + " Ano: "
                                    + listaDeLivros[i].getAno());
                        }
                    }

                    System.out.println("Livros disponíveis: \n\n");
                    for (int i = 0; i < contadorDeLivros; i++) {
                        if (listaDeLivros[i].getEmprestado() == false) {
                            System.out.println("Titulo: " + listaDeLivros[i].getTitulo() + " Autor: "
                                    + listaDeLivros[i].getAutor() + " Editora: " + listaDeLivros[i].getEditora()
                                    + " Ano: "
                                    + listaDeLivros[i].getAno());
                        }
                    }

                    break;

                case "4":
                    System.out.println("Mostrando emprestimos");
                    for (Emprestimo emp : pessoa.getHistoricoEmprestimos()) {
                        System.out.println("Data emprestimo: " + emp.getDataEmprestimo() + " Data devolução: "
                                + emp.getDataDevolucao());
                    }
                    break;

                case "5":
                    System.out.println("Digite o titulo do livro que deseja pegar emprestado");
                    String tituloLivro = scanner.nextLine();
                    System.out.println("Digite a data de devolução (dd/mm/aaaa)");
                    String dataDevolucao = scanner.nextLine();

                    for (int i = 0; i < contadorDeLivros; i++) {
                        if (listaDeLivros[i].getTitulo().equals(tituloLivro)
                                && listaDeLivros[i].getEmprestado() == false) {
                            Livro livroAchado = listaDeLivros[i];
                            livroAchado.setEmprestado(true);
                            Emprestimo emprestimo = new Emprestimo(dataDevolucao);
                            emprestimo.realizarEmprestimo(livroAchado, pessoa);
                            pessoa.adicionarEmprestimo(emprestimo);
                        }
                    }
                    break;

                case "6":
                    System.out.println("Digite o titulo do livro que deseja devolver");
                    String tituloLivroParaDevolver = scanner.nextLine();

                    for (int i = 0; i < contadorDeLivros; i++) {
                        if (listaDeLivros[i].getTitulo().equals(tituloLivroParaDevolver)
                                && listaDeLivros[i].getEmprestado() == true) {
                            Livro livroAchado = listaDeLivros[i];
                            livroAchado.setEmprestado(false);
                        }
                    }
                    break;
                case "7":
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}