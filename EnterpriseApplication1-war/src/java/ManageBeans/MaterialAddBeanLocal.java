/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import domain.Material;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface MaterialAddBeanLocal {
    void insertMaterial(Material material);
}
