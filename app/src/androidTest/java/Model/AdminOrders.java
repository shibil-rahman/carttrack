package Model;

public class AdminOrders {
    private String CustomerName,CustomerPhoneNumber,TotalAmount,PaymentStatus;
    public AdminOrders()
    {

    }

    public AdminOrders(String customerName, String customerPhoneNumber, String totalAmount, String paymentStatus) {
        CustomerName = customerName;
        CustomerPhoneNumber = customerPhoneNumber;
        TotalAmount = totalAmount;
        PaymentStatus = paymentStatus;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        CustomerPhoneNumber = customerPhoneNumber;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }
}
