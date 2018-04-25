package eighteen.cmp.nan.itourbradford;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Hotel extends AppCompatActivity {
    String myurl,cat_id,status;
    PlaceAdapter fc;
    List<Hero> heroList;
    EditText e1;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);
        myurl="https://maps.googleapis.com/maps/api/place/textsearch/json?query=bradford+hotels&language=en&key=AIzaSyC6zHflVgVCLKEMWBFMFm5qj0Jis-eoR4U";
        lv = (ListView) findViewById(R.id.list_hotel);
        e1=(EditText)findViewById(R.id.search);
        heroList=new ArrayList<>();

        fc=new PlaceAdapter(heroList,Hotel.this);
        member();
        setUpSearchTask();
    }

    private void setUpSearchTask(){
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // adapter.clear();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // CollectionDate();
                fc.filter1(charSequence.toString());


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // adapter.clear();
    }
    private void member() {
        final ProgressDialog dialog = ProgressDialog.show(Hotel.this, null, "Loading..", true, false);
        dialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, myurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        //      progressBar.setVisibility(View.INVISIBLE);

                        // dialog.cancel();

                        dialog.cancel();

                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray heroArray = obj.getJSONArray("results");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < heroArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject heroObject = heroArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object

                                Hero hero = new Hero();
                                hero.setName(heroObject.getString("formatted_address"));
                                hero.setDob(heroObject.getString("name").toLowerCase());
                                hero.setImage(heroObject.getString("icon"));
                                hero.setDescription(heroObject.getString("geometry"));
                              //  hero.setHeight1(heroObject.getString("lng"));

/*
                                    hero.setDob(heroObject.getString("member_email"));
                                    hero.setHeight(heroObject.getString("member_contact_num"));
                                    hero.setImage(heroObject.getString("prof_image"));
                                    hero.setDescription(heroObject.getString("status"));
                                    hero.setHeight1(heroObject.getString("blood_group"));
                                    hero.setHeight2(heroObject.getString("member_address"));
                                    hero.setDob1(heroObject.getString("emergency_no"));
*/

                                heroList.add(hero);


                           /* //creating custom adapter object
                            ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);*/



                            }
                            fc.update(heroList);

                            lv.setAdapter(fc);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(Hotel.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(Hotel.this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);


        // new Shop_Order_Brief.DownloadImageTask(im).execute(stat5);

    }



}
