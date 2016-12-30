package com.cytmxk.test.testmaterialdesign.behavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/11/1.
 */

public class ScrollBehaviorFragment extends BaseFragment {

    private View root;
    private RecyclerView dependencyRV;
    private RecyclerView childRV;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_scroll_behavior;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        dependencyRV = (RecyclerView) root.findViewById(R.id.recyclerview_dependency);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        MyAdapter adapter1 = new MyAdapter();
        dependencyRV.setLayoutManager(layoutManager1);
        dependencyRV.setAdapter(adapter1);
        childRV = (RecyclerView) root.findViewById(R.id.recyclerview_child);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        MyAdapter adapter2 = new MyAdapter();
        childRV.setLayoutManager(layoutManager2);
        childRV.setAdapter(adapter2);
    }

    public class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.my_view_holder_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder)holder).updateView("position : " + position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }

        void updateView(String text) {
            textView.setText(text);
        }
    }
}
