package com.github.yglll.funlive.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;



public class FunLiveProvide extends ContentProvider {
    private static final UriMatcher uriMatcher=getUriMatcher();
    public static final String AUTHORITIES="com.github.yglll.funlive.db.provider";
    public static final String QUERY="/query/";
    public static final String DELETE="/delete/";
    public static final String CONTENTAGREEMENT="content://";

    static final int QUERYALLCOLLECTIONROOM=1;
    static final int QUERYALLHISTORYROOM=2;
    static final int DELETECOLLECTIONROOMBYID=3;
    static final int DELETEHISTORYROOMBYID=4;

    private FunLiveDB funLiveDB;

    private static UriMatcher getUriMatcher(){
        UriMatcher u=new UriMatcher(UriMatcher.NO_MATCH);
        //第一个参数这是在AndroidManifest.xml中内容提供者注册清单中的authorities，
        //第二个参数需要匹配的路径名，
        //第三个参数这是路径匹配时所返回的值
        u.addURI(AUTHORITIES,QUERY+FunLiveDbHelper.collection,QUERYALLCOLLECTIONROOM);
        u.addURI(AUTHORITIES,QUERY+FunLiveDbHelper.history,QUERYALLHISTORYROOM);
        u.addURI(AUTHORITIES,DELETE+FunLiveDbHelper.collection,DELETECOLLECTIONROOMBYID);
        u.addURI(AUTHORITIES,DELETE+FunLiveDbHelper.history,DELETEHISTORYROOMBYID);
        return u;
    }

    @Override
    public boolean onCreate() {
        funLiveDB=FunLiveDB.getInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Logger.i("query");
        Cursor cursor;
        switch(uriMatcher.match(uri)){
            case QUERYALLCOLLECTIONROOM:
                cursor=funLiveDB.getSqLiteDatabase().query(FunLiveDbHelper.collection,null,null,null,null,null,null);
                break;
            case QUERYALLHISTORYROOM:
                cursor=funLiveDB.getSqLiteDatabase().query(FunLiveDbHelper.history,null,null,null,null,null,null);
                break;
            default:
                Logger.i("Unknown uri");
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        //能回调onLoadFinished
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return new String();
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        getContext().getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int i;
        switch(uriMatcher.match(uri)){
            case DELETECOLLECTIONROOMBYID:
                i=funLiveDB.getSqLiteDatabase().delete(FunLiveDbHelper.collection,s,strings);
                break;
            case DELETEHISTORYROOMBYID:
                i=funLiveDB.getSqLiteDatabase().delete(FunLiveDbHelper.history,s,strings);
                break;
            default:
                i=0;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        getContext().getContentResolver().notifyChange(uri, null);
        return 0;
    }
}
