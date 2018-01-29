package cn.lawwing.wheellib.speed;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import cn.lawwing.wheellib.LWWheelView;

/**
 * Created by lawwing on 2018/1/28.
 */

public class SpeedWheelView extends LWWheelView<String> {
    private OnSpeedSelectedListener onSpeedSelectedListener;

    public SpeedWheelView(Context context) {
        this(context, null);
    }

    public SpeedWheelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpeedWheelView(Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setItemMaximumWidthText("X 1.0");
        updateSpeed();
        setSelectedSpeed(0, false);
        setOnWheelChangeListener(new OnWheelChangeListener<String>() {
            @Override
            public void onWheelSelected(String item, int position) {
                if (onSpeedSelectedListener != null) {
                    onSpeedSelectedListener.onSpeedSelected(position, item);
                }
            }
        });
    }

    public void setSelectedSpeed(int poi, boolean smoothScroll) {
        setCurrentPosition(poi, smoothScroll);
    }

    private void updateSpeed() {
        List<String> list = new ArrayList<>();
        for (int i = 3; i >= 0; i--) {
            list.add("X " + (i + 2) * 0.2);
        }
        setDataList(list);
    }


    public void setOnSpeedSelectedListener(OnSpeedSelectedListener onSpeedSelectedListener) {
        this.onSpeedSelectedListener = onSpeedSelectedListener;
    }

    public interface OnSpeedSelectedListener {
        void onSpeedSelected(int poi, String speedName);
    }

}
