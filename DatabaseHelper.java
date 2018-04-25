package eighteen.cmp.nan.itourbradford;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
	public static final String KEY_ID = "Id";




	public static final String KEY_SECOND2 = "Date";
	public static final String KEY_THIRD3 = "Details";


	private static final String DATABASE_NAME = "Bradford";



	private static final String DATABASE_TABLE = "Complaints";
	
	private static final int DATABASE_VERSION = 3;
	private DbHelper dbh;
	private final Context context;
	private static SQLiteDatabase ourdatabase;
	


	private static final String DATABASE_CREATE3 ="create table "+DATABASE_TABLE+"("
			+ KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+KEY_SECOND2+" TEXT NOT NULL, "
			+KEY_THIRD3+" TEXT NOT NULL);";
	


	public DatabaseHelper(Context c){
		this.context=c;
	}
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			

			arg0.execSQL(DATABASE_CREATE3);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			arg0.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
			onCreate(arg0);
		}
		
	}
	
	public DatabaseHelper open(){
		dbh=new DbHelper(context);
		ourdatabase=dbh.getWritableDatabase();
		return this;
	}
	public void close(){
		dbh.close();
	}
	

	public long insert( String s2, String s3) {
		// TODO Auto-generated method stub
		ContentValues initialValues = new ContentValues();

		initialValues.put(KEY_SECOND2, s2);

		initialValues.put(KEY_THIRD3, s3);




		return ourdatabase.insert(DATABASE_TABLE, null, initialValues);
	}

	public Cursor retrieve() {

		String[] colname = new String[] {KEY_THIRD3};
		return ourdatabase.query(DATABASE_TABLE, colname, null,null, null, null, null);
	}
	public List<String> getDetails1() {

		String[] colname=new String[]{KEY_THIRD3};
		Cursor c=ourdatabase.query(DATABASE_TABLE, colname, null, null,null,null,null);
		ArrayList<String> arr=new ArrayList<String>();

		int date=c.getColumnIndex(KEY_THIRD3);

		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			arr.add(c.getString(date)
			);
		}
		return arr;
	}




    public ArrayList<String> getDetails() {

        String[] colname=new String[]{KEY_SECOND2,KEY_THIRD3};

        Cursor c=ourdatabase.query(DATABASE_TABLE, colname,null,null, null,null,null,null);
        ArrayList<String> arr=new ArrayList<String>();


        int detail=c.getColumnIndex(KEY_SECOND2);
        int pdate=c.getColumnIndex(KEY_THIRD3);



        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            arr.add(
                    "Date					::"+c.getString(detail)+"\n"+
                    "Plan		        ::"+c.getString(pdate)


					);
        }
        return arr;
    }

	public void delete(String id) {
		String[] s=new String[]{id};
		ourdatabase.delete(DATABASE_TABLE, KEY_SECOND2 + " =?", s);
	}
}

