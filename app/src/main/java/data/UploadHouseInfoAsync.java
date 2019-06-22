package data;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;


import utils.MyPreferences;
import utils.PostRequestData;
import utils.QuestionModel;



import static data.LocalDataManager.database;

/**
 * Created by Umeed-e-Nau on 12/28/2016.
 */
public class UploadHouseInfoAsync extends AsyncTask {

Context mContext;
public static ProgressDialog dialog;
HashMap<String, String> param;
String[] interviewLogData;
String mUserMsg;

 MyPreferences prefs;
public UploadHouseInfoAsync(Context context) {

//stop interview
 // if(InterviewUploadingStatus.status<2)
 // this.cancel(false);

mContext = context;
dialog = new ProgressDialog(context);
param = new HashMap<>();


 prefs = new MyPreferences(mContext);
}

@Override
protected void onPreExecute() {

dialog.setMessage("Uploading interview Please wait ....");
dialog.setCancelable(false);
dialog.show();



HashMap<String, List<String>> map = QuestionModel.quest.get("a");




//region Query

String query ="select" +

" Q11,"
 +" Q12,"
 +" Q1_1 ,"
 +" Q1 ,"
 +" Q2 ,"
 +" Q3 ,"
 +" Q4 ,"
 +" Q5 ,"
 +" Q6 ,"
 +" Q6_1 ,"
 +" Q7 ,"
 +" Q8 ,"
 +" P1 ,"
 +" P2 ,"
 +" P3 ,"
 +" P4 ,"
 +" P5 ,"
 +" P6 ,"
 +" P7 ,"
 +" P8 ,"
 +" P9 ,"
 +" P10,"
 +" P11,"
 +" P12,"
 +" P12_1,"
 +" P12_2,"
 +" P12_3,"
 +" P12_4,"
 +" P12_5,"
 +" P12_6,"
 +" P12_7,"
 +" P12_8,"
 +" P12_9,"
 +" P12_10 ,"
 +" P12_11 ,"
 +" P12_12 ,"
 +" P12_13 ,"
 +" P13,"
 +" D1,"
 +" D2,"
 +" D3,"
 +" D4,"
 +" D5,"
 +" D6,"
 +" D6_1 ,"
 +" D6_2 ,"
 +" D6_3 ,"
 +" D6_4 ,"
 +" D6_5 ,"
 +" D6_6 ,"
 +" D7,"
 +" D8,"
 +" PNC1 ,"
 +" PNC2 ,"
 +" PNC3 ,"
 +" PNC4 ,"
 +" PNC5 ,"
 +" PNC5_1 ,"
 +" PNC5_2 ,"
 +" PNC5_3 ,"
 +" PNC6 ,"
 +" PNC7 ,"
 +" N1,"
 +" N2,"
 +" N3,"
 +" N4,"
 +" N5,"
 +" N6,"
 +" N7,"
 +" N8,"
 +" N9,"
 +" N10,"
 +" N11,"
 +" N12,"
 +" N13,"
 +" N14,"
 +" N15,"
 +" N16,"
 +" N17,"
 +" N18,"
 +" N19,"
 +" N20_1,"
 +" N20_2,"
 +" N20_3,"
 +" N20_4,"
 +" N20_5,"
 +" N20_6,"
 +" N20_7,"
 +" N21,"
 +" N22,"
 +" I1 ,"
 +" I2 ,"
 +" I3 ,"
 +" I4 ,"
 +" DI1,"
 +" DI2,"
 +" DI3,"
 +" DI4,"
 +" DI5,"
 +" DI6,"
 +" DI7,"
 +" DI8,"
 +" DI9,"
 +" DI10 ,"
 +" DI11 ,"
 +" PN1,"
 +" PN2,"
 +" PN3,"
 +" PN4,"
 +" PN5,"
 +" PN6,"
 +" PN7,"+

"datee,"+
"timee,"+
"userid,"+
"Interview_status,"+
"sesssion, remarks"+



" from ttable where id = '%s' order by id desc LIMIT 1";



//query="select * from hfa h join tbllog lg on h.id=lg.hfa_idwhere h.id = %s ORDER BY h.id desc LIMIT 1";
query = String.format(query, col_A.data_upload_id);

LocalDataManager Lm=new LocalDataManager(mContext);
Cursor c = Lm.database.rawQuery(query, null);




if (c != null) {
if (c.moveToFirst())
{

param.put("Q11", c.getString(c.getColumnIndex("Q11")));
param.put("Q12", c.getString(c.getColumnIndex("Q12")));
param.put("Q1_1", c.getString(c.getColumnIndex("Q1_1")));
param.put("Q1", c.getString(c.getColumnIndex("Q1")));
param.put("Q2", c.getString(c.getColumnIndex("Q2")));
param.put("Q3", c.getString(c.getColumnIndex("Q3")));
param.put("Q4", c.getString(c.getColumnIndex("Q4")));
param.put("Q5", c.getString(c.getColumnIndex("Q5")));
param.put("Q6", c.getString(c.getColumnIndex("Q6")));
param.put("Q6_1", c.getString(c.getColumnIndex("Q6_1")));
param.put("Q7", c.getString(c.getColumnIndex("Q7")));
param.put("Q8", c.getString(c.getColumnIndex("Q8")));
param.put("P1", c.getString(c.getColumnIndex("P1")));
param.put("P2", c.getString(c.getColumnIndex("P2")));
param.put("P3", c.getString(c.getColumnIndex("P3")));
param.put("P4", c.getString(c.getColumnIndex("P4")));
param.put("P5", c.getString(c.getColumnIndex("P5")));
param.put("P6", c.getString(c.getColumnIndex("P6")));
param.put("P7", c.getString(c.getColumnIndex("P7")));
param.put("P8", c.getString(c.getColumnIndex("P8")));
param.put("P9", c.getString(c.getColumnIndex("P9")));
param.put("P10", c.getString(c.getColumnIndex("P10")));
param.put("P11", c.getString(c.getColumnIndex("P11")));
param.put("P12", c.getString(c.getColumnIndex("P12")));
param.put("P12_1", c.getString(c.getColumnIndex("P12_1")));
param.put("P12_2", c.getString(c.getColumnIndex("P12_2")));
param.put("P12_3", c.getString(c.getColumnIndex("P12_3")));
param.put("P12_4", c.getString(c.getColumnIndex("P12_4")));
param.put("P12_5", c.getString(c.getColumnIndex("P12_5")));
param.put("P12_6", c.getString(c.getColumnIndex("P12_6")));
param.put("P12_7", c.getString(c.getColumnIndex("P12_7")));
param.put("P12_8", c.getString(c.getColumnIndex("P12_8")));
param.put("P12_9", c.getString(c.getColumnIndex("P12_9")));
param.put("P12_10", c.getString(c.getColumnIndex("P12_10")));
param.put("P12_11", c.getString(c.getColumnIndex("P12_11")));
param.put("P12_12", c.getString(c.getColumnIndex("P12_12")));
param.put("P12_13", c.getString(c.getColumnIndex("P12_13")));
param.put("P13", c.getString(c.getColumnIndex("P13")));
param.put("D1", c.getString(c.getColumnIndex("D1")));
param.put("D2", c.getString(c.getColumnIndex("D2")));
param.put("D3", c.getString(c.getColumnIndex("D3")));
param.put("D4", c.getString(c.getColumnIndex("D4")));
param.put("D5", c.getString(c.getColumnIndex("D5")));
param.put("D6", c.getString(c.getColumnIndex("D6")));
param.put("D6_1", c.getString(c.getColumnIndex("D6_1")));
param.put("D6_2", c.getString(c.getColumnIndex("D6_2")));
param.put("D6_3", c.getString(c.getColumnIndex("D6_3")));
param.put("D6_4", c.getString(c.getColumnIndex("D6_4")));
param.put("D6_5", c.getString(c.getColumnIndex("D6_5")));
param.put("D6_6", c.getString(c.getColumnIndex("D6_6")));
param.put("D7", c.getString(c.getColumnIndex("D7")));
param.put("D8", c.getString(c.getColumnIndex("D8")));
param.put("PNC1", c.getString(c.getColumnIndex("PNC1")));
param.put("PNC2", c.getString(c.getColumnIndex("PNC2")));
param.put("PNC3", c.getString(c.getColumnIndex("PNC3")));
param.put("PNC4", c.getString(c.getColumnIndex("PNC4")));
param.put("PNC5", c.getString(c.getColumnIndex("PNC5")));
param.put("PNC5_1", c.getString(c.getColumnIndex("PNC5_1")));
param.put("PNC5_2", c.getString(c.getColumnIndex("PNC5_2")));
param.put("PNC5_3", c.getString(c.getColumnIndex("PNC5_3")));
param.put("PNC6", c.getString(c.getColumnIndex("PNC6")));
param.put("PNC7", c.getString(c.getColumnIndex("PNC7")));
param.put("N1", c.getString(c.getColumnIndex("N1")));
param.put("N2", c.getString(c.getColumnIndex("N2")));
param.put("N3", c.getString(c.getColumnIndex("N3")));
param.put("N4", c.getString(c.getColumnIndex("N4")));
param.put("N5", c.getString(c.getColumnIndex("N5")));
param.put("N6", c.getString(c.getColumnIndex("N6")));
param.put("N7", c.getString(c.getColumnIndex("N7")));
param.put("N8", c.getString(c.getColumnIndex("N8")));
param.put("N9", c.getString(c.getColumnIndex("N9")));
param.put("N10", c.getString(c.getColumnIndex("N10")));
param.put("N11", c.getString(c.getColumnIndex("N11")));
param.put("N12", c.getString(c.getColumnIndex("N12")));
param.put("N13", c.getString(c.getColumnIndex("N13")));
param.put("N14", c.getString(c.getColumnIndex("N14")));
param.put("N15", c.getString(c.getColumnIndex("N15")));
param.put("N16", c.getString(c.getColumnIndex("N16")));
param.put("N17", c.getString(c.getColumnIndex("N17")));
param.put("N18", c.getString(c.getColumnIndex("N18")));
param.put("N19", c.getString(c.getColumnIndex("N19")));
param.put("N20_1", c.getString(c.getColumnIndex("N20_1")));
param.put("N20_2", c.getString(c.getColumnIndex("N20_2")));
param.put("N20_3", c.getString(c.getColumnIndex("N20_3")));
param.put("N20_4", c.getString(c.getColumnIndex("N20_4")));
param.put("N20_5", c.getString(c.getColumnIndex("N20_5")));
param.put("N20_6", c.getString(c.getColumnIndex("N20_6")));
param.put("N20_7", c.getString(c.getColumnIndex("N20_7")));
param.put("N21", c.getString(c.getColumnIndex("N21")));
param.put("N22", c.getString(c.getColumnIndex("N22")));
param.put("I1", c.getString(c.getColumnIndex("I1")));
param.put("I2", c.getString(c.getColumnIndex("I2")));
param.put("I3", c.getString(c.getColumnIndex("I3")));
param.put("I4", c.getString(c.getColumnIndex("I4")));
param.put("DI1", c.getString(c.getColumnIndex("DI1")));
param.put("DI2", c.getString(c.getColumnIndex("DI2")));
param.put("DI3", c.getString(c.getColumnIndex("DI3")));
param.put("DI4", c.getString(c.getColumnIndex("DI4")));
param.put("DI5", c.getString(c.getColumnIndex("DI5")));
param.put("DI6", c.getString(c.getColumnIndex("DI6")));
param.put("DI7", c.getString(c.getColumnIndex("DI7")));
param.put("DI8", c.getString(c.getColumnIndex("DI8")));
param.put("DI9", c.getString(c.getColumnIndex("DI9")));
param.put("DI10", c.getString(c.getColumnIndex("DI10")));
param.put("DI11", c.getString(c.getColumnIndex("DI11")));
param.put("PN1", c.getString(c.getColumnIndex("PN1")));
param.put("PN2", c.getString(c.getColumnIndex("PN2")));
param.put("PN3", c.getString(c.getColumnIndex("PN3")));
param.put("PN4", c.getString(c.getColumnIndex("PN4")));
param.put("PN5", c.getString(c.getColumnIndex("PN5")));
param.put("PN6", c.getString(c.getColumnIndex("PN6")));
param.put("PN7", c.getString(c.getColumnIndex("PN7")));
param.put("datee", c.getString(c.getColumnIndex("datee")));
param.put("timee", c.getString(c.getColumnIndex("timee")));
param.put("userid", Integer.toString(prefs.getUserId()) );
param.put("Interview_status", c.getString(c.getColumnIndex("Interview_status")));
param.put("sesssion", c.getString(c.getColumnIndex("sesssion")));
param.put("remarks", c.getString(c.getColumnIndex("remarks")));





}

}
//endregion


super.onPreExecute();
}

@Override
protected Object doInBackground(Object[] objects)
{

String urlString = new MyPreferences(mContext).getReq1();

URL url;
HttpURLConnection connection;

try
{
url = new URL(urlString);
connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("POST");
 // connection.setRequestMethod("GET");
connection.setConnectTimeout(1000);

 OutputStream os = connection.getOutputStream();
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

bw.write(PostRequestData.getData(param));
bw.flush();


int responseCode = connection.getResponseCode();
if (responseCode == HttpURLConnection.HTTP_OK) {
BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String st ="", line;
while ((line = br.readLine()) != null) {
st = st + line;
}
return st;
}
else
{
mUserMsg ="Server Couldn't process the request";
}
}
catch (MalformedURLException e) {
Toast.makeText(mContext,e.toString(), Toast.LENGTH_LONG).show();
e.printStackTrace();
} catch (IOException e) {


mUserMsg ="Please make sure that Internet connection is available," +
" and server IP is inserted in settings";
e.printStackTrace();
}

return null;
}

@Override
protected void onPostExecute(Object o) {



try {
dialog.dismiss();

if(mUserMsg != null)
throw new IOException();



//int houseId = Integer.parseInt(((String) o).replace("\"",""));

String result=(((String) o).replace("\"",""));



Toast.makeText(mContext,"Interivew Has ben Uploaded", Toast.LENGTH_SHORT).show();





 Update_Status_Tabl1();



}

catch (IOException e) {
//if connection was available via connecting but
//we can't get data from server..
if(mUserMsg == null)
mUserMsg ="Please check connection";
dialog.dismiss();
e.printStackTrace();
} catch (NullPointerException e) {
e.printStackTrace();
mUserMsg = e.getMessage();
dialog.dismiss();
}

catch (Exception e) {
Toast.makeText(mContext,"Uploading failed at request 1", Toast.LENGTH_SHORT).show();
dialog.dismiss();
return;
}
finally {
if (mUserMsg != null)
Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
}


super.onPostExecute(o);
}



 void Update_Status_Tabl1() {

  String query ="update  ttable  set Interview_status='2' where id="+col_A.data_upload_id;


  query = String.format(query);

  LocalDataManager validationactivity = new LocalDataManager(mContext);

  database.execSQL(query);

  thread.start();

 }

 // wait for Toast then kill app
Thread thread = new Thread(){
@Override
public void run() {
try {
Thread.sleep(800); // As I am using LENGTH_LONG in Toast
// Your_Activity.this.finish();


int pid = android.os.Process.myPid();
android.os.Process.killProcess(pid);
// getActivity().finish();




System.exit(0);

} catch (Exception e) {
e.printStackTrace();
}
}
};
}


