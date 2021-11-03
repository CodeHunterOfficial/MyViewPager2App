package com.example.myviewpager2app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PageFragment extends Fragment {

    private int pageNumber;
    ArrayList<String> massimg;

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment() {
        massimg = new ArrayList<String>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
        massimg.add("dog1.jpg");
        massimg.add("dog2.jpg");
        massimg.add("dog3.jpg");
        massimg.add("dog4.png");
        massimg.add("dog5.png");
        massimg.add("dog6.png");
        massimg.add("dog7.jpg");
        massimg.add("dog8.jpg");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_page, container, false);
       // TextView pageHeader = result.findViewById(R.id.displayText);
        String header = "Фрагмент " + (pageNumber);
       // pageHeader.setText(header);

        ImageView imageView = result.findViewById(R.id.image);
        String filename = massimg.get(pageNumber);

        try (InputStream inputStream = getActivity().getApplicationContext().getAssets().open(filename)) {
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}