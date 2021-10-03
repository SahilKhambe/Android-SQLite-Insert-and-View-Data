package com.example.androidsqliteview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbName";
    public static final int DATABASE_VERSION = 1;
    public static final String QUERY =
            "CREATE TABLE " + UserContact.NewUserInfo.TABLE_NAME + "(" + UserContact.NewUserInfo.NAME_KEY + " TEXT," + UserContact.NewUserInfo.CONTACT_KEY + " TEXT," + UserContact.NewUserInfo.EMAIL_KEY + " TEXT);";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("TAG", "Database Created or Opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(QUERY);
        Log.e("TAG", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//  Method to add data
    public void addInformation(String name, String contact, String email, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.NAME_KEY, name);
        contentValues.put(UserContact.NewUserInfo.CONTACT_KEY, contact);
        contentValues.put(UserContact.NewUserInfo.EMAIL_KEY, email);
        sqLiteDatabase.insert(UserContact.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("TAG", "Data inserted");
    }
//  Method to view data
    public Cursor getInfos(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor;
        String[] columns = {UserContact.NewUserInfo.NAME_KEY, UserContact.NewUserInfo.CONTACT_KEY, UserContact.NewUserInfo.EMAIL_KEY};
        cursor = sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
}

}
