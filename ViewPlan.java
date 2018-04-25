package eighteen.cmp.nan.itourbradford;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ViewPlan extends AppCompatActivity {
    private ListView listView;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_plan);
        listView = (ListView)findViewById(R.id.list_user);
        dbh=new DatabaseHelper(ViewPlan.this);
        dbh.open();
        List<String> data=dbh.getDetails();
      //  Toast.makeText(ViewPlan.this,"Data"+data, Toast.LENGTH_LONG).show();
        ArrayAdapter<String> ad= new ArrayAdapter<String>(ViewPlan.this,R.layout.list,data);
        listView.setAdapter(ad);
        dbh.close();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {

                String s=adapterView.getItemAtPosition(i).toString();

                final String r[]=s.split("\n");

                final String res[]=r[0].split("::");
            //    Toast.makeText(ViewPlan.this,"res1"+res[1],Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewPlan.this);

                builder.setTitle("Delete");

                // set dialog message
                builder
                        .setMessage("Are you sure you want to Delete?")
                        .setIcon(R.drawable.logo);
// Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        DatabaseHelper dbh1=new DatabaseHelper(ViewPlan.this);
                        dbh1.open();
                        dbh1.delete(res[1]);
                        Toast.makeText(ViewPlan.this,"deleted",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(ViewPlan.this,ViewPlan.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
// Set other dialog properties


// Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
