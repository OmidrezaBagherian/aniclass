package ir.omidrezabagherian.aniclass.room.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;
import io.reactivex.rxjava3.core.Observable;
import ir.omidrezabagherian.aniclass.room.entity.ClassItemEntity;
import retrofit2.http.GET;

@Dao
public interface ClassDao {

  @GET
  Observable<List<ClassItemEntity>> getAllClass();

  @Query("SELECT * FROM class_tb WHERE id=:classId")
  Observable<List<ClassItemEntity>> getClassById(int classId);

}
