
package model.BEAN;

public class Ferramenta {
    
    private int idFerramenta;
    private String nome;
    private String descricao; 

    public Ferramenta() {
    }

    public Ferramenta(int idCategoria, String nome, String descricao) {
        this.idFerramenta = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(int idCategoria) {
        this.idFerramenta = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
}
