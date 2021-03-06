package com.cytmxk.test.messagemechanism.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cytmxk.test.R;

public class LtrMergePictureFragment extends Fragment {

	private ImageView mIvShowBeauty = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_ltr_merge, container,
				false);
		mIvShowBeauty = (ImageView) view.findViewById(R.id.show_beauty);
		AsyncTaskUtil.getLtrMergePicture(getActivity(), BitmapFactory
				.decodeResource(getResources(), R.drawable.beauty1), BitmapFactory
				.decodeResource(getResources(), R.drawable.beauty2),
				mAsyncTaskListener);
		return view;
	}

	private AsyncTaskUtil.AsyncTaskListener mAsyncTaskListener = new AsyncTaskUtil.AsyncTaskListener() {

		@Override
		public void onGetResultPicture(Bitmap bitmap) {
			// TODO Auto-generated method stub
			mIvShowBeauty.setImageBitmap(bitmap);
		}
	};
}
