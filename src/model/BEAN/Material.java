
package model.BEAN;

public class Material {
    
    private int idMaterial;
    private String nomeM;
    private String descricaoM;
    private Unidade un;
    private double precoM;
    private Categoria categoria;

    public Material() {
    }

    public Material(int idMaterial, String nomeM, String descricaoM, Unidade un, double precoM, Categoria categoria) {
        this.idMaterial = idMaterial;
        this.nomeM = nomeM;
        this.descricaoM = descricaoM;
        this.un = un;
        this.precoM = precoM;
        this.categoria = categoria;
    }

    

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomeM() {
        return nomeM;
    }

    public void setNomeM(String nomeM) {
        this.nomeM = nomeM;
    }

    public String getDescricaoM() {
        return descricaoM;
    }

    public void setDescricaoM(String descricaoM) {
        this.descricaoM = descricaoM;
    }

    public Unidade getUn() {
        return un;
    }

    public void setUn(Unidade un) {
        this.un = un;
    }

    public double getPrecoM() {
        return precoM;
    }

    public void setPrecoM(double precoM) {
        this.precoM = precoM;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return getNomeM();
    }
    
}
