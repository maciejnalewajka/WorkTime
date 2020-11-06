package com.nalewajka.worktime.DownloadData;

import android.os.AsyncTask;

import com.nalewajka.worktime.Data.User;

import io.realm.Realm;

public class DownloadUsers extends AsyncTask<Void, Void, Void> {

    private Realm realm;
    private User user;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        realm = Realm.getDefaultInstance();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        realm.beginTransaction();
        //TODO
        realm.commitTransaction();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
