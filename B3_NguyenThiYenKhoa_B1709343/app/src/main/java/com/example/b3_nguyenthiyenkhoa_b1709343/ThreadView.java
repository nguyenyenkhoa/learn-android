package com.example.b3_nguyenthiyenkhoa_b1709343;

import android.graphics.*;
import android.view.*;

public class ThreadView extends Thread{
    private GamePanel mpanel;
    private SurfaceHolder mholder;
    private boolean mrun = false;

    public ThreadView (GamePanel panel){
        mpanel = panel;
        mholder = mpanel.getHolder();
    }

    public void setRunning(boolean run){
        mrun = run;
    }

    @Override
    public void run(){
        Canvas canvas = null;
        while (mrun){
            canvas = mholder.lockCanvas();
            if (canvas!=null){
                mpanel.doDraw(canvas);
                mholder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
