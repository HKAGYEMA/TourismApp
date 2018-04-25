package eighteen.cmp.nan.itourbradford;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DashBoard extends AppCompatActivity {
LinearLayout res,hotel,use,shop,tour,plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board);
        res=(LinearLayout)findViewById(R.id.ll_res);
        hotel=(LinearLayout)findViewById(R.id.ll_hotel);
        use=(LinearLayout)findViewById(R.id.ll_use);
        shop=(LinearLayout)findViewById(R.id.ll_shop);
        tour=(LinearLayout)findViewById(R.id.ll_tour);
        plan=(LinearLayout)findViewById(R.id.plan);
res.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(DashBoard.this,Restaurant.class);
        startActivity(i);
    }
});
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashBoard.this,Hotel.class);
                startActivity(i);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashBoard.this,Shopping.class);
                startActivity(i);
            }
        });

        use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashBoard.this,Useful.class);
                startActivity(i);
            }
        });
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashBoard.this,Tourist.class);
                startActivity(i);
            }
        });
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashBoard.this,PlanPage.class);
                startActivity(i);
            }
        });

    }

}
