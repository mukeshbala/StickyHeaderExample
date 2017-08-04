package com.example.orgware.stickyheadersample;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Orgware on 8/3/2017.
 */

public class StickyAdapter extends SectioningAdapter {

    public Context context;
    public LayoutInflater inflater;
    public List<HeaderPojo> headerPojoList;

    public StickyAdapter(Context context) {
        this.context = context;
        headerPojoList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setStickyList(List<HeaderPojo> mList) {
        if (mList == null) {
            return;
        }
        headerPojoList.clear();
        headerPojoList.addAll(mList);
        notifyAllSectionsDataSetChanged();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return !TextUtils.isEmpty(headerPojoList.get(sectionIndex).getmType());
    }
    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerUserType) {
        View v = inflater.inflate(R.layout.item_header, parent, false);
        return new ItemHeaderViewHolder(v);
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemUserType) {
        View view = inflater.inflate(R.layout.item_child,parent,false);
        return new ItemChildViewHolder(view);
    }

    @Override
    public int getNumberOfSections() {
        return headerPojoList.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
    return headerPojoList.get(sectionIndex).getChildPojos().size();
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int sectionIndex, int headerUserType) {
        super.onBindHeaderViewHolder(viewHolder,sectionIndex,headerUserType);

        ItemHeaderViewHolder headerViewHolder =(ItemHeaderViewHolder) viewHolder;
        HeaderPojo headerPojo =headerPojoList.get(sectionIndex);
        headerViewHolder.setHeaderDataToView(headerPojo);
    }

    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemUserType) {
        super.onBindItemViewHolder(viewHolder, sectionIndex, itemIndex, itemUserType);
        ItemChildViewHolder childViewHolder =(ItemChildViewHolder) viewHolder;
        ChildPojo childPojo =headerPojoList.get(sectionIndex).getChildPojos().get(itemIndex);
        childViewHolder.setChildDataToView(childPojo);
    }

    class ItemHeaderViewHolder extends HeaderViewHolder {
        @BindView(R.id.txt_header)
        TextView mHeader;

        public ItemHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setHeaderDataToView(HeaderPojo item){
            mHeader.setText(item.getmType());
        }
    }

    class ItemChildViewHolder extends SectioningAdapter.ItemViewHolder{

        @BindView(R.id.txt_child)
        TextView mChild;
        public ItemChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void setChildDataToView(ChildPojo item){
            mChild.setText(item.getmName());
        }
    }



}
