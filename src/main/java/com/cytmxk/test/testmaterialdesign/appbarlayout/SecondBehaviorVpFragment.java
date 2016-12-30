package com.cytmxk.test.testmaterialdesign.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cytmxk.customview.divider.RecycleViewDivider;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/11/8.
 */

public class SecondBehaviorVpFragment extends BaseFragment {

    private View root;
    private RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_second_behavior_vp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview_show_image);
        MyAdapter myAdapter = new MyAdapter();
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),
                RecycleViewDivider.LayoutManagerType.GRID, RecycleViewDivider.OrientationType.HORIZONTAL));
        recyclerView.setAdapter(myAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter {

        private int[] imageResIds = new int[] {R.drawable.beauty1, R.drawable.beauty2,
                R.drawable.beauty3, R.drawable.beauty4, R.drawable.beauty5,
                R.drawable.beauty6, R.drawable.beauty7, R.drawable.beauty8};

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            MyViewHolder myViewHolder = new MyViewHolder(imageView);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder)holder).updateView(imageResIds[position]);
        }

        @Override
        public int getItemCount() {
            return imageResIds.length;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;
        }

        public void updateView(int resId) {
            imageView.setImageResource(resId);
        }
    }
}
