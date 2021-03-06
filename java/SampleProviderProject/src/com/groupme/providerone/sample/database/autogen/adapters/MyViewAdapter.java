/*
 * This file has been auto-generated by ProviderOne
 *
 * Copyright (C) 2011 GroupMe, Inc.
 */
package com.groupme.providerone.sample.database.autogen.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.groupme.providerone.sample.database.objects.MyView;
import com.groupme.providerone.sample.database.tables.MyViewInfo;

public abstract class MyViewAdapter extends CursorAdapter {

    public static CursorLoader createCursorLoader(Context ctx, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (projection == null)
            projection = MyViewInfo.ALL_COLUMNS;
        return new CursorLoader(ctx, MyViewInfo.CONTENT_URI, projection, selection, selectionArgs, sortOrder);
    }

    public static CursorLoader createCursorLoader(Context ctx, MyViewInfo.ColumnHelper columnHelper, String selection, String[] selectionArgs, String sortOrder) {
        return new CursorLoader(ctx, MyViewInfo.CONTENT_URI, columnHelper == null ? MyViewInfo.ALL_COLUMNS : columnHelper.projection, selection, selectionArgs, sortOrder);
    }

    protected MyViewInfo.ColumnHelper mColumnHelper = null;

    public MyViewAdapter(Context context, String[] projection) {
        super(context, null, false);
        if (projection == null)
            projection = MyViewInfo.ALL_COLUMNS;
        mColumnHelper = new MyViewInfo.ColumnHelper(projection);
    }

    public MyViewAdapter(Context context, MyViewInfo.ColumnHelper columnHelper) {
        super(context, null, false);
        if (columnHelper == null)
            columnHelper = MyViewInfo.ALL_COLUMNS_HELPER;
        mColumnHelper = columnHelper;
    }

    public MyViewInfo.ColumnHelper getColumnHelper() {
        return mColumnHelper;
    }

    public String[] getProjection() {
        return mColumnHelper.projection;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (!mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        View v;
        MyView myView = MyView.fromCursor(mCursor, mColumnHelper);
        if (convertView == null) {
            v = newView(mContext, myView, parent, position);
        } else {
            v = convertView;
        }
        bindView(v, mContext, myView, position);
        return v;
    }
    
    @Override
    public void bindView(View view, Context ctx, Cursor cursor) {
        //empty
    }

    @Override
    public View newView(Context ctx, Cursor cursor, ViewGroup parent) {
        //empty
        return null;
    }

    abstract public View newView(Context ctx, MyView myView, ViewGroup parent, int position);
    abstract public void bindView(View view, Context ctx, MyView myView, int position);

}
