package ir.omidrezabagherian.aniclass.local.room.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import ir.omidrezabagherian.aniclass.local.room.entity.ClassItemEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.FollowEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.TeacherEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UserEntity;
import ir.omidrezabagherian.aniclass.model.QueryAllClasses;
import ir.omidrezabagherian.aniclass.model.QueryFollowClasses;

@Dao
public interface AniClassDao {

  @Query("SELECT * FROM class_tb")
  Observable<List<ClassItemEntity>> getAllClass();

  @Query("SELECT * FROM class_tb WHERE teacher_id=:id")
  Observable<List<ClassItemEntity>> getCreatedClassesByTeacherId(long id);
  
  @Query("SELECT * FROM class_tb WHERE id=:classId")
  Observable<List<ClassItemEntity>> getClassById(int classId);

  @Query("SELECT * FROM follow_tb WHERE id=:followId")
  Observable<List<FollowEntity>> getFollowById(int followId);
  
  @RawQuery
  Single<List<QueryFollowClasses>> getFollows(SupportSQLiteQuery supportSQLiteQuery);

  @Query("SELECT * FROM user_tb WHERE national_code=:national_code AND password=:password")
  Single<UserEntity> userLogin(String national_code , String password);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> userSignup(UserEntity userEntity);
  
  @Query("SELECT * FROM teacher_tb WHERE national_code=:national_code AND password=:password")
  Single<TeacherEntity> teacherLogin(String national_code , String password);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> teacherSingup(TeacherEntity teacherEntity);
  
  @Query("SELECT * FROM teacher_tb WHERE id=:teacherId")
  Observable<TeacherEntity> getTeacherById(int teacherId);
  
  @Query("SELECT * FROM user_tb WHERE id=:userId")
  Observable<UserEntity> getUserById(int userId);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insertClass(ClassItemEntity classItemEntity);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertUser(UserEntity... userEntities);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertTeacher(TeacherEntity... teacherEntities);
  
  @Delete
  void deleteClass(ClassItemEntity classItemEntity);
  
  @Query("DELETE FROM follow_tb WHERE follow_tb.id=:id")
  Maybe<Integer> deleteFollow(long id);
  
  @Query("DELETE FROM class_tb WHERE class_tb.id=:id")
  Maybe<Integer> deleteClassById(long id);
  
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Maybe<Long> insertFollow(FollowEntity followEntities);
  
  @RawQuery
  Single<List<QueryAllClasses>> getClassesItemByTeacherId(SupportSQLiteQuery supportSQLiteQuery);
  @RawQuery
  Single<List<QueryAllClasses>> getClassesItem(SupportSQLiteQuery supportSQLiteQuery);
  
  default Single<List<QueryAllClasses>> getCustomClassesItemByTeacherId(Long id) {
    String query = "SELECT class_tb.* , teacher_tb.name as teacher_name FROM class_tb JOIN teacher_tb ON class_tb.teacher_id=teacher_tb.id WHERE class_tb.teacher_id=:id; ";
    return getClassesItemByTeacherId(new SimpleSQLiteQuery(query , new Long[]{id}));
  }
  
  default Single<List<QueryAllClasses>> getCustomClassesItem() {
    String query = "SELECT class_tb.* , teacher_tb.name as teacher_name FROM class_tb JOIN teacher_tb ON class_tb.teacher_id=teacher_tb.id; ";
    return getClassesItem(new SimpleSQLiteQuery(query , new ClassItemEntity[0]));
  }
  
  default Single<List<QueryFollowClasses>> getCustomFollow(long id) {
    String query = "SELECT class_tb.* , follow_tb.id as followId FROM follow_tb JOIN class_tb ON follow_tb.class_id=class_tb.id " +
        "WHERE follow_tb.user_id=:id; ";
    return getFollows(new SimpleSQLiteQuery(query , new Long[]{id}));
  }
}
