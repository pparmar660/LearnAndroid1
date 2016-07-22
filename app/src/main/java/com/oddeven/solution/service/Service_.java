package com.oddeven.solution.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Parvesh on 14-07-2016.
 */
public class Service_ extends Service{
    Timer timerTask=new Timer();
    int updateInterval=1000;
  public  int  count=0;
    public  void doSometing(){

        timerTask.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i("timer running ",String.valueOf(count++));
            }
        },0,updateInterval);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private  int DownloadFile(URL url){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}

        return  100;    }

    private class  DoBackgroudTask extends AsyncTask<URL,Integer,Long>
    {

        @Override
        protected void onPreExecute() {
int a;
            a=0;
        }

        @Override
        protected Long doInBackground(URL... params) {
            int count=params.length;
            long totalByteDownloaded=0;
            for (int i=0;i<count;i++){
                totalByteDownloaded +=DownloadFile(params[i]);
                publishProgress((int)((i+1/count)*100));

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Toast.makeText(getBaseContext(),String.valueOf(values[0])+"% downloaded",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Long aLong) {
            Toast.makeText(getBaseContext(),"Data is downloaed",Toast.LENGTH_LONG).show();
            stopSelf();
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        doSometing();
//                        try {
//                            new DoBackgroudTask().execute(new URL("https://www.google.co.in/?gfe_rd=cr&ei=D9qGV6jAI5WmvwSct5CgBg"),new URL("https://www.google.co.in/?gfe_rd=cr&ei=D9qGV6jAI5WmvwSct5CgBg"),new URL("https://www.google.co.in/?gfe_rd=cr&ei=D9qGV6jAI5WmvwSct5CgBg"),new URL("https://www.google.co.in/?gfe_rd=cr&ei=D9qGV6jAI5WmvwSct5CgBg"));
//
//                        }catch(MalformedURLException e)
//        {
//            Log.e("Srvice error", e.getMessage());
//
//        }

        return START_STICKY;































    }
}
