package com.utils.crashutil;

import java.io.File;

import android.content.Context;
/**
 * 将错误日志发送出去
 * @author wan
 * 使用方法
 * Application的类，在onCreate方法中加上如下代码
 * new CrashReport(this).setReceiver("url");
 *
 */
public class CrashReport extends AbstractCrashReportHandler {
	 public CrashReport(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	 	private String mReceiverUrl;  
	    public void setReceiver(String mReceiverUrl) {  
	    	mReceiverUrl = mReceiverUrl;  
	    }  
	      /*
	       * 需要写一个继承自Application的类，在onCreate方法中加上如下代码
	       * new CrashReport(this).setReceiver("log@msdx.pw");
	       * 
	       * 
	       * 
	       */
	    @Override  
	    protected void sendReport(String title, String body, File file) {  
//	        LogMail sender = new LogMail().setUser("irain_log@163.com").setPass("xxxxxxxx")  
//	                .setFrom("irain_log@163.com").setTo(mReceiveEmail).setHost("smtp.163.com")  
//	                .setPort("465").setSubject(title).setBody(body);  
//	        sender.init();  
//	        try {  
//	            sender.addAttachment(file.getPath(), file.getName());  
//	            sender.send();  
//	            file.delete();  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
	    	
	    }  

}
