package com.example.hb2006.helloandroid;

/**
 * Created by hb2006 on 2016-04-27.
 */

    public class MemberDAO extends SQLiteOpenHelper {

        // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
        public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // DB를 새로 생성할 때 호출되는 함수
        @Override
        public void onCreate(SQLiteDatabase db) {
            // 새로운 테이블 생성
        /* 이름은 MONEYBOOK이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
            db.execSQL("CREATE TABLE IF NOT EXISTS "
                    + "Member"
                    + "( uId TEXT"+
                    "password TEXT"
                    + "name TEXT);");
        }

        // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void insert(String create_at, String uid, String password, String name) {
            // 읽고 쓰기가 가능하게 DB 열기
            SQLiteDatabase db = getWritableDatabase();
            // DB에 입력한 값으로 행 추가
            db.execSQL("INSERT INTO Member VALUES('" + uid + "', " + password + ", '" + name + "');");
            db.close();
        }

        public void update(String password, String uid) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행의 가격 정보 수정
            db.execSQL("UPDATE Member SET password=" + password + " WHERE uid='" + uid + "';");
            db.close();
        }

        public void delete(String uid) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM Member WHERE uid='" + uid + "';");
            db.close();
        }

        public String getResult() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            String result = "";

            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM Member", null);
            while (cursor.moveToNext()) {
                result += cursor.getString(0)
                        + " , "
                        + cursor.getString(1)
                        + " , "
                        + cursor.getString(2)
                        + "\n";
            }

            return result;
        }
    }

