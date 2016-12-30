package com.cytmxk.test.animation.view;

import java.util.ArrayList;
import java.util.List;
import com.cytmxk.test.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LayoutActivity extends Activity {

	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		mListView=(ListView) findViewById(R.id.listView);
		List<String>list=new ArrayList<String>();
		for(int i=0;i<20;i++)
		{
			list.add("我是男生"+i);
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		mListView.setAdapter(adapter);

	    LayoutAnimationController lac=new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
	    lac.setDelay(0.5f);
		lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
	    mListView.setLayoutAnimation(lac);
	    //mListView.startLayoutAnimation();
	}
}
