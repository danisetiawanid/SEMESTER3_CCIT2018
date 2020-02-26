package com.dani.lakeviewcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityCoffeeProduct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffeedetails);
    }

    public void pindahorder(View view) {
        Intent intent = new Intent(ActivityCoffeeProduct.this, ActivityCoffeeOrder.class);
        startActivity(intent);
    }

    public void pindahkehome(View view) {
        Intent intent = new Intent(ActivityCoffeeProduct.this, ActivityCoffeeHome.class);
        startActivity(intent);
    }
}
