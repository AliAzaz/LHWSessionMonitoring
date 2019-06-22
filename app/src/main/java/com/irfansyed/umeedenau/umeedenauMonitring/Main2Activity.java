package com.irfansyed.umeedenau.umeedenauMonitring;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;


import data.LocalDataManager;
import data.col_A;
import data.oTable;
import utils.ClustorDistricts;
import utils.GpsTracker;
import utils.LocationHelper;
import utils.MyPreferences;

import static android.R.attr.format;
import static android.R.attr.streamType;
import static android.R.attr.thickness;
import static data.LocalDataManager.database;


public  class Main2Activity extends AppCompatActivity implements View.OnClickListener {









    //region Initialization


    col_A obj_tbl;

    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;
    EditText txt_b1,txt_b2;
    Button btn_gps_device,btn_gps,btn_next;
    int put_extra=0;
    MyPreferences pref;


  LinearLayout
    Lv_Q1,
          Lv_Q1_1,
    Lv_Q2,
    Lv_Q3,
    Lv_Q4,
    Lv_Q5,
    Lv_Q6,
          Lv_Q6_1,
    Lv_Q7,
    Lv_Q8,
   // Lv_Q9,
   // Lv_Q10,
      //    Lv_Q10_1,
    Lv_Q11;

  Spinner sp_Q1;

  EditText
          txt_Q2,
          txt_Q3,
          txt_Q4,
          txt_Q5,
          txt_Q6,
          txt_Q11,
          txt_Q12;

  RadioButton
          rb_Q1_1_yes,
          rb_Q1_1_no,

            rb_Q6_1_yes,
            rb_Q6_1_no,
          rb_Q7_yes,
          rb_Q7_no,
          rb_Q8_yes,
          rb_Q8_no;
         /* rb_Q9_yes,
          rb_Q9_no,
          rb_Q10_yes,
          rb_Q10_no,

    rb_Q10_1_yes,
    rb_Q10_1_no; */

  String

          Q1_1,
          Q1,
          Q2,
          Q3,
          Q4,
          Q5,
          Q6,
          Q6_1,
          Q7,
          Q8,
       /*   Q9,
          Q10,
          Q10_1, */
          Q11,
          Q12;

          String Session_on;








    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashbord);
        fun_intia_view();
        pref = new MyPreferences(Main2Activity.this);
        GetClusterNumber();


        put_extra = getIntent().getExtras().getInt("put_extra");

        btn_next.setOnClickListener(this);



        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GpsTracker gpsObj = new GpsTracker(Main2Activity.this);
                gpsObj.requestLocationUpdate(new GpsTracker.LocationCallback() {
                    @Override
                    public void onNewLocation(String gpsData) {
                        if (gpsData.split("-").length > 1) {
                            txt_b1.setText(gpsData.split("-")[0]);
                            txt_b2.setText(gpsData.split("-")[1]);
                        } else {
                            txt_b1.setText("00");
                            txt_b2.setText("00");
                        }
                    }
                });
            }
        });

//////////////////////////////////////////// get by Device gps.....................


        // to get location updates, initialize LocationResult
        this.locationResult = new LocationHelper.LocationResult(){
            @Override
            public void gotLocation(Location location){

                //Got the location!
                if(location!=null){

                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();



                    txt_b1.setText(latitude+"");
                    txt_b2.setText(longitude+"");

                    locationHelper.stopGettingLocationUpdates();
                    // here you can save the latitude and longitude values
                    // maybe in your text file or database
                    progressBar.dismiss();
                }else{
                    //Toast.makeText(getApplicationContext.this,"Kindly Turn ON Device GPS",Toast.LENGTH_LONG).show();
                    progressBar.dismiss();
                }

            }

        };






        this.locationHelper = new LocationHelper();
        btn_gps_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar = new ProgressDialog(Main2Activity.this);
                progressBar.setMessage("Searching for GPS coordinates...");
                progressBar.setCancelable(false);
                progressBar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });
                progressBar.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        locationHelper.stopGettingLocationUpdates();
                        dialog.dismiss();
                    }
                });
                progressBar.show();


                locationHelper.getLocation(Main2Activity.this,locationResult);




            }
        });




    }






    @Override
    public void onClick(View view)
    {


        if(view.getId()==R.id.btn_frag_manh_next)
        {

            if (yes_we_are_ok() == true) {





                fun_asignment();


                insertdata();
                Intent intent = null;
                if (put_extra == 1) {
                    intent = new Intent(this, preg.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else if (put_extra == 2) {
                    intent = new Intent(this, deliv.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else if (put_extra == 3) {
                    intent = new Intent(this, pnc.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else if (put_extra == 4) {
                    intent = new Intent(this, newborn.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else if (put_extra == 5) {
                    intent = new Intent(this, imm.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else if (put_extra == 6) {
                    intent = new Intent(this, pneuonia.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                } else {
                    intent = new Intent(this, diarhea.class);
                    startActivity(intent);
                    Main2Activity.this.finish();
                }


            }


        }
        else
        {
            Toast.makeText(this,"There is Some Missing values !",Toast.LENGTH_LONG);
        }

    }









    public  void fun_asignment()
    {
        Q1_1="0";
        Q1="0";
        Q2="0";
        Q3="0";
        Q4="0";
        Q5="0";
        Q6="0";
        Q6_1="0";
        Q7="0";
        Q8="0";
    /*    Q9="0";
        Q10="0";
        Q10_1="0"; */
        Q11="0";
        Q12="0";




        Q1=sp_Q1.getSelectedItem().toString();

        Q2=txt_Q2.getText().toString();
        Q3=txt_Q3.getText().toString();
        Q4=txt_Q4.getText().toString();
        Q5=txt_Q5.getText().toString();
        Q6=txt_Q6.getText().toString();


        if(rb_Q1_1_yes.isChecked())
        {
            Q1_1="1";
        }

        if(rb_Q6_1_yes.isChecked())
        {
            Q6_1="1";
        }

        if(rb_Q7_yes.isChecked())
        {
            Q7="1";
        }
        if(rb_Q8_yes.isChecked())
        {
            Q8="1";
        }

       /* if(rb_Q9_yes.isChecked())
        {
            Q9="1";
        }

        if(rb_Q10_yes.isChecked())
        {
            Q10="1";
        }
        if(rb_Q10_1_yes.isChecked())
        {
            Q10_1="1";
        }

 */
        Q11=txt_Q11.getText().toString();
        Q12=txt_Q12.getText().toString();


    }

    // initilalzie VIews

    public void fun_intia_view()
    {

        txt_b1=(EditText)findViewById(R.id.txt_Q11);
        txt_b2=(EditText)findViewById(R.id.txt_Q12);
        btn_gps=(Button)findViewById(R.id.btn_gps);
        btn_gps_device=(Button)findViewById(R.id.btn_gps_device);
        btn_next=(Button)findViewById(R.id.btn_frag_manh_next);

        Lv_Q1=(LinearLayout) findViewById(R.id.Lv_Q1);
        Lv_Q1_1=(LinearLayout) findViewById(R.id.Lv_Q1_1);
        Lv_Q2=(LinearLayout) findViewById(R.id.Lv_Q2);
        Lv_Q3=(LinearLayout) findViewById(R.id.Lv_Q3);
        Lv_Q4=(LinearLayout) findViewById(R.id.Lv_Q4);
        Lv_Q5=(LinearLayout) findViewById(R.id.Lv_Q5);
        Lv_Q6=(LinearLayout) findViewById(R.id.Lv_Q6);
        Lv_Q6_1=(LinearLayout) findViewById(R.id.Lv_Q6_1);
        Lv_Q7=(LinearLayout) findViewById(R.id.Lv_Q7);
        Lv_Q8=(LinearLayout) findViewById(R.id.Lv_Q8);
       // Lv_Q9=(LinearLayout) findViewById(R.id.Lv_Q9);
       // Lv_Q10=(LinearLayout) findViewById(R.id.Lv_Q10);
       // Lv_Q10_1=(LinearLayout) findViewById(R.id.Lv_Q10_1);

        Lv_Q11=(LinearLayout) findViewById(R.id.Lv_Q11);

        sp_Q1=(Spinner)findViewById(R.id.sp_Q1);

                txt_Q2=(EditText)findViewById(R.id. txt_Q2);
                txt_Q3=(EditText)findViewById(R.id. txt_Q3);
                txt_Q4=(EditText)findViewById(R.id. txt_Q4);
                txt_Q5=(EditText)findViewById(R.id. txt_Q5);
                txt_Q6=(EditText)findViewById(R.id. txt_Q6);
                txt_Q11=(EditText)findViewById(R.id.txt_Q11);
                txt_Q12=(EditText)findViewById(R.id.txt_Q12);



        rb_Q1_1_yes=(RadioButton)findViewById(R.id. rb_Q1_1_yes);
        rb_Q1_1_no=(RadioButton)findViewById(R.id. rb_Q1_1_no);

        rb_Q6_1_yes=(RadioButton)findViewById(R.id. rb_Q6_1_yes);
        rb_Q6_1_no=(RadioButton)findViewById(R.id. rb_Q6_1_no);
                rb_Q7_yes=(RadioButton)findViewById(R.id. rb_Q7_yes);
                rb_Q7_no=(RadioButton)findViewById(R.id.  rb_Q7_no);
                rb_Q8_yes=(RadioButton)findViewById(R.id. rb_Q8_yes);
                rb_Q8_no=(RadioButton)findViewById(R.id.  rb_Q8_no);
             //   rb_Q9_yes=(RadioButton)findViewById(R.id. rb_Q9_yes);
             //   rb_Q9_no=(RadioButton)findViewById(R.id.  rb_Q9_no);
             //   rb_Q10_yes=(RadioButton)findViewById(R.id.rb_Q10_yes);
             //   rb_Q10_no=(RadioButton)findViewById(R.id. rb_Q10_no);
      //  rb_Q10_1_yes=(RadioButton)findViewById(R.id.rb_Q10_1_yes);
      //  rb_Q10_1_no=(RadioButton)findViewById(R.id. rb_Q10_1_no);




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

    public  int  fun_compater_date(String current_date,String dp_date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(current_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = null;
        try {
            date2 = sdf.parse(dp_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        if (date1.after(date2)) {
            return  1;
        }

        if (date1.before(date2)) {
            return  0;
        }

        if (date1.equals(date2)) {
            return  0;
        }
        return  0;
    }


    public  boolean yes_we_are_ok()
    {


        if (fun_avioid_empty_text(Lv_Q1_1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q2) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q3) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q4) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q5) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q6) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q6_1) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q7) == false) {
            return false;
        }

        if (fun_avioid_empty_text(Lv_Q8) == false) {
            return false;
        }

    //    if (fun_avioid_empty_text(Lv_Q9) == false) {
    //        return false;
    //    }
//
    //    if (fun_avioid_empty_text(Lv_Q10) == false) {
    //        return false;
    //    }
//
    //    if (fun_avioid_empty_text(Lv_Q10_1) == false) {
    //        return false;
    //    }

        if (fun_avioid_empty_text(Lv_Q11) == false) {
            return false;
        }

        if (txt_Q11.getText().toString().length()==0) {
            return false;
        }

        if (txt_Q12.getText().toString().length()==0) {
            return false;
        }


        if (sp_Q1.getSelectedItem().toString().length()==0) {
            return false;
        }



        return  true;
    }





    public void insertdata() {



if(put_extra==1)
{
    Session_on="Pregnancy";

}
        if(put_extra==2)
        {
            Session_on="DELIVERY";

        }
        if(put_extra==3)
        {
            Session_on="POSTNATALCARE";

        }
        if(put_extra==4)
        {
            Session_on="NEWBORN";

        }
        if(put_extra==5)
        {
            Session_on="MMUNIZATION";

        }
        if(put_extra==6)
        {
            Session_on="PNEUMONIA";

        }
        if(put_extra==7)
        {
            Session_on="Diarrhea";

        }







//        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String Curent_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());



        String query = "insert into " +
            "ttable("
                +obj_tbl.Q1_1 +","
                +obj_tbl.Q1 +","
                +obj_tbl.Q2 +","
                +obj_tbl.Q3 +","
                +obj_tbl.Q4 +","
                +obj_tbl.Q5 +","

                +obj_tbl.Q6 +","
                +obj_tbl.Q6_1 +","
                +obj_tbl.Q7 +","
                +obj_tbl.Q8 +","
             //   +obj_tbl.Q9 +","
             //   +obj_tbl.Q10 +","
             //   +obj_tbl.Q10_1 +","
                +obj_tbl.Q11 +","
                +obj_tbl.Q12 +","


                +obj_tbl.datee +","
                +obj_tbl.timee +","

                +obj_tbl.userid +","

                +obj_tbl.Interview_status +","
                +obj_tbl.sesssion+ "," +



            "P1" +","+
    "P2"+","+
    "P3"+","+
    "P4"+","+
    "P5"+","+
    "P6"+","+
    "P7"+","+
    "P8"+","+
    "P9"+","+
    "P10"+","+
    "P11"+","+
    "P12"+","+
    "P12_1 "+","+
    "P12_2 "+","+
    "P12_3 "+","+
    "P12_4 "+","+
    "P12_5 "+","+
    "P12_6 "+","+
    "P12_7 "+","+
    "P12_8 "+","+
    "P12_9 "+","+
    "P12_10"+","+
    "P12_11"+","+
    "P12_12"+","+
    "P12_13"+","+
    "P13"+","+
    "D1"+","+
    "D2"+","+
    "D3"+","+
    "D4"+","+
    "D5"+","+
    "D6"+","+
    "D6_1  "+","+
    "D6_2  "+","+
    "D6_3  "+","+
    "D6_4  "+","+
    "D6_5  "+","+
    "D6_6  "+","+
    "D7"+","+
    "D8"+","+
    "PNC1  "+","+
    "PNC2  "+","+
    "PNC3  "+","+
    "PNC4  "+","+
    "PNC5  "+","+
    "PNC5_1"+","+
    "PNC5_2"+","+
    "PNC5_3"+","+
    "PNC6  "+","+
    "PNC7  "+","+
    "N1"+","+
    "N2"+","+
    "N3"+","+
    "N4"+","+
    "N5"+","+
    "N6"+","+
    "N7"+","+
    "N8"+","+
    "N9"+","+
    "N10"+","+
    "N11"+","+
    "N12"+","+
    "N13"+","+
    "N14"+","+
    "N15"+","+
    "N16"+","+
    "N17"+","+
    "N18"+","+
    "N19"+","+
    "N20_1 "+","+
    "N20_2 "+","+
    "N20_3 "+","+
    "N20_4 "+","+
    "N20_5 "+","+
    "N20_6 "+","+
    "N20_7 "+","+
    "N21"+","+
    "N22"+","+
    "I1"+","+
    "I2"+","+
    "I3"+","+
    "I4"+","+
    "DI1"+","+
    "DI2"+","+
    "DI3"+","+
    "DI4"+","+
    "DI5"+","+
    "DI6"+","+
    "DI7"+","+
    "DI8"+","+
    "DI9"+","+
    "DI10  "+","+
    "DI11  "+","+
    "PN1"+","+
    "PN2"+","+
    "PN3"+","+
    "PN4"+","+
    "PN5"+","+
    "PN6"+","+
    "PN7"+




    ")" +

            " values('"
                + Q1_1
                + "','" +Q1
                + "','" +Q2
                + "','" +Q3

                + "','" +Q4

                + "','" +Q5
                + "','" +Q6
                + "','" +Q6_1
                + "','" +Q7
                + "','" +Q8
             //   + "','" +Q9
             //   + "','" +Q10
             //   + "','" +Q10_1
                + "','" +Q11
                + "','" +Q12


                + "','" +Curent_date
                + "','" +timeStamp

                + "','" +obj_tbl.userid

                + "','"
                +"1', '"
                +Session_on +"',"+

                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT',"+
                "'EMPT'"+





    ")";


        query = String.format(query);


        LocalDataManager Lm = new LocalDataManager(this);

        database.execSQL(query);

        Toast.makeText(this, "Data Saved  successfully", Toast.LENGTH_SHORT).show();
        getlastinsertid();


    }



    public void getlastinsertid() {





            String  query = "SELECT  id from  ttable order by id ASC ";
            query = String.format(query);

            database.beginTransaction();
            Cursor c = database.rawQuery(query, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {


                      globale.db_pk=  c.getString(0);





                    } while (c.moveToNext());
                }
            }

            database.setTransactionSuccessful();
            database.endTransaction();
            database.close();


    }




    List<String> ClusterDiscticNumber=new ArrayList<>();
    public void GetClusterNumber() {

        String District_from_pref = pref.getLhwIds();

        if (District_from_pref!=null) {

            String[]  lhwids=District_from_pref.split("/");

            for(int i=1;i<lhwids.length;i++)
            {
                ClusterDiscticNumber.add(lhwids[i]);
            }
        }
        else
        {
            ClusterDiscticNumber.add("No Data ");
        }


        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_spinner_item, ClusterDiscticNumber);

        dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Q1.setAdapter(dataAdapterD);


        sp_Q1.setSelection(0);
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
                Main2Activity.super.onBackPressed();


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

}
