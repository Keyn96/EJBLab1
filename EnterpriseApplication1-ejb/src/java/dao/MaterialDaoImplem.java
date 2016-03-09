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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author НР
 */
@Stateless
@Remote(MaterialDAO.class)
public class MaterialDaoImplem implements MaterialDAO {
    @Resource(lookup = "Wholesale")
    private DataSource dataSource;

    @Override
    public List<Material> selectMaterials() {

        try (Connection connection = dataSource.getConnection()) {
            String query = ("SELECT * FROM material ");
            PreparedStatement stat = connection.prepareStatement(query);
            ResultSet res = stat.executeQuery();
            List<Material> materials = new ArrayList<>();
            while (res.next()) {
                Material material = new Material();
                material.setId_material(res.getInt(1));
                material.setName(res.getString(2));
                material.setWeight(res.getInt(3));
                material.setManufacturer(res.getString(4));
                material.setCost(res.getInt(5));
                material.setQuantity(res.getInt(6));
                materials.add(material);
            }
            return materials;
        } catch (Exception e) {
            throw new RuntimeException("Error:selectMaterials", e);
        }
        

    }
/*
    @Override
    public Material selectMaterial(int id_material) {
        try (Connection connection = dataSource.getConnection()) {
            String query = ("select * from material m WHERE m.id_material=?");
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id_material);
            ResultSet res = stat.executeQuery();
            if (res.next()) {
                Material material = new Material();
                material.setId_material(res.getInt(1));
                material.setName(res.getString(2));
                material.setWeight(res.getInt(3));
                material.setManufacturer(res.getString(4));
                material.setCost(res.getInt(5));
                material.setQuantity(res.getInt(6));
                return material;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error:selectMaterial", e);
        }
        finally{
            try {
                dataSource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialDaoImplem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
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
                throw new RuntimeException("Не удалось добавить материал в базу");
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
*/
    @Override
    public boolean updateMaterial(Material material) {
        try (Connection connection = dataSource.getConnection()) {
            String query = ("update Material m "
                    + "set m.name=?, m.weight=?, m.manufacturer=?,m.cost=?,m.quantity=? WHERE m.id_material=?");
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setString(1, material.getName());
            stat.setInt(2, material.getWeight());
            stat.setString(3, material.getManufacturer());
            stat.setInt(4, material.getCost());
            stat.setInt(5, material.getQuantity());
            stat.setInt(6, material.getId_material());
            stat.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error:updateMaterial", e);
        }
        finally{
            try {
                dataSource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialDaoImplem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/*
    @Override
    public boolean deleteMaterial(Material material) {
        try (Connection connection = dataSource.getConnection()) {
            String query = ("delete from material where id_material=?");
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, material.getId_material());
            stat.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error:deleteMaterial", e);
        }
        finally{
            try {
                dataSource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(MaterialDaoImplem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
}
