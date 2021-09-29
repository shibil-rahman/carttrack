package com.example.carttrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

public class ViewCart extends AppCompatActivity {

    Bitmap bmp,scalebmp;
    int PageWidth = 1200;
    Date dateobj;
    DateFormat dateFormat;
    String name,price,quantity;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    Button confirm,home;
    TextView TotalPrice,pname,pqty,pprice;
    private int userBudget;
    private int OverallTotalPrice=0;
    HashMap<String,Object> BudgetMap=new HashMap<>();
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



    }
}