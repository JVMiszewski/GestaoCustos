
package model.BEAN;

public class Unidade {
    
    private String nome;
    private String descricao;
    private int id;

    public Unidade() {
    }

    public Unidade(String nome, String descricao, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
        
}
