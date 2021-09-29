package Model;

public class Products {
    private String barcode,brand,category,expiry,name,price,quantity,image,pid;
    public Products()
    {

    }

    public Products(String barcode, String brand, String category, String expiry, String name, String price, String quantity,String image) {
        this.barcode = barcode;
        this.brand = brand;
        this.category = category;
        this.expiry = expiry;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image=image;
        this.pid=pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

