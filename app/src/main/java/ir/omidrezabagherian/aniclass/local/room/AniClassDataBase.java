package ir.omidrezabagherian.aniclass.local.room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import ir.omidrezabagherian.aniclass.local.room.dao.AniClassDao;
import ir.omidrezabagherian.aniclass.local.room.entity.ClassItemEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.TeacherEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UniversityEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UserEntity;

@Database(entities = {
    ClassItemEntity.class,
    TeacherEntity.class,
    UniversityEntity.class,
    UserEntity.class
}, version = 1)
public abstract class AniClassDataBase extends RoomDatabase {
    private static AniClassDataBase database = null;
    
    public abstract AniClassDao getDao();
    
    public static synchronized AniClassDataBase getDatabase(@NonNull Context applicationContext) {
        if(database == null) {
             database = Room.databaseBuilder(applicationContext, AniClassDataBase.class, "aniclass")
                    .allowMainThreadQueries()
                    .createFromAsset("databases/aniclass.db")
                    .build();
        }
        
        return database;
    }
    
}
