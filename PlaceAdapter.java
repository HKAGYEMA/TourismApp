package eighteen.cmp.nan.itourbradford;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class PlaceAdapter extends ArrayAdapter<Hero> {

    //the hero list that will be displayed
    private List<Hero> heroList;
    final static public String PREFS_MOB = "Login";
    SharedPreferences preference;
    String member_id;
    List<Hero> copylist;
    public static final String PREFS_ID = "idd";
    private SparseBooleanArray mSelectedItemsIds;
    private Context mCtx;
    private NetworkImageView mNetworkImageView;
    private ImageLoader mImageLoader;
    EditText e1;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public PlaceAdapter(List<Hero> heroList, Context mCtx) {
        super(mCtx, R.layout.list_bradford, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
        preference = mCtx.getSharedPreferences(PREFS_MOB, Context.MODE_PRIVATE);

        this.heroList = new ArrayList<>();
        this.heroList.addAll(heroList);
        this.heroList = heroList;

        copylist = new ArrayList<>();
       // copylist = new ArrayList<>();
        member_id = preference.getString("member_login", "");
//        Toast.makeText(mCtx, member_id, Toast.LENGTH_SHORT).show();
    }

    //this method will return the list item
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        mSelectedItemsIds = new SparseBooleanArray();
        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_bradford, null, true);

        //getting text views
            TextView mem_name = (TextView) listViewItem.findViewById(R.id.mem_name);

        TextView name = (TextView) listViewItem.findViewById(R.id.name);
        TextView desc = (TextView) listViewItem.findViewById(R.id.lat);
        TextView height = (TextView) listViewItem.findViewById(R.id.lan);

        LinearLayout ll = listViewItem.findViewById(R.id.linear_food);
        mNetworkImageView = (NetworkImageView) listViewItem.findViewById(R.id.food_image);


        //Getting the hero for the specified position
        final Hero hero = heroList.get(position);


        //set ting hero values to textviews

        mem_name.setText(hero.getName());

        name.setText(hero.getDob());
        desc.setText(hero.getDescription());

      //  height.setText(hero.getHeight1());


        mImageLoader = CustomVolleyRequestQueue.getInstance(this.getContext())
                .getImageLoader();

        mImageLoader.get(hero.getImage(), ImageLoader.getImageListener(mNetworkImageView,
                R.drawable.no_image, R.drawable
                        .no_image));
        mNetworkImageView.setImageUrl(hero.getImage(), mImageLoader);

        if (hero.getImage().equals("")) {
            mNetworkImageView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.no_image));
        }

ll.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       /* SharedPreferences settings = getContext().getSharedPreferences(PREFS_ID, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("idd", hero.getDescription());
        editor.commit();
        Log.d( "Location",hero.getDescription());*/
        String s=hero.getDescription();
        String nam=hero.getDob();
        Toast.makeText(getContext(),nam,Toast.LENGTH_SHORT).show();
        String ss[]=s.split(":");

      //  Toast.makeText(getContext(),"Location"+ss[2],Toast.LENGTH_SHORT).show();

        String lat[]=ss[2].split(",");
     //   Toast.makeText(getContext(),"lattitude"+lat[0],Toast.LENGTH_SHORT).show();



        String lag[]=ss[3].split(",");
        String lng=lag[0].substring(0,lag[0].length()-1);

        String res_lat=lat[0];
        String res_lan=lng;

        Intent i= new Intent(getContext(),Navigate.class);
        i.putExtra("key",res_lat);
        i.putExtra("key1",res_lan);
        i.putExtra("namee",nam);
        getContext().startActivity(i);





      //  Toast.makeText(getContext(),"longitude"+lng,Toast.LENGTH_SHORT).show();

    }
});

        //returning the listitem
        return listViewItem;
    }


    @Override
    public void remove(Hero object) {
        heroList.remove(object);
        notifyDataSetChanged();
    }

    public List<Hero> getWorldPopulation() {
        return heroList;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }
    public void update(List<Hero> h)
    {

        Set<Hero> hs = new HashSet<>();
        hs.addAll(h);
        copylist.clear();
        copylist.addAll(hs);

        //copylist.addAll(h);
    }
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
    public void filter1(String text){
        Log.d("Text",text);
        Log.d("heroList", String.valueOf(heroList.size()));
        Log.d("copyList", String.valueOf(copylist.size()));
       // text = text.toLowerCase(Locale.getDefault());

        this.heroList.clear();

        if (text.length() == 0){
            this.heroList.addAll(this.copylist);
        }
        else {

            for (Hero info : copylist){

                if (info.getDob().contains(text)){
                    this.heroList.add(info);
                }

            }
            //  copylist.clear();
            notifyDataSetChanged();
        }

    }
}



