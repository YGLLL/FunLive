package com.github.yglll.funlive.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.yglll.funlive.net.bean.FunLiveRoom;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.utils.Log;

public class FunLiveDB {
    private SQLiteDatabase sqLiteDatabase;
    private static FunLiveDB funLiveDB;

    private FunLiveDB(Context context){
        FunLiveDbHelper funLiveDbHelper=new FunLiveDbHelper(context);
        /*
        * SQLiteOpenHelper 中有两个非常重要的方法，
        * getReadableDatabase() 和getWritableDatabase()。
        * 这两个方法都可以创建或打开一个现有的数据库（如果数据库已存在则直接打开，否则创建一个新的数据库），
        * 并返回一个可对数据库进行读写操作的对象。
        * 不同的是，当数据库不可写入的时候（如磁盘空间已满）
        * getReadableDatabase()方法返回的对象将以只读的方式去打开数据库，
        * 而getWritableDatabase()方法则将出现异常。
        */
        sqLiteDatabase=funLiveDbHelper.getWritableDatabase();
    }
    public synchronized static FunLiveDB getInstance(Context context){
        if(funLiveDB==null){
            return funLiveDB=new FunLiveDB(context);
        }else {
            return funLiveDB;
        }
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public List<FunLiveRoom> getAllFunLiveRoom(String tableName){
        return getFunLiveRoom(-1,tableName);
    }
    public List<FunLiveRoom> getFunLiveRoom(int roomId, String tableName) {
        List<FunLiveRoom> funLiveRoomList=new ArrayList<>();
        Cursor cursor;
        if(roomId==-1){
            cursor=sqLiteDatabase.query(tableName,null,null,null,null,null,null);
        }else {
            cursor=sqLiteDatabase.query(tableName,null,"room_id=?",new String[]{String.valueOf(roomId)},null,null,null);
        }
        if(cursor.moveToFirst()){
            do {
                FunLiveRoom funLiveRoom=new FunLiveRoom();
                funLiveRoom.setId(cursor.getInt(cursor.getColumnIndex("id")));
                funLiveRoom.setHn(cursor.getInt(cursor.getColumnIndex("hn")));
                funLiveRoom.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                funLiveRoom.setOnline(cursor.getInt(cursor.getColumnIndex("online")));
                funLiveRoom.setOwner_uid(cursor.getString(cursor.getColumnIndex("owner_uid")));
                funLiveRoom.setRoom_id(cursor.getInt(cursor.getColumnIndex("room_id")));
                funLiveRoom.setRoom_name(cursor.getString(cursor.getColumnIndex("room_name")));
                funLiveRoom.setRoom_src(cursor.getString(cursor.getColumnIndex("room_src")));
                funLiveRoom.setUrl(cursor.getString(cursor.getColumnIndex("url")));
                if(cursor.getInt(cursor.getColumnIndex("vertical"))==1){
                    funLiveRoom.setVertical(true);
                }else {
                    funLiveRoom.setVertical(false);
                }
                funLiveRoomList.add(funLiveRoom);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return funLiveRoomList;
    }

    public void setFunLiveRoom(FunLiveRoom funLiveRoom,String tableName) {
        //限制最大写入数据
        //int limit=10;
        //while (getTableSize(tableName)>limit){
        //    deleteRoomFromId(0,tableName);
        //}
        ContentValues contentValues=new ContentValues();
        contentValues.put("room_id",funLiveRoom.getRoom_id());
        contentValues.put("room_src",funLiveRoom.getRoom_src());
        contentValues.put("room_name",funLiveRoom.getRoom_name());
        contentValues.put("owner_uid",funLiveRoom.getOwner_uid());
        contentValues.put("online",funLiveRoom.getOnline());
        contentValues.put("hn",funLiveRoom.getHn());
        contentValues.put("nickname",funLiveRoom.getNickname());
        contentValues.put("url",funLiveRoom.getUrl());
        if(funLiveRoom.getVertical()){
            contentValues.put("vertical",1);
        }else {
            contentValues.put("vertical",0);
        }
        sqLiteDatabase.insert(tableName,null,contentValues);
        contentValues.clear();
    }

    public int getTableSize(String tableName){
        int size=0;
        Cursor cursor=sqLiteDatabase.query(tableName,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                size++;
            }while (cursor.moveToNext());
        }
        cursor.close();
        return size;
    }

    public void deleteRoom(int roomId,String tableName){
        sqLiteDatabase.delete(tableName,"room_id=?",new String[]{String.valueOf(roomId)});
    }
    public void deleteRoomFromId(int id,String tableName){
        int i=sqLiteDatabase.delete(tableName,"id=?",new String[]{String.valueOf(id)});
        Logger.i("deleteRoomFromId:"+i+"    id:"+id);
    }
}
