public class HabitDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HabitTracker.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_HABITS = "Habits";

    public HabitDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_HABITS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "reminder_time TEXT, " +
                "is_completed INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HABITS);
        onCreate(db);
    }

    public void addHabit(String name, String reminderTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("reminder_time", reminderTime);
        values.put("is_completed", 0);
        db.insert(TABLE_HABITS, null, values);
    }
}
