package ir.omidrezabagherian.aniclass.local.room.entity;
/*
@created in 17/07/2021 - 10:05 PM
@project AniClass
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "follow_tb")
public class FollowEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
 
    @NonNull
    @ColumnInfo(name = "class_id")
    public int classId;
 
    @NonNull
    @ColumnInfo(name = "user_id")
    public int userId;
}
