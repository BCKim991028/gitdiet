/*package com.course.project;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class ContentsProvider extends ContentProvider {
    static final String PROVIDER_NAME = "com.course.ContentsProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/Foods";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String FOOD_NAME = "food_name";
    static final String FOOD_NUM = "food_num";
    static final String FOOD_FEEL = "food_feel";
    static final String EAT_TIME = "eat_time";
    static final String LATITUDE = "latitude";
    static final String LONGITUDE = "longitude";
    public foodDBManager dbManager;
    public ContentsProvider() {
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return dbManager.delete(selection, selectionArgs);
    }
    @Override
    public String getType(Uri uri) {
        return null;
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowid = dbManager.insert(values);
        return null;
    }
    @Override
    public boolean onCreate() {
        dbManager = foodDBManager.getInstance(getContext());
        return true;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return dbManager.query(projection, selection, selectionArgs, null,
                null, sortOrder);
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
*/