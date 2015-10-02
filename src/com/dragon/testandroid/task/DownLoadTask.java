package com.dragon.testandroid.task;

import com.dragon.testandroid.download.DownloadModel;

import android.R.integer;
import android.R.string;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownLoadTask extends AsyncTask<Integer, Integer, String> {
	private TextView textView;
	private ProgressBar progressBar;
	private Button button;
	public DownLoadTask(){
	}
	public DownLoadTask(TextView textView, ProgressBar progressBar,Button button) {
		super();
		this.textView = textView;
		this.progressBar = progressBar;
		this.button = button;
	}

	//doinbackground、是用来实现耗时任务的
	@Override
	protected String doInBackground(Integer... params) {
		// 开始模拟的下载
		DownloadModel downloadModel = new DownloadModel();
		int i = 0;
		for( ; i < params[0]; i++){
			downloadModel.operate();
			int a = (int) ((i+1)/(params[0]+0.0)*100);
			Log.i("下载进度", a+"");
			publishProgress(a);  
		}
		return "下载"+params[0].intValue()+"的任务顺利完成！！！！";
	}
	//任务结束后执行的操作
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		textView.setText("异步操作结束："+result);
		button.setEnabled(false);
	}
	//任务执行前执行的操作
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		textView.setText("");
		Log.i("info", "》》》》》》》》》》异步操作开始！！！！！！！");
	}
	
	/**  
     * 这里的Intege参数对应AsyncTask中的第二个参数  
     * 在doInBackground方法当中，，每次调用publishProgress方法都会触发onProgressUpdate执行  
     * onProgressUpdate是在UI线程中执行，所有可以对UI空间进行操作  
     */  
	@Override
	protected void onProgressUpdate(Integer... values) {
		// 实时更新进度条
		super.onProgressUpdate(values);
		int progress = values[0];
		progressBar.setProgress(progress);
	}
	
}
