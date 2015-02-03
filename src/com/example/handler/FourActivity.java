package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FourActivity extends Activity implements OnClickListener {

	private Button button1;
	private Button button2;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Message msg2 = new Message();
			threadhandler.sendMessageDelayed(msg2, 1000);
			System.out.println("main handler");
			super.handleMessage(msg);
		}
	};
	private Handler threadhandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		HandlerThread thread = new HandlerThread("handler_thread");
		thread.start();
		threadhandler = new Handler(thread.getLooper()) {
			@Override
			public void handleMessage(Message msg) {
				Message msg1 = new Message();
				System.out.println("thread handler");
				handler.sendMessageDelayed(msg1, 1000);
				super.handleMessage(msg);
			}
		};
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			handler.sendEmptyMessage(0);
			break;
		case R.id.button2:
			handler.removeMessages(0);
			break;

		default:
			break;
		}
	}

}
