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
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author yousef abdou
 */
public class AddProductViewModel {

    //takes parameters of product from AddProductScreen and validates and adds to database
    //made it take parameters of object not object so the view(AddProductScreen)  gets no logic only takes info and shows info
    //made static to be called directly in AddProductScreen without making instance of it
    public static boolean ValidateThenAddProduct(String id, String name,String price){
        if(isIdValid(id) && isNameValid(name) && IsPriceValid(price)){
            ProductItem Product = new ProductItem(id,name,Float.parseFloat(price));
            AddToDatabase(Product);
            return true;
        }
        else 
            return false;
        
       
    }
    
    private static void AddToDatabase(ProductItem Product) {
       
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
       if(Float.parseFloat(price)>0)
            return true;
       else 
           return false;
    }

    
}
