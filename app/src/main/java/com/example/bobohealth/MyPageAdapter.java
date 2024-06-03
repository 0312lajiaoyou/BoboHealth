package com.example.bobohealth;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPageAdapter extends FragmentStateAdapter {
    public MyPageAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new BreakfastFragment();
        }else if(position==1){
            return new LunchFragment();
        }else{
            return new DinnerFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}