package Model;

public class Cart {
    private String pid,pname,pprice,quantity,pdiscount;
    public Cart()
    {

    }

    public Cart(String pid, String pname, String pprice, String quantity, String pdiscount) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.quantity=quantity;
        this.pdiscount = pdiscount;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getPprice() {
        return pprice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPdiscount() {
        return pdiscount;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }



    public void setPdiscount(String pdiscount) {
        this.pdiscount = pdiscount;
    }
}

