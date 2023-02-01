package com.example.playerinfovtp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {


    //Constructor
    public DBHelper(Context context) {
        super(context,"sort.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //Create Table
        MyDB.execSQL("Create Table users(fullname TEXT, username TEXT primary key, email TEXT, phone INTEGER, password TEXT)");

        MyDB.execSQL("Create Table player(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, class TEXT, div TEXT,sport TEXT, phone INTEGER,mail TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        //drop Table
        MyDB.execSQL("Drop Table if exists users");
//        MyDB.execSQL("Drop Table if exists student");
    }

    //Method insertData
    public Boolean insertData(String fullname, String username, String email, String phone, String password){
        //
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname",fullname);
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        long result = MyDB.insert("users",null, contentValues);
        //condition
        if (result==-1) return false;
        else
            return true;
    }

    //Function checkusername
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //use rawQuery for checkusername
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?",new String[] {username});

        //condition
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //Function checkusernamepassword
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        //use rawQuery for checkusernamepassword
        Cursor cursor = DB.rawQuery("Select * from users where username = ? and password = ?",new String[] {username,password});
        //condition
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


    //student
    public Boolean insertDatastudent(String nam, String cl, String di,String sport, String phon,String mai, String addres){
        //
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",nam);
        contentValues.put("class",cl);
        contentValues.put("div",di);
        contentValues.put("sport",sport);
        contentValues.put("phone",phon);
        contentValues.put("mail",mai);
        contentValues.put("address",addres);

        long result = MyDB.insert("player",null, contentValues);
        //condition
        if (result==-1) return false;
        else
            return true;
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from player",null);
        //Cursor cursor = DB.rawQuery("Select * from student where std = 10",null);
        //Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }


    public Cursor retrieve(String searchTerm)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String[] columns={"id","name","std","div","phone","mail","address"};
        Cursor c=null;

        if(searchTerm != null && searchTerm.length()>0)
        {
            //String sql="SELECT * FROM "+ "student" +" WHERE "+ "std" +" LIKE '%"+searchTerm+"%'";
            String sql="Select * from student where std = LIKE '%"+searchTerm+"%'";
            c=DB.rawQuery(sql,null);
            return c;
        }

        c=DB.query(" " +
                "",columns,null,null,null,null,null);
        return c;
    }


    public Cursor getdataa(String idi)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from student where std = "+ idi +" ",null);
        return cursor;
    }
//    public Cursor getsearch(String stdd)
//    {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        //SQLiteDatabase DB1 = this.getReadableDatabase();
//        //ContentValues contentValues = new ContentValues();
//        Cursor cursor = DB.rawQuery("Select * from student where std = stdd ",null);
//        //String columnArray[]=new String[]{"id","name","std","div","phone","mail","address"};
//        ///Cursor cursor = DB1.query("student",columnArray,"std" + " = " + stdd,null,null,null,null);
//        return cursor;
//    }

    public void UpdateDetail(long id,String nam, String cl, String di,String spor,String phon,String mai,String addres) {
        SQLiteDatabase db =this.getWritableDatabase();//writeable
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",nam);
        contentValues.put("class",cl);
        contentValues.put("div",di);
        contentValues.put("sport",spor);
        contentValues.put("phone",phon);
        contentValues.put("mail",mai);
        contentValues.put("address",addres);
        db.update("player",contentValues,"id" + " = " + id,null);
        db.close();
    }
    public Integer deleteData(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("player","id" + " = " + id,null );
    }

    public String getName(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(0);
            return name;
        }
        return null;
    }


    public String getClas(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(1);
            return name;
        }
        return null;
    }


    public String getDiv(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(2);
            return name;
        }
        return null;
    }

    public String getSport(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(3);
            return name;
        }
        return null;
    }

    public String getMobile(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(4);
            return name;
        }
        return null;
    }
    public String getMail(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(5);
            return name;
        }
        return null;
    }

    public String getAddress(long id) {
        SQLiteDatabase db =this.getReadableDatabase();
        String columnArray[]=new String[]{"name","class","div","sport","phone","mail","address"};
        Cursor cursor = db.query("player", columnArray,"id" + " = " + id ,null,null,null,null);

        if (cursor!=null)
        {
            cursor.moveToNext();
            String name= cursor.getString(6);
            return name;
        }
        return null;
    }
}
