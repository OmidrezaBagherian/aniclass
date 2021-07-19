package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "class_tb")
public class ClassItemEntity {

  @PrimaryKey(autoGenerate = true)
  public int id;
  @NonNull
  @ColumnInfo
  public String code;
  @NonNull
  @ColumnInfo
  public String name;
  @NonNull
  @ColumnInfo
  public String desc;
  @NonNull
  @ColumnInfo
  public String link;
  @NonNull
  @ColumnInfo
  public int capacity;
  @NonNull
  @ColumnInfo(name = "teacher_id")
  public int teacherId;
  @NonNull
  @ColumnInfo(name = "department_id")
  public int departmentId;
  @NonNull
  @ColumnInfo(name = "university_id")
  public int universityId;

}
