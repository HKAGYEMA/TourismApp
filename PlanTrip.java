package eighteen.cmp.nan.itourbradford;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanTrip extends AppCompatActivity {
String dd;
    TextView t1;
    EditText e1;
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_trip);

        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dd=simpleDateFormat.format(d);

        t1=(TextView)findViewById(R.id.add);
        e1=(EditText)findViewById(R.id.det);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().contentEquals("")){
                    Toast.makeText(PlanTrip.this,"Enter Plans",Toast.LENGTH_SHORT).show();
                }
                else {
                    dbh = new DatabaseHelper(PlanTrip.this);
                    dbh.open();
                    dbh.insert(dd, e1.getText().toString());
                    Toast.makeText(PlanTrip.this,"Plan Added",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(PlanTrip.this,PlanPage.class);
                    startActivity(i);
                    finish();
                    dbh.close();
                }
                e1.setText("");
            }
        });
    }
}
