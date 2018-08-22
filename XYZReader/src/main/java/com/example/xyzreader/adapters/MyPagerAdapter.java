package com.example.xyzreader.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.ui.ArticleDetailActivity;
import com.example.xyzreader.ui.ArticleDetailFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private ArticleDetailActivity ada ;
    public MyPagerAdapter(FragmentManager fm , ArticleDetailActivity ada) {
        super(fm);
        this.ada = ada;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        ArticleDetailFragment fragment = (ArticleDetailFragment) object;
        if (fragment != null) {
            ada.mSelectedItemUpButtonFloor = fragment.getUpButtonFloor();
            ada.updateUpButtonPosition();
        }
    }

    @Override
    public Fragment getItem(int position) {
        ada.mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(ada.mCursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (ada.mCursor != null) ? ada.mCursor.getCount() : 0;
    }
}
