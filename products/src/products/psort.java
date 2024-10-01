package products;

import java.util.Comparator;

class psort implements Comparator<Product>
{
	 public int compare(Product i, Product j)
	 {
		 return i.getPrice()>j.getPrice()?1:-1;
	 }
}
