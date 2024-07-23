package com.example.java_9;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListUserInTextViewActivity extends AppCompatActivity {

    private TextView textViewSavedUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_users2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewSavedUsers = findViewById(R.id.textViewSavedUsers);

        loadUsers();
    }

    private void loadUsers() {
        ArrayList<User> users = UserStorage.getInstance().getUsers();
        StringBuilder usersDisplay = new StringBuilder();

        for (User user : users) {
            usersDisplay.append("Name: ")
                    .append(user.getFirstName())
                    .append(" ")
                    .append(user.getLastName())
                    .append("\nEmail: ")
                    .append(user.getEmail())
                    .append("\nDegree Program: ")
                    .append(user.getDegreeProgram())
                    .append("\n\n");
        }

        textViewSavedUsers.setText(usersDisplay.toString());
    }

}