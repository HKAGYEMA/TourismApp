package eighteen.cmp.nan.itourbradford;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlanPage extends AppCompatActivity {
Button plan,vplan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_page);
        plan=(Button)findViewById(R.id.trip);
        vplan=(Button)findViewById(R.id.vplan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PlanPage.this,PlanTrip.class);
                startActivity(i);
            }
        });
        vplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PlanPage.this,ViewPlan.class);
                startActivity(i);
            }
        });
    }
}
