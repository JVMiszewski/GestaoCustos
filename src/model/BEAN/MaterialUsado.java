package model.BEAN;

public class MaterialUsado {
    
    private int idMaterialUsado;
    private Material material;
    private FichaTecnica fichaTecnica;
    private double preco;
    private int quantidade;

    public MaterialUsado() {
    }

    public MaterialUsado(int idMaterialUsado, Material material, FichaTecnica fichaTecnica, double preco, int quantidade) {
        this.idMaterialUsado = idMaterialUsado;
        this.material = material;
        this.fichaTecnica = fichaTecnica;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdMaterialUsado() {
        return idMaterialUsado;
    }

    public void setIdMaterialUsado(int idMaterialUsado) {
        this.idMaterialUsado = idMaterialUsado;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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
