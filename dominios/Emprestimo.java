package dominios;

public class Emprestimo {
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(String dataDevolucao) {
        this.dataEmprestimo = new java.util.Date().toString();
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void realizarEmprestimo(Livro livro, Usuario usuario) {
        if (livro.getEmprestado()) {
            System.out.println("Livro já emprestado");
        } else {
            livro.setEmprestado(true);
            System.out.println("Livro emprestado com sucesso");
        }
    }

}
