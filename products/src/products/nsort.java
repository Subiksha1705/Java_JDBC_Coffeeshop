package products;
import java.util.*;

public class nsort implements Comparator<Product> {

	public int compare(Product i, Product j)
	 {
		 return (i.getProdName()).compareTo(j.getProdName());
	 }
	
	

}
