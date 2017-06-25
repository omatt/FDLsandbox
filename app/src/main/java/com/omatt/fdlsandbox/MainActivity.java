package com.omatt.fdlsandbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject FirebaseDynamicLinks mFDL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
