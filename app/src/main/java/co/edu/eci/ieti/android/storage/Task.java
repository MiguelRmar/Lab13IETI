package co.edu.eci.ieti.android.storage;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Task_table")
public class Task {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "TaskId")
    private Integer id;
    private Task mTask;
    private String description;

    public Task getTask(){return this.mTask;}

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", mTask=" + mTask +
                ", description='" + description + '\'' +
                '}';
    }
}
