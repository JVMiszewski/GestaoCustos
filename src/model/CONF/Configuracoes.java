
package model.CONF;

public class Configuracoes {
    
    private int id;
    private String pesquisa;
    private int casas;

    public Configuracoes() {
    }

    public Configuracoes(int id, String pesquisa, int casas) {
        this.id = id;
        this.pesquisa = pesquisa;
        this.casas = casas;
    }

    public int getId() {
        return id;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }  
    
}
