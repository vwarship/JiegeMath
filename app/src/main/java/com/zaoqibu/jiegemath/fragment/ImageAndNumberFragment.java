package com.zaoqibu.jiegemath.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.zaoqibu.jiegemath.R;
import com.zaoqibu.jiegemath.customview.ImageButtonWithText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImageAndNumberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImageAndNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageAndNumberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private int imageBackgroundColor = 0xFFFFFFFF;
    private int numColumns = 3;
    private int number;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageAndNumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageAndNumberFragment newInstance(String param1, String param2) {
        ImageAndNumberFragment fragment = new ImageAndNumberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ImageAndNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_and_number, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateUI();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void setNumber(int number) {
        this.number = number;

        updateUI();
    }

    public void setBackgroundColor(String color) {
        this.getView().setBackgroundColor(Color.parseColor(color));
    }

    private void updateUI() {
        ImageButtonWithText tvNumber = (ImageButtonWithText)getView().findViewById(R.id.tvNumber);
        tvNumber.setText(number == 0 ? "" : String.format("%d", number));

        List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();
        for (int i=0; i<number; ++i) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("image", R.drawable.ic_launcher);
            images.add(data);
        }
        GridView gvImages = (GridView)getView().findViewById(R.id.gvImages);
        gvImages.setNumColumns(numColumns);
        gvImages.setBackgroundColor(imageBackgroundColor);
        gvImages.setAdapter(new SimpleAdapter(getActivity(), images,
                R.layout.image_and_number_with_image,
                new String[] {"image"}, new int[] {R.id.ivImage}));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
