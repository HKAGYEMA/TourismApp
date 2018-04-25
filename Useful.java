package eighteen.cmp.nan.itourbradford;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Useful extends AppCompatActivity {
LinearLayout l1,l2,l3,l4,l5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useful);
        l1=(LinearLayout)findViewById(R.id.ll_traf);
        l2=(LinearLayout)findViewById(R.id.ll_weat);
        l3=(LinearLayout)findViewById(R.id.ll_emer);
        l4=(LinearLayout)findViewById(R.id.ll_car);
        l5=(LinearLayout)findViewById(R.id.ll_trav);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Useful.this,Traffic.class);
                startActivity(i);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Useful.this,Weather.class);
                startActivity(i);
            }
        });


        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Useful.this,Emergency.class);
                startActivity(i);
            }
        });


        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Useful.this,CarHire.class);
                startActivity(i);
            }
        });

        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Useful.this,Travel.class);
                startActivity(i);
            }
        });






    }
}
