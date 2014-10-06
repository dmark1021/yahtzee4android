package com.tum.yahtzee.services;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MessageService {
	public static void showMessage(Context context, String title, String message) {
		AlertDialog.Builder alertDialog_build = new AlertDialog.Builder(context);
		alertDialog_build.setCancelable(false);
		alertDialog_build.setTitle(title);
		alertDialog_build.setMessage(message);
		alertDialog_build.setPositiveButton("OK",
		   new DialogInterface.OnClickListener() {
			 
		      public void onClick(DialogInterface dialog, int which) {
		    	  dialog.dismiss();
		    }
		   });
		AlertDialog alertDialog = alertDialog_build.create();
		alertDialog.show();
	}
	
	public static void showMessage(Context context, String title, String message, final MethodPointer methodPointer) {
		AlertDialog.Builder alertDialog_build = new AlertDialog.Builder(context);
		alertDialog_build.setCancelable(false);
		alertDialog_build.setTitle(title);
		alertDialog_build.setMessage(message);
		alertDialog_build.setPositiveButton("OK",
		   new DialogInterface.OnClickListener() {
			 
		      public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					methodPointer.execute();
		    }
		   });
		AlertDialog alertDialog = alertDialog_build.create();
		alertDialog.show();
	}
}
