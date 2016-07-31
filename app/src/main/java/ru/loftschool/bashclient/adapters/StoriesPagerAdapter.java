package ru.loftschool.bashclient.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ru.loftschool.bashclient.database.models.Story;
import ru.loftschool.bashclient.ui.fragments.FullStoryFragment;


public class StoriesPagerAdapter extends FragmentStatePagerAdapter {
    private List<Story> items;

    public StoriesPagerAdapter(FragmentManager fm, boolean allStories) {
        super(fm);
        // XXX Data query on UI thread (other similar queries used Loaders)
        if (allStories) {
            items = Story.selectAll();
        } else {
            items = Story.selectFavorites();
        }
    }

    // XXX Fragment overhead
    // XXX No view reuse
    @Override
    public Fragment getItem(int position) {
        return FullStoryFragment.newInstance(items.get(position).getId());
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
