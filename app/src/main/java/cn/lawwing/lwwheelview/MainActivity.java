package cn.lawwing.lwwheelview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.lawwing.wheellib.date.DatePicker;
import cn.lawwing.wheellib.date.DatePickerDialogFragment;

public class MainActivity extends AppCompatActivity
{
    
    private TextView dateTv;
    
    private DatePicker datePicker;
    
    private Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateTv = (TextView) findViewById(R.id.tv_date);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
                datePickerDialogFragment.setOnDateChooseListener(
                        new DatePickerDialogFragment.OnDateChooseListener()
                        {
                            @Override
                            public void onDateChoose(int year, int month,
                                    int day)
                            {
                                Toast.makeText(getApplicationContext(),
                                        year + "-" + month + "-" + day,
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                datePickerDialogFragment.show(getSupportFragmentManager(),
                        "DatePickerDialogFragment");
            }
        });
        
        datePicker.setOnDateSelectedListener(
                new DatePicker.OnDateSelectedListener()
                {
                    @Override
                    public void onDateSelected(int year, int month, int day)
                    {
                        dateTv.setText(year + "-" + month + "-" + day);
                    }
                });
    }
    
}
