package com.cytmxk.test.interpolator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RadioGroup;
import com.cytmxk.test.R;

/**
 * Created by chenyang on 16/8/16.
 */
public class InterpolatorFragment extends Fragment {

    private RadioGroup mInterpolatorGroup = null;
    private CurveView mCurveView = null;
    private float[] mXValues = new float[] { 0.0f, 0.1f, 0.2f, 0.3f, 0.4f,
            0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f };
    private float[] mYValues = new float[11];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_interpolator, container, false);

        mInterpolatorGroup = (RadioGroup) root.findViewById(R.id.interpolatorGroup);
        mCurveView = (CurveView) root.findViewById(R.id.curve);
        mCurveView.setxValues(mXValues);
        mInterpolatorGroup
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        Interpolator interpolator = getInterpolator();
                        for (int i = 0; i < mXValues.length; ++i) {
                            mYValues[i] = interpolator
                                    .getInterpolation(mXValues[i]);
                        }
                        mCurveView.setyValues(mYValues);
                        mCurveView.invalidate();
                    }
                });

        mInterpolatorGroup.check(R.id.LinearInterpolator);

        return root;
    }

    private Interpolator getInterpolator() {

        int checkedId = mInterpolatorGroup.getCheckedRadioButtonId();

        switch (checkedId) {
            case R.id.AccelerateDecelerateInterpolator:
                return new AccelerateDecelerateInterpolator();

            case R.id.AccelerateInterpolator:

                return new AccelerateInterpolator();

            case R.id.AnticipateInterpolator:

                return new AnticipateInterpolator();

            case R.id.AnticipateOvershootInterpolator:
                return new AnticipateOvershootInterpolator();

            case R.id.BounceInterpolator:
                return new BounceInterpolator();

            case R.id.CycleInterpolator:

                return new CycleInterpolator(2);

            case R.id.DecelerateInterpolator:

                return new DecelerateInterpolator();

            case R.id.LinearInterpolator:
                return new LinearInterpolator();

            case R.id.OvershootInterpolator:
                return new OvershootInterpolator();

            default:
                break;
        }

        return null;

    }
}
