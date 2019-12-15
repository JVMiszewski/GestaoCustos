
package model.BEAN;

public class MaterialProcesso {
    
    private int idMaterialProcesso;
    private Material material;
    private Processo processo;

    public MaterialProcesso() {
    }

    public MaterialProcesso(int idMaterialProcesso, Material material, Processo processo, double precoTotal) {
        this.idMaterialProcesso = idMaterialProcesso;
        this.material = material;
        this.processo = processo;
    }

    public int getIdMaterialProcesso() {
        return idMaterialProcesso;
    }

    public Material getMaterial() {
        return material;
    }

    public void setIdMaterialProcesso(int idMaterialProcesso) {
        this.idMaterialProcesso = idMaterialProcesso;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }
          
}
