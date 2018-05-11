package com.github.yglll.funlive.view.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.view.MainActivity;


public class FunLiveWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId:appWidgetIds){
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views=new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            //views.setOnClickPendingIntent(R.id.widget,pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId,views);
        }
    }
}