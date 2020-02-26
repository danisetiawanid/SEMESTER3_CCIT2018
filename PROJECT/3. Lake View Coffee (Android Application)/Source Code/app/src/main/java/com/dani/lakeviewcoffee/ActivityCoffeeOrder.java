package com.dani.lakeviewcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ActivityCoffeeOrder extends AppCompatActivity implements View.OnClickListener {
    private DBManager dbManager;
    private Button addTodoBtn;

    private EditText nomejaEditText;
    private EditText cappuccinoEditText;
    private EditText espressoEditText;
    private EditText macchiatoEditText;
    private EditText mochaEditText;
    private EditText ristrettoEditText;
    private EditText cafe_latteEditText;
    private EditText americanoEditText;
    private EditText mocha_lateEditText;
    private EditText affogato_lateEditText;


    private EditText hargaEditText;
    private EditText harga2EditText;
    private EditText harga3EditText;
    private EditText harga4EditText;
    private EditText harga5EditText;
    private EditText harga6EditText;
    private EditText harga7EditText;
    private EditText harga8EditText;
    private EditText harga9EditText;


    private EditText hasilEditText;
    private EditText hasil2EditText;
    private EditText hasil3EditText;
    private EditText hasil4EditText;
    private EditText hasil5EditText;
    private EditText hasil6EditText;
    private EditText hasil7EditText;
    private EditText hasil8EditText;
    private EditText hasil9EditText;

    private EditText tanggalEditText;
    private EditText totalEditText;
    private EditText jamEditText;

    private TextWatcher textWatcher = null;
    private TextWatcher textWatcher2 = null;
    private TextWatcher textWatcher3 = null;
    private TextWatcher textWatcher4 = null;
    private TextWatcher textWatcher5 = null;
    private TextWatcher textWatcher6 = null;
    private TextWatcher textWatcher7 = null;
    private TextWatcher textWatcher8 = null;
    private TextWatcher textWatcher9 = null;
    private TextWatcher textWatcherhasilsemua = null;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Coffee Order");
        setContentView(R.layout.activity_coffeeorder);


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
                        Intent a = new Intent(ActivityCoffeeOrder.this, ActivityCoffeeHome.class);
                        startActivity(a);
                        break;
                    case R.id.order:
                        Intent a2 = new Intent(ActivityCoffeeOrder.this, ActivityCoffeeOrder.class);
                        startActivity(a2);
                        break;
                    case R.id.transactionhistory:
                        Intent a3 = new Intent(ActivityCoffeeOrder.this, ActivityCoffeeOrderHistory.class);
                        startActivity(a3);
                        break;

                }

                return false;


            }
        });


        nomejaEditText = (EditText) findViewById(R.id.nomeja_edittext);
        cappuccinoEditText = (EditText) findViewById(R.id.cappuccino_edittext);
        espressoEditText = (EditText) findViewById(R.id.espresso_edittext);
        macchiatoEditText = (EditText) findViewById(R.id.macchiato_edittext);
        mochaEditText = (EditText) findViewById(R.id.mocha_edittext);
        ristrettoEditText = (EditText) findViewById(R.id.ristretto_edittext);
        cafe_latteEditText = (EditText) findViewById(R.id.cafe_latte_edittext);
        americanoEditText = (EditText) findViewById(R.id.americano_edittext);
        mocha_lateEditText = (EditText) findViewById(R.id.mocha_late_edittext);
        affogato_lateEditText = (EditText) findViewById(R.id.affogato_late_edittext);
        addTodoBtn = (Button) findViewById(R.id.add_record);

        hargaEditText = (EditText) findViewById(R.id.harga_edittext);
        harga2EditText = (EditText) findViewById(R.id.harga2_edittext);
        harga3EditText = (EditText) findViewById(R.id.harga3_edittext);
        harga4EditText = (EditText) findViewById(R.id.harga4_edittext);
        harga5EditText = (EditText) findViewById(R.id.harga5_edittext);
        harga6EditText = (EditText) findViewById(R.id.harga6_edittext);
        harga7EditText = (EditText) findViewById(R.id.harga7_edittext);
        harga8EditText = (EditText) findViewById(R.id.harga8_edittext);
        harga9EditText = (EditText) findViewById(R.id.harga9_edittext);

        hasilEditText = (EditText) findViewById(R.id.hasil_edittext);
        hasil2EditText = (EditText) findViewById(R.id.hasil2_edittext);
        hasil3EditText = (EditText) findViewById(R.id.hasil3_edittext);
        hasil4EditText = (EditText) findViewById(R.id.hasil4_edittext);
        hasil5EditText = (EditText) findViewById(R.id.hasil5_edittext);
        hasil6EditText = (EditText) findViewById(R.id.hasil6_edittext);
        hasil7EditText = (EditText) findViewById(R.id.hasil7_edittext);
        hasil8EditText = (EditText) findViewById(R.id.hasil8_edittext);
        hasil9EditText = (EditText) findViewById(R.id.hasil9_edittext);

        jamEditText = (EditText) findViewById(R.id.jam_edittext);
        tanggalEditText = (EditText) findViewById(R.id.tanggal_edittext);
        totalEditText = (EditText) findViewById(R.id.total_edittext);
        // Membuat objek dari kelas DBManager
        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                EditText tdate = (EditText) findViewById(R.id.tanggal_edittext);
                                EditText ttime = (EditText) findViewById(R.id.jam_edittext);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
                                SimpleDateFormat jamdani = new SimpleDateFormat("\nhh-mm-ss a");
                                String dateString = sdf.format(date);
                                String timeString = jamdani.format(date);
                                tdate.setText(dateString);
                                ttime.setText(timeString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(hargaEditText.getText().toString());
                int num2 = Integer.parseInt(cappuccinoEditText.getText().toString());

                int sum = num1 * num2;

                hasilEditText.setText(Integer.toString(sum));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        textWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga2EditText.getText().toString());
                int num2 = Integer.parseInt(espressoEditText.getText().toString());

                int sum2 = num1 * num2;

                hasil2EditText.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcher3 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga3EditText.getText().toString());
                int num2 = Integer.parseInt(macchiatoEditText.getText().toString());

                int sum = num1 * num2;

                hasil3EditText.setText(Integer.toString(sum));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        textWatcher4 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga4EditText.getText().toString());
                int num2 = Integer.parseInt(mochaEditText.getText().toString());

                int sum2 = num1 * num2;

                hasil4EditText.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcher5 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga5EditText.getText().toString());
                int num2 = Integer.parseInt(ristrettoEditText.getText().toString());

                int sum = num1 * num2;

                hasil5EditText.setText(Integer.toString(sum));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        textWatcher6 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga6EditText.getText().toString());
                int num2 = Integer.parseInt(cafe_latteEditText.getText().toString());

                int sum2 = num1 * num2;

                hasil6EditText.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcher7 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga7EditText.getText().toString());
                int num2 = Integer.parseInt(americanoEditText.getText().toString());

                int sum = num1 * num2;

                hasil7EditText.setText(Integer.toString(sum));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        textWatcher8 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga8EditText.getText().toString());
                int num2 = Integer.parseInt(mocha_lateEditText.getText().toString());

                int sum2 = num1 * num2;

                hasil8EditText.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcher9 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(harga9EditText.getText().toString());
                int num2 = Integer.parseInt(affogato_lateEditText.getText().toString());

                int sum2 = num1 * num2;

                hasil9EditText.setText(Integer.toString(sum2));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        textWatcherhasilsemua = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int hasilsemua1 = Integer.parseInt(hasilEditText.getText().toString());
                int hasilsemua2 = Integer.parseInt(hasil2EditText.getText().toString());
                int hasilsemua3 = Integer.parseInt(hasil3EditText.getText().toString());
                int hasilsemua4 = Integer.parseInt(hasil4EditText.getText().toString());
                int hasilsemua5 = Integer.parseInt(hasil5EditText.getText().toString());
                int hasilsemua6 = Integer.parseInt(hasil6EditText.getText().toString());
                int hasilsemua7 = Integer.parseInt(hasil7EditText.getText().toString());
                int hasilsemua8 = Integer.parseInt(hasil8EditText.getText().toString());
                int hasilsemua9 = Integer.parseInt(hasil9EditText.getText().toString());



                int sum3 = hasilsemua1 + hasilsemua2 + hasilsemua3 + hasilsemua4 + hasilsemua5 + hasilsemua6 + hasilsemua7 + hasilsemua8 + hasilsemua9;

                totalEditText.setText(Integer.toString(sum3));

                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                totalEditText.setText(formatRupiah.format((double) sum3));


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        hargaEditText.addTextChangedListener(textWatcher);
        cappuccinoEditText.addTextChangedListener(textWatcher);
        hasilEditText.addTextChangedListener(textWatcherhasilsemua);

        harga2EditText.addTextChangedListener(textWatcher2);
        espressoEditText.addTextChangedListener(textWatcher2);
        hasil2EditText.addTextChangedListener(textWatcherhasilsemua);

        harga3EditText.addTextChangedListener(textWatcher3);
        macchiatoEditText.addTextChangedListener(textWatcher3);
        hasil3EditText.addTextChangedListener(textWatcherhasilsemua);

        harga4EditText.addTextChangedListener(textWatcher4);
        mochaEditText.addTextChangedListener(textWatcher4);
        hasil4EditText.addTextChangedListener(textWatcherhasilsemua);

        harga5EditText.addTextChangedListener(textWatcher5);
        ristrettoEditText.addTextChangedListener(textWatcher5);
        hasil5EditText.addTextChangedListener(textWatcherhasilsemua);

        harga6EditText.addTextChangedListener(textWatcher6);
        cafe_latteEditText.addTextChangedListener(textWatcher6);
        hasil6EditText.addTextChangedListener(textWatcherhasilsemua);

        harga7EditText.addTextChangedListener(textWatcher7);
        americanoEditText.addTextChangedListener(textWatcher7);
        hasil7EditText.addTextChangedListener(textWatcherhasilsemua);

        harga8EditText.addTextChangedListener(textWatcher8);
        mocha_lateEditText.addTextChangedListener(textWatcher8);
        hasil8EditText.addTextChangedListener(textWatcherhasilsemua);

        harga9EditText.addTextChangedListener(textWatcher9);
        affogato_lateEditText.addTextChangedListener(textWatcher9);
        hasil9EditText.addTextChangedListener(textWatcherhasilsemua);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:
                // Mengambil data inputan user
                final String nomeja = nomejaEditText.getText().toString();
                final String cappuccino = cappuccinoEditText.getText().toString();
                final String espresso = espressoEditText.getText().toString();
                final String macchiato = macchiatoEditText.getText().toString();
                final String mocha = mochaEditText.getText().toString();
                final String ristretto = ristrettoEditText.getText().toString();
                final String cafe_latte = cafe_latteEditText.getText().toString();
                final String americano = americanoEditText.getText().toString();
                final String mocha_late = mocha_lateEditText.getText().toString();
                final String affogato_late = affogato_lateEditText.getText().toString();
                final String total = totalEditText.getText().toString();
                final String tanggal = tanggalEditText.getText().toString();
                final String jam = jamEditText.getText().toString();

                EditText nomejaValidasiText = (EditText) findViewById(R.id.nomeja_edittext);
                String snomeja = nomejaValidasiText.getText().toString();
                if (snomeja.matches("")) {
                    Toast.makeText(this, "You did not enter a number table", Toast.LENGTH_SHORT).show();
                    return;
                }

                EditText produk1ValidasiText = (EditText) findViewById(R.id.cappuccino_edittext);
                EditText produk2ValidasiText = (EditText) findViewById(R.id.espresso_edittext);
                EditText produk3ValidasiText = (EditText) findViewById(R.id.macchiato_edittext);
                EditText produk4ValidasiText = (EditText) findViewById(R.id.mocha_edittext);
                EditText produk5ValidasiText = (EditText) findViewById(R.id.ristretto_edittext);
                EditText produk6ValidasiText = (EditText) findViewById(R.id.cafe_latte_edittext);
                EditText produk7ValidasiText = (EditText) findViewById(R.id.americano_edittext);
                EditText produk8ValidasiText = (EditText) findViewById(R.id.mocha_late_edittext);
                EditText produk9ValidasiText = (EditText) findViewById(R.id.affogato_late_edittext);

                String sproduk1 = produk1ValidasiText.getText().toString();
                String sproduk2 = produk2ValidasiText.getText().toString();
                String sproduk3 = produk3ValidasiText.getText().toString();
                String sproduk4 = produk4ValidasiText.getText().toString();
                String sproduk5 = produk5ValidasiText.getText().toString();
                String sproduk6 = produk6ValidasiText.getText().toString();
                String sproduk7 = produk7ValidasiText.getText().toString();
                String sproduk8 = produk8ValidasiText.getText().toString();
                String sproduk9 = produk9ValidasiText.getText().toString();

                if (sproduk1.matches("0")
                        && sproduk2.matches("0")
                        && sproduk3.matches("0")
                        && sproduk4.matches("0")
                        && sproduk5.matches("0")
                        && sproduk6.matches("0")
                        && sproduk7.matches("0")
                        && sproduk8.matches("0")
                        && sproduk9.matches("0")) {
                    Toast.makeText(this, "The coffee hasn't been ordered yet", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbManager.insert(nomeja, cappuccino, espresso, macchiato, mocha,ristretto,
                        cafe_latte, americano,mocha_late, affogato_late , total, tanggal, jam  );
                Intent main = new Intent(ActivityCoffeeOrder.this, ActivityCoffeeOrderHistory.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                Toast.makeText(getApplicationContext(),"Order successful,Please check your order history",Toast.LENGTH_LONG).show();
                startActivity(main);
                break;

            }


        }

    int minteger = 0;


    public void tambahqty(View view) {
        minteger = minteger + 1;
        display(minteger);
    }

    public void kurangqty(View view) {

        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.cappuccino_edittext);
        displayInteger.setText("" + number);
    }


//    BEDA PRODUK

    int minteger2 = 0;


    public void tambahqty2(View view) {
        minteger2 = minteger2 + 1;
        display2(minteger2);
    }

    public void kurangqty2(View view) {

        minteger2 = minteger2 - 1;
        display2(minteger2);
    }

    private void display2(int number2) {
        EditText displayInteger = (EditText) findViewById(
                R.id.espresso_edittext);
        displayInteger.setText("" + number2);
    }

    int minteger3 = 0;


    public void tambahqty3(View view) {
        minteger3 = minteger3 + 1;
        display3(minteger3);
    }

    public void kurangqty3(View view) {

        minteger3 = minteger3 - 1;
        display3(minteger3);
    }

    private void display3(int number3) {
        EditText displayInteger = (EditText) findViewById(
                R.id.macchiato_edittext);
        displayInteger.setText("" + number3);
    }

    int minteger4 = 0;


    public void tambahqty4(View view) {
        minteger4 = minteger4 + 1;
        display4(minteger4);
    }

    public void kurangqty4(View view) {

        minteger4 = minteger4 - 1;
        display4(minteger4);
    }

    private void display4(int number4) {
        EditText displayInteger = (EditText) findViewById(
                R.id.mocha_edittext);
        displayInteger.setText("" + number4);
    }

    int minteger5 = 0;


    public void tambahqty5(View view) {
        minteger5 = minteger5 + 1;
        display5(minteger5);
    }

    public void kurangqty5(View view) {

        minteger5 = minteger5 - 1;
        display5(minteger5);
    }

    private void display5(int number5) {
        EditText displayInteger = (EditText) findViewById(
                R.id.ristretto_edittext);
        displayInteger.setText("" + number5);
    }

    int minteger6 = 0;


    public void tambahqty6(View view) {
        minteger6 = minteger6 + 1;
        display6(minteger6);
    }

    public void kurangqty6(View view) {

        minteger6 = minteger6 - 1;
        display6(minteger6);
    }

    private void display6(int number6) {
        EditText displayInteger = (EditText) findViewById(
                R.id.cafe_latte_edittext);
        displayInteger.setText("" + number6);
    }

    int minteger7 = 0;


    public void tambahqty7(View view) {
        minteger7 = minteger7 + 1;
        display7(minteger7);
    }

    public void kurangqty7(View view) {

        minteger7 = minteger7 - 1;
        display7(minteger7);
    }

    private void display7(int number7) {
        EditText displayInteger = (EditText) findViewById(
                R.id.americano_edittext);
        displayInteger.setText("" + number7);
    }

    int minteger8 = 0;


    public void tambahqty8(View view) {
        minteger8 = minteger8 + 1;
        display8(minteger8);
    }

    public void kurangqty8(View view) {

        minteger8 = minteger8 - 1;
        display8(minteger8);
    }

    private void display8(int number8) {
        EditText displayInteger = (EditText) findViewById(
                R.id.mocha_late_edittext);
        displayInteger.setText("" + number8);
    }


    int minteger9 = 0;

    public void tambahqty9(View view) {
        minteger9 = minteger9 + 1;
        display9(minteger9);
    }

    public void kurangqty9(View view) {

        minteger9 = minteger9 - 1;
        display9(minteger9);
    }

    private void display9(int number9) {
        EditText displayInteger = (EditText) findViewById(
                R.id.affogato_late_edittext);
        displayInteger.setText("" + number9);
    }


}
