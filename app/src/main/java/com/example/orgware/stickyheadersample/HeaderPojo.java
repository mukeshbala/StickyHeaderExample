package com.example.orgware.stickyheadersample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orgware on 8/3/2017.
 */

public class HeaderPojo {
   public String mType;
    public List<ChildPojo> childPojos = new ArrayList<>();

    public HeaderPojo(String mType, List<ChildPojo> childPojos) {
        this.mType = mType;
        this.childPojos = childPojos;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public List<ChildPojo> getChildPojos() {
        return childPojos;
    }

    public void setChildPojos(List<ChildPojo> childPojos) {
        this.childPojos = childPojos;
    }
}
