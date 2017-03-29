package com.t_mtimer;

import android.app.Application;
import android.content.Context;

public class Tm_TimerApplication extends Application
{
	public static Tm_TimerApplication application;

	public Tm_TimerApplication() {
		application = this;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		application = this;
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	public static Tm_TimerApplication getApp() {
		if (application == null) {
			application = new Tm_TimerApplication();
		}
		return application;
	}

	public static Context getAppContext() {
		if (application == null) {
			application = new Tm_TimerApplication();
		}
		return application;
	}
}
