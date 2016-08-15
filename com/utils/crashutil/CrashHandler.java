package com.utils.crashutil;

import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CrashHandler implements UncaughtExceptionHandler {
	private static  CrashHandler sHandler=null;
	private static final UncaughtExceptionHandler sDefaultHandler = Thread
			.getDefaultUncaughtExceptionHandler();
	private static final ExecutorService THREAD_POOL = Executors
			.newSingleThreadExecutor();
	private Future<?> future;
	private CrashListener mListener;
	private File mLogFile;

	public static CrashHandler getInstance() {
		if(sHandler== null){
			synchronized (CrashHandler.class)
            {
                if (sHandler == null)
                {
                	sHandler = new CrashHandler();
                }
            }
		}
		return sHandler;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		CrashLogUtil.writeLog(mLogFile, "CrashHandler", ex.getMessage(), ex);
		future = THREAD_POOL.submit(new Runnable() {
			public void run() {
				if (mListener != null) {
					mListener.afterSaveCrash(mLogFile);
				}
			};
		});
		if (!future.isDone()) {
			try {
				future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sDefaultHandler.uncaughtException(thread, ex);
	}

	public void init(File logFile, CrashListener listener) {
		mLogFile = logFile;
		mListener = listener;
	}

}
