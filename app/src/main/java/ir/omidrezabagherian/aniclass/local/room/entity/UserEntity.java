package ir.omidrezabagherian.aniclass.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_tb")
public class UserEntity {
  @PrimaryKey
  public int id;

  @NonNull
  @ColumnInfo
  public String name;

  @NonNull
  @ColumnInfo
  public String email;

  @NonNull
  @ColumnInfo
  public String password;

  @NonNull
  @ColumnInfo(name = "national_code")
  public String nationalCode;

  @NonNull
  @ColumnInfo
  public String family;

}
