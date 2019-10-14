package com.semi.ex01;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 2017-07-26.
 */
public class controlMysql extends Thread {

    public static boolean active=false;
    Handler mHandler;
    String url=null;




    public controlMysql(String image){ //이미지 추가
        String userdeviceinfo_url="http://1.250.62.157/addimage.php?";
        mHandler= new Handler(Looper.getMainLooper());
        String imageurl=image;
        Log.d("Main",imageurl);

        url=userdeviceinfo_url+imageurl;
        Log.d("Main",url);

    }



    /**
     * Calls the <code>run()</code> method of the Runnable object the receiver
     * holds. If no Runnable is set, does nothing.
     *
     * @see Thread#start
     */
    @Override
    public void run() {
        super.run();
        if(active){
            Log.d("Main","스레드실행");

            StringBuilder jsonHtml = new StringBuilder();
            try {
                URL phpUrl = new URL(url);
                Log.d("Main", url);

                HttpURLConnection conn = (HttpURLConnection)phpUrl.openConnection();

                if ( conn != null ) {
                    Log.d("Main", "conn 널아님");
                    conn.setConnectTimeout(10000);
                    conn.setUseCaches(false);
                    conn.setRequestProperty("Content-Length", Integer.toString(url.length())+1000);

                    Log.d("Main", String.valueOf(conn.getResponseCode()));
                    Log.d("Main", String.valueOf(HttpURLConnection.HTTP_OK));
                    if ( conn.getResponseCode() == HttpURLConnection.HTTP_OK ) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                        while ( true ) {
                            String line = br.readLine();
                            if ( line == null )
                                break;
                            jsonHtml.append(line + "\n");

                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            } catch ( Exception e ) {
                e.printStackTrace();

            }

            show(jsonHtml.toString());

        }

    }

    void show(final String result){
        mHandler.post(new Runnable(){

            @Override
            public void run() {
                ImageActivity.add_image(result);

            }
        });

    }


}

