package com.ldoublem.wxsportstatistical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ldoublem.wxsportstatistical.view.WXSportStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements  WXSportStatistics.SelectItem{
    List<Integer> listValueNum = new ArrayList<Integer>();
    List<String> listday = new ArrayList<String>();
    TextView test;
    WXSportStatistics wxs_statistics;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wxs_statistics = (WXSportStatistics) findViewById(R.id.wxs_statistics);
        test = (TextView) findViewById(R.id.btn_test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (test.getText().toString().equals("Month")){
                    show(30);
                    test.setText("Week");
                }
                else
                {
                    show(7);
                    test.setText("Month");
                }
            }
        });

        show(7);
        test.setText("Month");
    }
    private void show(int size) {
        listday.clear();
        listValueNum.clear();
        for (int i = 0; i < size; i++) {


            listValueNum.add(random.nextInt(10000));
            if (i == 0) {
                listday.add("MAY" + (i + 1));

            } else {
                listday.add((i + 1) + "");
            }
        }
        wxs_statistics.setValue(listValueNum, false, true, listday, this, R.id.wxs_statistics);
    }


    @Override
    public void onSelectItem(int vid, int item) {
        switch (vid) {
            case R.id.wxs_statistics:

                wxs_statistics.select = item;
                wxs_statistics.selectbottom = item;
                wxs_statistics.ShowView();

                break;
            default:
                break;

        }
    }
}
