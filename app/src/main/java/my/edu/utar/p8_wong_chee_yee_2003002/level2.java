package my.edu.utar.p8_wong_chee_yee_2003002;

import android.annotation.SuppressLint;
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

import java.util.Random;

public class level2 extends AppCompatActivity {
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2);

        score = getIntent().getIntExtra("score", 0);
        Intent intent = getIntent();


        ConstraintLayout layout = findViewById(R.id.Constraintlayout);

        TextView[] tv = new TextView[9];
        tv[0] = (TextView) findViewById(R.id.textView1);
        tv[1] = (TextView) findViewById(R.id.textView2);
        tv[2] = (TextView) findViewById(R.id.textView3);
        tv[3] = (TextView) findViewById(R.id.textView4);
        tv[4] = (TextView) findViewById(R.id.textView5);
        tv[5] = (TextView) findViewById(R.id.textView6);
        tv[6] = (TextView) findViewById(R.id.textVie7);
        tv[7] = (TextView) findViewById(R.id.textView8);
        tv[8] = (TextView) findViewById(R.id.textView9);


        for (int i = 0; i < tv.length; i++) {
            tv[i].setBackgroundColor(Color.parseColor("#E7E5E5"));
        }
        Button home = findViewById(R.id.home);
        Button nextpage = findViewById(R.id.button);
        Button back = findViewById(R.id.back);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level2.this, Home.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level2.this, level3.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

        TextView lv = findViewById(R.id.lv);
        lv.setTextColor(Color.WHITE);


        final TextView tvScore = findViewById(R.id.score);
        tvScore.setText("Score: " + score);

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
            final TextView textView = tv[i];
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((ColorDrawable) textView.getBackground()).getColor() ==
                            Color.parseColor("#F6E1A1")) {
                        textView.setBackgroundColor(ContextCompat.
                                getColor(getApplicationContext(), R.color.green));
                        int selectedIndex = -1;
                        for (int j = 0; j < tv.length; j++) {
                            if (tv[j] == textView) {
                                selectedIndex = j;
                                break;
                            }
                        }

                        isSelected[selectedIndex] = true;
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
                            textView.setBackgroundColor(ContextCompat.
                                    getColor(getApplicationContext(), R.color.green));
                            isSelected[index] = true;
                            tv[index].setBackgroundColor(Color.parseColor("#F6E1A1"));
                        }
                    } else if (((ColorDrawable) textView.getBackground()).getColor() ==
                            ContextCompat.getColor(getApplicationContext(), R.color.green)) {
                        textView.setBackgroundColor(Color.parseColor("#E7E5E5"));
                    }
                }
            });
        }


        new CountDownTimer(5000, 1000) {
            @SuppressLint("SetTextI18n")
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