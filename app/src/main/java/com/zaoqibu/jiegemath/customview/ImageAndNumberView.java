package com.zaoqibu.jiegemath.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.zaoqibu.jiegemath.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vwarship on 2015/1/27.
 */
public class ImageAndNumberView extends RelativeLayout {
    private int numColumns =3;
    private int imageBackgroundColor;
    private int number;

    public  ImageAndNumberView(Context context) {
        super(context);

        inflateLayout();
    }

    public  ImageAndNumberView(Context context, AttributeSet attrs) {
        super(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageAndNumberView);
        numColumns = typedArray.getInteger(R.styleable.ImageAndNumberView_numColumns, 2);
        imageBackgroundColor = typedArray.getColor(R.styleable.ImageAndNumberView_backgroundColor, 0xFFFFFFFF);
        number = typedArray.getInteger(R.styleable.ImageAndNumberView_number, 0);

        inflateLayout();
    }
    private void inflateLayout() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.image_and_number, this, true);

        setImageAndNumber();
    }

    private void setImageAndNumber() {
        ImageButtonWithText tvNumber = (ImageButtonWithText)findViewById(R.id.tvNumber);
        tvNumber.setText(number == 0 ? "" : String.format("%d", number));

        List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();
        for (int i=0; i<number; ++i) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("image", R.drawable.ic_launcher);
            images.add(data);
        }
        GridView gvImages = (GridView)findViewById(R.id.gvImages);
        gvImages.setNumColumns(numColumns);
        gvImages.setBackgroundColor(imageBackgroundColor);
        gvImages.setAdapter(new SimpleAdapter(getContext(), images,
                R.layout.image_and_number_with_image,
                new String[] {"image"}, new int[] {R.id.ivImage}));
    }

    public void setNumber(int number) {
        this.number = number;

        setImageAndNumber();
    }

}
