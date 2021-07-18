package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "university_tb")
public class UniversityEntity {
  @PrimaryKey
  public int id;

  @ColumnInfo
  public String name;

}
