/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.ProductItem;
import java.lang.Object;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author yousef abdou
 */
public class AddProductViewModel{

    //takes parameters of product from AddProductScreen and validates and adds to database
    //made it take parameters of object not object so the view(AddProductScreen)  gets no logic only takes info and shows info
    //made static to be called directly in AddProductScreen without making instance of it
    public AddProductViewModel() throws SQLException{
    String jdbcUrl = "jdbc:sqlite:products.db";
    Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl);
            System.out.println( "connection made");
        } catch (SQLException ex) {
           // Logger.getLogger(AddProductViewModel.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
           System.out.println( "connection failed");
        }
    
    String sqlCommand1 = "create table products(id varchar(20),name varchar(20)";
    @SuppressWarnings("null")
    Statement statement = connection.createStatement();
    statement.executeUpdate(sqlCommand1);
    System.out.println( "table created");
    
    String sqlCommand2 = "insert into products('2020','apple') ";
    statement.executeUpdate(sqlCommand2);
     
    String sqlCommand3 = "select * from products";
    ResultSet  result = statement.executeQuery(sqlCommand3);
    while(result.next()){
    String i= result.getString("id");
    String n= result.getString("name");
    //double p= result.getDouble("price");
    
        System.out.println( "id : " + i + "name  :" + n);
    }
    connection.close();
    
        
            
    }
    
    
             private static void AddToDatabase(ProductItem Product) {
        //add to database code
        
        
        
    }
             
//    private static boolean isRepeated(String s){
//        if(null)
//            return true;
//        else 
//            return false;
//    }
    
    public static boolean ValidateThenAddProduct(String id, String name,String price){
        if(isIdValid(id) && isNameValid(name) && IsPriceValid(price)){
            ProductItem Product = new ProductItem(id,name,Float.parseFloat(price));
            AddToDatabase(Product);
            return true;
        }
        else 
            return false;
        
       
    }
    

    //checks if id is valid ; has to be only numbers and not repeated in database
    // example valid id : 1234
    private static boolean isIdValid(String id) {
        if(StringUtils.isNumeric(id)){
        
            //check if repeated in database 
        
                return true;
        }
        else 
            return false;
    }

    //checks if name is valid; has to be only letters and not repeated in database
    // example of valid name : lemon
    private static boolean isNameValid(String name){
        if(StringUtils.isAlpha(name)){
         //check if repeated in database 
        
                return true;
        }
        return false;
        
    }
     
     

    private static boolean IsPriceValid(String price){
      try{
        if(Float.parseFloat(price)>0)
            return true;
    }
     catch(Exception e){
    return false;
            }
        return false;
}

    public static void main(String[] args) {
        try {
            AddProductViewModel a = new AddProductViewModel();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}
