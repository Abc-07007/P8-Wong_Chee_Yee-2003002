package my.edu.utar.p8_wong_chee_yee_2003002;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ConstraintLayout layout = findViewById(R.id.Constraintlayout);

        TextView tv1 = findViewById(R.id.design);
        TextView tv2 = findViewById(R.id.design2);
        TextView tv3 = findViewById(R.id.design3);
        TextView tv4 = findViewById(R.id.design4);


        tv1.setBackgroundColor(Color.parseColor("#F4A27C"));
        tv2.setBackgroundColor(Color.parseColor("#F6E1A1"));
        tv3.setBackgroundColor(Color.parseColor("#E7E5E5"));
        tv4.setBackgroundColor(Color.parseColor("#9BEF9F"));

        Button startgame = findViewById(R.id.playgame);
        Button lv1 = findViewById(R.id.lv1);
        Button lv2 = findViewById(R.id.lv2);
        Button lv3= findViewById(R.id.lv3);
        Button lv4= findViewById(R.id.lv4);
        Button lv5= findViewById(R.id.lv5);


        startgame.setBackgroundColor(Color.parseColor("#F4A27C"));
        lv1.setBackgroundColor(Color.parseColor("#4B84DA"));
        lv2.setBackgroundColor(Color.parseColor("#4B84DA"));
        lv3.setBackgroundColor(Color.parseColor("#4B84DA"));
        lv4.setBackgroundColor(Color.parseColor("#4B84DA"));
        lv5.setBackgroundColor(Color.parseColor("#4B84DA"));




        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, level2.class);
                startActivity(intent);
            }
        });

        lv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, level3.class);
                startActivity(intent);
            }
        });

        lv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, level4.class);
                startActivity(intent);
            }
        });

        lv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, level5.class);
                startActivity(intent);
            }
        });

        lv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, level5.class);
                startActivity(intent);
            }
        });




    }




}
