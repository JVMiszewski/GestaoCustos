
package model.BEAN;

public class MaquinaProcesso {
    
    private int idMaquinaProcesso;
    private Maquina maquina;
    private Processo processo;

    public MaquinaProcesso() {
    }

    public MaquinaProcesso(int idMaquinaProcesso, Maquina maquina, Processo processo) {
        this.idMaquinaProcesso = idMaquinaProcesso;
        this.maquina = maquina;
        this.processo = processo;
    }

    public int getIdMaquinaProcesso() {
        return idMaquinaProcesso;
    }

    public void setIdMaquinaProcesso(int idMaquinaProcesso) {
        this.idMaquinaProcesso = idMaquinaProcesso;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
    
    
    
}
