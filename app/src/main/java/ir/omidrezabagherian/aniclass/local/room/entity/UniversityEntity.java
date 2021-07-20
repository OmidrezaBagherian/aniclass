package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "university_tb")
public class UniversityEntity {
  @PrimaryKey(autoGenerate = true)
  public int id;

  @NonNull
  @ColumnInfo
  public String name;

}
