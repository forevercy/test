package com.cytmxk.test.storage;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chenyang on 2017/3/17.
 */

public class StorageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        test();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void test() {
        Log.d("chenyang", "Environment.getRootDirectory() = " + Environment.getRootDirectory().getAbsolutePath());
        Log.d("chenyang", "Environment.getDownloadCacheDirectory() = " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d("chenyang", "Environment.getDataDirectory() = " + Environment.getDataDirectory().getAbsolutePath());
        Log.d("chenyang", "Environment.getExternalStoragePublicDirectory(\"\") = " + Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
        Log.d("chenyang", "Environment.getExternalStoragePublicDirectory(\"dir1\") = " + Environment.getExternalStoragePublicDirectory("dir1").getAbsolutePath());
        Log.d("chenyang", "Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) = " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        Log.d("chenyang", "Environment.getExternalStorageDirectory() = " + Environment.getExternalStorageDirectory().getAbsolutePath());

        Log.d("chenyang", "Context.getFilesDir() = " + getContext().getFilesDir().getAbsolutePath());
        Log.d("chenyang", "Context.getFileStreamPath(\"\") = " + getContext().getFileStreamPath("").getAbsolutePath());
        Log.d("chenyang", "Context.getFileStreamPath(\"file1\") = " + getContext().getFileStreamPath("file1").getAbsolutePath());
        //Log.d("chenyang", "Context.getDataDir() = " + getContext().getDataDir().getAbsolutePath());
        Log.d("chenyang", "Context.getCacheDir() = " + getContext().getCacheDir().getAbsolutePath());
        Log.d("chenyang", "Context.getExternalCacheDir() = " + getContext().getExternalCacheDir().getAbsolutePath());
        //Log.d("chenyang", "Context.getExternalCacheDirs() = " + Arrays.toString(getContext().getExternalCacheDirs()));
        //Log.d("chenyang", "Context.getCodeCacheDir() = " + getContext().getCodeCacheDir().getAbsolutePath());
        Log.d("chenyang", "getContext().getDir(\"svcv\", Context.MODE_PRIVATE) = " + getContext().getDir("svcv", Context.MODE_PRIVATE).getAbsolutePath());
        Log.d("chenyang", "Context.getExternalFilesDir(\"\") = " + getContext().getExternalFilesDir("").getAbsolutePath());
        Log.d("chenyang", "Context.getExternalFilesDir(\"file1\") = " + getContext().getExternalFilesDir("file1").getAbsolutePath());
        Log.d("chenyang", "Context.getExternalFilesDir(Environment.DIRECTORY_MUSIC) = " + getContext().getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        //Log.d("chenyang", "Context.getExternalFilesDirs(Environment.DIRECTORY_MUSIC) = " + Arrays.toString(getContext().getExternalFilesDirs(Environment.DIRECTORY_MUSIC)));
        //Log.d("chenyang", "Context.getExternalMediaDirs() = " + Arrays.toString(getContext().getExternalMediaDirs()));
        Log.d("chenyang", "Context.getObbDir() = " + getContext().getObbDir().getAbsolutePath());
        //Log.d("chenyang", "Context.getObbDirs() = " + Arrays.toString(getContext().getObbDirs()));
        //Log.d("chenyang", "Context.getNoBackupFilesDir() = " + getContext().getNoBackupFilesDir().getAbsolutePath());
        Log.d("chenyang", "Context.getDatabasePath(\"hhsh\") = " + getContext().getDatabasePath("hhsh"));
        Log.d("chenyang", "Context.getPackageCodePath() = " + getContext().getPackageCodePath());
        Log.d("chenyang", "Context.getPackageResourcePath() = " + getContext().getPackageResourcePath());
    }
}
