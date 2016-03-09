/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author НР
 */
@Singleton
@LocalBean
@ApplicationScoped
public class CheckMaterials implements CheckInterface {

    private int quant;
    
@PostConstruct
private void onCreate(){
    quant=500;
}

    @Override
    public int sumQuant(int q)
{
    if(q<=quant){q+=quant*5;}
    return q;
    
}
}
