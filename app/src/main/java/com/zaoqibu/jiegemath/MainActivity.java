package com.zaoqibu.jiegemath;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zaoqibu.jiegemath.customview.ImageButtonWithText;
import com.zaoqibu.jiegemath.fragment.ImageAndNumberFragment;
import com.zaoqibu.jiegemath.util.MediaPlayerSingleton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity implements ImageAndNumberFragment.OnFragmentInteractionListener, View.OnClickListener {
    private ImageAndNumberFragment xFragment;
    private ImageAndNumberFragment yFragment;
    private ImageAndNumberFragment resultFragment;

    private ImageButtonWithText result1;
    private ImageButtonWithText result2;
    private ImageButtonWithText result3;

    private int result;

    private TestPaper testPaper = new TestPaper();

    private Problem problem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int r=2; r<=10; ++r) {
            for (int x=1; x<r; ++x) {
                int y = r-x;
                testPaper.add(new ProblemWithAdd(x, y));
            }
        }

        FragmentManager fm = this.getFragmentManager();
        xFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.xFragment);
        yFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.yFragment);

        resultFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.resultFragment);
        resultFragment.setNumColumns(5);

        result1 = (ImageButtonWithText)findViewById(R.id.ibResult1);
        result2 = (ImageButtonWithText)findViewById(R.id.ibResult2);
        result3 = (ImageButtonWithText)findViewById(R.id.ibResult3);

        result1.setOnClickListener(this);
        result2.setOnClickListener(this);
        result3.setOnClickListener(this);

        nextProblem();
    }

    private void nextProblem() {
        final int imageId = getImage();
        xFragment.setImageId(imageId);
        yFragment.setImageId(imageId);
        resultFragment.setImageId(imageId);

        problem = getProblemByRandom();

        xFragment.setNumber(problem.getX());
        yFragment.setNumber(problem.getY());

        List<Integer> results = getResults(problem.result());
        setResults(results);
    }

    private Problem getProblemByRandom() {
        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int index = random.nextInt(testPaper.count());

        return testPaper.get(index);
    }

    private List<Integer> getResults(int result) {
        List<Integer> results = new ArrayList<Integer>();

        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int n = -2 + random.nextInt(3);

        for (int i=0; i<3; ++i) {
            results.add(n+i+result);
        }

        return results;
    }

    private void setResults(List<Integer> results) {
        result1.setText(results.get(0) + "");
        result1.setTag(results.get(0));
        result2.setText(results.get(1) + "");
        result2.setTag(results.get(1));
        result3.setText(results.get(2) + "");
        result3.setTag(results.get(2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        if (v==null || v.getTag()==null) {
            result = 0;
            return;
        }

        result1.setEnabled(false);
        result2.setEnabled(false);
        result3.setEnabled(false);

        result = (int)v.getTag();

        if (result == problem.result()) { //正确
            MediaPlayerSingleton.getInstance().play(this, "sounds/zhencongming.mp3");
        }
        else { //错误
            MediaPlayerSingleton.getInstance().play(this, "sounds/yaojiayou.mp3");
        }

        resultFragment.setNumber(problem.result());

        Handler handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            resultFragment.setNumber(0);
            nextProblem();

            result1.setEnabled(true);
            result2.setEnabled(true);
            result3.setEnabled(true);
        }
    };

    //选择显示的图片
    private Integer getImage() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a);
        images.add(R.drawable.b);
        images.add(R.drawable.c);
        images.add(R.drawable.d);
        images.add(R.drawable.e);
        images.add(R.drawable.f);
        images.add(R.drawable.g);
        images.add(R.drawable.h);
        images.add(R.drawable.i);
        images.add(R.drawable.pz13);
        images.add(R.drawable.pz14);
        images.add(R.drawable.pz15);
        images.add(R.drawable.pz16);
        images.add(R.drawable.pz17);
        images.add(R.drawable.pz18);
        images.add(R.drawable.pz19);
        images.add(R.drawable.pz20);
        images.add(R.drawable.pz21);
        images.add(R.drawable.pz22);
        images.add(R.drawable.pz23);
        images.add(R.drawable.pz24);
        images.add(R.drawable.pz25);
        images.add(R.drawable.pz26);
        images.add(R.drawable.pz27);
        images.add(R.drawable.pz28);
        images.add(R.drawable.pz29);
        images.add(R.drawable.pz30);
        images.add(R.drawable.pz31);
        images.add(R.drawable.pz32);
        images.add(R.drawable.pz33);
        images.add(R.drawable.pz34);
        images.add(R.drawable.pz35);
        images.add(R.drawable.pz36);
        images.add(R.drawable.pz37);
        images.add(R.drawable.pz38);
        images.add(R.drawable.pz39);
        images.add(R.drawable.pz40);
        images.add(R.drawable.pz41);
        images.add(R.drawable.pz42);

        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        return images.get(random.nextInt(images.size()));
    }

}
