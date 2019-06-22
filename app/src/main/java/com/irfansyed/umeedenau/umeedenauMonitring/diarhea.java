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


public  class diarhea extends AppCompatActivity implements View.OnClickListener {









    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;

    String

            DI1	,
            DI2	,
            DI3	,
            DI4	,
            DI5	,
            DI6	,
            DI7	,
            DI8	,
            DI9	,
            DI10	,
            DI11	;


    LinearLayout

           Lv_DI1,
           Lv_DI2,
           Lv_DI3,
           Lv_DI4,
           Lv_DI5,
           Lv_DI6,
           Lv_DI7,
           Lv_DI8,
           Lv_DI9,
           Lv_DI10,
           Lv_DI11;





    RadioButton

            rb_DI1_yes,
            rb_DI2_yes,
            rb_DI3_yes,
            rb_DI4_yes,
            rb_DI5_yes,
            rb_DI6_yes,
            rb_DI7_yes,
            rb_DI8_yes,
            rb_DI9_yes,
            rb_DI10_yes,
            rb_DI11_yes,
            rb_DI1_no,
            rb_DI2_no,
            rb_DI3_no,
            rb_DI4_no,
            rb_DI5_no,
            rb_DI6_no,
            rb_DI7_no,
            rb_DI8_no,
            rb_DI9_no,
            rb_DI10_no,
            rb_DI11_no;

    Button btn_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diarrhea);
        fun_DIntia_view();




        btn_next.setOnClickListener(this);

    }




    boolean yesok=true;

    @Override
    public void onClick(View view)
    {


        if(view.getId()==R.id.btn_next_DI)
        {

            if(yes_we_are_ok()==true)
            {
                this.fun_asignment();
                insertdata();
                next_sterp();
               // Intent itt=new Intent(this,finall.class);
               // itt.putExtra("put_extra",6);
               // startActivity(itt);


                Insert_remarks();

            }

            else
            {
                Toast.makeText(this,"Some thing is missing! please Review your form.",Toast.LENGTH_LONG);
            }

        }


    }








    public void fun_DIntia_view()
    {
       Lv_DI1=(LinearLayout) findViewById(R.id.Lv_DI1);
       Lv_DI2=(LinearLayout) findViewById(R.id.Lv_DI2);
       Lv_DI3=(LinearLayout) findViewById(R.id.Lv_DI3);
       Lv_DI4=(LinearLayout) findViewById(R.id.Lv_DI4);
       Lv_DI5=(LinearLayout) findViewById(R.id.Lv_DI5);
       Lv_DI6=(LinearLayout) findViewById(R.id.Lv_DI6);
       Lv_DI7=(LinearLayout) findViewById(R.id.Lv_DI7);
       Lv_DI8=(LinearLayout) findViewById(R.id.Lv_DI8);
       Lv_DI9=(LinearLayout) findViewById(R.id.Lv_DI9);
       Lv_DI10=(LinearLayout) findViewById(R.id.Lv_DI10);
       Lv_DI11=(LinearLayout) findViewById(R.id.Lv_DI11);



        rb_DI1_yes=(RadioButton)findViewById(R.id.rb_DI1_yes);
        rb_DI2_yes=(RadioButton)findViewById(R.id.rb_DI2_yes);
        rb_DI3_yes=(RadioButton)findViewById(R.id.rb_DI3_yes);
        rb_DI4_yes=(RadioButton)findViewById(R.id.rb_DI4_yes);
        rb_DI5_yes=(RadioButton)findViewById(R.id.rb_DI5_yes);
        rb_DI6_yes=(RadioButton)findViewById(R.id.rb_DI6_yes);
        rb_DI7_yes=(RadioButton)findViewById(R.id.rb_DI7_yes);
        rb_DI8_yes=(RadioButton)findViewById(R.id.rb_DI8_yes);
        rb_DI9_yes=(RadioButton)findViewById(R.id.rb_DI9_yes);
        rb_DI10_yes=(RadioButton)findViewById(R.id.rb_DI10_yes);
        rb_DI11_yes=(RadioButton)findViewById(R.id.rb_DI11_yes);


        rb_DI1_no=(RadioButton)findViewById(R.id.rb_DI1_no);
        rb_DI2_no=(RadioButton)findViewById(R.id.rb_DI2_no);
        rb_DI3_no=(RadioButton)findViewById(R.id.rb_DI3_no);
        rb_DI4_no=(RadioButton)findViewById(R.id.rb_DI4_no);
        rb_DI5_no=(RadioButton)findViewById(R.id.rb_DI5_no);
        rb_DI6_no=(RadioButton)findViewById(R.id.rb_DI6_no);
        rb_DI7_no=(RadioButton)findViewById(R.id.rb_DI7_no);
        rb_DI8_no=(RadioButton)findViewById(R.id.rb_DI8_no);
        rb_DI9_no=(RadioButton)findViewById(R.id.rb_DI9_no);
        rb_DI10_no=(RadioButton)findViewById(R.id.rb_DI10_no);
        rb_DI11_no=(RadioButton)findViewById(R.id.rb_DI11_no);


        btn_next=(Button)findViewById(R.id.btn_next_DI);



    }



    public  boolean yes_we_are_ok()
    {

        if( fun_avioid_empty_text(Lv_DI1)==false)
        {
            return  false;
        }

        if( fun_avioid_empty_text(Lv_DI2)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI3)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI4)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI5)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI6)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI7)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI8)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI9)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI10)==false)
        {
            return  false;
        }
        if( fun_avioid_empty_text(Lv_DI11)==false)
        {
            return  false;
        }



        return  true;
    }



    public  boolean fun_avioid_empty_text(LinearLayout lv)
    {
        Boolean Yes_DIam_good=true;
        Yes_DIam_good=Gothrough.IamHiden(lv);
        if(Yes_DIam_good==false)
        {
            return  false;
        }

        return true;
    }



    public  void fun_asignment()
    {

        DI1="0";
        DI2="0";
        DI3="0";
        DI4="0";
        DI5="0";
        DI6="0";
        DI7="0";
        DI8="0";
        DI9="0";
        DI10="0";
        DI11="0";




        if(rb_DI1_yes.isChecked())
        {
            DI1="1";
        }
        if(rb_DI2_yes.isChecked())
        {
            DI2="1";
        }
        if(rb_DI3_yes.isChecked())
        {
            DI3="1";
        }
        if(rb_DI4_yes.isChecked())
        {
            DI4="1";
        }
        if(rb_DI5_yes.isChecked())
        {
            DI5="1";
        }
        if(rb_DI6_yes.isChecked())
        {
            DI6="1";
        }
        if(rb_DI7_yes.isChecked())
        {
            DI7="1";
        }
        if(rb_DI8_yes.isChecked())
        {
            DI8="1";
        }
        if(rb_DI9_yes.isChecked())
        {
            DI9="1";
        }

        if(rb_DI10_yes.isChecked())
        {
            DI10="1";
        }
        if(rb_DI11_yes.isChecked())
        {
            DI11="1";
        }










    }




    public void insertdata() {









        String query = "Update  " +
                "ttable set "+

                "DI1='"+DI1+"',"+
                "DI2='"+DI2+"',"+
                "DI3='"+DI3+"',"+
                "DI4='"+DI4+"',"+
                "DI5='"+DI5+"',"+
                "DI6='"+DI6+"',"+
                "DI7='"+DI7+"',"+
                "DI8='"+DI8+"',"+
                "DI9='"+DI9+"',"+
                "DI10='"+DI10+"',"+
                "DI11='"+DI11+"'"+




                " where id="+globale.db_pk;




        query = String.format(query);


        LocalDataManager Lm = new LocalDataManager(this);

        database.execSQL(query);

        Toast.makeText(this, "Data Saved  successfully", Toast.LENGTH_SHORT).show();


    }



    public void  fun_next_step()
    {

        globale.f_DI1=DI1;
        globale.f_DI2=DI2;
        globale.f_DI3=DI3;
        globale.f_DI4=DI4;
        globale.f_DI5=DI5;
        globale.f_DI6=DI6;
        globale.f_DI7=DI7;
        globale.f_DI8=DI8;
        globale.f_DI9=DI9;
        globale.f_DI10=DI10;
        globale.f_DI11=DI11;

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
                diarhea.super.onBackPressed();


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


    void next_sterp()
    {
                globale.DI1	=DI1;
                globale.DI2	=DI2;
                globale.DI3	=DI3;
                globale.DI4	=DI4;
                globale.DI5	=DI5;
                globale.DI6	=DI6;
                globale.DI7	=DI7;
                globale.DI8	=DI8;
                globale.DI9	=DI9;
                globale.DI10=DI10;
                globale.DI11=DI11;
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
