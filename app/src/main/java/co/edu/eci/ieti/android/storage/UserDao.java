
package co.edu.eci.ieti.android.storage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert();

    @Query("DELETE FROM User_table")
    void deleteAll();

    @Query("SELECT * from User_table ORDER BY name ASC")
    LiveData<List<User>> getAlphabetizedUsers();

}
