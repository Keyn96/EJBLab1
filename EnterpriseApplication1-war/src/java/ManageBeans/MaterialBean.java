/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import dao.*;
import domain.Material;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value = "materialBean")
@RequestScoped
public class MaterialBean implements Serializable{

    @EJB
    private MaterialDAO materialDAO;
    @EJB 
    private CheckMaterials check;
     
    public List<Material> selectMaterial()
    {
        List<Material> mat= materialDAO.selectMaterials();
        for (Material material : mat) {
            int q=material.getQuantity();
            int i=check.sumQuant(q);
            
            if (i!=q){
                material.setQuantity(i);
                materialDAO.updateMaterial(material);
            }
        }
        return mat;
    }
   
    
    
}
