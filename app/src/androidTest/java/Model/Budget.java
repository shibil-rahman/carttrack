package Model;

public class Budget {
    public String budget;
    public String totalprice;

    public Budget() {

    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public Budget(String budget, String totalprice) {
        this.budget = budget;
        this.totalprice = totalprice;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

}