/*package com.course.project;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class foodDBManager extends SQLiteOpenHelper {
    static final String FOOD_DB = "Foods.db";
    static final String FOOD_TABLE = "Foods";
    Context context = null;
    private static  foodDBManager dbManager = null;
    static final String CREATE_DB = " CREATE TABLE " + FOOD_TABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " student_id TEXT NOT NULL, name TEXT NOT NULL, phone_numberTEXT);";
    public static  foodDBManager getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new foodDBManager(context, FOOD_DB, null, 1);
        }
        return dbManager;
    }
    public foodDBManager(Context context, String dbName,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        this.context = context;
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
    }
    public long insert(ContentValues addValue) {
        return getWritableDatabase().insert(FOOD_TABLE, null, addValue);
    }
    public Cursor query(String [] columns, String selection, String[]
            selectionArgs, String groupBy, String having, String orderBy){
        return getReadableDatabase().query(FOOD_TABLE, columns,
                selection, selectionArgs, groupBy, having, orderBy);
    }
    public int delete(String whereClause, String[] whereArgs) {
        return getWritableDatabase().delete(FOOD_TABLE, whereClause,
                whereArgs);
    }
}
*/