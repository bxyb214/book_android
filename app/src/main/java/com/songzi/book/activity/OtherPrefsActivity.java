package com.songzi.book.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.songzi.book.R;
import com.songzi.book.fragment.PrefsFragment;
import com.songzi.book.fragment.PrefsFragment.OnPreChangeListener;

/**
 * 类说明： 	用于 Android4.0+ 的设置页Activity
 * 
 * @date 	2014-9-20
 * @version 1.0
 */
@SuppressLint("NewApi")
public class OtherPrefsActivity extends BaseActivity implements OnPreChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(R.string.actionbar_title_setting);
		
		getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
	}
	
	@Override
	public void onChanged(boolean result) {
		
		recreateActivity();
	}
}