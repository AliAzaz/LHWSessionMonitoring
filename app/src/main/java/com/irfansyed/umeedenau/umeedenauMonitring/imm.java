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


public  class imm extends AppCompatActivity implements View.OnClickListener {









    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    String
        I1	,
        I2	,
        I3	,
        I4	;



    LinearLayout

            Lv_I1,
            Lv_I2,
            Lv_I3,
            Lv_I4;





    RadioButton

            rb_I1_yes,
            rb_I2_yes,
            rb_I3_yes,
            rb_I4_yes,
            rb_I1_no,
            rb_I2_no,
            rb_I3_no,
            rb_I4_no;

    Button btn_next;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immun);
        fun_intia_view();

        btn_next.setOnClickListener(this);









    }






    @Override
    public void onClick(View view)
    {



        if(view.getId()==R.id.btn_next_I)
        {

            if(yes_we_are_ok()==true)
            {
                this.fun_asignment();
                insertdata();
                next_step();
               // Intent itt=new Intent(this,finall.class);
               // itt.putExtra("put_extra",5);
               // startActivity(itt);
                Insert_remarks();


            }

            else
            {
                Toast.makeText(this,"Some thing is missing! please Review your form.",Toast.LENGTH_LONG);
            }

        }

    }









    public void fun_intia_view()
    {
        Lv_I1=(LinearLayout) findViewById(R.id.Lv_I1);
        Lv_I2=(LinearLayout) findViewById(R.id.Lv_I2);
        Lv_I3=(LinearLayout) findViewById(R.id.Lv_I3);
        Lv_I4=(LinearLayout) findViewById(R.id.Lv_I4);



        rb_I1_yes=(RadioButton)findViewById(R.id.rb_I1_yes);
        rb_I2_yes=(RadioButton)findViewById(R.id.rb_I2_yes);
        rb_I3_yes=(RadioButton)findViewById(R.id.rb_I3_yes);
        rb_I4_yes=(RadioButton)findViewById(R.id.rb_I4_yes);


        rb_I1_no=(RadioButton)findViewById(R.id.rb_I1_no);
        rb_I2_no=(RadioButton)findViewById(R.id.rb_I2_no);
        rb_I3_no=(RadioButton)findViewById(R.id.rb_I3_no);
        rb_I4_no=(RadioButton)findViewById(R.id.rb_I4_no);



        btn_next=(Button)findViewById(R.id.btn_next_I);



    }

    // switcher counter



    public  boolean yes_we_are_ok()
    {

        if( fun_avioid_empty_text(Lv_I1)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_I2)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_I3)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_I4)==false)
        {
            return  false;
        }




        return  true;
    }



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

        I1="0";
        I2="0";
        I3="0";
        I4="0";





        if(rb_I1_yes.isChecked())
        {
            I1="1";
        }
        if(rb_I2_yes.isChecked())
        {
            I2="1";
        }
        if(rb_I3_yes.isChecked())
        {
            I3="1";
        }
        if(rb_I4_yes.isChecked())
        {
            I4="1";
        }











    }




    public void insertdata() {









        String query = "Update  " +
                "ttable set "+

                "I1='"+I1+"',"+
                "I2='"+I2+"',"+
                "I3='"+I3+"',"+
                "I4='"+I4+"'"+





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
                imm.super.onBackPressed();


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



    void next_step()
    {
               globale. I1=I1;
               globale. I2=I2;
               globale. I3=I3;
               globale. I4=I4;

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
