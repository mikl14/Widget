package widget.test.clockwidgetalarm;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeReceiver extends BroadcastReceiver {
    private static final String TAG = "TimeReceiver";

    public final static String ACTION_SEND = "widget.test.clockwidgetalarm.ACTION_SEND";
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        String time = sdf.format(new Date());
        Log.i(TAG, "--onReceive-- " + time);
        updateViews(context);
    }
    private void updateViews(Context context){
        String time = sdf.format(new Date());

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.clock_widget);
        rv.setImageViewResource(R.id.imageView,R.drawable.lnm2);
        rv.setImageViewResource(R.id.imageView1,R.drawable.lnm21);

        //rv.setTextViewText(R.id.ditialTimer,time);
        Log.i(TAG, "updateViews: time:"+ time);
        AppWidgetManager manager= AppWidgetManager.getInstance(context);
        ComponentName cn = new ComponentName(context, ClockWidget.class);
        manager.updateAppWidget(cn,rv);
    }
}
