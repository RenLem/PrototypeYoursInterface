package omy.boston.prototypeyoursinterface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ProgressBar;

import omy.boston.prototypeyoursinterface.interfaces.OnProgressChangeListener;

import static android.R.id.progress;

/**
 * Created by LosFrancisco on 10-Feb-17.
 */

public class HorizontalSlider extends ProgressBar {

    private OnProgressChangeListener listener;

    public HorizontalSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizontalSlider(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.progressBarStyleHorizontal);
    }

    public HorizontalSlider(Context context) {
        super(context);
    }

    public void setOnProgressChangeListener(OnProgressChangeListener q){
        listener = q;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) {
            float x_mouse = event.getX();
            float width = getWidth();
            int progress = Math.round((float) getMax() * (x_mouse / width));

            if (progress < 0) {
                progress = 0;
            }
            if (progress > 100) {
                progress = 100;
            }

            this.setProgress(progress);

            if (listener != null){
                listener.onProgressChange(this, progress);
            }
        }
            return true;

    }
}
