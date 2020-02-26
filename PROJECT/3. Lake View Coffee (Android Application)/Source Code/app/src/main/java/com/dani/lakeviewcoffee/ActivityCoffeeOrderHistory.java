package com.dani.lakeviewcoffee;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ActivityCoffeeOrderHistory extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.NOMEJA, DatabaseHelper.CAPPUCCINO,
            DatabaseHelper.ESPRESSO, DatabaseHelper.MACCHIATO,DatabaseHelper.MOCHA, DatabaseHelper.RISTRETTO,
            DatabaseHelper.CAFE_LATTE,DatabaseHelper.AMERICANO, DatabaseHelper.MOCHA_LATE, DatabaseHelper.AFFOGATO_LATE,
            DatabaseHelper.TOTAL, DatabaseHelper.TANGGAL, DatabaseHelper.JAM };
    final int[] to = new int[] { R.id.id, R.id.nomeja, R.id.cappuccino, R.id.espresso, R.id.macchiato,
            R.id.mocha, R.id.ristretto, R.id.cafe_latte,R.id.americano,
            R.id.mocha_late, R.id.affogato_late, R.id.total, R.id.tanggal, R.id.jam };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Order History");
        // Memilih layout
        setContentView(R.layout.activity_coffeeorderhistory);

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
                        Intent a = new Intent(ActivityCoffeeOrderHistory.this, ActivityCoffeeHome.class);
                        startActivity(a);
                        break;
                    case R.id.order:
                        Intent a2 = new Intent(ActivityCoffeeOrderHistory.this, ActivityCoffeeOrder.class);
                        startActivity(a2);
                        break;
                    case R.id.transactionhistory:
                        Intent a3 = new Intent(ActivityCoffeeOrderHistory.this, ActivityCoffeeOrderHistory.class);
                        startActivity(a3);
                        break;

                }

                return false;


            }
        });

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        /* Adapter untuk menunjuk data di database
        untuk di tampilkan dalam list siswa yang mana data tersebut
        menunjuk ke fragment dari ListView */
        adapter = new SimpleCursorAdapter(this, R.layout.activity_coffeefragment, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner untuk Data Siswa yang telah ada di database
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                // Mengambil nilai list yang dipilih
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView nomejaTextView = (TextView) view.findViewById(R.id.nomeja);
                TextView cappuccinoTextView = (TextView) view.findViewById(R.id.cappuccino);
                TextView espressoTextView = (TextView) view.findViewById(R.id.espresso);
                TextView macchiatoTextView = (TextView) view.findViewById(R.id.macchiato);
                TextView mochaTextView = (TextView) view.findViewById(R.id.mocha);
                TextView ristrettoTextView = (TextView) view.findViewById(R.id.ristretto);
                TextView cafe_latteTextView = (TextView) view.findViewById(R.id.cafe_latte);
                TextView americanoTextView = (TextView) view.findViewById(R.id.americano);
                TextView mocha_lateTextView = (TextView) view.findViewById(R.id.mocha_late);
                TextView affogato_lateTextView = (TextView) view.findViewById(R.id.affogato_late);
                TextView totalTextView = (TextView) view.findViewById(R.id.total);
                TextView tanggalTextView = (TextView) view.findViewById(R.id.tanggal);
                TextView jamTextView = (TextView) view.findViewById(R.id.jam);

                // Menyimpan nilai list yang di pilih ke variabel
                String id = idTextView.getText().toString();
                String nomeja = nomejaTextView.getText().toString();
                String cappuccino = cappuccinoTextView.getText().toString();
                String espresso = espressoTextView.getText().toString();
                String macchiato = macchiatoTextView.getText().toString();
                String mocha = mochaTextView.getText().toString();
                String ristretto = ristrettoTextView.getText().toString();
                String cafe_latte = cafe_latteTextView.getText().toString();
                String americano = americanoTextView.getText().toString();
                String mocha_late = mocha_lateTextView.getText().toString();
                String affogato_late = affogato_lateTextView.getText().toString();
                String total = totalTextView.getText().toString();
                String tanggal = tanggalTextView.getText().toString();
                String jam = jamTextView.getText().toString();


                // Proses Intent untuk mengirim data ke halaman Edit
                Intent modify_intent = new Intent(getApplicationContext(), ActivityCoffeeModify.class);
                modify_intent.putExtra("nomeja", nomeja);
                modify_intent.putExtra("cappuccino", cappuccino);
                modify_intent.putExtra("espresso", espresso);
                modify_intent.putExtra("macchiato", macchiato);
                modify_intent.putExtra("mocha", mocha);
                modify_intent.putExtra("ristretto", ristretto);
                modify_intent.putExtra("cafe_latte", cafe_latte);
                modify_intent.putExtra("americano", americano);
                modify_intent.putExtra("mocha_late", mocha_late);
                modify_intent.putExtra("affogato_late", affogato_late);
                modify_intent.putExtra("total", total);
                modify_intent.putExtra("tanggal", tanggal);
                modify_intent.putExtra("jam", jam);
                modify_intent.putExtra("id", id);
                startActivity(modify_intent);
            }
        }); }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Intent add_mem = new Intent(this, ActivityCoffeeOrder.class);
            startActivity(add_mem);
        }
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    } }
