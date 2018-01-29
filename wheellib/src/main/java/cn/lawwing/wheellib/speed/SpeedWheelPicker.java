package cn.lawwing.wheellib.speed;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.lawwing.wheellib.R;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class SpeedWheelPicker extends LinearLayout implements SpeedWheelView.OnSpeedSelectedListener {
    private TextView tvTitle;
    private SpeedWheelView speedView;
    private OnSpeedSelectListener speedListener;

    public SpeedWheelPicker(Context context) {
        this(context, null);
    }

    public SpeedWheelPicker(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpeedWheelPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_speed, this);
        initChild();
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
    }

    private void initChild() {
        tvTitle = findViewById(R.id.tv_speed_title);
        speedView = findViewById(R.id.speed_wheel_view);
        speedView.setCyclic(true);
        //speedView.setCurrentPosition(1, false);
    }

    @Override
    public void onSpeedSelected(int poi, String speedName) {
        if (null != speedListener) {
            speedListener.onSpeedSelect(poi, speedName);
        }
    }

    public void setSpeedListener(OnSpeedSelectListener speedListener) {
        this.speedListener = speedListener;
    }

    public interface OnSpeedSelectListener {
        void onSpeedSelect(int poi, String name);
    }
}
