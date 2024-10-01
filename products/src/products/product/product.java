package products;

class Product {
    private String prodName;
    private String prodType;
    private int price;
    private int productId; // Add productId

    public Product() {
    }

    public Product(int productId, String prodName, String prodType, int price) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodType = prodType;
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", prodName=" + prodName + ", prodType=" + prodType + ", price=" + price + "]";
    }
}
