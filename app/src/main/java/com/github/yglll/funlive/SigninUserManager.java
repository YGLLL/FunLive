package com.github.yglll.funlive;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


public class SigninUserManager{
    public final static int NOUSER=1;
    public final static int PWDERROR=2;
    public final static int SIGNINSU=-1;

    public static Boolean deleteUser(User user) {
        return null;
    }

    public static Boolean addUser(Context context,User user) {
        if(TextUtils.isEmpty(user.getName())||TextUtils.isEmpty(user.getId())||TextUtils.isEmpty(user.getPwd())){
            return false;
        }else {
            if(getUser(context,user.getName())==null){
                setUserToSP(context,user);
                return true;
            }else {
                return false;
            }
        }
    }

    public static User getSigninUser(Context context) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(SigninUserManager.class.toString(),Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("signinName","");
        return getUser(context,name);
    }

    public static User getUser(Context context,String name) {
        User user=getUserFromSP(context,name);
        if(TextUtils.isEmpty(user.getName())||TextUtils.isEmpty(user.getId())||TextUtils.isEmpty(user.getPwd())){
            return null;
        }else {
            return user;
        }
    }

    public static int userSignin(Context context,User user) {
        User readUser=getUser(context,user.getName());
        if(readUser==null){
            return NOUSER;
        }else {
            if(readUser.getPwd().equals(user.getPwd())){
                SharedPreferences sharedPreferences=context.getSharedPreferences(SigninUserManager.class.toString(),Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("signinName",user.getName());
                editor.apply();
                return SIGNINSU;
            }else {
                return PWDERROR;
            }
        }
    }

    public static Boolean userLogout(Context context) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(SigninUserManager.class.toString(),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("signinName","");
        editor.apply();
        return true;
    }

    private static User getUserFromSP(Context context,String name){
        User u=new User();
        SharedPreferences sharedPreferences=context.getSharedPreferences(SigninUserManager.class.toString(),Context.MODE_PRIVATE);
        u.setId(sharedPreferences.getString("id"+name,""));
        u.setName(sharedPreferences.getString("name"+name,""));
        u.setPwd(sharedPreferences.getString("pwd"+name,""));
        return u;
    }

    private static void setUserToSP(Context context,User u){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SigninUserManager.class.toString(),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("id"+u.getName(),u.getId());
        editor.putString("name"+u.getName(),u.getName());
        editor.putString("pwd"+u.getName(),u.getPwd());
        editor.apply();
    }
}
