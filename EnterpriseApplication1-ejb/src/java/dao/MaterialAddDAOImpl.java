/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

/**
 *
 * @author НР
 */
@ApplicationScoped
public class MaterialAddDAOImpl {
@Resource(lookup = "Wholesale")
    private DataSource dataSource;

    public int insertMaterial(Material material) {
        try (Connection connection = dataSource.getConnection()) {
            String query = ("INSERT INTO Material (name, weight, manufacturer,cost,quantity) values(?,?,?,?,?)");
            PreparedStatement stat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, material.getName());
            stat.setInt(2, material.getWeight());
            stat.setString(3, material.getManufacturer());
            stat.setInt(4, material.getCost());
            stat.setInt(5, material.getQuantity());
            stat.execute();
            ResultSet res = stat.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            } else {
                return -2;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error:insertMaterial", e);
        }
        finally{
            try {
                dataSource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialDaoImplem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
