package ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wecaremartfirebasecommon.R;

public class AdminOrdersViewHolder extends RecyclerView.ViewHolder{
    public TextView userName,userPhone,userTotalPrice,paymentStatus;
    public Button AdminViewUsersCart,AdminChangePaymentStatus;
    public AdminOrdersViewHolder(@NonNull View itemView) {
        super(itemView);
        userName=itemView.findViewById(R.id.ordersUsername);
        userPhone=itemView.findViewById(R.id.ordersPhone);
        userTotalPrice=itemView.findViewById(R.id.ordersTotalprice);
        paymentStatus=itemView.findViewById(R.id.paymentStatus);
        AdminViewUsersCart=itemView.findViewById(R.id.adminCheckOrders);
        AdminChangePaymentStatus=itemView.findViewById(R.id.ChangePaymentStatus);
    }
}
