package com.irfansyed.umeedenau.umeedenauMonitring;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.LocalDataManager;
import data.col_A;
import utils.LocationHelper;

import static data.LocalDataManager.database;


public class pneuonia extends AppCompatActivity implements View.OnClickListener {


    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    String
            PN1,
            PN2,
            PN3,
            PN4,
            PN5,
            PN6,
            PN7;


    LinearLayout
            Lv_PN1,
            Lv_PN2,
            Lv_PN3,
            Lv_PN4,
            Lv_PN5,
            Lv_PN6,
            Lv_PN7;


    RadioButton

            rb_PN1_yes,
            rb_PN2_yes,
            rb_PN3_yes,
            rb_PN4_yes,
            rb_PN5_yes,
            rb_PN6_yes,
            rb_PN7_yes,

    rb_PN1_no,
            rb_PN2_no,
            rb_PN3_no,
            rb_PN4_no,
            rb_PN5_no,
            rb_PN6_no,
            rb_PN7_no;

    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pneumonia);
        fun_intia_view();


        btn_next.setOnClickListener(this);


    }


    boolean yesok = true;

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btn_Next_Pn) {

            if (yes_we_are_ok() == true) {
                this.fun_asignment();
                insertdata();

              //  Intent itt=new Intent(this,finall.class);
              //  itt.putExtra("put_extra",7);
              //  startActivity(itt);

                Insert_remarks();



            } else {
                Toast.makeText(this, "Some thing is missing! please Review your form.", Toast.LENGTH_LONG);
            }

        }


    }


    // initilalzie VIews

    public void fun_intia_view() {
        Lv_PN1 = (LinearLayout) findViewById(R.id.Lv_PN1);
        Lv_PN2 = (LinearLayout) findViewById(R.id.Lv_PN2);
        Lv_PN3 = (LinearLayout) findViewById(R.id.Lv_PN3);
        Lv_PN4 = (LinearLayout) findViewById(R.id.Lv_PN4);
        Lv_PN5 = (LinearLayout) findViewById(R.id.Lv_PN5);
        Lv_PN6 = (LinearLayout) findViewById(R.id.Lv_PN6);
        Lv_PN7 = (LinearLayout) findViewById(R.id.Lv_PN7);


        rb_PN1_yes = (RadioButton) findViewById(R.id.rb_PN1_yes);
        rb_PN2_yes = (RadioButton) findViewById(R.id.rb_PN2_yes);
        rb_PN3_yes = (RadioButton) findViewById(R.id.rb_PN3_yes);
        rb_PN4_yes = (RadioButton) findViewById(R.id.rb_PN4_yes);
        rb_PN5_yes = (RadioButton) findViewById(R.id.rb_PN5_yes);
        rb_PN6_yes = (RadioButton) findViewById(R.id.rb_PN6_yes);
        rb_PN7_yes = (RadioButton) findViewById(R.id.rb_PN7_yes);


        rb_PN1_no = (RadioButton) findViewById(R.id.rb_PN1_no);
        rb_PN2_no = (RadioButton) findViewById(R.id.rb_PN2_no);
        rb_PN3_no = (RadioButton) findViewById(R.id.rb_PN3_no);
        rb_PN4_no = (RadioButton) findViewById(R.id.rb_PN4_no);
        rb_PN5_no = (RadioButton) findViewById(R.id.rb_PN5_no);
        rb_PN6_no = (RadioButton) findViewById(R.id.rb_PN6_no);
        rb_PN7_no = (RadioButton) findViewById(R.id.rb_PN7_no);


        btn_next = (Button) findViewById(R.id.btn_Next_Pn);


    }


    public boolean yes_we_are_ok() {

        if (fun_avioid_empty_text(Lv_PN1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_PN2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PN3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PN4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PN5) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PN6) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PN7) == false) {
            return false;
        }


        return true;
    }

    // switcher counter


    public boolean fun_avioid_empty_text(LinearLayout lv) {
        Boolean Yes_iam_good = true;
        Yes_iam_good = Gothrough.IamHiden(lv);
        if (Yes_iam_good == false) {
            return false;
        }

        return true;
    }


    public void fun_asignment() {

        PN1 = "0";
        PN2 = "0";
        PN3 = "0";
        PN4 = "0";
        PN5 = "0";
        PN6 = "0";
        PN7 = "0";


        if (rb_PN1_yes.isChecked()) {
            PN1 = "1";
        }
        if (rb_PN2_yes.isChecked()) {
            PN2 = "1";
        }
        if (rb_PN3_yes.isChecked()) {
            PN3 = "1";
        }
        if (rb_PN4_yes.isChecked()) {
            PN4 = "1";
        }
        if (rb_PN5_yes.isChecked()) {
            PN5 = "1";
        }
        if (rb_PN6_yes.isChecked()) {
            PN6 = "1";
        }
        if (rb_PN7_yes.isChecked()) {
            PN7 = "1";
        }


    }


    public void insertdata() {


        String query = "Update  " +
                "ttable set " +

                "PN1='" + PN1 + "'," +
                "PN2='" + PN2 + "'," +
                "PN3='" + PN3 + "'," +
                "PN4='" + PN4 + "'," +
                "PN5='" + PN5 + "'," +
                "PN6='" + PN6 + "'," +
                "PN7='" + PN7 + "'" +


                " where id=" + globale.db_pk;


        query = String.format(query);


        LocalDataManager Lm = new LocalDataManager(this);

        database.execSQL(query);

        Toast.makeText(this, "Data Saved  successfully", Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onBackPressed() {

        final AlertDialog b = new AlertDialog.Builder(this).create();

        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.dialog_back, null);
        b.setView(v);


        Button btnPending = (Button) v.findViewById(R.id.btn_dialog_back_pending);
        Button btnCancel = (Button) v.findViewById(R.id.btn_dialog_back_cancel);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pneuonia.super.onBackPressed();


                b.cancel();
            }
        });

        btnPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                b.cancel();

            }
        });


        //show dialog
        b.show();

    }

    void next_step() {
        globale.PN1 = PN1;
        globale.PN2 = PN2;
        globale.PN3 = PN3;
        globale.PN4 = PN4;
        globale.PN5 = PN5;
        globale.PN6 = PN6;
        globale.PN7 = PN7;
    }



    String s_remarks="";
    public  void Insert_remarks()
    {


        final AlertDialog b = new AlertDialog.Builder(this).create();

        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.dialog_remkarks, null);
        b.setView(v);
        b.setCancelable(false);



        final EditText ed_remakrs=(EditText)v.findViewById(R.id.ed_remarks);
        Button btnsave = (Button) v.findViewById(R.id.btn_save);



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(ed_remakrs.getText().toString().length()>0)
                {
                    s_remarks=ed_remakrs.getText().toString().trim();



                }


                String query = "Update  " +
                        "ttable set "+

                        "remarks='"+s_remarks+"'"+
                        " where id="+globale.db_pk;

                query = String.format(query);


                LocalDataManager Lm = new LocalDataManager(getApplicationContext());

                database.execSQL(query);


                finish();

            }
        });




        //show dialog
        b.show();


    }


}
