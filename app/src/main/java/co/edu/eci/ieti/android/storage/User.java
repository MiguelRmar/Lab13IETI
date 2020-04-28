package co.edu.eci.ieti.android.storage;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Username")
    private String email;

    private String name;
    private String lastName;

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
