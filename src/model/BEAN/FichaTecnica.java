
package model.BEAN;

public class FichaTecnica {
    
    private int idFichaTecnica;
    private ProcessoUsado processoUsado;
    private MaterialUsado materialUsado;
    private double preco;
    private double custo;
    private Categoria categoria;
    private int quantidade;
    private String nome;

    public FichaTecnica() {
    }

    public FichaTecnica(int idFichaTecnica, ProcessoUsado processoUsado, MaterialUsado materialUsado, double preco, double custo, Categoria categoria, int quantidade, String nome) {
        this.idFichaTecnica = idFichaTecnica;
        this.processoUsado = processoUsado;
        this.materialUsado = materialUsado;
        this.preco = preco;
        this.custo = custo;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.nome = nome;
    }
 
    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getIdFichaTecnica() {
        return idFichaTecnica;
    }

    public void setIdFichaTecnica(int idFichaTecnica) {
        this.idFichaTecnica = idFichaTecnica;
    }

    public ProcessoUsado getProcessoUsado() {
        return processoUsado;
    }

    public void setProcessoUsado(ProcessoUsado processoUsado) {
        this.processoUsado = processoUsado;
    }

    public MaterialUsado getMaterialUsado() {
        return materialUsado;
    }

    public void setMaterialUsado(MaterialUsado materialUsado) {
        this.materialUsado = materialUsado;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return getNome();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
