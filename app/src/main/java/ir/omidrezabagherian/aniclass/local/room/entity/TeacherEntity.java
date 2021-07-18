package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_tb")
public class TeacherEntity {
  @PrimaryKey
  public int id;

  @ColumnInfo
  public String name;

  @ColumnInfo
  public String email;

  @ColumnInfo
  public String password;

  @ColumnInfo(name = "national_code")
  public String nationalCode;

  @ColumnInfo
  public String family;

}
