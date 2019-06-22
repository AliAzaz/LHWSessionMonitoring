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


public  class newborn extends AppCompatActivity implements View.OnClickListener,RadioButton.OnCheckedChangeListener {


    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    LinearLayout

            Lv_N1,
            Lv_N2,
            Lv_N3,
            Lv_N4,
            Lv_N5,
            Lv_N6,
            Lv_N7,
            Lv_N8,
            Lv_N9,
            Lv_N10,
            Lv_N11,
            Lv_N12,
            Lv_N13,
            Lv_N14,
            Lv_N15,
            Lv_N16,
            Lv_N17,
            Lv_N18,
            Lv_N19,

            Lv_N21,
            Lv_N22,
            Lv_N20_1,
            Lv_N20_2,
            Lv_N20_3,
            Lv_N20_4,
            Lv_N20_5,
            Lv_N20_6,
            Lv_N20_7;


    RadioButton

            rb_N1_yes,
            rb_N2_yes,
            rb_N3_yes,
            rb_N4_yes,
            rb_N5_yes,
            rb_N6_yes,
            rb_N7_yes,
            rb_N8_yes,
            rb_N9_yes,
            rb_N10_yes,
            rb_N11_yes,
            rb_N12_yes,
            rb_N13_yes,
            rb_N14_yes,
            rb_N15_yes,
            rb_N16_yes,
            rb_N17_yes,
            rb_N18_yes,
            rb_N19_yes,

            rb_N21_yes,
            rb_N22_yes,
            rb_N20_1_yes,
            rb_N20_2_yes,
            rb_N20_3_yes,
            rb_N20_4_yes,
            rb_N20_5_yes,
            rb_N20_6_yes,
            rb_N20_7_yes,
            rb_N1_no,
            rb_N2_no,
            rb_N3_no,
            rb_N4_no,
            rb_N5_no,
            rb_N6_no,
            rb_N7_no,
            rb_N8_no,
            rb_N9_no,
            rb_N10_no,
            rb_N11_no,
            rb_N12_no,
            rb_N13_no,
            rb_N14_no,
            rb_N15_no,
            rb_N16_no,
            rb_N17_no,
            rb_N18_no,
            rb_N19_no,

            rb_N21_no,
            rb_N22_no,
            rb_N20_1_no,
            rb_N20_2_no,
            rb_N20_3_no,
            rb_N20_4_no,
            rb_N20_5_no,
            rb_N20_6_no,
            rb_N20_7_no;


    Button btn_next;


    String N1,
            N2,
            N3,
            N4,
            N5,
            N6,
            N7,
            N8,
            N9,
            N10,
            N11,
            N12,
            N13,
            N14,
            N15,
            N16,
            N17,
            N18,
            N19,

            N21,
            N22,
            N20_1,
            N20_2,
            N20_3,
            N20_4,
            N20_5,
            N20_6,
            N20_7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newborn);
        fun_intia_view();
        btn_next.setOnClickListener(this);

        rb_N19_no.setOnCheckedChangeListener(this);
        rb_N19_yes.setOnCheckedChangeListener(this);

    }


    boolean yesok = true;

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_next_new) {

            if (yes_we_are_ok() == true) {
                this.fun_asignment();
                insertdata();
                this.next_ster();
                //Intent itnn = new Intent(this, finall.class);
                //itnn.putExtra("put_extra", 4);
                //startActivity(itnn);
                Insert_remarks();


            } else {
                Toast.makeText(this, "Some thing is missing! please Review your form.", Toast.LENGTH_LONG);
            }

        }


    }


    public void fun_intia_view() {
        Lv_N1 = (LinearLayout) findViewById(R.id.Lv_N1);
        Lv_N2 = (LinearLayout) findViewById(R.id.Lv_N2);
        Lv_N3 = (LinearLayout) findViewById(R.id.Lv_N3);
        Lv_N4 = (LinearLayout) findViewById(R.id.Lv_N4);
        Lv_N5 = (LinearLayout) findViewById(R.id.Lv_N5);
        Lv_N6 = (LinearLayout) findViewById(R.id.Lv_N6);
        Lv_N7 = (LinearLayout) findViewById(R.id.Lv_N7);
        Lv_N8 = (LinearLayout) findViewById(R.id.Lv_N8);
        Lv_N9 = (LinearLayout) findViewById(R.id.Lv_N9);
        Lv_N10 = (LinearLayout) findViewById(R.id.Lv_N10);
        Lv_N11 = (LinearLayout) findViewById(R.id.Lv_N11);
        Lv_N12 = (LinearLayout) findViewById(R.id.Lv_N12);
        Lv_N13 = (LinearLayout) findViewById(R.id.Lv_N13);
        Lv_N14 = (LinearLayout) findViewById(R.id.Lv_N14);
        Lv_N15 = (LinearLayout) findViewById(R.id.Lv_N15);
        Lv_N16 = (LinearLayout) findViewById(R.id.Lv_N16);
        Lv_N17 = (LinearLayout) findViewById(R.id.Lv_N17);
        Lv_N18 = (LinearLayout) findViewById(R.id.Lv_N18);
        Lv_N19 = (LinearLayout) findViewById(R.id.Lv_N19);

        Lv_N21 = (LinearLayout) findViewById(R.id.Lv_N21);
        Lv_N22 = (LinearLayout) findViewById(R.id.Lv_N22);
        Lv_N20_1 = (LinearLayout) findViewById(R.id.Lv_N20_1);
        Lv_N20_2 = (LinearLayout) findViewById(R.id.Lv_N20_2);
        Lv_N20_3 = (LinearLayout) findViewById(R.id.Lv_N20_3);
        Lv_N20_4 = (LinearLayout) findViewById(R.id.Lv_N20_4);
        Lv_N20_5 = (LinearLayout) findViewById(R.id.Lv_N20_5);
        Lv_N20_6 = (LinearLayout) findViewById(R.id.Lv_N20_6);
        Lv_N20_7 = (LinearLayout) findViewById(R.id.Lv_N20_7);


        rb_N1_yes = (RadioButton) findViewById(R.id.rb_N1_yes);
        rb_N2_yes = (RadioButton) findViewById(R.id.rb_N2_yes);
        rb_N3_yes = (RadioButton) findViewById(R.id.rb_N3_yes);
        rb_N4_yes = (RadioButton) findViewById(R.id.rb_N4_yes);
        rb_N5_yes = (RadioButton) findViewById(R.id.rb_N5_yes);
        rb_N6_yes = (RadioButton) findViewById(R.id.rb_N6_yes);
        rb_N7_yes = (RadioButton) findViewById(R.id.rb_N7_yes);
        rb_N8_yes = (RadioButton) findViewById(R.id.rb_N8_yes);
        rb_N9_yes = (RadioButton) findViewById(R.id.rb_N9_yes);
        rb_N10_yes = (RadioButton) findViewById(R.id.rb_N10_yes);
        rb_N11_yes = (RadioButton) findViewById(R.id.rb_N11_yes);
        rb_N12_yes = (RadioButton) findViewById(R.id.rb_N12_yes);
        rb_N13_yes = (RadioButton) findViewById(R.id.rb_N13_yes);
        rb_N14_yes = (RadioButton) findViewById(R.id.rb_N14_yes);
        rb_N15_yes = (RadioButton) findViewById(R.id.rb_N15_yes);
        rb_N16_yes = (RadioButton) findViewById(R.id.rb_N16_yes);
        rb_N17_yes = (RadioButton) findViewById(R.id.rb_N17_yes);
        rb_N18_yes = (RadioButton) findViewById(R.id.rb_N18_yes);
        rb_N19_yes = (RadioButton) findViewById(R.id.rb_N19_yes);

        rb_N21_yes = (RadioButton) findViewById(R.id.rb_N21_yes);
        rb_N22_yes = (RadioButton) findViewById(R.id.rb_N22_yes);
        rb_N20_1_yes = (RadioButton) findViewById(R.id.rb_N20_1_yes);
        rb_N20_2_yes = (RadioButton) findViewById(R.id.rb_N20_2_yes);
        rb_N20_3_yes = (RadioButton) findViewById(R.id.rb_N20_3_yes);
        rb_N20_4_yes = (RadioButton) findViewById(R.id.rb_N20_4_yes);
        rb_N20_5_yes = (RadioButton) findViewById(R.id.rb_N20_5_yes);
        rb_N20_6_yes = (RadioButton) findViewById(R.id.rb_N20_6_yes);
        rb_N20_7_yes = (RadioButton) findViewById(R.id.rb_N20_7_yes);


        rb_N1_no = (RadioButton) findViewById(R.id.rb_N1_no);
        rb_N2_no = (RadioButton) findViewById(R.id.rb_N2_no);
        rb_N3_no = (RadioButton) findViewById(R.id.rb_N3_no);
        rb_N4_no = (RadioButton) findViewById(R.id.rb_N4_no);
        rb_N5_no = (RadioButton) findViewById(R.id.rb_N5_no);
        rb_N6_no = (RadioButton) findViewById(R.id.rb_N6_no);
        rb_N7_no = (RadioButton) findViewById(R.id.rb_N7_no);
        rb_N8_no = (RadioButton) findViewById(R.id.rb_N8_no);
        rb_N9_no = (RadioButton) findViewById(R.id.rb_N9_no);
        rb_N10_no = (RadioButton) findViewById(R.id.rb_N10_no);
        rb_N11_no = (RadioButton) findViewById(R.id.rb_N11_no);
        rb_N12_no = (RadioButton) findViewById(R.id.rb_N12_no);
        rb_N13_no = (RadioButton) findViewById(R.id.rb_N13_no);

        rb_N14_no = (RadioButton) findViewById(R.id.rb_N14_no);
        rb_N15_no = (RadioButton) findViewById(R.id.rb_N15_no);
        rb_N16_no = (RadioButton) findViewById(R.id.rb_N16_no);
        rb_N17_no = (RadioButton) findViewById(R.id.rb_N17_no);
        rb_N18_no = (RadioButton) findViewById(R.id.rb_N18_no);
        rb_N19_no = (RadioButton) findViewById(R.id.rb_N19_no);

        rb_N21_no = (RadioButton) findViewById(R.id.rb_N21_no);
        rb_N22_no = (RadioButton) findViewById(R.id.rb_N22_no);
        rb_N20_1_no = (RadioButton) findViewById(R.id.rb_N20_1_no);
        rb_N20_2_no = (RadioButton) findViewById(R.id.rb_N20_2_no);
        rb_N20_3_no = (RadioButton) findViewById(R.id.rb_N20_3_no);
        rb_N20_4_no = (RadioButton) findViewById(R.id.rb_N20_4_no);
        rb_N20_5_no = (RadioButton) findViewById(R.id.rb_N20_5_no);
        rb_N20_6_no = (RadioButton) findViewById(R.id.rb_N20_6_no);
        rb_N20_7_no = (RadioButton) findViewById(R.id.rb_N20_7_no);


        btn_next = (Button) findViewById(R.id.btn_next_new);


    }


    public boolean yes_we_are_ok() {

        if (fun_avioid_empty_text(Lv_N1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_N2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N5) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N6) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N7) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N8) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N9) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N10) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N11) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N12) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N13) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N14) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N15) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N16) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N17) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N18) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N19) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_N21) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N22) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_1) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_5) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_6) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_N20_7) == false) {
            return false;
        }


        return true;
    }


    public boolean fun_avioid_empty_text(LinearLayout lv)
    {
        Boolean Yes_iam_good = true;
        Yes_iam_good = Gothrough.IamHiden(lv);
        if (Yes_iam_good == false) {
            return false;
        }

        return true;
    }


    public void fun_asignment() {

        N1 = "0";
        N2 = "0";
        N3 = "0";
        N4 = "0";
        N5 = "0";
        N6 = "0";
        N7 = "0";
        N8 = "0";
        N9 = "0";
        N10 = "0";
        N11 = "0";
        N12 = "0";
        N13 = "0";
        N14 = "0";
        N15 = "0";
        N16 = "0";
        N17 = "0";
        N18 = "0";
        N19 = "0";

        N21 = "0";
        N22 = "0";
        N20_1 = "0";
        N20_2 = "0";
        N20_3 = "0";
        N20_4 = "0";
        N20_5 = "0";
        N20_6 = "0";
        N20_7 = "0";


        if (rb_N1_yes.isChecked()) {
            N1 = "1";
        }
        if (rb_N2_yes.isChecked()) {
            N2 = "1";
        }
        if (rb_N3_yes.isChecked()) {
            N3 = "1";
        }
        if (rb_N4_yes.isChecked()) {
            N4 = "1";
        }
        if (rb_N5_yes.isChecked()) {
            N5 = "1";
        }
        if (rb_N6_yes.isChecked()) {
            N6 = "1";
        }
        if (rb_N7_yes.isChecked()) {
            N7 = "1";
        }
        if (rb_N8_yes.isChecked()) {
            N8 = "1";
        }
        if (rb_N9_yes.isChecked()) {
            N9 = "1";
        }

        if (rb_N10_yes.isChecked()) {
            N10 = "1";
        }
        if (rb_N11_yes.isChecked()) {
            N11 = "1";
        }
        if (rb_N12_yes.isChecked()) {
            N12 = "1";
        }
        if (rb_N13_yes.isChecked()) {
            N13 = "1";
        }

        if (rb_N14_yes.isChecked()) {
            N14 = "1";
        }

        if (rb_N15_yes.isChecked()) {
            N15 = "1";
        }

        if (rb_N16_yes.isChecked()) {
            N16 = "1";
        }

        if (rb_N17_yes.isChecked()) {
            N17 = "1";
        }

        if (rb_N18_yes.isChecked()) {
            N18 = "1";
        }

        if (rb_N18_yes.isChecked()) {
            N18 = "1";
        }

        if (rb_N19_yes.isChecked()) {
            N19 = "1";
        }



        if (rb_N21_yes.isChecked()) {
            N21 = "1";
        }

        if (rb_N22_yes.isChecked()) {
            N22 = "1";
        }

        if (rb_N20_1_yes.isChecked()) {
            N20_1 = "1";
        }
        if (rb_N20_2_yes.isChecked()) {
            N20_2 = "1";
        }
        if (rb_N20_3_yes.isChecked()) {
            N20_3 = "1";
        }
        if (rb_N20_4_yes.isChecked()) {
            N20_4 = "1";
        }
        if (rb_N20_5_yes.isChecked()) {
            N20_5 = "1";
        }
        if (rb_N20_6_yes.isChecked()) {
            N20_6 = "1";
        }
        if (rb_N20_7_yes.isChecked()) {
            N20_7 = "1";
        }


    }


    public void insertdata() {


        String query = "Update  " +
                "ttable set " +

                "N1='" + N1 + "'," +
                "N2='" + N2 + "'," +
                "N3='" + N3 + "'," +
                "N4='" + N4 + "'," +
                "N5='" + N5 + "'," +
                "N6='" + N6 + "'," +
                "N7='" + N7 + "'," +
                "N8='" + N8 + "'," +
                "N9='" + N9 + "'," +
                "N10='" + N10 + "'," +
                "N11='" + N11 + "'," +
                "N12='" + N12 + "'," +
                "N13='" + N13 + "'," +
                "N14='" + N14 + "'," +
                "N15='" + N15 + "'," +
                "N16='" + N16 + "'," +
                "N17='" + N17 + "'," +
                "N18='" + N18 + "'," +
                "N19='" + N19 + "'," +

                "N21='" + N21 + "'," +
                "N22='" + N22 + "'," +
                "N20_1='" + N20_1 + "'," +
                "N20_2='" + N20_2 + "'," +
                "N20_3='" + N20_3 + "'," +
                "N20_4='" + N20_4 + "'," +
                "N20_5='" + N20_5 + "'," +
                "N20_6='" + N20_6 + "'," +
                "N20_7='" + N20_7 + "'" +


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
                newborn.super.onBackPressed();


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


    void next_ster() {
        ///   globale. N1=N1;
        ///   globale. N2=N2;
        ///   globale. N3=N3;
        ///   globale. N4=N4;
        ///   globale. N5=N5;
        ///   globale. N6=N6;
        ///   globale. N7=N7;
        ///   globale. N8=N8;
        ///   globale. N9=N9;
        ///    globale.N10=N10;
        ///    globale.N11=N11;
        ///    globale.N12=N12;
        ///    globale.N13=N13;
        ///    globale.N14=N14;
        ///    globale.N15=N15;
        ///    globale.N16=N16;
        ///    globale.N17=N17;
        ///    globale.N18=N18;
        ///    globale.N19=N19;
        ///    globale.N20=N20;
        ///    globale.N21=N21;
        ///    globale.N22=N22;
        ///    globale.N20_1=N20_1;
        ///    globale.N20_2=N20_2;

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()) {


            case R.id.rb_N19_yes: {
                //do stuff
                if (rb_N19_yes.isChecked()) {


                    Lv_N20_1.setVisibility(View.VISIBLE);
                    Lv_N20_2.setVisibility(View.VISIBLE);
                    Lv_N20_3.setVisibility(View.VISIBLE);
                    Lv_N20_4.setVisibility(View.VISIBLE);
                    Lv_N20_5.setVisibility(View.VISIBLE);
                    Lv_N20_6.setVisibility(View.VISIBLE);
                    Lv_N20_7.setVisibility(View.VISIBLE);

                }
                break;

            }


            case R.id.rb_N19_no: {
                //do stuff
                if (rb_N19_no.isChecked()) {


                    Lv_N20_1.setVisibility(View.GONE);
                    Lv_N20_2.setVisibility(View.GONE);
                    Lv_N20_3.setVisibility(View.GONE);
                    Lv_N20_4.setVisibility(View.GONE);
                    Lv_N20_5.setVisibility(View.GONE);
                    Lv_N20_6.setVisibility(View.GONE);
                    Lv_N20_7.setVisibility(View.GONE);


                    ClearAllcontrol.ClearAll(Lv_N20_1);
                    ClearAllcontrol.ClearAll(Lv_N20_2);
                    ClearAllcontrol.ClearAll(Lv_N20_3);
                    ClearAllcontrol.ClearAll(Lv_N20_4);
                    ClearAllcontrol.ClearAll(Lv_N20_5);
                    ClearAllcontrol.ClearAll(Lv_N20_6);
                    ClearAllcontrol.ClearAll(Lv_N20_7);


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
