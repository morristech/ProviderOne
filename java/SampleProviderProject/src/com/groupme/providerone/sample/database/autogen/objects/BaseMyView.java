/*
 * This file has been auto-generated by ProviderOne
 *
 * Copyright (C) 2011 GroupMe, Inc.
 */
package com.groupme.providerone.sample.database.autogen.objects;


import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;

import com.groupme.providerone.sample.database.SampleProvider;
import com.groupme.providerone.sample.database.autogen.SamplePersistentObject;
import com.groupme.providerone.sample.database.objects.MyView;
import com.groupme.providerone.sample.database.tables.MyViewInfo;

public abstract class BaseMyView extends SamplePersistentObject {

	public static final boolean IS_EDITABLE = false;

    public static MyView fromCursor(Cursor cursor, MyView.ColumnHelper helper) {
        MyView obj = new MyView();
        obj.hydrate(cursor, helper);
        return obj;
    }

    public static MyView fromJson(JSONObject obj) {
        if (obj == null)
            return null;
        MyView myView = new MyView();
        myView.hydrate(obj);
        return myView;
    }

    public static int getCount(String selection, String[] selectionArgs) {
        return getSingleIntResult(MyViewInfo.COUNT_URI, null, selection, selectionArgs, null);
    }

    public static int getIntSum(String columnName, String selection, String[] selectionArgs) {
        return getSingleIntResult(MyViewInfo.SUM_URI, new String[] {columnName}, selection, selectionArgs, null);
    }

    public static long getLongSum(String columnName, String selection, String[] selectionArgs) {
        return getSingleLongResult(MyViewInfo.SUM_URI, new String[] {columnName}, selection, selectionArgs, null);
    }

    public static double getDoubleSum(String columnName, String selection, String[] selectionArgs) {
        return getSingleDoubleResult(MyViewInfo.SUM_URI, new String[] {columnName}, selection, selectionArgs, null);
    }

    public static float getFloatSum(String columnName, String selection, String[] selectionArgs) {
        return getSingleFloatResult(MyViewInfo.SUM_URI, new String[] {columnName}, selection, selectionArgs, null);
    }

    public static ArrayList<MyView> findAllWhere(String selection, String[] selectionArgs, String sortOrder) {
        return findAllWhere(MyViewInfo.ALL_COLUMNS_HELPER, selection, selectionArgs, sortOrder);
    }

    public static ArrayList<MyView> findAllWhere(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return findAllWhere(projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection), selection, selectionArgs, sortOrder);
    }

    public static ArrayList<MyView> findAllWhere(MyViewInfo.ColumnHelper helper, String selection, String[] selectionArgs, String sortOrder) {
        return findAllByUri(MyViewInfo.CONTENT_URI, helper, selection, selectionArgs, sortOrder);
    }

    public static MyView findOneWhere(String selection, String[] selectionArgs, String orderBy) {
        return findOneWhere(MyViewInfo.ALL_COLUMNS_HELPER, selection, selectionArgs, orderBy);
    }

    public static MyView findOneWhere(String[] projection, String selection, String[] selectionArgs, String orderBy) {
        return findOneWhere(projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection), selection, selectionArgs, orderBy);
    }

    public static MyView findOneWhere(MyViewInfo.ColumnHelper helper, String selection, String[] selectionArgs, String orderBy) {
        return findOneByUri(MyViewInfo.CONTENT_URI, helper, selection, selectionArgs, orderBy);
    }

    public static MyView findOneById(long id) {
        return findOneById(id, MyViewInfo.ALL_COLUMNS_HELPER);
    }

    public static MyView findOneById(long id, String[] projection) {
        return findOneById(id, projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection));
    }

    public static MyView findOneById(long id, MyViewInfo.ColumnHelper helper) {
        return findOneByUri(MyViewInfo.buildIdLookupUri(id), helper, null, null, null);
    }


    public static MyView findOneByMyString(String myString) {
        return findOneByMyString(myString, MyViewInfo.ALL_COLUMNS_HELPER);
    }
            
    public static MyView findOneByMyString(String myString, String[] projection) {
        return findOneByMyString(myString, projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection));
    }
    
    public static MyView findOneByMyString(String myString, MyViewInfo.ColumnHelper helper) {
        return findOneByUri(MyViewInfo.buildMyStringLookupUri(myString.toString()), helper, null, null, null);
    }

    public static MyView findOneWithMyStringInArray(String myString, ArrayList<MyView> myViewList) {
		if (myString == null || myViewList == null || myViewList.isEmpty())
            return null;
        for (MyView myView : myViewList) {
            if (myView.mMyStringSet && myView.mMyString != null && myView.mMyString.equals(myString))
                return myView;
        }
        return null;
    }


	public static MyView findOneWithIdInArray(long id, ArrayList<MyView> myViewList) {
	    if (myViewList == null || myViewList.isEmpty())
	        return null;
	    for (MyView myView : myViewList) {
	        if (myView.mIdSet && myView.mId != null && myView.mId.longValue() == id)
	            return myView;
	    }
	    return null;
	}

    public static MyView findOneByUri(Uri uri, MyViewInfo.ColumnHelper helper, String selection, String[] selectionArgs, String sortOrder) {
        MyView rtr = null;

        if (helper == null)
            helper = MyViewInfo.ALL_COLUMNS_HELPER;
        
        if (TextUtils.isEmpty(sortOrder))
            sortOrder = MyViewInfo.Columns._ID;

        Cursor c = SampleProvider.getAppContext().getContentResolver().query(
                uri,
                helper.projection,
                selection,
                selectionArgs,
                sortOrder + " LIMIT 1");
        if (c != null) {
            if (c.moveToFirst()) {
                rtr = fromCursor(c, helper);
            }
            c.close();
        }
        return rtr;
    }

    public static ArrayList<MyView> findAllByUri(Uri uri, MyViewInfo.ColumnHelper helper, String selection, String[] selectionArgs, String sortOrder) {
        if (helper == null)
            helper = MyViewInfo.ALL_COLUMNS_HELPER;

        Cursor c = SampleProvider.getAppContext().getContentResolver().query(uri, helper.projection, selection, selectionArgs, sortOrder);
        ArrayList<MyView> rtr = new ArrayList<MyView>();
        if (c != null) {
            while(c.moveToNext()) {
                rtr.add(MyView.fromCursor(c, helper));
            }
            c.close();
        }
        return rtr;
    }

	protected Long mId = null;
	protected boolean mIdSet = false;
	protected Boolean mMyBoolean = null;
	protected boolean mMyBooleanSet = false;
	protected String mMyString = null;
	protected boolean mMyStringSet = false;


    public BaseMyView() {
        super();
    }
    public BaseMyView(Parcel in) {
        readFromParcel(in);
    }

    private void assertColumnHelper(ColumnHelper helper, boolean allowNull) {
        if (helper == null) {
            if (allowNull)
                return;
            else
                throw new IllegalArgumentException("Trying to use a null column helper with MyView");
        }
        if (!(helper instanceof MyViewInfo.ColumnHelper))
            throw new IllegalArgumentException("Trying to use wrong type of ColumnHelper with MyView - " + helper.getClass().getName());
    }

    @Override
    public void hydrate(Cursor c, ColumnHelper helper) {
        assertColumnHelper(helper, false);
        hydrate(c, (MyViewInfo.ColumnHelper)helper);
    }

    public void hydrate(Cursor c, MyViewInfo.ColumnHelper h) {
        if (h.col__id != -1) {
            mId = c.isNull(h.col__id) ? null : c.getLong(h.col__id);
            mIdSet = true;
        } else {
            mId = null;
            mIdSet = false;
        }
        if (h.col_my_boolean != -1) {
            mMyBoolean = c.isNull(h.col_my_boolean) ? null : (c.getInt(h.col_my_boolean) == 1);
            mMyBooleanSet = true;
        } else {
            mMyBoolean = null;
            mMyBooleanSet = false;
        }
        if (h.col_my_string != -1) {
            mMyString = c.getString(h.col_my_string);
            mMyStringSet = true;
        } else {
            mMyString = null;
            mMyStringSet = false;
        }

        mIsNew = false;
    }

    @Override
	public void hydrate(JSONObject obj) {
		if (obj == null)
			return;
//_id doesnt get hydrated from json
		if (obj.has(MyViewInfo.Columns.MY_BOOLEAN)) {
		    try {
				if (obj.isNull(MyViewInfo.Columns.MY_BOOLEAN)) {
					mMyBoolean = null;
				} else {
					mMyBoolean = obj.getBoolean(MyViewInfo.Columns.MY_BOOLEAN);
				}
		    } catch (JSONException e) {
		        mMyBoolean = null;
		    }
		    mMyBooleanSet = true;
		}
		if (obj.has(MyViewInfo.Columns.MY_STRING)) {
		    try {
				if (obj.isNull(MyViewInfo.Columns.MY_STRING)) {
					mMyString = null;
				} else {
					mMyString = obj.getString(MyViewInfo.Columns.MY_STRING);
				}
		    } catch (JSONException e) {
		        mMyString = null;
		    }
		    mMyStringSet = true;
		}

	}

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
		if (mIdSet)
			values.put(MyViewInfo.Columns._ID, mId);
		if (mMyBooleanSet)
			values.put(MyViewInfo.Columns.MY_BOOLEAN, mMyBoolean);
		if (mMyStringSet)
			values.put(MyViewInfo.Columns.MY_STRING, mMyString);

        return values;
    }

    @Override
    public JSONObject toJson(ColumnHelper helper) throws JSONException {
        assertColumnHelper(helper, true);
        return toJson((MyViewInfo.ColumnHelper)helper);
    }

    @Override
    public JSONObject toJson(String[] projection) throws JSONException {
        return toJson(projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection));
    }

    public JSONObject toJson(MyViewInfo.ColumnHelper h) throws JSONException {
        if (h == null)
            h = MyViewInfo.ALL_COLUMNS_HELPER;
        JSONObject rtr = new JSONObject();
		if (mIdSet && h.col__id != -1)
			rtr.put(MyViewInfo.Columns._ID, mId);
		if (mMyBooleanSet && h.col_my_boolean != -1)
			rtr.put(MyViewInfo.Columns.MY_BOOLEAN, mMyBoolean);
		if (mMyStringSet && h.col_my_string != -1)
			rtr.put(MyViewInfo.Columns.MY_STRING, mMyString);

        return rtr;
    }

    @Override
    public void save() {
		throw new UnsupportedOperationException("Cannot save or delete a MyView because it's a sqlite view");
    }

    @Override
    public ContentProviderOperation getSaveProviderOperation() {
		throw new UnsupportedOperationException("Cannot save or delete a MyView because it's a sqlite view");
    }

    @Override
    public void markForDeletion() {
		throw new UnsupportedOperationException("Cannot save or delete a MyView because it's a sqlite view");
    }

    @Override
    public int delete() {
		throw new UnsupportedOperationException("Cannot save or delete a MyView because it's a sqlite view");
    }
    
    @Override
    public boolean reload() {
        return reload(MyViewInfo.ALL_COLUMNS_HELPER);
    }

    @Override
    public boolean reload(String[] projection) {
        return reload(projection == null ? MyViewInfo.ALL_COLUMNS_HELPER : new MyViewInfo.ColumnHelper(projection));
    }

    @Override
    public boolean reload(ColumnHelper helper) {
        assertColumnHelper(helper, true);
        return reload((MyViewInfo.ColumnHelper)helper);
    }
    
    public boolean reload(MyViewInfo.ColumnHelper helper) {
        if (isNew() || !mIdSet)
            throw new IllegalArgumentException("Trying to reload a record without an id");
        if (helper == null)
            helper = MyViewInfo.ALL_COLUMNS_HELPER;
        
        boolean result = false;
        
        Cursor c = SampleProvider.getAppContext().getContentResolver().query(
                MyViewInfo.buildIdLookupUri(mId),
                helper.projection,
                null,
                null,
                null);
        if (c != null) {
            if (c.moveToFirst()) {
                hydrate(c, helper);
                result = true;
            }
            c.close();
        }
        return result;
    }

	public Uri getIdLookupUri() {
		if (isNew() || !mIdSet)
			return null;
		else
			return MyViewInfo.buildIdLookupUri(mId);
	}

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
        mIdSet = true;
        mIsNew = id == null;
    }

    public Boolean getMyBoolean() {
        return mMyBoolean;
    }

    public void setMyBoolean(Boolean myBoolean) {
        mMyBoolean = myBoolean;
        mMyBooleanSet = true;
    }

    public String getMyString() {
        return mMyString;
    }

    public void setMyString(String myString) {
        mMyString = myString;
        mMyStringSet = true;
    }



    public boolean isIdSet() {
        return mIdSet;
    }
    public boolean isMyBooleanSet() {
        return mMyBooleanSet;
    }
    public boolean isMyStringSet() {
        return mMyStringSet;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

		dest.writeValue(mId);
		dest.writeInt(mIdSet ? 1 : 0);

		dest.writeValue(mMyBoolean);
		dest.writeInt(mMyBooleanSet ? 1 : 0);

		dest.writeValue(mMyString);
		dest.writeInt(mMyStringSet ? 1 : 0);


    }

    @Override
    public void readFromParcel(Parcel in) {
        super.readFromParcel(in);

		mId = (Long) in.readValue(Long.class.getClassLoader());
		mIdSet = in.readInt() == 1;

		mMyBoolean = (Boolean) in.readValue(Boolean.class.getClassLoader());
		mMyBooleanSet = in.readInt() == 1;

		mMyString = (String) in.readValue(String.class.getClassLoader());
		mMyStringSet = in.readInt() == 1;


    }

}
