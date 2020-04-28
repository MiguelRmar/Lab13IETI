package co.edu.eci.ieti.android.storage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    private LiveData<List<Task>> mAllTasks;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTaks();
    }

    LiveData<List<Task>> getAllTasks() { return mAllTasks; }

    public void insert(Task task) { mRepository.insert(task); }
}
