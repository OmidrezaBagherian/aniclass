package ir.omidrezabagherian.aniclass.local.shared_pref;
/*

@created in 18/07/2021 - 4:19 PM
@project AniClass
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.content.Context;
import android.content.SharedPreferences;

import ir.omidrezabagherian.aniclass.core.Base;
import ir.omidrezabagherian.aniclass.local.room.entity.TeacherEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UserEntity;

public class AniclassSharedPref {
    public static String SHARED_PREF_NAME = "aniclass_local_pref";
    public static SharedPreferences sharedPreferences = Base.getContext().getSharedPreferences(SHARED_PREF_NAME , Context.MODE_PRIVATE);
    public static SharedPreferences.Editor editor = sharedPreferences.edit();
    
    
    public static boolean isLogined() {
        return sharedPreferences.getLong("id", -1) != -1;
    }
    
    
    public static boolean isTeacher() {
        return sharedPreferences.getInt("is_teacher", 0) != 0;
    }
    
    public static void login(UserEntity userEntity) {
        editor.putLong("id"    , userEntity.id);
        editor.putInt("is_teacher"    , 0);
        editor.commit();
    }
    
    public static void login(TeacherEntity teacherEntity) {
        editor.putLong("id"    , teacherEntity.id);
        editor.putInt("is_teacher"    , 1);
        editor.commit();
    }
    
    public static void signup(TeacherEntity teacherEntity) {
        editor.putLong("id"    , teacherEntity.id);
        editor.putInt("is_teacher"    , 1);
        editor.commit();
    }
    
    public static void signup(UserEntity userEntity) {
        editor.putLong("id"    , userEntity.id);
        editor.putInt("is_teacher"    , 0);
        editor.commit();
    }
    
}
