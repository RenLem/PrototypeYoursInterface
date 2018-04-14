package omy.boston.prototypeyoursinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import omy.boston.prototypeyoursinterface.interfaces.OnProgressChangeListener;
import omy.boston.prototypeyoursinterface.view.HorizontalSlider;

public class MainActivity extends AppCompatActivity implements OnProgressChangeListener{

    private TextView textView_progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_progress = (TextView) findViewById(R.id.textView_progress);

        HorizontalSlider slider = (HorizontalSlider) findViewById(R.id.horizontalSlider_slider);
        slider.setOnProgressChangeListener(this);

    }

    @Override
    public void onProgressChange(View view, int progress) {
        textView_progress.setText(progress + "%");
    }
}
