package com.nalewajka.worktime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nalewajka.worktime.Data.MyData;
import com.nalewajka.worktime.Data.User;
import com.nalewajka.worktime.DownloadData.DownloadProjects;
import com.nalewajka.worktime.DownloadData.DownloadTasks;
import com.nalewajka.worktime.DownloadData.DownloadUsers;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class Main extends AppCompatActivity {

    private EditText text_login, text_pass;
    private Button login, register;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        downloadUser();
        init();
        setListeners();
    }

    private void init(){
        setContentView(R.layout.activity_main);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        text_login = findViewById(R.id.main_email);
        text_pass = findViewById(R.id.main_password);
        login = findViewById(R.id.main_login);
        register = findViewById(R.id.main_register);
    }

    private void setListeners(){
        login.setOnClickListener(v -> logIn());
        register.setOnClickListener(v -> register());
    }

    private void logIn() {
        MyData mydData = restoreDataUser();
        if(search(mydData)){
            downloadData();
            String type = mydData.getType();
            switch (type){
                case "Master":
                    Intent intentMaster = new Intent(this, Master.class);
                    startActivity(intentMaster);
                    break;
                case "User":
                    Intent intentUser = new Intent(this, User.class);
                    startActivity(intentUser);
                    break;
            }
        }
    }

    private void register(){
        Intent intent = new Intent(this, Rejestracja.class);
        startActivity(intent);
    }

    private boolean search(MyData mydData){
        try {
            realm.beginTransaction();
            RealmResults<User> users = realm.where(User.class).findAll();
            realm.commitTransaction();
            for (User item : users){
                String text = text_login.getText().toString().trim();
                String pass = text_pass.getText().toString().trim();
                if (item.getEmail().equals(text) &
                        revers(item.getPassword()).equals(pass)){
                    save_data(text, pass);
                    return true;
                }
                if (item.getEmail().equals(mydData.getEmail()) &
                        revers(item.getPassword()).equals(mydData.getPassword())){
                    return true;
                }
            Toast.makeText(this, "Błędne dane!", Toast.LENGTH_SHORT).show();
            return false;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    private void downloadData(){
        DownloadProjects downloadProjects = new DownloadProjects();
        downloadProjects.execute();
        DownloadTasks downloadTasks = new DownloadTasks();
        downloadTasks.execute();
    }

    private void downloadUser(){
        DownloadUsers downloadUsers = new DownloadUsers();
        downloadUsers.execute();
    }

    private MyData restoreDataUser() {
        MyData myData = new MyData("", "");
        realm.beginTransaction();
        RealmResults<MyData> log = realm.where(MyData.class).findAll();
        realm.commitTransaction();
        if (!log.isEmpty()){
            myData.setEmail(Objects.requireNonNull(log.get(0)).getEmail());
            myData.setPassword(revers(Objects.requireNonNull(log.get(0)).getPassword()));
        }
        return myData;
    }

    private void save_data(String log, String pass){
        MyData myData = new MyData(log, revers(pass));
        realm.beginTransaction();
        realm.delete(MyData.class);
        realm.copyToRealm(myData);
        realm.commitTransaction();
    }

    private String revers(String text){
        return new StringBuilder(text).reverse().toString();
    }
}