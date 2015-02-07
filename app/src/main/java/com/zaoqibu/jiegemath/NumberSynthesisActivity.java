package com.zaoqibu.jiegemath;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zaoqibu.jiegemath.customview.ImageAndNumberView;

/**
 * Created by vwarship on 2015/1/28.
 */
public class NumberSynthesisActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout topLayout = new LinearLayout(this);
        ImageAndNumberView x = new ImageAndNumberView(this);
        x.setNumber(3);
        x.setBackgroundColor(Color.parseColor("#F57945"));
        ImageAndNumberView y = new ImageAndNumberView(this);
        y.setNumber(5);

        LinearLayout.LayoutParams xLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        xLayoutParams.weight = 1;
        topLayout.addView(x, xLayoutParams);
        topLayout.addView(y, xLayoutParams);

        LinearLayout.LayoutParams topLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        topLayoutParams.weight = 3;
        rootLayout.addView(topLayout, topLayoutParams);

        ImageAndNumberView result = new ImageAndNumberView(this);
        result.setNumber(8);

        LinearLayout.LayoutParams resultLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        resultLayoutParams.weight = 4;
        rootLayout.addView(result, resultLayoutParams);

        LinearLayout.LayoutParams resultSetLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 40);
        LinearLayout resultSetLayout = new LinearLayout(this);
        rootLayout.addView(resultSetLayout, resultSetLayoutParams);
        Button result1 = new Button(this);
        LinearLayout.LayoutParams result1tLayoutParams = new LinearLayout.LayoutParams(50, 50);
        resultSetLayout.addView(result1, result1tLayoutParams);

        LinearLayout.LayoutParams rootLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(rootLayout, rootLayoutParams);
    }
}
