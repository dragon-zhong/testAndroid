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

	//doinbackground��������ʵ�ֺ�ʱ�����
	@Override
	protected String doInBackground(Integer... params) {
		// ��ʼģ�������
		DownloadModel downloadModel = new DownloadModel();
		int i = 0;
		for( ; i < params[0]; i++){
			downloadModel.operate();
			int a = (int) ((i+1)/(params[0]+0.0)*100);
			Log.i("���ؽ���", a+"");
			publishProgress(a);  
		}
		return "����"+params[0].intValue()+"������˳����ɣ�������";
	}
	//���������ִ�еĲ���
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		textView.setText("�첽����������"+result);
		button.setEnabled(false);
	}
	//����ִ��ǰִ�еĲ���
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		textView.setText("");
		Log.i("info", "���������������������첽������ʼ��������������");
	}
	
	/**  
     * �����Intege������ӦAsyncTask�еĵڶ�������  
     * ��doInBackground�������У���ÿ�ε���publishProgress�������ᴥ��onProgressUpdateִ��  
     * onProgressUpdate����UI�߳���ִ�У����п��Զ�UI�ռ���в���  
     */  
	@Override
	protected void onProgressUpdate(Integer... values) {
		// ʵʱ���½�����
		super.onProgressUpdate(values);
		int progress = values[0];
		progressBar.setProgress(progress);
	}
	
}
