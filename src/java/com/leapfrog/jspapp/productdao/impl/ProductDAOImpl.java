/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jspapp.productdao.impl;

import com.leapfrog.jspapp.entity.Product;
import com.leapfrog.jspap.productdao.ProductDAO;
import com.leapfrog.jspap.util.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductDAOImpl implements ProductDAO{
    private DBConnection db =new DBConnection();
    @Override
    public List<Product> getAll() throws ClassNotFoundException, SQLException {
       List<Product> productList= new ArrayList<>();
       //productList.add(new Product(1,"iPhone5","ios",40000 ));
       //productList.add(new Product(2,"iPhone6","ios",70000 ));
       String sql="SELECT * FROM tbl_product";
       db.open();
       db.initStatement(sql);
       ResultSet rs=db.executeQuery();
       while(rs.next()){
           Product p = new Product();
           p.setProductId(rs.getInt("productId"));
           p.setProductName(rs.getString("productName"));
           p.setProductDescription(rs.getString("productDescription"));
           p.setProductPrice(rs.getDouble("productPrice"));
           productList.add(p);
       }
       return productList;
    }

    @Override
    public int insert(Product p) throws ClassNotFoundException, SQLException {
        db.open();
        String sql= "INSERT INTO tbl_product(productName,productDescription,productPrice) VALUES(?,?,?)";
        PreparedStatement stmt= db.initStatement(sql);
        stmt.setString(1, p.getProductName());
        stmt.setString(1, p.getProductDescription());
        stmt.setDouble(3, p.getProductPrice());
        int result= db.executeUpdate();
        db.close();
        return result;
       
    }
    
}
