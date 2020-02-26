package com.dani.lakeviewcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ActivityCoffeeHome extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setTitle("Home");
            setContentView(R.layout.activity_coffeehome);

            dl = (DrawerLayout)findViewById(R.id.activity_main);
            t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

            dl.addDrawerListener(t);
            t.syncState();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            nv = (NavigationView)findViewById(R.id.nv);
            nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId())
                    {
                        case R.id.home:
                            Intent a = new Intent(ActivityCoffeeHome.this, ActivityCoffeeOrder.class);
                            startActivity(a);
                            break;
                        case R.id.order:
                            Intent a2 = new Intent(ActivityCoffeeHome.this, ActivityCoffeeOrder.class);
                            startActivity(a2);
                            break;
                        case R.id.transactionhistory:
                            Intent a3 = new Intent(ActivityCoffeeHome.this, ActivityCoffeeOrderHistory.class);
                            startActivity(a3);
                            break;

                    }

                    return false;


                }
            });


        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void pindah(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah2(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah3(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah4(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah5(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah6(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }
    public void pindah7(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah8(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindah9(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeProduct.class);
        startActivity(intent);
    }

    public void pindahkeorder(View view) {
        Intent intent = new Intent(ActivityCoffeeHome.this, ActivityCoffeeOrder.class);
        startActivity(intent);
    }
}
