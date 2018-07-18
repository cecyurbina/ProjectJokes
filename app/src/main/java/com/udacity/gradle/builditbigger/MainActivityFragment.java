package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.surbi.androidlibraryjoke.ActivityJoke;

import static com.example.surbi.androidlibraryjoke.ActivityJoke.KEY_JOKE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, OnJokeTaskCompleted{
    private boolean isTaskRunning = false;
    private ProgressDialog progressDialog;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = root.findViewById(R.id.button_joke);
        button.setOnClickListener(this);


        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isTaskRunning) {
            progressDialog = ProgressDialog.show(getActivity(), "Loading", "Please wait a moment!");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_joke:
                if (!isTaskRunning) {
                    EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this);
                    asyncTask.execute();
                }
                break;
                default:

        }
    }

    @Override
    public void onTaskStarted() {
        isTaskRunning = true;
        progressDialog = ProgressDialog.show(getActivity(), getString(R.string.progress_loading), getString(R.string.progress_please_wait));
    }

    @Override
    public void onTaskCompleted(String data) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        isTaskRunning = false;
        Intent intent = new Intent(getContext(), ActivityJoke.class);
        intent.putExtra(KEY_JOKE, data);
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.onDetach();
    }
}
