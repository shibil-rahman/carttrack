package com.example.carttrack;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class ViewCart extends AppCompatActivity {

    Bitmap bmp,scalebmp;
    int PageWidth = 1200;
    Date dateobj;
    DateFormat dateFormat;
    String name,price,quantity;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseReference cartListRef;
    Button confirm,home;
    TextView TotalPrice,pname,pqty,pprice;
    private int userBudget;
    private int OverallTotalPrice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        recyclerView=findViewById(R.id.recycler_menu_cart);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TotalPrice=findViewById(R.id.cart_TP);
        home=findViewById(R.id.home);
        confirm=findViewById(R.id.confirm);
        cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart List");



    }
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(cartListRef.child("User View").child("Products"), Cart.class).build();
        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {


            @NonNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                CartViewHolder holder = new CartViewHolder(view);
                return holder;

            }

            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i, @NonNull final Cart cart) {

                int OneTypeProductTotalPrice = (Integer.valueOf(cart.getPprice())) * (Integer.valueOf(cart.getQuantity()));
                OverallTotalPrice = OverallTotalPrice + OneTypeProductTotalPrice;
                if (userBudget > 0) {
                    if (OverallTotalPrice > userBudget) {
                        //Toast.makeText(CartActivity.this, "Sorry!TotalPrice exeeds your budget", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ViewCart.this);
                        alertDialogBuilder.setMessage("TotalPrice exeeds your budget.\nPlease remove some items from the cart!");

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                cartViewHolder.pqty.setText("Quantity=" + cart.getQuantity());
                cartViewHolder.pname.setText(cart.getPname());
                cartViewHolder.pprice.setText("Price=Rs " + cart.getPprice()*);
                TotalPrice.setText("Total Price=" + OverallTotalPrice);

                name = cart.getPname();
                price = cart.getPprice();
                quantity = cart.getQuantity();

//                payOnline.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        orderStatus="confirmed";
//                        confirmOrder();
//                        finishpdf(OverallTotalPrice);
//                        Intent intent=new Intent(CartActivity.this,intermediate_cart.class);//if blind binduserhome else on
//                        Bundle bundle = new Bundle();
//                        bundle.putString("TotalAmount",String.valueOf(OverallTotalPrice));
//                        intent.putExtras(bundle);
//                        startActivity(intent);
//                    }
//                });


                cartViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence options[] = new CharSequence[]
                                {
                                        "Delete"
                                };
                        AlertDialog.Builder builder = new AlertDialog.Builder(ViewCart.this);
                        //builder.setTitle("Cart Options");
                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                if(i==0)
//                                {
//                                    Intent intent=new Intent(CartActivity.this,ProductDetailsActivity.class);
//                                    intent.putExtra("pid",cart.getPid());
//                                    startActivity(intent);
//                                }
                                if (i == 0) {
                                    cartListRef.child("User View").child("Products").child(cart.getPid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(ViewCart.this, "Item Removed from cart", Toast.LENGTH_SHORT).show();
                                                Intent intent = getIntent();
                                                finish();
                                                startActivity(intent);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        builder.show();

                    }
                });


            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();



    }
}
class Cart {
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

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
interface ItemClickListener {
    void onclick(View view,int position,boolean isLongClick);
}