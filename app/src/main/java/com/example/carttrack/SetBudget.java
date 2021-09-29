package com.example.carttrack;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SetBudget extends AppCompatActivity {
    EditText budgetInput;
    Button set;
    //private DatabaseReference BudgetRef;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget);
        budgetInput=findViewById(R.id.budget);
        set=findViewById(R.id.setbudgetfunction);
        String budget=budgetInput.getText().toString();
        budgetInput.setText(budget);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String budgetVal=budgetInput.getText().toString();
                final DatabaseReference BudgetRef= FirebaseDatabase.getInstance().getReference().child("Budgets");
                HashMap<String,Object> BudgetMap=new HashMap<>();
                BudgetMap.put("budget",budgetVal);
                BudgetRef.updateChildren(BudgetMap);
                Toast.makeText(SetBudget.this, "Your budget has been set", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SetBudget.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
