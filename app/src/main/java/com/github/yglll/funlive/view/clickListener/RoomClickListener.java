package com.github.yglll.funlive.view.clickListener;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.CallSuper;
import android.view.View;

import com.github.yglll.funlive.db.FunLiveDB;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.db.FunLiveDbHelper;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/2/20.
 */
//可以记录历史纪录的ClickListener
//todo 全面使用这个ClickListener
public class RoomClickListener implements View.OnClickListener {

    private RoomInfo roomInfo;
    private String tableName;
    private FunLiveDB funLiveDB;

    public RoomClickListener(Context context,RoomInfo roomInfo){
        this.roomInfo=roomInfo;
        tableName=FunLiveDbHelper.userHistoryTableName;
        funLiveDB=FunLiveDB.getInstance(context);
    }
    public RoomClickListener(Context context,RoomInfo roomInfo,String tableName){
        this.roomInfo=roomInfo;
        this.tableName=tableName;
        funLiveDB=FunLiveDB.getInstance(context);
    }

    @Override
    @CallSuper
    public void onClick(View view) {
        //save history
        funLiveDB.setRoomInfo(roomInfo,tableName);
    }
}
