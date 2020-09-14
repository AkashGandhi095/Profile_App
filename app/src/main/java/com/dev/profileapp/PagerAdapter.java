package com.dev.profileapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {

    private List<PagerData> tabList;
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        tabList = new ArrayList<>();
        tabList.add(new PagerData("Requests", R.drawable.ic_no_req , "You don't have any request's yet !!"));
        tabList.add(new PagerData("Offerings", R.drawable.ic_offering_empty_xct9 , "You don't have any offerings's yet !!"));
        tabList.add(new PagerData("Recommends", R.drawable.ic_undraw_notify_re_65on , "You don't have any recommendations's yet !!"));

    }

    public List<PagerData> getTabList()
    {
        return tabList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ProfileChildFragment.newInstance(tabList.get(position).title
                , tabList.get(position).resId , tabList.get(position).errText);
    }

    @Override
    public int getItemCount() {
        return tabList.size();
    }


    public static class PagerData
    {
        private String title;
        private int resId;
        private String errText;

        public PagerData(String title, int resId , String errText) {
            this.title = title;
            this.resId = resId;
            this.errText = errText;
        }

        public String getTitle() {
            return title;
        }

        public int getResId() {
            return resId;
        }

        public String getErrText() {
            return errText;
        }
    }
}
