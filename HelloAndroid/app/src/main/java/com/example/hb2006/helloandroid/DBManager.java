package com.example.hb2006.helloandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hb2006 on 2016-04-27.
 */
public class DBManager {
    //DB명, 테이블명 ,DB 버전 정보를 정의한다.
    //=============================================================================================
    static final String DB_STUDENTS     = "Student.db";
    static final String TABLE_STUDENTS  = "Students";
    static final int    DB_VERSION      = 1;
    //=============================================================================================

    Context mContext = null;

    private static DBManager mdbManager = null;
    private SQLiteDatabase    mDatabase  = null;

    //DB 매너지ㅓ 객체는 싱글톤으로 구현한다
    //=============================================================================================
    private static DBManager getInstance(Context context)
    {
        if (mdbManager == null){
            mdbManager = new DBManager( context );
        }

        return mdbManager;
    }
    //=============================================================================================
    private DBManager(Context context){
        mContext = context;

    //1.DB Manager를 생성할 때 DB를 생성하고 연다.
    //=============================================================================================
        mDatabase = context.openOrCreateDatabase(DB_STUDENTS,
                    context.MODE_PRIVATE,
                null);
        //=========================================================================================

        //2.만일 DB에 테이블이 존재하지 않으면 생성한다.
        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_STUDENTS
                + "( uId TEXT"+
                "password TEXT"
                + "name TEXT);"
        );
        //==========================================================================================
    }
    public long insert(ContentValues val){
        /**
         mDatabase.execSQL("INSERT INTO TABLE_STUDENTS(uid,password,name)
                            +VALUES('"+hong+"','"++"')")
         반환값은 몇번째 행에 입력되었는 지 값을 알려주고
         그 타입은 long이다.
         * */
        return mDatabase.insert(TABLE_STUDENTS,null,val);
    }
}
