package com.example.hzcj.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hzcj.myrecyclerviewdemo.R;

/**
 * Created by HZCJ on 2017/9/12.
 * <pre>
 * author:zhu
 * e-mail:18911664778@163.com
 * desc:
 * version:
 * </pre>
 */

public class MultipleItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public  static enum ITEM_TYPE{
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT

    }
    private  LayoutInflater layoutInflater;
    private  Context context;
    private String[] mTitle;

    public MultipleItemAdapter(Context context, String[] mTitle) {
        this.context = context;
        this.mTitle = mTitle;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

          if(viewType==ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()){
              return new ImageViewHodler(layoutInflater.inflate(R.layout.item_image_layout,parent,false));
          }else {
              return new TextViewHodler(layoutInflater.inflate(R.layout.item_text_layout,parent,false));
          }
    }
    

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
               if (holder instanceof TextViewHodler){


                   ((TextViewHodler) holder).tv_title.setText(mTitle[position]);
               }else if(holder instanceof ImageViewHodler){
                  ((ImageViewHodler) holder).img_title.setText(mTitle[position]);
               }
    }

    @Override
    public int getItemCount() {
        return mTitle==null?0:mTitle.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0?ITEM_TYPE.ITEM_TYPE_TEXT.ordinal():ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal();
    }

    public static class TextViewHodler extends RecyclerView.ViewHolder {
        TextView tv_title;
        public TextViewHodler(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.tv_item_title);
        }
    }
    public static class ImageViewHodler extends RecyclerView.ViewHolder {
        ImageView iv_title;
        TextView  img_title;
        public ImageViewHodler(View itemView) {
            super(itemView);
            img_title= (TextView) itemView.findViewById(R.id.item_img_title);
        }
    }


}


//public class MultipleItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    public static enum ITEM_TYPE {
//        ITEM_TYPE_IMAGE,
//        ITEM_TYPE_TEXT
//    }
//
//    private final LayoutInflater mLayoutInflater;
//    private final Context mContext;
//    private String[] mTitles;
//
//    public MultipleItemAdapter(Context context) {
//        mTitles = context.getResources().getStringArray(R.array.titles);
//        mContext = context;
//        mLayoutInflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
//            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
//        } else {
//            return new TextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof TextViewHolder) {
//            ((TextViewHolder) holder).mTextView.setText(mTitles[position]);
//        } else if (holder instanceof ImageViewHolder) {
//            ((ImageViewHolder) holder).mTextView.setText(mTitles[position]);
//        }
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
//    }
//
//    @Override
//    public int getItemCount() {
//        return mTitles == null ? 0 : mTitles.length;
//    }
//
//    public static class TextViewHolder extends RecyclerView.ViewHolder {
//        @InjectView(R.id.text_view)
//        TextView mTextView;
//
//        TextViewHolder(View view) {
//            super(view);
//            ButterKnife.inject(this, view);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("TextViewHolder", "onClick--> position = " + getPosition());
//                }
//            });
//        }
//    }
//
//    public static class ImageViewHolder extends RecyclerView.ViewHolder {
//        @InjectView(R.id.text_view)
//        TextView mTextView;
//        @InjectView(R.id.image_view)
//        ImageView mImageView;
//
//        ImageViewHolder(View view) {
//            super(view);
//            ButterKnife.inject(this, view);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("ImageViewHolder", "onClick--> position = " + getPosition());
//                }
//            });
//        }
//    }
//}
