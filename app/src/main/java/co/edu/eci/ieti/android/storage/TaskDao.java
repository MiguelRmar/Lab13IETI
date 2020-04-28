package co.edu.eci.ieti.android.storage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM Task_table")
    void deleteAll();

    @Query("SELECT * from Task_table ORDER BY TaskId ASC")
    LiveData<List<Task>> getAlphabetizedTasks();

}
