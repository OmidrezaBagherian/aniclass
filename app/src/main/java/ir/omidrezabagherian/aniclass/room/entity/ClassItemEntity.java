package ir.omidrezabagherian.aniclass.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "class_tb")
public class ClassItemEntity {

  @PrimaryKey(autoGenerate = true)
  public int id;
  @ColumnInfo
  public String code;
  @ColumnInfo
  public String name;
  @ColumnInfo
  public String desc;
  @ColumnInfo
  public String link;
  @ColumnInfo
  public int capacity;
  @ColumnInfo(name = "teacher_id")
  public int teacherId;
  @ColumnInfo(name = "department_id")
  public int departmentId;
  @ColumnInfo(name = "university_id")
  public int universityId;

}
