package com.Shrutika.bankingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public Database(@Nullable Context context) {
        super(context, "User.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9156745634,'SHRUTIKA',9000.00,'shrutika59@gmail.com','XXXXXXXXXXXX8786','CBIN0280593')");
        db.execSQL("insert into user_table values(9234565431,'ANKITA',599.60,'ankita56@gmail.com','XXXXXXXXXXXX7675','CBIN0280691')");
        db.execSQL("insert into user_table values(8765432345,'SUMIT',4000.60,'sumit67@gmail.com','XXXXXXXXXXXX3452','BKID0000506')");
        db.execSQL("insert into user_table values(8976543245,'PRONOTI',500.01,'pronoti55@gmail.com','XXXXXXXXXXXX1234','BKID0000506')");
        db.execSQL("insert into user_table values(7865435643,'RIYA',8903.90,'riya4@gmail.com','XXXXXXXXXXXX8976','MAHB0001355 ')");
        db.execSQL("insert into user_table values(7654787654,'Anmol',845.06,'anmol23@gmail.com','XXXXXXXXXXXX6756','MAHB0001355 ')");
        db.execSQL("insert into user_table values(9876543563,'DIPALI',5836.00,'dipali12@gmail.com','XXXXXXXXXXXX9877','CBIN0280593')");
        db.execSQL("insert into user_table values(7788676754,'VIJAY',800.22,'vijay23@gmail.com','XXXXXXXXXXXX8756','CBIN0280593')");
        db.execSQL("insert into user_table values(9876543456,'RAM',4004.49,'ram89@gmail.com','XXXXXXXXXXXX9096','BKID0000506')");
        db.execSQL("insert into user_table values(9987687856,'RAJESH',203.40,'rajesh78@gmail.com','XXXXXXXXXXXX4563','MAHB0001355 ')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
