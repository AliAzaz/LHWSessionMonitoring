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


public class deliv extends AppCompatActivity implements View.OnClickListener, RadioButton.OnCheckedChangeListener {


//region Initialization

    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    LinearLayout

            Lv_D1,
            Lv_D2,
            Lv_D3,
            Lv_D4,
            Lv_D5,
            Lv_D6,
            Lv_D7,
            Lv_D8,
            Lv_D6_1,
            Lv_D6_2,
            Lv_D6_3,
            Lv_D6_4,
            Lv_D6_5,
            Lv_D6_6;

    RadioButton

            rb_D1_yes,
            rb_D2_yes,
            rb_D3_yes,
            rb_D4_yes,
            rb_D5_yes,
            rb_D6_yes,
            rb_D7_yes,
            rb_D8_yes,
            rb_D6_1_yes,
            rb_D6_2_yes,
            rb_D6_3_yes,
            rb_D6_4_yes,
            rb_D6_5_yes,
            rb_D6_6_yes,


    rb_D1_no,
            rb_D2_no,
            rb_D3_no,
            rb_D4_no,
            rb_D5_no,
            rb_D6_no,
            rb_D7_no,
            rb_D8_no,
            rb_D6_1_no,
            rb_D6_2_no,
            rb_D6_3_no,
            rb_D6_4_no,
            rb_D6_5_no,
            rb_D6_6_no;

    Button btn_next;
    String D1,
            D2,
            D3,
            D4,
            D5,
            D6,
            D7,
            D8,
            D6_1,
            D6_2,
            D6_3,
            D6_4,
            D6_5,
            D6_6;


    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);
        fun_intia_view();


        btn_next.setOnClickListener(this);
        rb_D6_yes.setOnCheckedChangeListener(this);
        rb_D6_no.setOnCheckedChangeListener(this);


    }


    boolean yesok = true;

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.Button_Next_D) {

            if (yes_we_are_ok() == true) {
                this.fun_asignment();
                insertdata();
                fun_next_step();
              //  Intent intt = new Intent(this, finall.class);
             //   intt.putExtra("put_extra", 2);
           //     startActivity(intt);
                Insert_remarks();

            } else {
                Toast.makeText(this, "Some thing is missing! please Review your form.", Toast.LENGTH_LONG);
            }

        }


    }


    // initilalzie VIews

    // initilalzie VIews

    public void fun_intia_view() {
        Lv_D1 = (LinearLayout) findViewById(R.id.Lv_D1);
        Lv_D2 = (LinearLayout) findViewById(R.id.Lv_D2);
        Lv_D3 = (LinearLayout) findViewById(R.id.Lv_D3);
        Lv_D4 = (LinearLayout) findViewById(R.id.Lv_D4);
        Lv_D5 = (LinearLayout) findViewById(R.id.Lv_D5);
        Lv_D6 = (LinearLayout) findViewById(R.id.Lv_D6);
        Lv_D7 = (LinearLayout) findViewById(R.id.Lv_D7);
        Lv_D8 = (LinearLayout) findViewById(R.id.Lv_D8);
        Lv_D6_1 = (LinearLayout) findViewById(R.id.Lv_D6_1);
        Lv_D6_2 = (LinearLayout) findViewById(R.id.Lv_D6_2);
        Lv_D6_3 = (LinearLayout) findViewById(R.id.Lv_D6_3);
        Lv_D6_4 = (LinearLayout) findViewById(R.id.Lv_D6_4);
        Lv_D6_5 = (LinearLayout) findViewById(R.id.Lv_D6_5);
        Lv_D6_6 = (LinearLayout) findViewById(R.id.Lv_D6_6);
        //   Lv_D15=(LinearLayout) findViewById(R.id.Lv_D15);
        //   Lv_D16=(LinearLayout) findViewById(R.id.Lv_D16);
        //   Lv_D17=(LinearLayout) findViewById(R.id.Lv_D17);
        //   Lv_D18=(LinearLayout) findViewById(R.id.Lv_D18);
        //   Lv_D19=(LinearLayout) findViewById(R.id.Lv_D19);
        //   Lv_D20=(LinearLayout) findViewById(R.id.Lv_D20);
        //   Lv_D21=(LinearLayout) findViewById(R.id.Lv_D21);
        //   Lv_D22=(LinearLayout) findViewById(R.id.Lv_D22);
        //   Lv_D23=(LinearLayout) findViewById(R.id.Lv_D23);


        rb_D1_yes = (RadioButton) findViewById(R.id.rb_D1_yes);
        rb_D2_yes = (RadioButton) findViewById(R.id.rb_D2_yes);
        rb_D3_yes = (RadioButton) findViewById(R.id.rb_D3_yes);
        rb_D4_yes = (RadioButton) findViewById(R.id.rb_D4_yes);
        rb_D5_yes = (RadioButton) findViewById(R.id.rb_D5_yes);
        rb_D6_yes = (RadioButton) findViewById(R.id.rb_D6_yes);
        rb_D7_yes = (RadioButton) findViewById(R.id.rb_D7_yes);
        rb_D8_yes = (RadioButton) findViewById(R.id.rb_D8_yes);
        rb_D6_1_yes = (RadioButton) findViewById(R.id.rb_D6_1_yes);
        rb_D6_2_yes = (RadioButton) findViewById(R.id.rb_D6_2_yes);
        rb_D6_3_yes = (RadioButton) findViewById(R.id.rb_D6_3_yes);
        rb_D6_4_yes = (RadioButton) findViewById(R.id.rb_D6_4_yes);
        rb_D6_5_yes = (RadioButton) findViewById(R.id.rb_D6_5_yes);
        rb_D6_6_yes = (RadioButton) findViewById(R.id.rb_D6_6_yes);
        //   rb_D15_yes=(RadioButton)findViewById(R.id.rb_D15_yes);
        //   rb_D16_yes=(RadioButton)findViewById(R.id.rb_D16_yes);
        //   rb_D17_yes=(RadioButton)findViewById(R.id.rb_D17_yes);
        //   rb_D18_yes=(RadioButton)findViewById(R.id.rb_D18_yes);
        //   rb_D19_yes=(RadioButton)findViewById(R.id.rb_D19_yes);
        //   rb_D20_yes=(RadioButton)findViewById(R.id.rb_D20_yes);
        //   rb_D21_yes=(RadioButton)findViewById(R.id.rb_D21_yes);
        //   rb_D22_yes=(RadioButton)findViewById(R.id.rb_D22_yes);
        //   rb_D23_yes=(RadioButton)findViewById(R.id.rb_D23_yes);

        rb_D1_no = (RadioButton) findViewById(R.id.rb_D1_no);
        rb_D2_no = (RadioButton) findViewById(R.id.rb_D2_no);
        rb_D3_no = (RadioButton) findViewById(R.id.rb_D3_no);
        rb_D4_no = (RadioButton) findViewById(R.id.rb_D4_no);
        rb_D5_no = (RadioButton) findViewById(R.id.rb_D5_no);
        rb_D6_no = (RadioButton) findViewById(R.id.rb_D6_no);
        rb_D7_no = (RadioButton) findViewById(R.id.rb_D7_no);
        rb_D8_no = (RadioButton) findViewById(R.id.rb_D8_no);
        rb_D6_1_no = (RadioButton) findViewById(R.id.rb_D6_1_no);
        rb_D6_2_no = (RadioButton) findViewById(R.id.rb_D6_2_no);
        rb_D6_3_no = (RadioButton) findViewById(R.id.rb_D6_3_no);
        rb_D6_4_no = (RadioButton) findViewById(R.id.rb_D6_4_no);
        rb_D6_5_no = (RadioButton) findViewById(R.id.rb_D6_5_no);
        rb_D6_6_no = (RadioButton) findViewById(R.id.rb_D6_6_no);
        //   rb_D15_no=(RadioButton)findViewById(R.id.rb_D15_no);
        //   rb_D16_no=(RadioButton)findViewById(R.id.rb_D16_no);
        //   rb_D17_no=(RadioButton)findViewById(R.id.rb_D17_no);
        //   rb_D18_no=(RadioButton)findViewById(R.id.rb_D18_no);
        //   rb_D19_no=(RadioButton)findViewById(R.id.rb_D19_no);
        //   rb_D20_no=(RadioButton)findViewById(R.id.rb_D20_no);
        //   rb_D21_no=(RadioButton)findViewById(R.id.rb_D21_no);
        //   rb_D22_no=(RadioButton)findViewById(R.id.rb_D22_no);
        //   rb_D23_no=(RadioButton)findViewById(R.id.rb_D23_no);


        btn_next = (Button) findViewById(R.id.Button_Next_D);


    }


    public boolean yes_we_are_ok() {

        if (fun_avioid_empty_text(Lv_D1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_D2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D5) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D7) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D8) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6_1) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6_2) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6_3) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6_4) == false) {
            return false;
        }
        if (fun_avioid_empty_text(Lv_D6_5) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_D6_6) == false) {
            return false;
        }

        //  if( fun_avioid_empty_text(Lv_D15)==false)
        //  {
        //      return  false;
        //  }

        //  if( fun_avioid_empty_text(Lv_D16)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D17)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D18)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D19)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D20)==false)
        //  {
        //      return  false;
        //  }

        //  if( fun_avioid_empty_text(Lv_D21)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D22)==false)
        //  {
        //      return  false;
        //  }
        //  if( fun_avioid_empty_text(Lv_D23)==false)
        //  {
        //      return  false;
        //  }


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

        D1 = "0";
        D2 = "0";
        D3 = "0";
        D4 = "0";
        D5 = "0";
        D6 = "0";
        D7 = "0";
        D8 = "0";
        D6_1 = "0";
        D6_2 = "0";
        D6_3 = "0";
        D6_4 = "0";
        D6_5 = "0";
        D6_6 = "0";
        //  D15="0";
        //  D16="0";
        //  D17="0";
        //  D18="0";
        //  D19="0";
        //  D20="0";
        //  D21="0";
        //  D22="0";
        //  D23="0";


        if (rb_D1_yes.isChecked()) {
            D1 = "1";
        }
        if (rb_D2_yes.isChecked()) {
            D2 = "1";
        }
        if (rb_D3_yes.isChecked()) {
            D3 = "1";
        }
        if (rb_D4_yes.isChecked()) {
            D4 = "1";
        }
        if (rb_D5_yes.isChecked()) {
            D5 = "1";
        }
        if (rb_D6_yes.isChecked()) {
            D6 = "1";
        }
        if (rb_D7_yes.isChecked()) {
            D7 = "1";
        }
        if (rb_D8_yes.isChecked()) {
            D8 = "1";
        }
        if (rb_D6_1_yes.isChecked()) {
            D6_1 = "1";
        }

        if (rb_D6_2_yes.isChecked()) {
            D6_2 = "1";
        }
        if (rb_D6_3_yes.isChecked()) {
            D6_3 = "1";
        }
        if (rb_D6_4_yes.isChecked()) {
            D6_4 = "1";
        }
        if (rb_D6_5_yes.isChecked()) {
            D1 = "1";
        }

        if (rb_D6_5_yes.isChecked()) {
            D1 = "1";
        }

        if (rb_D6_6_yes.isChecked()) {
            D6_6 = "1";
        }
        //     if(rb_D15_yes.isChecked())
        //     {
        //         D15="1";
        //     }
//
        //     if(rb_D16_yes.isChecked())
        //     {
        //         D1="1";
        //     }
        //     if(rb_D16_yes.isChecked())
        //     {
        //         D1="1";
        //     }
        //     if(rb_D17_yes.isChecked())
        //     {
        //         D17="1";
        //     }
        //     if(rb_D18_yes.isChecked())
        //     {
        //         D18="1";
        //     }
        //     if(rb_D19_yes.isChecked())
        //     {
        //         D19="1";
        //     }
        //     if(rb_D20_yes.isChecked())
        //     {
        //         D20="1";
        //     }
        //     if(rb_D21_yes.isChecked())
        //     {
        //         D21="1";
        //     }
        //     if(rb_D22_yes.isChecked())
        //     {
        //         D22="1";
        //     }
        //     if(rb_D23_yes.isChecked())
        //     {
        //         D23="1";
        //     }


    }


    public void insertdata() {


        String query = "Update  " +
                "ttable set " +

                "D1='" + D1 + "'," +
                "D2='" + D2 + "'," +
                "D3='" + D3 + "'," +
                "D4='" + D4 + "'," +
                "D5='" + D5 + "'," +
                "D6='" + D6 + "'," +
                "D7='" + D7 + "'," +
                "D8='" + D8 + "'," +
                "D6_1='" + D6_1 + "'," +
                "D6_2='" + D6_2 + "'," +
                "D6_3='" + D6_3 + "'," +
                "D6_4='" + D6_4 + "'," +
                "D6_5='" + D6_5 + "'," +
                "D6_6='" + D6_6 + "'" +
                //    "D15='"+D15+"',"+
                //    "D16='"+D16+"',"+
                //    "D17='"+D17+"',"+
                //    "D18='"+D18+"',"+
                //    "D19='"+D19+"',"+
                //    "D20='"+D20+"',"+
                //    "D21='"+D21+"',"+
                //    "D22='"+D22+"',"+
                //    "D23='"+D23+"'"+


                " where id=" + globale.db_pk;


        query = String.format(query);


        LocalDataManager Lm = new LocalDataManager(this);

        database.execSQL(query);

        Toast.makeText(this, "Data Saved  successfully", Toast.LENGTH_SHORT).show();


    }


    public void fun_next_step() {


        globale.f_D1 = D1;
        globale.f_D2 = D2;
        globale.f_D3 = D3;
        globale.f_D4 = D4;
        globale.f_D5 = D5;
        globale.f_D6 = D6;
        globale.f_D7 = D7;
        globale.f_D8 = D8;
        // globale.f_D6_1=D6_1;
        // globale.f_D6_2=D6_2;
        // globale.f_D6_3=D6_3;
        // globale.f_D6_4=D6_4;
        // globale.f_D6_5=D6_5;
        // globale.f_D6_6=D6_6;

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
                deliv.super.onBackPressed();


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


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()) {


            case R.id.rb_D6_yes: {
                //do stuff
                if (rb_D6_yes.isChecked()) {

                    Lv_D6_1.setVisibility(View.VISIBLE);
                    Lv_D6_2.setVisibility(View.VISIBLE);
                    Lv_D6_3.setVisibility(View.VISIBLE);
                    Lv_D6_4.setVisibility(View.VISIBLE);
                    Lv_D6_5.setVisibility(View.VISIBLE);
                    Lv_D6_6.setVisibility(View.VISIBLE);

                }
                break;
            }


            case R.id.rb_D6_no: {
                //do stuff
                if (rb_D6_no.isChecked()) {


                    Lv_D6_1.setVisibility(View.GONE);
                    Lv_D6_2.setVisibility(View.GONE);
                    Lv_D6_3.setVisibility(View.GONE);
                    Lv_D6_4.setVisibility(View.GONE);
                    Lv_D6_5.setVisibility(View.GONE);
                    Lv_D6_6.setVisibility(View.GONE);


                    ClearAllcontrol.ClearAll(Lv_D6_1);
                    ClearAllcontrol.ClearAll(Lv_D6_2);
                    ClearAllcontrol.ClearAll(Lv_D6_3);
                    ClearAllcontrol.ClearAll(Lv_D6_4);
                    ClearAllcontrol.ClearAll(Lv_D6_5);
                    ClearAllcontrol.ClearAll(Lv_D6_6);


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



