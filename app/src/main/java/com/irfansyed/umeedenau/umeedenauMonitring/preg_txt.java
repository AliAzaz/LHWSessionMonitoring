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

import data.LocalDataManager;
import data.col_A;
import utils.LocationHelper;

import static data.LocalDataManager.database;


public  class preg_txt extends AppCompatActivity implements View.OnClickListener {


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
            Lv_P13,
            Lv_P14,
            Lv_P15,
            Lv_P16,
            Lv_P17,
            Lv_P18,
            Lv_P19,
            Lv_P20,
            Lv_P21,
            Lv_P22,
            Lv_P23,
            Lv_P24,
            Lv_P25,
            Lv_P26,
            Lv_P27;
    


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
            P13,
            P14,
            P15,
            P16,
            P17,
            P18,
            P19,
            P20,
            P21,
            P22,
            P23,
            P24,
            P25,
            P26,
            P27;



    EditText

            txt_P1,
            txt_P2,
            txt_P3,
            txt_P4,
            txt_P5,
            txt_P6,
            txt_P7,
            txt_P8,
            txt_P9,
            txt_P10,
            txt_P11,
            txt_P12,
            txt_P13,
            txt_P14,
            txt_P15,
            txt_P16,
            txt_P17,
            txt_P18,
            txt_P19,
            txt_P20,
            txt_P21,
            txt_P22,
            txt_P23,
            txt_P24,
            txt_P25,
            txt_P26,
            txt_P27;


    //endregion


    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preg_txt);
        fun_intia_view();
        fu_set_visibilty();





        btn_next.setOnClickListener(this);





    }






    @Override
    public void onClick(View view)
    {


        if(view.getId()==R.id.btn_preg_next)
        {

                this.fun_asignment();
                insertdata();

                Intent itt=new Intent(this,finall_txt.class);
                startActivity(itt);
            this.finish();


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
        Lv_P13=(LinearLayout) findViewById(R.id.Lv_P13);
        Lv_P14=(LinearLayout) findViewById(R.id.Lv_P14);
        Lv_P15=(LinearLayout) findViewById(R.id.Lv_P15);
        Lv_P16=(LinearLayout) findViewById(R.id.Lv_P16);
        Lv_P17=(LinearLayout) findViewById(R.id.Lv_P17);
        Lv_P18=(LinearLayout) findViewById(R.id.Lv_P18);
        Lv_P19=(LinearLayout) findViewById(R.id.Lv_P19);
        Lv_P20=(LinearLayout) findViewById(R.id.Lv_P20);
        Lv_P21=(LinearLayout) findViewById(R.id.Lv_P21);
        Lv_P22=(LinearLayout) findViewById(R.id.Lv_P22);
        Lv_P23=(LinearLayout) findViewById(R.id.Lv_P23);
        Lv_P24=(LinearLayout) findViewById(R.id.Lv_P24);
        Lv_P25=(LinearLayout) findViewById(R.id.Lv_P25);
        Lv_P26=(LinearLayout) findViewById(R.id.Lv_P26);
        Lv_P27=(LinearLayout) findViewById(R.id.Lv_P27);


                txt_P1=(EditText)findViewById(R.id. txt_P1);
                txt_P2=(EditText)findViewById(R.id. txt_P2);
                txt_P3=(EditText)findViewById(R.id. txt_P3);
                txt_P4=(EditText)findViewById(R.id. txt_P4);
                txt_P5=(EditText)findViewById(R.id. txt_P5);
                txt_P6=(EditText)findViewById(R.id. txt_P6);
                txt_P7=(EditText)findViewById(R.id. txt_P7);
                txt_P8=(EditText)findViewById(R.id. txt_P8);
                txt_P9=(EditText)findViewById(R.id. txt_P9);
                txt_P10=(EditText)findViewById(R.id.txt_P10);
                txt_P11=(EditText)findViewById(R.id.txt_P11);
                txt_P12=(EditText)findViewById(R.id.txt_P12);
                txt_P13=(EditText)findViewById(R.id.txt_P13);
                txt_P14=(EditText)findViewById(R.id.txt_P14);
                txt_P15=(EditText)findViewById(R.id.txt_P15);
                txt_P16=(EditText)findViewById(R.id.txt_P16);
                txt_P17=(EditText)findViewById(R.id.txt_P17);
                txt_P18=(EditText)findViewById(R.id.txt_P18);
                txt_P19=(EditText)findViewById(R.id.txt_P19);
                txt_P20=(EditText)findViewById(R.id.txt_P20);
                txt_P21=(EditText)findViewById(R.id.txt_P21);
                txt_P22=(EditText)findViewById(R.id.txt_P22);
                txt_P23=(EditText)findViewById(R.id.txt_P23);
                txt_P24=(EditText)findViewById(R.id.txt_P24);
                txt_P25=(EditText)findViewById(R.id.txt_P25);
                txt_P26=(EditText)findViewById(R.id.txt_P26);
                txt_P27=(EditText)findViewById(R.id.txt_P27);



        btn_next=(Button)findViewById(R.id.btn_preg_next);



    }




    // switcher counter






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
        P13="0";
        P14="0";
        P15="0";
        P16="0";
        P17="0";
        P18="0";
        P19="0";
        P20="0";
        P21="0";
        P22="0";
        P23="0";
        P24="0";
        P25="0";
        P26="0";
        P27="0";


        if(txt_P1.getText().toString().length()>0)
        {
            P1=txt_P1.getText().toString();
        }
        if(txt_P2.getText().toString().length()>0)
        {
            P2=txt_P2.getText().toString();
        }
        if(txt_P3.getText().toString().length()>0)
        {
            P3=txt_P3.getText().toString();
        }
        if(txt_P4.getText().toString().length()>0)
        {
            P4=txt_P4.getText().toString();
        }
        if(txt_P5.getText().toString().length()>0)
        {
            P5=txt_P5.getText().toString();
        }
        if(txt_P6.getText().toString().length()>0)
        {
            P6=txt_P6.getText().toString();
        }
        if(txt_P7.getText().toString().length()>0)
        {
            P7=txt_P7.getText().toString();
        }
        if(txt_P8.getText().toString().length()>0)
        {
            P8=txt_P8.getText().toString();
        }
        if(txt_P9.getText().toString().length()>0)
        {
            P9=txt_P9.getText().toString();
        }
        if(txt_P10.getText().toString().length()>0)
        {
            P10=txt_P10.getText().toString();
        }
        if(txt_P11.getText().toString().length()>0)
        {
            P11=txt_P11.getText().toString();
        }
        if(txt_P12.getText().toString().length()>0)
        {
            P12=txt_P12.getText().toString();
        }
        if(txt_P13.getText().toString().length()>0)
        {
            P13=txt_P13.getText().toString();
        }
        if(txt_P14.getText().toString().length()>0)
        {
            P14=txt_P14.getText().toString();
        }
        if(txt_P15.getText().toString().length()>0)
        {
            P15=txt_P15.getText().toString();
        }
        if(txt_P16.getText().toString().length()>0)
        {
            P16=txt_P16.getText().toString();
        }
        if(txt_P17.getText().toString().length()>0)
        {
            P17=txt_P17.getText().toString();
        }
        if(txt_P18.getText().toString().length()>0)
        {
            P18=txt_P18.getText().toString();
        }
        if(txt_P19.getText().toString().length()>0)
        {
            P19=txt_P19.getText().toString();
        }
        if(txt_P20.getText().toString().length()>0)
        {
            P20=txt_P20.getText().toString();
        }
        if(txt_P21.getText().toString().length()>0)
        {
            P21=txt_P21.getText().toString();
        }
        if(txt_P22.getText().toString().length()>0)
        {
            P22=txt_P22.getText().toString();
        }
        if(txt_P23.getText().toString().length()>0)
        {
            P23=txt_P23.getText().toString();
        }
        if(txt_P24.getText().toString().length()>0)
        {
            P24=txt_P24.getText().toString();
        }
        if(txt_P25.getText().toString().length()>0)
        {
            P25=txt_P25.getText().toString();
        }
        if(txt_P26.getText().toString().length()>0)
        {
            P26=txt_P26.getText().toString();
        }
        if(txt_P27.getText().toString().length()>0)
        {
            P27=txt_P27.getText().toString();
        }







    }



    public void insertdata() {









        String query = "Update  " +
                "ttable set "+
             
        "txt_P1='"+P1+"',"+
                "txt_P2='"+P2+"',"+
        "txt_P3='"+P3+"',"+
        "txt_P4='"+P4+"',"+
        "txt_P5='"+P5+"',"+
        "txt_P6='"+P6+"',"+
        "txt_P7='"+P7+"',"+
        "txt_P8='"+P8+"',"+
        "txt_P9='"+P9+"',"+
        "txt_P10='"+P10+"',"+
        "txt_P11='"+P11+"',"+
        "txt_P12='"+P12+"',"+
        "txt_P13='"+P13+"',"+
        "txt_P14='"+P14+"',"+
        "txt_P15='"+P15+"',"+
        "txt_P16='"+P16+"',"+
        "txt_P17='"+P17+"',"+
        "txt_P18='"+P18+"',"+
        "txt_P19='"+P19+"',"+
        "txt_P20='"+P20+"',"+
        "txt_P21='"+P21+"',"+
        "txt_P22='"+P22+"',"+
        "txt_P23='"+P23+"',"+
        "txt_P24='"+P24+"',"+
        "txt_P25='"+P25+"',"+
        "txt_P26='"+P26+"',"+
        "txt_P27='"+P27+"'"+

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
                preg_txt.super.onBackPressed();


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


    public void  fu_set_visibilty()
    {

                if(globale.P1.equals("0"))
                {
                    Lv_P1.setVisibility(View.GONE);
                }
        if(globale.P2.equals("0"))
        {
            Lv_P2.setVisibility(View.GONE);
        }

        if(globale.P3.equals("0"))
        {
            Lv_P3.setVisibility(View.GONE);
        }

        if(globale.P4.equals("0"))
        {
            Lv_P4.setVisibility(View.GONE);
        }

        if(globale.P5.equals("0"))
        {
            Lv_P5.setVisibility(View.GONE);
        }
        if(globale.P6.equals("0"))
        {
            Lv_P6.setVisibility(View.GONE);
        }
        if(globale.P7.equals("0"))
        {
            Lv_P7.setVisibility(View.GONE);
        }
        if(globale.P8.equals("0"))
        {
            Lv_P8.setVisibility(View.GONE);
        }

        if(globale.P9.equals("0"))
        {
            Lv_P9.setVisibility(View.GONE);
        }

        if(globale.P10.equals("0"))
        {
            Lv_P10.setVisibility(View.GONE);
        }

        if(globale.P11.equals("0"))
        {
            Lv_P11.setVisibility(View.GONE);
        }

        if(globale.P12.equals("0"))
        {
            Lv_P12.setVisibility(View.GONE);
        }

        if(globale.P13.equals("0"))
        {
            Lv_P13.setVisibility(View.GONE);
        }

      /*  if(globale.P14.equals("0"))
        {
            Lv_P14.setVisibility(View.GONE);
        }
        if(globale.P15.equals("0"))
        {
            Lv_P15.setVisibility(View.GONE);
        }

        if(globale.P16.equals("0"))
        {
            Lv_P16.setVisibility(View.GONE);
        }

        if(globale.P17.equals("0"))
        {
            Lv_P17.setVisibility(View.GONE);
        }

        if(globale.P18.equals("0"))
        {
            Lv_P18.setVisibility(View.GONE);
        }
        if(globale.P19.equals("0"))
        {
            Lv_P19.setVisibility(View.GONE);
        }

        if(globale.P20.equals("0"))
        {
            Lv_P20.setVisibility(View.GONE);
        }

        if(globale.P21.equals("0"))
        {
            Lv_P21.setVisibility(View.GONE);
        }
        if(globale.P22.equals("0"))
        {
            Lv_P22.setVisibility(View.GONE);
        }
        if(globale.P23.equals("0"))
        {
            Lv_P23.setVisibility(View.GONE);
        }
        if(globale.P24.equals("0"))
        {
            Lv_P24.setVisibility(View.GONE);
        }

        if(globale.P25.equals("0"))
        {
            Lv_P25.setVisibility(View.GONE);
        }
        if(globale.P26.equals("0"))
        {
            Lv_P26.setVisibility(View.GONE);
        }

        if(globale.P27.equals("0"))
        {
            Lv_P27.setVisibility(View.GONE);
        }

*/











    }


}
