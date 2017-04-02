package com.cytmxk.test.animation.vector;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cytmxk.test.R;

/**
 * Created by chenyang on 2017/3/14.
 */

public class VectorAnimationFragment extends Fragment implements View.OnClickListener {


    // 对应于Android pre-L支持的vector动画
    private ImageView crossAnimIV;
    private ImageView searchBarAnimIV;
    private ImageView starAnimIV;
    private ImageView arrowAnimIV;
    private ImageView squareAnimIV;

    // Android L+支持的vector动画
    private ImageView pathPawAnimTV;
    private ImageView pathTickAnimIV;
    private ImageView heartEmptyAnimIV;
    private ImageView fiveStarAnimIV;

    private boolean isTick1 = false;
    private boolean isEmpty = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vector_animation_prel,
                container, false);
        crossAnimIV = (ImageView) root.findViewById(R.id.imageview_cross_anim);
        crossAnimIV.setOnClickListener(this);
        searchBarAnimIV = (ImageView) root.findViewById(R.id.imageview_search_bar_anim);
        searchBarAnimIV.setOnClickListener(this);
        starAnimIV = (ImageView) root.findViewById(R.id.imageview_star_anim);
        starAnimIV.setOnClickListener(this);
        arrowAnimIV = (ImageView) root.findViewById(R.id.imageview_arrow_anim);
        arrowAnimIV.setOnClickListener(this);
        squareAnimIV = (ImageView) root.findViewById(R.id.imageview_square_anim);
        squareAnimIV.setOnClickListener(this);

        pathPawAnimTV = (ImageView) root.findViewById(R.id.imageview_path_paw);
        pathPawAnimTV.setOnClickListener(this);
        pathTickAnimIV = (ImageView) root.findViewById(R.id.imageview_path_tick);
        pathTickAnimIV.setOnClickListener(this);
        heartEmptyAnimIV = (ImageView) root.findViewById(R.id.imageview_heart_empty_anim);
        heartEmptyAnimIV.setOnClickListener(this);
        fiveStarAnimIV = (ImageView) root.findViewById(R.id.imageview_five_satr_anim);
        fiveStarAnimIV.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.imageview_cross_anim == id || R.id.imageview_search_bar_anim == id ||
                R.id.imageview_star_anim == id || R.id.imageview_arrow_anim == id ||
                R.id.imageview_square_anim == id) {
            ImageView imageView = (ImageView) v;
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        } else if (R.id.imageview_path_paw == id) {
            anim1(v);
        } else if (R.id.imageview_path_tick == id) {
            anim2(v);
        } else if (R.id.imageview_heart_empty_anim == id) {
            anim3(v);
        } else if (R.id.imageview_five_satr_anim == id) {
            anim4(v);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void anim1(View view) {
        ImageView imageView = (ImageView) view;

        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.avd_path_paw);

        imageView.setImageDrawable(animatedVectorDrawable);
        if (animatedVectorDrawable != null) {
            animatedVectorDrawable.start();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void anim2(View view) {
        ImageView imageView = (ImageView) view;

        AnimatedVectorDrawable tickToCross = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.path_tick2cross_anim);
        AnimatedVectorDrawable crossToTick = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.path_cross2tick_anim);

        AnimatedVectorDrawable animDrawable = isTick1 ? crossToTick: tickToCross;
        imageView.setImageDrawable(animDrawable);
        if (animDrawable != null) {
            animDrawable.start();
        }
        isTick1 = !isTick1;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void anim3(View view) {
        ImageView imageView = (ImageView) view;

        AnimatedVectorDrawable emptyToFull = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.avd_path_heart_full);
        AnimatedVectorDrawable fullToEmpty = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.avd_path_heart_empty);

        AnimatedVectorDrawable animDrawable = isEmpty ? fullToEmpty: emptyToFull;
        imageView.setImageDrawable(animDrawable);
        if (animDrawable != null) {
            animDrawable.start();
        }
        isEmpty = !isEmpty;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void anim4(View view) {
        ImageView imageView = (ImageView) view;
        AnimatedVectorDrawable tickToCross = (AnimatedVectorDrawable) getContext().getDrawable(R.drawable.fivestat_anim);
        imageView.setImageDrawable(tickToCross);
        if (tickToCross != null) {
            tickToCross.start();
        }
    }
}
