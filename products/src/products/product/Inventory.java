package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    Statement stmt;
    ResultSet rs;
    String qry=null;
    dbconnection db=new dbconnection();
    Connection con;
    private static final int MAX_PRODUCTS = 10;  // Set product limit
    private int idCounter = 1; // Counter for generating unique productIds

public void add(Product p) {
	

//        p.setProductId(idCounter++); // Assign unique productId
//        products.add(p);
       boolean sts=false;
       int count;
       try {
    	   Connection con=db.dbconnection();
    	   stmt=con.createStatement();
    	   qry = String.format("INSERT INTO coffee (productId, prodName, prodType, price) VALUES (%d, '%s', '%s', %d)",
                   p.getProductId(), p.getProdName(), p.getProdType(), p.getPrice());
    	   count=stmt.executeUpdate(qry);
    	   System.out.println("Inserted sucessfully");
       }
       catch(Exception ex) {
    	   System.out.println(ex.getMessage());
       }
       
}
    

  public void display() {
	  try {
		  con=db.dbconnection();
		  stmt=con.createStatement();
		  rs=stmt.executeQuery("select * from coffee");
		  while(rs.next())
			  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" ");
		  
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
  }
//        if (products.isEmpty()) {
//            System.out.println("No products available.");
//            return;
//        }
//        for (Product p : products) {
//            System.out.println(p);
//        }

    public void search(String name) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getProdName().equalsIgnoreCase(name)) {
                System.out.println("Item Found");
                System.out.println(p);
                return;
            }
        }
        throw new ProductNotFoundException("Product with name '" + name + "' not found.");
    }

//    
    public void remove(String name) throws ProductNotFoundException {
        try {
            Connection con = db.dbconnection(); // Ensure you have your database connection
            String qry = "DELETE FROM coffee WHERE prodName = ?";
            PreparedStatement pstmt = con.prepareStatement(qry);
            pstmt.setString(1, name);
            
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("Item Removed");
            } else {
                throw new ProductNotFoundException("Product with name '" + name + "' not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing product: " + e.getMessage());
        }
    }


    void sort3() {
        Collections.sort(products, new psort());
    }

    void sort2() {
        Collections.sort(products, new nsort());
    }

    public void update(String name) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getProdName().equalsIgnoreCase(name)) {
                System.out.println("1. Update Product Name");
                System.out.println("2. Update Product Type");
                System.out.println("3. Update Product Price");
                int op = scanner.nextInt();
                scanner.nextLine(); 

                try (Connection con = db.dbconnection();
                     Statement stmt = con.createStatement()) {
                    
                    switch (op) {
                        case 1:
                            System.out.println("Enter New Product Name:");
                            String newName = scanner.nextLine();
                            p.setProdName(newName);
                            String updateNameQry = String.format("UPDATE coffee SET prodName = '%s' WHERE productId = %d", newName, p.getProductId());
                            stmt.executeUpdate(updateNameQry);
                            break;

                        case 2:
                            System.out.println("Enter New Product Type:");
                            String newType = scanner.nextLine();
                            p.setProdType(newType);
                            String updateTypeQry = String.format("UPDATE coffee SET prodType = '%s' WHERE productId = %d", newType, p.getProductId());
                            stmt.executeUpdate(updateTypeQry);
                            break;

                        case 3:
                            System.out.println("Enter New Product Price:");
                            int newPrice = scanner.nextInt();
                            p.setPrice(newPrice);
                            String updatePriceQry = String.format("UPDATE coffee SET price = %d WHERE productId = %d", newPrice, p.getProductId());
                            stmt.executeUpdate(updatePriceQry);
                            break;

                        default:
                            System.out.println("Invalid option");
                            break;
                    }

                    System.out.println("Product Updated Successfully");
                    return;
                } catch (Exception ex) {
                    System.out.println("Error during update: " + ex.getMessage());
                }
            }
        }
        throw new ProductNotFoundException("Product with name '" + name + "' not found.");
    }

public void loadProductsFromDatabase() {
    try (Connection con = db.dbconnection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM coffee")) {
         
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String prodName = rs.getString("prodName");
            String prodType = rs.getString("prodType");
            int price = rs.getInt("price");

            Product product = new Product(productId, prodName, prodType, price);
            products.add(product);
        }
    } catch (Exception e) {
        System.out.println("Error loading products: " + e.getMessage());
    }
}
}