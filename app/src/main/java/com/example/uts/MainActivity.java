package com.example.uts;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
ImageButton imageButton2;
TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageButton2 = findViewById(R.id.aA_language);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
            }
        });
        TextView text = findViewById(R.id.bonustext);

// Animate the text color from red to purple
        ObjectAnimator colorAnim = ObjectAnimator.ofInt(text, "textColor", Color.parseColor("#00057D"), Color.parseColor("#FF1F84FF"));
        colorAnim.setDuration(400); // duration of one cycle
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE); // repeat forever
        colorAnim.setRepeatMode(ValueAnimator.REVERSE); // reverse after one cycle

// Start the animation
        colorAnim.start();





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}