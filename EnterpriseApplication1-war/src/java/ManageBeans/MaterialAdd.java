/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import domain.Material;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author НР
 */
@Named(value = "materialAdd")
@RequestScoped
public class MaterialAdd {
@Inject
    private MaterialAddBeanLocal materialAdd;
    /**
     * Creates a new instance of MaterialAdd
     */
    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    public MaterialAdd() 
    {
        material = new Material();
        
    }
    
    public String insertMaterial()
    {
        this.materialAdd.insertMaterial(material);
        return "/index.xhtml";
    }
    
    
}
