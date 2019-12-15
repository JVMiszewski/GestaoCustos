
package model.BEAN;

public class ProcessoUsado {
    
    private int idProcessoUsado;
    private Processo processo;
    private FichaTecnica fichaTecnica;
    private double preco;
    private int quantidade;

    public ProcessoUsado() {
    }

    public ProcessoUsado(int idProcessoUsado, Processo processo, FichaTecnica fichaTecnica, double preco, int quantidade) {
        this.idProcessoUsado = idProcessoUsado;
        this.processo = processo;
        this.fichaTecnica = fichaTecnica;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public int getIdProcessoUsado() {
        return idProcessoUsado;
    }

    public void setIdProcessoUsado(int idProcessoUsado) {
        this.idProcessoUsado = idProcessoUsado;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
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
    
}
