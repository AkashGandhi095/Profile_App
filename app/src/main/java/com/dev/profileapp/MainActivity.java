package com.dev.profileapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textview.MaterialTextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private MaterialTextView toolText;
    private ImageView settingImg , addIconImage , shareImg;
    private String title = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();



    }

    @SuppressLint("CutPasteId")
    private void initViews() {

        title = "Posts";
        toolText = findViewById(R.id.tool_text);
        settingImg = findViewById(R.id.setting_img);
        addIconImage = findViewById(R.id.add_img);
        shareImg = findViewById(R.id.share_img);
        toolText.setText(title);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavController navController = Navigation.findNavController(this ,R.id.fragment_host);
        NavigationUI.setupWithNavController(bottomNavigationView , navController);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        ImageView imageView = findViewById(R.id.add_img);

        // this called when fragment changes in bottom navigation
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.postFragment)
                {
                    title = "Posts";
                    settingImg.setVisibility(View.GONE);
                    addIconImage.setVisibility(View.GONE);
                    shareImg.setVisibility(View.GONE);
                }
                else if (destination.getId() == R.id.profileFragment)
                {
                    title = "Profile";
                    settingImg.setVisibility(View.VISIBLE);
                    addIconImage.setVisibility(View.VISIBLE);
                    shareImg.setVisibility(View.VISIBLE);
                }
                toolText.setText(title);

            }
        });




        imageView.setOnClickListener(view -> {

            imageView.animate().rotation(46.66F).start();
            showPopUpMenu(view);






        });


    }

    @SuppressLint("RestrictedApi")
    private void showPopUpMenu(View view) {
        PopupMenu popup = new PopupMenu(MainActivity.this, view , Gravity.END);
        popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

        @SuppressLint("RestrictedApi")
        MenuPopupHelper menuHelper = new MenuPopupHelper(this, (MenuBuilder) popup.getMenu(), view);
        menuHelper.setGravity(Gravity.END|Gravity.TOP);
        menuHelper.setForceShowIcon(true);
        menuHelper.setOnDismissListener(() -> {
            view.animate().rotation(0).start();
        });

        menuHelper.show();//showing popup menu

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}