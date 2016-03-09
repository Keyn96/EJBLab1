/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import dao.MaterialAddDAOImpl;
import domain.Material;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Stateful
@ConversationScoped
public class MaterialAddBean implements MaterialAddBeanLocal,Serializable{
    
    private MaterialAddDAOImpl materialAddDAO;
    /**
     * Creates a new instance of MaterialAddBean
     */
    
    public MaterialAddBean() 
    { 
    }
    
    @Inject Conversation conversation;
    
    @Override
    public void insertMaterial(Material material)
    {
        int i=0;
        conversation.begin();
        int a=materialAddDAO.insertMaterial(material);
        if(a!=-2 || i==3){ 
        conversation.end();
        }
        else{ i++; insertMaterial(material);}
    } 
    
}
