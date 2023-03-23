package my.edu.utar.p8_wong_chee_yee_2003002;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.Constraintlayout);

        TextView[] tv = new TextView[4];
        tv[0] = (TextView) findViewById(R.id.textView1);
        tv[1] = (TextView) findViewById(R.id.textView2);
        tv[2] = (TextView) findViewById(R.id.textView3);
        tv[3] = (TextView) findViewById(R.id.textView4);

        for (int i = 0; i < tv.length; i++) {
            tv[i].setBackgroundColor(Color.parseColor("#E7E5E5"));
        }


        Button home = findViewById(R.id.button2);
        Button nextpage = findViewById(R.id.button);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }
        });

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, level2.class);
                intent.putExtra("score", score); // Add the score to the intent
                startActivity(intent);
            }
        });

        TextView lv = findViewById(R.id.lv);
        lv.setTextColor(Color.WHITE);


        final TextView tvScore = findViewById(R.id.score);
        final TextView tvTime = findViewById(R.id.time);
        tvScore.setTextColor(Color.WHITE);
        tvTime.setTextColor(Color.WHITE);

        Random random_yellow = new Random(System.nanoTime());
        final boolean[] isSelected = new boolean[tv.length];
        final int[] remainingTime = {5000};

        int index = random_yellow.nextInt(tv.length);
        tv[index].setBackgroundColor(Color.parseColor("#F6E1A1"));
        isSelected[index] = true;

        for (int i = 0; i < tv.length; i++) {
            final TextView textV = tv[i];
            textV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((ColorDrawable) textV.getBackground()).getColor() ==
                            Color.parseColor("#F6E1A1")) {
                        textV.setBackgroundColor(ContextCompat.
                                getColor(getApplicationContext(), R.color.green));
                        isSelected[index] = true;
                        score += 1;
                        tvScore.setText("Score: " + score);
                        boolean allSelected = true;
                        for (boolean selected : isSelected) {
                            if (!selected) {
                                allSelected = false;
                                break;
                            }
                        }
                        if (allSelected) {
                            for (int i = 0; i < tv.length; i++) {
                                tv[i].setBackgroundColor(ContextCompat.
                                        getColor(getApplicationContext(), R.color.green));
                            }
                        } else {
                            Random random = new Random();
                            int index = random.nextInt(tv.length);
                            while (isSelected[index]) {
                                index = random.nextInt(tv.length);
                            }
                            textV.setBackgroundColor(ContextCompat.
                                    getColor(getApplicationContext(), R.color.green));
                            isSelected[index] = true;
                            tv[index].setBackgroundColor(Color.parseColor("#F6E1A1"));
                        }
                    } else if (((ColorDrawable) textV.getBackground()).getColor() ==
                            ContextCompat.getColor(getApplicationContext(), R.color.green)) {
                        textV.setBackgroundColor(Color.parseColor("#E7E5E5"));
                    }
                }
            });
        }


        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                remainingTime[0] = (int) millisUntilFinished;
                tvTime.setText("Time: " + remainingTime[0] / 1000 + "s");
            }

            public void onFinish() {
                tvTime.setText("Time: 0s");
                for (int i = 0; i < tv.length; i++) {
                    tv[i].setOnClickListener(null);
                }
            }
        }.start();
    }
}


