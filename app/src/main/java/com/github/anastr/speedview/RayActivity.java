package com.github.anastr.speedview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.anastr.speedviewlib.RaySpeedometer;

import java.util.Locale;

public class RayActivity extends AppCompatActivity {

    RaySpeedometer raySpeedometer;
    SeekBar seekBarSpeed, seekBarDegree, seekBarWidth;
    Button ok;
    TextView textSpeed, textDegree, textWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ray);

        raySpeedometer = (RaySpeedometer) findViewById(R.id.raySpeedometer);
        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        seekBarDegree = (SeekBar) findViewById(R.id.seekBarDegree);
        seekBarWidth = (SeekBar) findViewById(R.id.seekBarWidth);
        ok = (Button) findViewById(R.id.ok);
        textSpeed = (TextView) findViewById(R.id.textSpeed);
        textDegree = (TextView) findViewById(R.id.textDegree);
        textWidth = (TextView) findViewById(R.id.textWidth);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raySpeedometer.speedTo(seekBarSpeed.getProgress());
            }
        });

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format(Locale.getDefault(), "%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarDegree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textDegree.setText(String.format(Locale.getDefault(), "%d", progress));
                raySpeedometer.setDegreeBetweenMark(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textWidth.setText(String.format(Locale.getDefault(), "%ddp", progress));

                raySpeedometer.setMarkWidth((int) raySpeedometer.dpTOpx(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
