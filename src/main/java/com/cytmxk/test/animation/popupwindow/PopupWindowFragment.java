package com.cytmxk.test.animation.popupwindow;

import com.cytmxk.customview.slidingmenu.SlidingMenu;
import com.cytmxk.test.R;
import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PopupWindowFragment extends Fragment{

	private Button mBtShowLocationPopupWindow = null;
	private Button mBtShowDropdownPopupWindow = null;
    //自定义的弹出框类  
	SlidingMenu menuWindow;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_popupwindow, container, false);
		mBtShowLocationPopupWindow = (Button) view.findViewById(R.id.bt_show_location_popup_window);
		mBtShowDropdownPopupWindow = (Button) view.findViewById(R.id.bt_show_dropdown_popup_window);
		mBtShowLocationPopupWindow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//实例化SelectPicPopupWindow  
                menuWindow = new SlidingMenu(getActivity(), R.menu.sliding_menu, R.style.AnimBottom);
				menuWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_light)));
                //显示窗口  
                menuWindow.showAtLocation(getActivity().findViewById(R.id.fragment_popup_window), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置  
			}
		});
		mBtShowDropdownPopupWindow.setOnClickListener(new View.OnClickListener() {
			
			@TargetApi(Build.VERSION_CODES.KITKAT)
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//实例化SelectPicPopupWindow  
                menuWindow = new SlidingMenu(getActivity(), R.menu.sliding_menu, R.style.AnimScale);
				menuWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_light)));
                //显示窗口  
                menuWindow.showAsDropDown(mBtShowDropdownPopupWindow, 0, 50, Gravity.TOP | Gravity.START);
			}
		});
		return view;
	}
}
