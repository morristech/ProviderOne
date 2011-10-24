package {PackageName}.database.tables;

import {PackageName}.database.autogen.tables.Base{CapCamelTableName}Info;

public class {CapCamelTableName}Info extends Base{CapCamelTableName}Info {


    public static void upgradeTable(SQLiteDatabase db, int oldVersion, int newVersion) {
        Base{CapCamelTableName}Info.upgradeTable(db, oldVersion, newVersion);
    }

    public static class ColumnHelper extends Base{CapCamelTableName}Info.ColumnHelper {

        public ColumnHelper(String[] projection) {
            super(projection);
        }

    }
}