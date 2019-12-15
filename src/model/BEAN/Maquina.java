
package model.BEAN;

import java.sql.Array;

public class Maquina {
    
    private int idMaquina;
    private String nome;
    private String descricao;

    public Maquina() {
    }

    public Maquina(int idCategoria, String nome, String descricao) {
        this.idMaquina = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idCategoria) {
        this.idMaquina = idCategoria;
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
