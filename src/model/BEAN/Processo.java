
package model.BEAN;

public class Processo {

    
    private int idProcesso;
    private String nomeP;
    private String descricaoP;
    private double precoP;
    private Categoria categoria;

    public Processo() {
    }

    public Processo(int idProcesso, String nomeP, String descricaoP, double precoP, Categoria categoria) {
        this.idProcesso = idProcesso;
        this.nomeP = nomeP;
        this.descricaoP = descricaoP;
        this.precoP = precoP;
        this.categoria = categoria;
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public String getDescricaoP() {
        return descricaoP;
    }

    public void setDescricaoP(String descricaoP) {
        this.descricaoP = descricaoP;
    }

    public double getPrecoP() {
        return precoP;
    }

    public void setPrecoP(double precoP) {
        this.precoP = precoP;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
}
