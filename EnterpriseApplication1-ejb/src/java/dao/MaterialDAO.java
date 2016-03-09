/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Material;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author НР
 */
@Remote
public interface MaterialDAO {
    List<Material> selectMaterials();
   // Material selectMaterial(int id_material);
    //int insertMaterial(Material material);
    boolean updateMaterial(Material material);
   // boolean deleteMaterial(Material material);
}
