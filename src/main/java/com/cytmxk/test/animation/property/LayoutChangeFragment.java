package com.cytmxk.test.animation.property;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/8/18.
 */
public class LayoutChangeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout llImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_layout_change, container, false);
        root.findViewById(R.id.btn_add_image).setOnClickListener(this);
        root.findViewById(R.id.btn_remove_image).setOnClickListener(this);
        llImageView = (LinearLayout) root.findViewById(R.id.ll_image);

        LayoutTransition transition = new LayoutTransition();

        transition.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        transition.setDuration(LayoutTransition.CHANGE_APPEARING, transition.getDuration(LayoutTransition.CHANGE_APPEARING));
        transition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0);

        ObjectAnimator appearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("alpha", 0, 1.0f));
        transition.setAnimator(LayoutTransition.APPEARING, appearingAnimator);
        transition.setDuration(LayoutTransition.APPEARING, transition.getDuration(LayoutTransition.APPEARING));
        transition.setStartDelay(LayoutTransition.APPEARING, transition.getDuration(LayoutTransition.CHANGE_APPEARING));

        ObjectAnimator disappearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("alpha", 1.0f, 0));
        transition.setAnimator(LayoutTransition.DISAPPEARING, disappearingAnimator);
        transition.setDuration(LayoutTransition.DISAPPEARING, transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setStartDelay(LayoutTransition.DISAPPEARING, 0);

        transition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);
        transition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, transition.getDuration(LayoutTransition.DISAPPEARING));

        llImageView.setLayoutTransition(transition);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_image:{
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(R.drawable.second_pic);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200,200);
                llImageView.addView(imageView, 0, layoutParams);
            }
                break;
            case R.id.btn_remove_image:{
                int count = llImageView.getChildCount();
                if (count > 0) {
                    llImageView.removeViewAt(0);
                }
            }
                break;
        }
    }
}
