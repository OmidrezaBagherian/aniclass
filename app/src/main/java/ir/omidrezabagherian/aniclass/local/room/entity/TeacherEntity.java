package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_tb")
public class TeacherEntity {
  @PrimaryKey(autoGenerate = true)
  public long id;
  
  @NonNull
  @ColumnInfo(name = "national_code")
  public String nationalCode;
  
  
  @NonNull
  @ColumnInfo
  public String password;
  
  @NonNull
  @ColumnInfo
  public String name;
  
  @NonNull
  @ColumnInfo
  public String family;
  
  @NonNull
  @ColumnInfo
  public String email;



}
