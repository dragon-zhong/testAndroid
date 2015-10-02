package com.dragon.testandroid;

import com.dragon.testandroid.task.DownLoadTask;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	private Button button;
	private TextView textView;
	private ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.textView01);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		//按钮点击开始下载任务
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 开始一部任务的执行
				new DownLoadTask(textView,progressBar,button).execute(10);
				
			}
		});
		
	}

}
