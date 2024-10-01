package products;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws ProductLimitExceededException {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
//        Product product = new Product();
//        inventory.display();
//    }
//}
        String option;
        String adminName = "subiksha";
        String pass = "12345";
        String exit;

        do {
            System.out.println("Welcome to CaffineCafe");
            System.out.println("Enter Credentials\n1. Username\n2. Password");
            String username = scanner.nextLine();
            String password = scanner.nextLine();

            if (adminName.equals(username) && pass.equals(password)) {
                do {
                    System.out.println("1. Add 2. Display 3. Search 4. Remove 5. Update  6. Exit");
                    option = scanner.nextLine();

                    switch (option) {
                        case "1":
//                            System.out.println("Enter Product Name:");
//                            String name = scanner.nextLine();
//                            System.out.println("Enter Product Type:");
//                            String type = scanner.nextLine();
//                            System.out.println("Enter Price:");
//                            int price = scanner.nextInt();
//                            scanner.nextLine(); // Consume newline
//                           break;
//                        	System.out.println("Enter Product Name,Type,Price,Id:");
//                        	product.setProdName(scanner.next());
//                        	product.setProdType(scanner.next());
//                        	product.setPrice(scanner.nextInt()); 
//                        	product.setProductId(scanner.nextInt());
////                        	Product product1 = new Product(0, ProdName, ProdType, Price); // Use 0 for productId, it will be set in add method
//                            try {
//                                inventory.add(product);
//                            } catch (ProductLimitExceededException e) {
//                                System.out.println(e.getMessage());
//                            }
//                        	System.out.println("Enter Product Name:");
                        	System.out.println("Enter Product Name:");
                        	String name = scanner.nextLine(); 

                        	System.out.println("Enter Product Type:");
                        	String type = scanner.nextLine(); 

                        	System.out.println("Enter Product Price:");
                        	int price = scanner.nextInt(); 
                        	scanner.nextLine(); 

                        	System.out.println("Enter Product ID:");
                        	int productId = scanner.nextInt(); 
                        	scanner.nextLine(); 
                            Product product = new Product(productId, name, type, price);
                            inventory.add(product);
                            break; 


                        case "2":
                            inventory.display();
                            break;

                        case "3":
                            System.out.println("Enter Product Name to Search:");
                            String searchName = scanner.nextLine();
                            inventory.loadProductsFromDatabase();
                            try {
                                inventory.search(searchName);
                            } catch (ProductNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "4":
//                            System.out.println("Enter Product Name to Remove:");
//                            String removeName = scanner.nextLine();
//                            try {
//                                inventory.remove(removeName);
//                            } catch (ProductNotFoundException e) {
//                                System.out.println(e.getMessage());
//                            }
//                            break;
                        	System.out.println("Enter Product Name to Remove:");
                        	String removeName = scanner.nextLine();
                        	try {
                        	    inventory.remove(removeName);
                        	} catch (ProductNotFoundException e) {
                        	    System.out.println(e.getMessage());
                        	}
                        	break;

                        case "5":
                            System.out.println("Enter Product Name to Update:");
                            String updateName = scanner.nextLine();
                            inventory.loadProductsFromDatabase();
                            try {
                                inventory.update(updateName);
                            } catch (ProductNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

//                        case "6":
//                            System.out.println("Sort By \n1. Price\n2. Name");
//                            int sortOpt = scanner.nextInt();
//                            if (sortOpt == 1) {
//                                inventory.sort3();
//                                inventory.display();
//                            } else if (sortOpt == 2) {
//                                inventory.sort2();
//                                inventory.display();
//                            } else {
//                                System.out.println("Invalid option");
//                            }
//                            break;

                        case "6":
                            System.out.println("Exited Program");
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                } while (!option.equals("6"));
            } else {
                System.out.println("Invalid Credentials");
            }

            System.out.println("Enter 'logout' to exit or press Enter to continue:");
            exit = scanner.nextLine();
        } while (!exit.equalsIgnoreCase("logout"));

        scanner.close();
    }
}
