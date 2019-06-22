package com.irfansyed.umeedenau.umeedenauMonitring;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.LocalDataManager;
import data.col_A;
import utils.ClearAllcontrol;
import utils.LocationHelper;

import static data.LocalDataManager.database;


public class pnc extends AppCompatActivity implements View.OnClickListener, RadioButton.OnCheckedChangeListener {


    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    LinearLayout
            Lv_PNC1,
            Lv_PNC2,
            Lv_PNC3,
            Lv_PNC4,
            Lv_PNC5,
            Lv_PNC6,
            Lv_PNC7,
            Lv_PNC5_1,
            Lv_PNC5_2,
            Lv_PNC5_3;


    RadioButton

            rb_PNC1_yes,
            rb_PNC2_yes,
            rb_PNC3_yes,
            rb_PNC4_yes,
            rb_PNC5_yes,
            rb_PNC6_yes,
            rb_PNC7_yes,
            rb_PNC5_1_yes,
            rb_PNC5_2_yes,
            rb_PNC5_3_yes,
            rb_PNC1_no,
            rb_PNC2_no,
            rb_PNC3_no,
            rb_PNC4_no,
            rb_PNC5_no,
            rb_PNC6_no,
            rb_PNC7_no,
            rb_PNC5_1_no,
            rb_PNC5_2_no,
            rb_PNC5_3_no;


    Button btn_next;

    String
            PNC1,
            PNC2,
            PNC3,
            PNC4,
            PNC5,
            PNC6,
            PNC7,
            PNC5_1,
            PNC5_2,
            PNC5_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pnc);
        fun_intia_view();


        fun_intia_view();


        btn_next.setOnClickListener(this);

        rb_PNC4_yes.setOnCheckedChangeListener(this);
        rb_PNC4_no.setOnCheckedChangeListener(this);


    }


    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btn_next_PNC) {

            if (yes_we_are_ok() == true) {
                this.fun_asignment();
                insertdata();
                this.next_step();
                //   Intent itt=new Intent(this,finall.class);
                //  itt.putExtra("put_extra",3);
                //  startActivity(itt);
                Insert_remarks();


            } else {
                Toast.makeText(this, "Some thing is missing! please Review your form.", Toast.LENGTH_LONG);
            }

        }


    }


    // initilalzie VIews

    public void fun_intia_view() {
        Lv_PNC1 = (LinearLayout) findViewById(R.id.Lv_PNC1);
        Lv_PNC2 = (LinearLayout) findViewById(R.id.Lv_PNC2);
        Lv_PNC3 = (LinearLayout) findViewById(R.id.Lv_PNC3);
        Lv_PNC4 = (LinearLayout) findViewById(R.id.Lv_PNC4);
        Lv_PNC5 = (LinearLayout) findViewById(R.id.Lv_PNC5);
        Lv_PNC6 = (LinearLayout) findViewById(R.id.Lv_PNC6);
        Lv_PNC7 = (LinearLayout) findViewById(R.id.Lv_PNC7);
        Lv_PNC5_1 = (LinearLayout) findViewById(R.id.Lv_PNC5_1);
        Lv_PNC5_2 = (LinearLayout) findViewById(R.id.Lv_PNC5_2);
        Lv_PNC5_3 = (LinearLayout) findViewById(R.id.Lv_PNC5_3);


        rb_PNC1_yes = (RadioButton) findViewById(R.id.rb_PNC1_yes);
        rb_PNC2_yes = (RadioButton) findViewById(R.id.rb_PNC2_yes);
        rb_PNC3_yes = (RadioButton) findViewById(R.id.rb_PNC3_yes);
        rb_PNC4_yes = (RadioButton) findViewById(R.id.rb_PNC4_yes);
        rb_PNC5_yes = (RadioButton) findViewById(R.id.rb_PNC5_yes);
        rb_PNC6_yes = (RadioButton) findViewById(R.id.rb_PNC6_yes);
        rb_PNC7_yes = (RadioButton) findViewById(R.id.rb_PNC7_yes);
        rb_PNC5_1_yes = (RadioButton) findViewById(R.id.rb_PNC5_1_yes);
        rb_PNC5_2_yes = (RadioButton) findViewById(R.id.rb_PNC5_2_yes);
        rb_PNC5_3_yes = (RadioButton) findViewById(R.id.rb_PNC5_3_yes);


        rb_PNC1_no = (RadioButton) findViewById(R.id.rb_PNC1_no);
        rb_PNC2_no = (RadioButton) findViewById(R.id.rb_PNC2_no);
        rb_PNC3_no = (RadioButton) findViewById(R.id.rb_PNC3_no);
        rb_PNC4_no = (RadioButton) findViewById(R.id.rb_PNC4_no);
        rb_PNC5_no = (RadioButton) findViewById(R.id.rb_PNC5_no);
        rb_PNC6_no = (RadioButton) findViewById(R.id.rb_PNC6_no);
        rb_PNC7_no = (RadioButton) findViewById(R.id.rb_PNC7_no);
        rb_PNC5_1_no = (RadioButton) findViewById(R.id.rb_PNC5_1_no);
        rb_PNC5_2_no = (RadioButton) findViewById(R.id.rb_PNC5_2_no);
        rb_PNC5_3_no = (RadioButton) findViewById(R.id.rb_PNC5_3_no);


        btn_next = (Button) findViewById(R.id.btn_next_PNC);


    }


    public boolean yes_we_are_ok() {

        if (fun_avioid_empty_text(Lv_PNC1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_PNC2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC5) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC6) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC7) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC5_1) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC5_2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_PNC5_3) == false) {
            return false;
        }


        return true;
    }


    public boolean fun_avioid_empty_text(LinearLayout lv) {
        Boolean Yes_iam_good = true;
        Yes_iam_good = Gothrough.IamHiden(lv);
        if (Yes_iam_good == false) {
            return false;
        }

        return true;
    }

    public void fun_asignment() {

        PNC1 = "0";
        PNC2 = "0";
        PNC3 = "0";
        PNC4 = "0";
        PNC5 = "0";
        PNC6 = "0";
        PNC7 = "0";
        PNC5_1 = "0";
        PNC5_2 = "0";
        PNC5_3 = "0";


        if (rb_PNC1_yes.isChecked()) {
            PNC1 = "1";
        }
        if (rb_PNC2_yes.isChecked()) {
            PNC2 = "1";
        }
        if (rb_PNC3_yes.isChecked()) {
            PNC3 = "1";
        }
        if (rb_PNC4_yes.isChecked()) {
            PNC4 = "1";
        }
        if (rb_PNC5_yes.isChecked()) {
            PNC5 = "1";
        }
        if (rb_PNC6_yes.isChecked()) {
            PNC6 = "1";
        }
        if (rb_PNC7_yes.isChecked()) {
            PNC7 = "1";
        }
        if (rb_PNC5_1_yes.isChecked()) {
            PNC5_1 = "1";
        }
        if (rb_PNC5_2_yes.isChecked()) {
            PNC5_2 = "1";
        }

        if (rb_PNC5_3_yes.isChecked()) {
            PNC5_3 = "1";
        }


    }


    public void insertdata() {


        String query = "Update  " +
                "ttable set " +

                "PNC1='" + PNC1 + "'," +
                "PNC2='" + PNC2 + "'," +
                "PNC3='" + PNC3 + "'," +
                "PNC4='" + PNC4 + "'," +
                "PNC5='" + PNC5 + "'," +
                "PNC6='" + PNC6 + "'," +
                "PNC7='" + PNC7 + "'," +
                "PNC5_1='" + PNC5_1 + "'," +
                "PNC5_2='" + PNC5_2 + "'," +
                "PNC5_3='" + PNC5_3 + "'" +


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
                pnc.super.onBackPressed();


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
        //   globale.PNC1= PNC1;
        //   globale.PNC2= PNC2;
        //   globale.PNC3= PNC3;
        //   globale.PNC4= PNC4;
        //   globale.PNC5= PNC5;
        //   globale.PNC6= PNC6;
        //   globale.PNC7= PNC7;
        //   globale.PNC5_1= PNC5_1;
        //   globale.PNC5_2= PNC5_2;
        //   globale.PNC5_3=PNC5_3;
        //   globale.PNC11=PNC11;
        //   globale.PNC12=PNC12;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        switch (compoundButton.getId()) {


            case R.id.rb_PNC4_yes: {
                //do stuff
                if (rb_PNC4_yes.isChecked()) {

                    Lv_PNC5.setVisibility(View.VISIBLE);
                    Lv_PNC5_1.setVisibility(View.VISIBLE);
                    Lv_PNC5_2.setVisibility(View.VISIBLE);
                    Lv_PNC5_3.setVisibility(View.VISIBLE);

                }
                break;

            }


            case R.id.rb_PNC4_no: {
                //do stuff
                if (rb_PNC4_no.isChecked()) {

                    Lv_PNC5.setVisibility(View.GONE);
                    Lv_PNC5_1.setVisibility(View.GONE);
                    Lv_PNC5_2.setVisibility(View.GONE);
                    Lv_PNC5_3.setVisibility(View.GONE);

                    ClearAllcontrol.ClearAll(Lv_PNC5);
                    ClearAllcontrol.ClearAll(Lv_PNC5_1);
                    ClearAllcontrol.ClearAll(Lv_PNC5_2);
                    ClearAllcontrol.ClearAll(Lv_PNC5_3);



                }
                break;

            }


        }

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
