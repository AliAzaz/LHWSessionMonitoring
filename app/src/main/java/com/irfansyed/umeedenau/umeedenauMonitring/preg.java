package com.irfansyed.umeedenau.umeedenauMonitring;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.LocalDataManager;
import data.col_A;
import utils.ClearAllcontrol;
import utils.GpsTracker;
import utils.LocationHelper;

import static data.LocalDataManager.database;


public  class preg extends AppCompatActivity implements View.OnClickListener, RadioButton.OnCheckedChangeListener {








//region  Intialization
    col_A obj_tbl;
    LinearLayout
            Lv_P1,
            Lv_P2,
            Lv_P3,
            Lv_P4,
            Lv_P5,
            Lv_P6,
            Lv_P7,
            Lv_P8,
            Lv_P9,
            Lv_P10,
            Lv_P11,
            Lv_P12,
            Lv_P12_1,
            Lv_P12_2,
            Lv_P12_3,
            Lv_P12_4,
            Lv_P12_5,
            Lv_P12_6,
            Lv_P12_7,
            Lv_P12_8,
            Lv_P12_9,
            Lv_P12_10,
            Lv_P12_11,
            Lv_P12_12,
            Lv_P12_13,
            Lv_P13;
    
    
    RadioButton

    rb_P1_yes,
    rb_P2_yes,
    rb_P3_yes,
    rb_P4_yes,
    rb_P5_yes,
    rb_P6_yes,
    rb_P7_yes,
    rb_P8_yes,
    rb_P9_yes,
    rb_P10_yes,
    rb_P11_yes,
    rb_P12_yes,
    rb_P12_1_yes,
    rb_P12_2_yes,
    rb_P12_3_yes,
    rb_P12_4_yes,
    rb_P12_5_yes,
    rb_P12_6_yes,
    rb_P12_7_yes,
    rb_P12_8_yes,
    rb_P12_9_yes,
    rb_P12_10_yes,
    rb_P12_11_yes,
    rb_P12_12_yes,
    rb_P12_13_yes,
    rb_P13_yes,
    rb_P1_no,
    rb_P2_no,
    rb_P3_no,
    rb_P4_no,
    rb_P5_no,
    rb_P6_no,
    rb_P7_no,
    rb_P8_no,
    rb_P9_no,
    rb_P10_no,
    rb_P11_no,
    rb_P12_no,
    rb_P12_1_no,
    rb_P12_2_no,
    rb_P12_3_no,
    rb_P12_4_no,
    rb_P12_5_no,
    rb_P12_6_no,
    rb_P12_7_no,
    rb_P12_8_no,
    rb_P12_9_no,
    rb_P12_10_no,
    rb_P12_11_no,
    rb_P12_12_no,
    rb_P12_13_no,
    rb_P13_no;



    Button btn_next;

    String
            P1,
            P2,
            P3,
            P4,
            P5,
            P6,
            P7,
            P8,
            P9,
            P10,
            P11,
            P12,
            P12_1,
            P12_2,
            P12_3,
            P12_4,
            P12_5,
            P12_6,
            P12_7,
            P12_8,
            P12_9,
            P12_10,
            P12_11,
            P12_12,
            P12_13,
            P13;


    //endregion


    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preg);
        fun_intia_view();






        btn_next.setOnClickListener(this);


        rb_P12_no.setOnCheckedChangeListener(this);
        rb_P12_yes.setOnCheckedChangeListener(this);



    }






    @Override
    public void onClick(View view)
    {


        if(view.getId()==R.id.btn_preg_next)
        {

            if(yes_we_are_ok()==true)
            {
                this.fun_asignment();
                insertdata();
                fun_next_step();



                Insert_remarks();





            }

            else
            {
                Toast.makeText(this,"Some thing is missing! please Review your form.",Toast.LENGTH_LONG);
            }

        }




    }









    // initilalzie VIews

    public void fun_intia_view()
    {
        Lv_P1=(LinearLayout) findViewById(R.id.Lv_P1);
        Lv_P2=(LinearLayout) findViewById(R.id.Lv_P2);
        Lv_P3=(LinearLayout) findViewById(R.id.Lv_P3);
        Lv_P4=(LinearLayout) findViewById(R.id.Lv_P4);
        Lv_P5=(LinearLayout) findViewById(R.id.Lv_P5);
        Lv_P6=(LinearLayout) findViewById(R.id.Lv_P6);
        Lv_P7=(LinearLayout) findViewById(R.id.Lv_P7);
        Lv_P8=(LinearLayout) findViewById(R.id.Lv_P8);
        Lv_P9=(LinearLayout) findViewById(R.id.Lv_P9);
        Lv_P10=(LinearLayout) findViewById(R.id.Lv_P10);
        Lv_P11=(LinearLayout) findViewById(R.id.Lv_P11);
        Lv_P12=(LinearLayout) findViewById(R.id.Lv_P12);
        Lv_P12_1=(LinearLayout) findViewById(R.id.Lv_P12_1);
        Lv_P12_2=(LinearLayout) findViewById(R.id.Lv_P12_2);
        Lv_P12_3=(LinearLayout) findViewById(R.id.Lv_P12_3);
        Lv_P12_4=(LinearLayout) findViewById(R.id.Lv_P12_4);
        Lv_P12_5=(LinearLayout) findViewById(R.id.Lv_P12_5);
        Lv_P12_6=(LinearLayout) findViewById(R.id.Lv_P12_6);
        Lv_P12_7=(LinearLayout) findViewById(R.id.Lv_P12_7);
        Lv_P12_8=(LinearLayout) findViewById(R.id.Lv_P12_8);
        Lv_P12_9=(LinearLayout) findViewById(R.id.Lv_P12_9);
        Lv_P12_10=(LinearLayout) findViewById(R.id.Lv_P12_10);
        Lv_P12_11=(LinearLayout) findViewById(R.id.Lv_P12_11);
        Lv_P12_12=(LinearLayout) findViewById(R.id.Lv_P12_12);
        Lv_P12_13=(LinearLayout) findViewById(R.id.Lv_P12_13);
        Lv_P13=(LinearLayout) findViewById(R.id.Lv_P13);


        rb_P1_yes=(RadioButton)findViewById(R.id.rb_P1_yes);
        rb_P2_yes=(RadioButton)findViewById(R.id.rb_P2_yes);
        rb_P3_yes=(RadioButton)findViewById(R.id.rb_P3_yes);
        rb_P4_yes=(RadioButton)findViewById(R.id.rb_P4_yes);
        rb_P5_yes=(RadioButton)findViewById(R.id.rb_P5_yes);
        rb_P6_yes=(RadioButton)findViewById(R.id.rb_P6_yes);
        rb_P7_yes=(RadioButton)findViewById(R.id.rb_P7_yes);
        rb_P8_yes=(RadioButton)findViewById(R.id.rb_P8_yes);
        rb_P9_yes=(RadioButton)findViewById(R.id.rb_P9_yes);
        rb_P10_yes=(RadioButton)findViewById(R.id.rb_P10_yes);
        rb_P11_yes=(RadioButton)findViewById(R.id.rb_P11_yes);
        rb_P12_yes=(RadioButton)findViewById(R.id.rb_P12_yes);
        rb_P12_1_yes=(RadioButton)findViewById(R.id.rb_P12_1_yes);
        rb_P12_2_yes=(RadioButton)findViewById(R.id.rb_P12_2_yes);
        rb_P12_3_yes=(RadioButton)findViewById(R.id.rb_P12_3_yes);
        rb_P12_4_yes=(RadioButton)findViewById(R.id.rb_P12_4_yes);
        rb_P12_5_yes=(RadioButton)findViewById(R.id.rb_P12_5_yes);
        rb_P12_6_yes=(RadioButton)findViewById(R.id.rb_P12_6_yes);
        rb_P12_7_yes=(RadioButton)findViewById(R.id.rb_P12_7_yes);
        rb_P12_8_yes=(RadioButton)findViewById(R.id.rb_P12_8_yes);
        rb_P12_9_yes=(RadioButton)findViewById(R.id.rb_P12_9_yes);
        rb_P12_10_yes=(RadioButton)findViewById(R.id.rb_P12_10_yes);
        rb_P12_11_yes=(RadioButton)findViewById(R.id.rb_P12_11_yes);
        rb_P12_12_yes=(RadioButton)findViewById(R.id.rb_P12_12_yes);
        rb_P12_13_yes=(RadioButton)findViewById(R.id.rb_P12_13_yes);
        rb_P13_yes=(RadioButton)findViewById(R.id.rb_P13_yes);

        rb_P1_no=(RadioButton)findViewById(R.id.rb_P1_no);
        rb_P2_no=(RadioButton)findViewById(R.id.rb_P2_no);
        rb_P3_no=(RadioButton)findViewById(R.id.rb_P3_no);
        rb_P4_no=(RadioButton)findViewById(R.id.rb_P4_no);
        rb_P5_no=(RadioButton)findViewById(R.id.rb_P5_no);
        rb_P6_no=(RadioButton)findViewById(R.id.rb_P6_no);
        rb_P7_no=(RadioButton)findViewById(R.id.rb_P7_no);
        rb_P8_no=(RadioButton)findViewById(R.id.rb_P8_no);
        rb_P9_no=(RadioButton)findViewById(R.id.rb_P9_no);
        rb_P10_no=(RadioButton)findViewById(R.id.rb_P10_no);
        rb_P11_no=(RadioButton)findViewById(R.id.rb_P11_no);
        rb_P12_no=(RadioButton)findViewById(R.id.rb_P12_no);
        rb_P12_1_no=(RadioButton)findViewById(R.id.rb_P12_1_no);
        rb_P12_2_no=(RadioButton)findViewById(R.id.rb_P12_2_no);
        rb_P12_3_no=(RadioButton)findViewById(R.id.rb_P12_3_no);
        rb_P12_4_no=(RadioButton)findViewById(R.id.rb_P12_4_no);
        rb_P12_5_no=(RadioButton)findViewById(R.id.rb_P12_5_no);
        rb_P12_6_no=(RadioButton)findViewById(R.id.rb_P12_6_no);
        rb_P12_7_no=(RadioButton)findViewById(R.id.rb_P12_7_no);
        rb_P12_8_no=(RadioButton)findViewById(R.id.rb_P12_8_no);
        rb_P12_9_no=(RadioButton)findViewById(R.id.rb_P12_9_no);
        rb_P12_10_no=(RadioButton)findViewById(R.id.rb_P12_10_no);
        rb_P12_11_no=(RadioButton)findViewById(R.id.rb_P12_11_no);
        rb_P12_12_no=(RadioButton)findViewById(R.id.rb_P12_12_no);
        rb_P12_13_no=(RadioButton)findViewById(R.id.rb_P12_13_no);
        rb_P13_no=(RadioButton)findViewById(R.id.rb_P13_no);


        btn_next=(Button)findViewById(R.id.btn_preg_next);



    }


    public  boolean yes_we_are_ok()
    {

       if( fun_avioid_empty_text(Lv_P1)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_P2)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P3)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P4)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P5)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P6)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P7)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P8)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P9)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P10)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P11)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_1)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_P12_2)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_P12_3)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_P12_4)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_5)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_6)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_7)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_8)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_P12_9)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_10)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_11)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_12)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P12_13)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_P13)==false)
        {
            return  false;
        }




        return  true;
    }

    // switcher counter



    public  boolean fun_avioid_empty_text(LinearLayout lv)
    {
        Boolean Yes_iam_good=true;
        Yes_iam_good=Gothrough.IamHiden(lv);
        if(Yes_iam_good==false)
        {
            return  false;
        }

        return true;
    }





    public  void fun_asignment()
    {

        P1="0";
        P2="0";
        P3="0";
        P4="0";
        P5="0";
        P6="0";
        P7="0";
        P8="0";
        P9="0";
        P10="0";
        P11="0";
        P12="0";
        P12_1="0";
        P12_2="0";
        P12_3="0";
        P12_4="0";
        P12_5="0";
        P12_6="0";
        P12_7="0";
        P12_8="0";
        P12_9="0";
        P12_10="0";
        P12_11="0";
        P12_12="0";
        P12_13="0";
        P13="0";



        if(rb_P1_yes.isChecked())
        {
            P1="1";
        }
        if(rb_P2_yes.isChecked())
        {
            P2="1";
        }
        if(rb_P3_yes.isChecked())
        {
            P3="1";
        }
        if(rb_P4_yes.isChecked())
        {
            P4="1";
        }
        if(rb_P5_yes.isChecked())
        {
            P5="1";
        }
        if(rb_P6_yes.isChecked())
        {
            P6="1";
        }
        if(rb_P7_yes.isChecked())
        {
            P7="1";
        }
        if(rb_P8_yes.isChecked())
        {
            P8="1";
        }
        if(rb_P9_yes.isChecked())
        {
            P9="1";
        }

        if(rb_P10_yes.isChecked())
        {
            P10="1";
        }
        if(rb_P11_yes.isChecked())
        {
            P11="1";
        }
        if(rb_P12_yes.isChecked())
        {
            P12="1";
        }
        if(rb_P12_1_yes.isChecked())
        {
            P1="1";
        }

        if(rb_P12_1_yes.isChecked())
        {
            P1="1";
        }

        if(rb_P12_2_yes.isChecked())
        {
            P12_2="1";
        }
        if(rb_P12_3_yes.isChecked())
        {
            P12_3="1";
        }

        if(rb_P12_4_yes.isChecked())
        {
            P1="1";
        }
        if(rb_P12_4_yes.isChecked())
        {
            P1="1";
        }
        if(rb_P12_5_yes.isChecked())
        {
            P12_5="1";
        }
        if(rb_P12_6_yes.isChecked())
        {
            P12_6="1";
        }
        if(rb_P12_7_yes.isChecked())
        {
            P12_7="1";
        }
        if(rb_P12_8_yes.isChecked())
        {
            P12_8="1";
        }
        if(rb_P12_9_yes.isChecked())
        {
            P12_9="1";
        }
        if(rb_P12_10_yes.isChecked())
        {
            P12_10="1";
        }
        if(rb_P12_11_yes.isChecked())
        {
            P12_11="1";
        }
        if(rb_P12_12_yes.isChecked())
        {
            P12_12="1";
        }
        if(rb_P12_13_yes.isChecked())
        {
            P12_13="1";
        }
        if(rb_P13_yes.isChecked())
        {
            P13="1";
        }










    }



    public void insertdata() {









        String query = "Update  " +
                "ttable set "+
             
        "P1='"+P1+"',"+ 
                "P2='"+P2+"',"+
        "P3='"+P3+"',"+
        "P4='"+P4+"',"+
        "P5='"+P5+"',"+
        "P6='"+P6+"',"+
        "P7='"+P7+"',"+
        "P8='"+P8+"',"+
        "P9='"+P9+"',"+
        "P10='"+P10+"',"+
        "P11='"+P11+"',"+
        "P12='"+P12+"',"+
        "P12_1='"+P12_1+"',"+
        "P12_2='"+P12_2+"',"+
        "P12_3='"+P12_3+"',"+
        "P12_4='"+P12_4+"',"+
        "P12_5='"+P12_5+"',"+
        "P12_6='"+P12_6+"',"+
        "P12_7='"+P12_7+"',"+
        "P12_8='"+P12_8+"',"+
        "P12_9='"+P12_9+"',"+
        "P12_10='"+P12_10+"',"+
        "P12_11='"+P12_11+"',"+
        "P12_12='"+P12_12+"',"+
        "P12_13='"+P12_13+"',"+
        "P13='"+P13+"'"+


                " where id="+globale.db_pk;




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
            public void onClick(View view)
            {
                preg.super.onBackPressed();


                b.cancel();
            }
        });

        btnPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                b.cancel();

            }
        });




        //show dialog
        b.show();

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

    public void  fun_next_step()
    {

                globale.P1=P1;
                globale.P2=P2;
                globale.P3=P3;
                globale.P4=P4;
                globale.P5=P5;
                globale.P6=P6;
                globale.P7=P7;
                globale.P8=P8;
                globale.P9=P9;
                globale.P10=P10;
                globale.P11=P11;
                globale.P12=P12;
                globale.P12_1=P12_1;
                globale.P12_2=P12_2;
                globale.P12_3=P12_3;
                globale.P12_4=P12_4;
                globale.P12_5=P12_5;
                globale.P12_6=P12_6;
                globale.P12_7=P12_7;
                globale.P12_8=P12_8;
                globale.P12_9=P12_9;
                globale.P12_10=P12_10;
                globale.P12_11=P12_11;
                globale.P12_12=P12_12;
                globale.P12_13=P12_13;
                globale.P13=P13;


    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()) {


            case R.id.rb_P12_yes: {
                //do stuff
                if (rb_P12_yes.isChecked()) {


                    Lv_P12_1.setVisibility(View.VISIBLE);
                    Lv_P12_2.setVisibility(View.VISIBLE);
                    Lv_P12_3.setVisibility(View.VISIBLE);
                    Lv_P12_4.setVisibility(View.VISIBLE);
                    Lv_P12_5.setVisibility(View.VISIBLE);
                    Lv_P12_6.setVisibility(View.VISIBLE);
                    Lv_P12_7.setVisibility(View.VISIBLE);
                    Lv_P12_8.setVisibility(View.VISIBLE);
                    Lv_P12_9.setVisibility(View.VISIBLE);
                    Lv_P12_10.setVisibility(View.VISIBLE);
                    Lv_P12_11.setVisibility(View.VISIBLE);
                    Lv_P12_12.setVisibility(View.VISIBLE);
                    Lv_P12_13.setVisibility(View.VISIBLE);
                }
                break;

                }


            case R.id.rb_P12_no: {
                //do stuff
                if (rb_P12_no.isChecked()) {


                    Lv_P12_1.setVisibility(View.GONE);
                    Lv_P12_2.setVisibility(View.GONE);
                    Lv_P12_3.setVisibility(View.GONE);
                    Lv_P12_4.setVisibility(View.GONE);
                    Lv_P12_5.setVisibility(View.GONE);
                    Lv_P12_6.setVisibility(View.GONE);
                    Lv_P12_7.setVisibility(View.GONE);
                    Lv_P12_8.setVisibility(View.GONE);
                    Lv_P12_9.setVisibility(View.GONE);
                    Lv_P12_10.setVisibility(View.GONE);
                    Lv_P12_11.setVisibility(View.GONE);
                    Lv_P12_12.setVisibility(View.GONE);
                    Lv_P12_13.setVisibility(View.GONE);




                    ClearAllcontrol.ClearAll(Lv_P12_1);
                    ClearAllcontrol.ClearAll(        Lv_P12_2);
                    ClearAllcontrol.ClearAll(Lv_P12_3);
                    ClearAllcontrol.ClearAll(        Lv_P12_4);
                    ClearAllcontrol.ClearAll(Lv_P12_5);
                    ClearAllcontrol.ClearAll(        Lv_P12_6);
                    ClearAllcontrol.ClearAll(Lv_P12_7);
                    ClearAllcontrol.ClearAll(        Lv_P12_8);
                    ClearAllcontrol.ClearAll(Lv_P12_9);

                    ClearAllcontrol.ClearAll(Lv_P12_10);
                    ClearAllcontrol.ClearAll(        Lv_P12_11);
                    ClearAllcontrol.ClearAll(Lv_P12_12);
                    ClearAllcontrol.ClearAll(        Lv_P12_13);








                }
                break;

            }


        }

    }
}
