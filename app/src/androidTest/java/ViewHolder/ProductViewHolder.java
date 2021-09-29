package ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wecaremartfirebasecommon.R;

import Interface.ItemClickListener;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView pname,pqty,pprice;
    public ImageView pimg;
    public ItemClickListener listener;
    public ProductViewHolder(View itemView)
    {
        super(itemView);
        pname=(TextView)itemView.findViewById(R.id.layout_pname);
        pprice=(TextView)itemView.findViewById(R.id.layout_pprice);
        pimg=(ImageView)itemView.findViewById(R.id.layout_pimg);

    }
    public void onClick(View view)
    {
        listener.onclick(view,getAdapterPosition(),false);
    }
}