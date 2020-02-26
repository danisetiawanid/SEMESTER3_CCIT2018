package com.dani.lakeviewcoffee;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.NumberFormat;
import java.util.Locale;

public class ActivityCoffeeModify extends AppCompatActivity implements View.OnClickListener {

    private EditText nomejaText;
    private EditText cappuccinoText;
    private EditText espressoText;
    private EditText macchiatoText;
    private EditText mochaText;
    private EditText ristrettoText;
    private EditText cafe_latteText;
    private EditText americanoText;
    private EditText mocha_lateText;
    private EditText affogato_lateText;
    private EditText tanggalText;
    private EditText totalText;
    private EditText jamText;


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

    private Button plusbutton;
    private Button minusbutton;
    private Button plus2button;
    private Button minus2button;
    private Button plus3button;
    private Button minus3button;
    private Button plus4button;
    private Button minus4button;
    private Button plus5button;
    private Button minus5button;
    private Button plus6button;
    private Button minus6button;
    private Button plus7button;
    private Button minus7button;
    private Button plus8button;
    private Button minus8button;
    private Button plus9button;
    private Button minus9button;

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

    private Button updateBtn, deleteBtn;
    private long _id;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Update Order History");
        setContentView(R.layout.activity_coffeemodify);

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
                        Intent a = new Intent(ActivityCoffeeModify.this, ActivityCoffeeHome.class);
                        startActivity(a);
                        break;
                    case R.id.order:
                        Intent a2 = new Intent(ActivityCoffeeModify.this, ActivityCoffeeOrder.class);
                        startActivity(a2);
                        break;
                    case R.id.transactionhistory:
                        Intent a3 = new Intent(ActivityCoffeeModify.this, ActivityCoffeeOrderHistory.class);
                        startActivity(a3);
                        break;

                }

                return false;


            }
        });


        dbManager = new DBManager(this);
        dbManager.open();

        nomejaText = (EditText) findViewById(R.id.nomeja_edittext);
        cappuccinoText = (EditText) findViewById(R.id.cappuccino_edittext);
        espressoText = (EditText) findViewById(R.id.espresso_edittext);
        macchiatoText = (EditText) findViewById(R.id.macchiato_edittext);
        mochaText = (EditText) findViewById(R.id.mocha_edittext);
        ristrettoText = (EditText) findViewById(R.id.ristretto_edittext);
        cafe_latteText = (EditText) findViewById(R.id.cafe_latte_edittext);
        americanoText = (EditText) findViewById(R.id.americano_edittext);
        mocha_lateText = (EditText) findViewById(R.id.mocha_late_edittext);
        affogato_lateText = (EditText) findViewById(R.id.affogato_late_edittext);

        jamText = (EditText) findViewById(R.id.jam_edittext);
        tanggalText = (EditText) findViewById(R.id.tanggal_edittext);
        totalText = (EditText) findViewById(R.id.total_edittext);

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

        plusbutton = (Button) findViewById(R.id.plus);
        minusbutton = (Button) findViewById(R.id.minus);
        plus2button = (Button) findViewById(R.id.plus2);
        minus2button = (Button) findViewById(R.id.minus2);
        plus3button = (Button) findViewById(R.id.plus3);
        minus3button = (Button) findViewById(R.id.minus3);
        plus4button = (Button) findViewById(R.id.plus4);
        minus4button = (Button) findViewById(R.id.minus4);
        plus5button = (Button) findViewById(R.id.plus5);
        minus5button = (Button) findViewById(R.id.minus5);
        plus6button = (Button) findViewById(R.id.plus6);
        minus6button = (Button) findViewById(R.id.minus6);
        plus7button = (Button) findViewById(R.id.plus7);
        minus7button = (Button) findViewById(R.id.minus7);
        plus8button = (Button) findViewById(R.id.plus8);
        minus8button = (Button) findViewById(R.id.minus8);
        plus9button = (Button) findViewById(R.id.plus9);
        minus9button = (Button) findViewById(R.id.minus9);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);




        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int num1 = Integer.parseInt(hargaEditText.getText().toString());
                int num2 = Integer.parseInt(cappuccinoText.getText().toString());

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
                int num2 = Integer.parseInt(espressoText.getText().toString());

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
                int num2 = Integer.parseInt(macchiatoText.getText().toString());

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
                int num2 = Integer.parseInt(mochaText.getText().toString());

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
                int num2 = Integer.parseInt(ristrettoText.getText().toString());

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
                int num2 = Integer.parseInt(cafe_latteText.getText().toString());

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
                int num2 = Integer.parseInt(americanoText.getText().toString());

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
                int num2 = Integer.parseInt(mocha_lateText.getText().toString());

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
                int num2 = Integer.parseInt(affogato_lateText.getText().toString());

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

                totalText.setText(Integer.toString(sum3));

                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                totalText.setText(formatRupiah.format((double) sum3));


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        hargaEditText.addTextChangedListener(textWatcher);
        cappuccinoText.addTextChangedListener(textWatcher);
        hasilEditText.addTextChangedListener(textWatcherhasilsemua);

        harga2EditText.addTextChangedListener(textWatcher2);
        espressoText.addTextChangedListener(textWatcher2);
        hasil2EditText.addTextChangedListener(textWatcherhasilsemua);

        harga3EditText.addTextChangedListener(textWatcher3);
        macchiatoText.addTextChangedListener(textWatcher3);
        hasil3EditText.addTextChangedListener(textWatcherhasilsemua);

        harga4EditText.addTextChangedListener(textWatcher4);
        mochaText.addTextChangedListener(textWatcher4);
        hasil4EditText.addTextChangedListener(textWatcherhasilsemua);

        harga5EditText.addTextChangedListener(textWatcher5);
        ristrettoText.addTextChangedListener(textWatcher5);
        hasil5EditText.addTextChangedListener(textWatcherhasilsemua);

        harga6EditText.addTextChangedListener(textWatcher6);
        cafe_latteText.addTextChangedListener(textWatcher6);
        hasil6EditText.addTextChangedListener(textWatcherhasilsemua);

        harga7EditText.addTextChangedListener(textWatcher7);
        americanoText.addTextChangedListener(textWatcher7);
        hasil7EditText.addTextChangedListener(textWatcherhasilsemua);

        harga8EditText.addTextChangedListener(textWatcher8);
        mocha_lateText.addTextChangedListener(textWatcher8);
        hasil8EditText.addTextChangedListener(textWatcherhasilsemua);

        harga9EditText.addTextChangedListener(textWatcher9);
        affogato_lateText.addTextChangedListener(textWatcher9);
        hasil9EditText.addTextChangedListener(textWatcherhasilsemua);


        /* Membuat objek Intent dengan nilai yang dikirim objek Intent
        yang telah memanggil kelas ini sebelumnya */
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String nomeja = intent.getStringExtra("nomeja");
        String cappuccino = intent.getStringExtra("cappuccino");
        String espresso = intent.getStringExtra("espresso");
        String macchiato = intent.getStringExtra("macchiato");
        String mocha = intent.getStringExtra("mocha");
        String ristretto = intent.getStringExtra("ristretto");
        String cafe_latte = intent.getStringExtra("cafe_latte");
        String americano = intent.getStringExtra("americano");
        String mocha_late = intent.getStringExtra("mocha_late");
        String affogato_late = intent.getStringExtra("affogato_late");
        String total = intent.getStringExtra("total");
        String tanggal = intent.getStringExtra("tanggal");
        String jam = intent.getStringExtra("jam");

        _id = Long.parseLong(id);
        nomejaText.setText(nomeja);
        cappuccinoText.setText(cappuccino);
        espressoText.setText(espresso);
        macchiatoText.setText(macchiato);
        mochaText.setText(mocha);
        ristrettoText.setText(ristretto);
        cafe_latteText.setText(cafe_latte);
        americanoText.setText(americano);
        mocha_lateText.setText(mocha_late);
        affogato_lateText.setText(affogato_late);
        totalText.setText(total);
        tanggalText.setText(tanggal);
        jamText.setText(jam);


        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger = Integer.parseInt(cappuccinoText.getText().toString());
                minteger = minteger + 1;
                display(minteger);
            }
        });

        minusbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int minteger = Integer.parseInt(cappuccinoText.getText().toString());
                        minteger = minteger - 1;
                        display(minteger);
                    }
                });

        plus2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger2 = Integer.parseInt(espressoText.getText().toString());
                minteger2 = minteger2 + 1;
                display2(minteger2);
            }
        });

        minus2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger2 = Integer.parseInt(espressoText.getText().toString());
                minteger2 = minteger2 - 1;
                display2(minteger2);
            }
        });
        plus3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger3 = Integer.parseInt(macchiatoText.getText().toString());
                minteger3 = minteger3 + 1;
                display3(minteger3);
            }
        });

        minus3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger3 = Integer.parseInt(macchiatoText.getText().toString());
                minteger3= minteger3 - 1;
                display3(minteger3);
            }
        });
        plus4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger4 = Integer.parseInt(mochaText.getText().toString());
                minteger4 = minteger4 + 1;
                display4(minteger4);
            }
        });

        minus4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger4 = Integer.parseInt(mochaText.getText().toString());
                minteger4= minteger4 - 1;
                display4(minteger4);
            }
        });
        plus5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger5 = Integer.parseInt(ristrettoText.getText().toString());
                minteger5 = minteger5 + 1;
                display5(minteger5);
            }
        });

        minus5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger5 = Integer.parseInt(ristrettoText.getText().toString());
                minteger5= minteger5 - 1;
                display5(minteger5);
            }
        });
        plus6button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger6 = Integer.parseInt(cafe_latteText.getText().toString());
                minteger6 = minteger6 + 1;
                display6(minteger6);
            }
        });

        minus6button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger6 = Integer.parseInt(cafe_latteText.getText().toString());
                minteger6= minteger6 - 1;
                display6(minteger6);
            }
        });
        plus7button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger7 = Integer.parseInt(americanoText.getText().toString());
                minteger7 = minteger7 + 1;
                display7(minteger7);
            }
        });

        minus7button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger7 = Integer.parseInt(americanoText.getText().toString());
                minteger7= minteger7 - 1;
                display7(minteger7);
            }
        });
        plus8button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger8 = Integer.parseInt(mocha_lateText.getText().toString());
                minteger8 = minteger8 + 1;
                display8(minteger8);
            }
        });

        minus8button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger8 = Integer.parseInt(mocha_lateText.getText().toString());
                minteger8= minteger8 - 1;
                display8(minteger8);
            }
        });
        plus9button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger9 = Integer.parseInt(affogato_lateText.getText().toString());
                minteger9 = minteger9 + 1;
                display9(minteger9);
            }
        });

        minus9button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minteger9 = Integer.parseInt(affogato_lateText.getText().toString());
                minteger9= minteger9 - 1;
                display9(minteger9);
            }
        });

    }
//======================DISPLAY UNTUK BUTTON NUMBER===============================================
    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.cappuccino_edittext);
        displayInteger.setText("" + number);
    }

    private void display2(int number2) {
        EditText displayInteger = (EditText) findViewById(
                R.id.espresso_edittext);
        displayInteger.setText("" + number2);
    }


    private void display3(int number3) {
        EditText displayInteger = (EditText) findViewById(
                R.id.macchiato_edittext);
        displayInteger.setText("" + number3);
    }

    private void display4(int number4) {
        EditText displayInteger = (EditText) findViewById(
                R.id.mocha_edittext);
        displayInteger.setText("" + number4);
    }


    private void display5(int number5) {
        EditText displayInteger = (EditText) findViewById(
                R.id.ristretto_edittext);
        displayInteger.setText("" + number5);
    }


    private void display6(int number6) {
        EditText displayInteger = (EditText) findViewById(
                R.id.cafe_latte_edittext);
        displayInteger.setText("" + number6);
    }


    private void display7(int number7) {
        EditText displayInteger = (EditText) findViewById(
                R.id.americano_edittext);
        displayInteger.setText("" + number7);
    }

    private void display8(int number8) {
        EditText displayInteger = (EditText) findViewById(
                R.id.mocha_late_edittext);
        displayInteger.setText("" + number8);
    }


    private void display9(int number9) {
        EditText displayInteger = (EditText) findViewById(
                R.id.affogato_late_edittext);
        displayInteger.setText("" + number9);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    // Pemilihan untuk tombol yang disentuh user (update/ delete)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Pilihan Update
            case R.id.btn_update:
                // Menyimpan nilai kelas dan nama baru ke variabel
                String nomeja = nomejaText.getText().toString();
                String cappuccino = cappuccinoText.getText().toString();
                String espresso = espressoText.getText().toString();
                String macchiato = macchiatoText.getText().toString();
                String mocha = mochaText.getText().toString();
                String ristretto = ristrettoText.getText().toString();
                String cafe_latte = cafe_latteText.getText().toString();
                String americano = americanoText.getText().toString();
                String mocha_late = mocha_lateText.getText().toString();
                String affogato_late = affogato_lateText.getText().toString();
                String total = totalText.getText().toString();
                String tanggal = tanggalText.getText().toString();
                String jam = jamText.getText().toString();
                /* Memanggil fungsi update melalui objek dbManager
                fungsi ini membawa tiga parameter yakni _id, kelas, nama */
                dbManager.update(_id, nomeja, cappuccino, espresso,macchiato, mocha, ristretto,
                        cafe_latte, americano , mocha_late , affogato_late, total, tanggal, jam);
                /* Setelah selesai, akan memanggil fungsi returnHome()
                untuk kembali kehalaman utama */
                Toast.makeText(getApplicationContext(),"Update order successfull",Toast.LENGTH_SHORT).show();
                this.returnHome();
                break;
            // Pilihan Update
            case R.id.btn_delete:
                // Memanggil fungsi delete dengan parameter _id
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setMessage("Are you sure, delete this order ?");
                alertBuilder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        dbManager.delete(_id);
                        Intent intent = new Intent(ActivityCoffeeModify.this,ActivityCoffeeOrderHistory.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Delete Order Successfull",Toast.LENGTH_SHORT).show();
                    }
                });
                alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ActivityCoffeeModify.this,ActivityCoffeeOrderHistory.class);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();

                break;
        } }

    // Fungsi untuk kembali ke halaman awal
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ActivityCoffeeOrderHistory.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }

}

