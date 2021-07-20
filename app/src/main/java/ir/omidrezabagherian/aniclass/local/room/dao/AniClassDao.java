package ir.omidrezabagherian.aniclass.local.room.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import ir.omidrezabagherian.aniclass.local.room.entity.ClassItemEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.FollowEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.TeacherEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UniversityEntity;
import ir.omidrezabagherian.aniclass.local.room.entity.UserEntity;

@Dao
public interface AniClassDao {

  @Query("SELECT * FROM class_tb")
  Observable<List<ClassItemEntity>> getAllClass();

  @Query("SELECT * FROM class_tb WHERE id=:classId")
  Observable<List<ClassItemEntity>> getClassById(int classId);

  @Query("SELECT * FROM follow_tb WHERE id=:followId")
  Observable<List<FollowEntity>> getFollowById(int followId);

  @Query("SELECT * FROM user_tb WHERE national_code=:national_code AND password=:password")
  Single<UserEntity> userLogin(String national_code , String password);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Single<Long> userSignup(UserEntity userEntity);
  
  @Query("SELECT * FROM teacher_tb WHERE national_code=:national_code AND password=:password")
  Single<TeacherEntity> teacherLogin(String national_code , String password);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Single<Long> teacherSingup(TeacherEntity teacherEntity);
  
  @Query("SELECT * FROM teacher_tb WHERE id=:teacherId")
  Observable<TeacherEntity> getTeacherById(int teacherId);
  
  @Query("SELECT * FROM user_tb WHERE id=:userId")
  Observable<UserEntity> getUserById(int userId);
  
  @Query("SELECT * FROM university_tb WHERE id=:uniId")
  Observable<UniversityEntity> getUniById(int uniId);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertClass(ClassItemEntity... classItemEntity);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertUser(UserEntity... userEntities);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertTeacher(TeacherEntity... teacherEntities);
  
  @Delete
  void deleteClass(ClassItemEntity classItemEntity);
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertFollow(FollowEntity... followEntities);

}
