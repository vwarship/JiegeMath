package com.zaoqibu.jiegemath;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zaoqibu.jiegemath.customview.ImageButtonWithText;
import com.zaoqibu.jiegemath.fragment.ImageAndNumberFragment;
import com.zaoqibu.jiegemath.util.MediaPlayerSingleton;


public class MainActivity extends ActionBarActivity implements ImageAndNumberFragment.OnFragmentInteractionListener, View.OnClickListener {
    private ImageAndNumberFragment xFragment;
    private ImageAndNumberFragment yFragment;
    private ImageAndNumberFragment resultFragment;

    private int result;

    TestPaper testPaper = new TestPaper();
    private int curProblemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testPaper.add(new ProblemWithAdd(2, 3));
        testPaper.add(new ProblemWithAdd(1, 3));
        testPaper.add(new ProblemWithAdd(3, 3));
        testPaper.add(new ProblemWithAdd(4, 2));
        testPaper.add(new ProblemWithAdd(3, 2));
        testPaper.add(new ProblemWithAdd(2, 4));
        testPaper.add(new ProblemWithAdd(3, 1));
        testPaper.add(new ProblemWithAdd(5, 1));

        FragmentManager fm = this.getFragmentManager();
        xFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.xFragment);
        xFragment.setNumber(testPaper.get(curProblemIndex).getX());

        yFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.yFragment);
        yFragment.setNumber(testPaper.get(curProblemIndex).getY());

        resultFragment = (ImageAndNumberFragment)fm.findFragmentById(R.id.resultFragment);
        resultFragment.setNumColumns(5);

        ImageButtonWithText result1 = (ImageButtonWithText)findViewById(R.id.ibResult1);
        ImageButtonWithText result2 = (ImageButtonWithText)findViewById(R.id.ibResult2);
        ImageButtonWithText result3 = (ImageButtonWithText)findViewById(R.id.ibResult3);

        result1.setText("4");
        result1.setTag("4");
        result2.setText("5");
        result2.setTag("5");
        result3.setText("6");
        result3.setTag("6");

        result1.setOnClickListener(this);
        result2.setOnClickListener(this);
        result3.setOnClickListener(this);
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

        String tag = v.getTag().toString();
        result = Integer.parseInt(tag);

        Problem problem = testPaper.get(curProblemIndex);
        if (result == problem.result()) { //正确
            MediaPlayerSingleton.getInstance().play(this, "sounds/zhencongming.mp3");
        }
        else { //错误
            MediaPlayerSingleton.getInstance().play(this, "sounds/yaojiayou.mp3");
        }

        Log.i("test", "result:" + problem.result());
        resultFragment.setNumber(problem.result());

        ++ curProblemIndex;

        if (curProblemIndex == 8)
            curProblemIndex = 0;

        xFragment.setNumber(testPaper.get(curProblemIndex).getX());
        yFragment.setNumber(testPaper.get(curProblemIndex).getY());
    }
}
