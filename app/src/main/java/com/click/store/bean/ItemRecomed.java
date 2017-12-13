package com.click.store.bean;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by S on 2017/11/21.
 */

public class ItemRecomed {
    private int icon;
    public String displayName;
    public int apkSize;

    public ItemRecomed(int icon, String displayName, int apkSize) {
        this.icon = icon;
        this.displayName = displayName;
        this.apkSize = apkSize;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getApkSize() {
        return apkSize;
    }

    public void setApkSize(int apkSize) {
        this.apkSize = apkSize;
    }
}
