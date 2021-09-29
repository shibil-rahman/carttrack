package ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.carttrack.R;

import Interface.ItemClickListener;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView pname,pqty,pprice;
    private ItemClickListener itemClickListener;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        pname=itemView.findViewById(R.id.cartlist_pname);
        pprice=itemView.findViewById(R.id.cartlist_pprice);
        pqty=itemView.findViewById(R.id.cartlist_pqty);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onclick(view,getAdapterPosition(),false);

    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
}
