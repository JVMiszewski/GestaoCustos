
package model.BEAN;

public class FerramentaProcesso {
    
    private int idFerramentaProcesso;
    private Ferramenta ferramenta;
    private Processo processo;

    public FerramentaProcesso() {
    }

    public FerramentaProcesso(int idFerramentaProcesso, Ferramenta ferramenta, Processo processo) {
        this.idFerramentaProcesso = idFerramentaProcesso;
        this.ferramenta = ferramenta;
        this.processo = processo;
    }

    public int getIdFerramentaProcesso() {
        return idFerramentaProcesso;
    }

    public void setIdFerramentaProcesso(int idFerramentaProcesso) {
        this.idFerramentaProcesso = idFerramentaProcesso;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    
    
    
}
