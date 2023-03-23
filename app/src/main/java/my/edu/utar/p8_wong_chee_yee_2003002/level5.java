package my.edu.utar.p8_wong_chee_yee_2003002;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class level5 extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level5);


        score = getIntent().getIntExtra("score", 0);
        Intent intent = getIntent();


        ConstraintLayout layout = findViewById(R.id.Constraintlayout);

        TextView[] tv = new TextView[36];
        tv[0] = (TextView) findViewById(R.id.textView1);
        tv[1] = (TextView) findViewById(R.id.textView2);
        tv[2] = (TextView) findViewById(R.id.textView3);
        tv[3] = (TextView) findViewById(R.id.textView4);
        tv[4] = (TextView) findViewById(R.id.textView5);
        tv[5] = (TextView) findViewById(R.id.textView6);
        tv[6] = (TextView) findViewById(R.id.textView7);
        tv[7] = (TextView) findViewById(R.id.textView8);
        tv[8] = (TextView) findViewById(R.id.textView9);
        tv[9] = (TextView) findViewById(R.id.textView10);
        tv[10] = (TextView) findViewById(R.id.textView11);
        tv[11] = (TextView) findViewById(R.id.textView12);
        tv[12] = (TextView) findViewById(R.id.textView13);
        tv[13] = (TextView) findViewById(R.id.textView14);
        tv[14] = (TextView) findViewById(R.id.textView15);
        tv[15] = (TextView) findViewById(R.id.textView16);
        tv[16] = (TextView) findViewById(R.id.textView17);
        tv[17] = (TextView) findViewById(R.id.textView18);
        tv[18] = (TextView) findViewById(R.id.textView19);
        tv[19] = (TextView) findViewById(R.id.textView20);
        tv[20] = (TextView) findViewById(R.id.textView21);
        tv[21] = (TextView) findViewById(R.id.textView22);
        tv[22] = (TextView) findViewById(R.id.textView23);
        tv[23] = (TextView) findViewById(R.id.textView24);
        tv[24] = (TextView) findViewById(R.id.textView25);
        tv[25] = (TextView) findViewById(R.id.textView26);
        tv[26] = (TextView) findViewById(R.id.textView27);
        tv[27] = (TextView) findViewById(R.id.textView28);
        tv[28] = (TextView) findViewById(R.id.textView29);
        tv[29] = (TextView) findViewById(R.id.textView30);
        tv[30] = (TextView) findViewById(R.id.textView31);
        tv[31] = (TextView) findViewById(R.id.textView32);
        tv[32] = (TextView) findViewById(R.id.textView33);
        tv[33] = (TextView) findViewById(R.id.textView34);
        tv[34] = (TextView) findViewById(R.id.textView35);
        tv[35] = (TextView) findViewById(R.id.textView36);


        for (int i = 0; i < tv.length; i++) {
            tv[i].setBackgroundColor(Color.parseColor("#E7E5E5"));
        }
        Button home = findViewById(R.id.home);
        Button back = findViewById(R.id.back);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        my.edu.utar.p8_wong_chee_yee_2003002.level5.this, Home.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        my.edu.utar.p8_wong_chee_yee_2003002.level5.this,
                        level4.class);
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
            final TextView textView = tv[i];
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((ColorDrawable) textView.getBackground()).getColor() ==
                            Color.parseColor("#F6E1A1")) {
                        textView.setBackgroundColor(ContextCompat.
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
                AlertDialog.Builder builder = new AlertDialog.Builder(level5.this);
                builder.setTitle("Times Out!!!!!")
                        .setMessage("You final score is" + score)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(
                                        my.edu.utar.p8_wong_chee_yee_2003002.level5.this,
                                        Home.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        }.start();

    }
}