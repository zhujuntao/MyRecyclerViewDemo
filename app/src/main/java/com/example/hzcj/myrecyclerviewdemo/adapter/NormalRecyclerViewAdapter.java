package com.example.hzcj.myrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class NormalRecyclerViewAdapter  extends  RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder>{
    private  LayoutInflater layoutInflater;
    private  Context context;
    private String [] mTitles;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
        void OnItemLongClick(View view,int position);
    }


    public NormalRecyclerViewAdapter(Context context, String[] mTitles) {
        this.context = context;
        this.mTitles = mTitles;
         layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(layoutInflater.inflate(R.layout.item_text_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final NormalTextViewHolder holder, final int position) {
           holder.tv_title.setText(mTitles[position]);
           if(onItemClickListener!=null){
               holder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       onItemClickListener.OnItemClick(holder.itemView,holder.getLayoutPosition());
                   }
               });
               holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View v) {
                       onItemClickListener.OnItemLongClick(holder.itemView,holder.getLayoutPosition());
                       return true;
                   }
               });





           }
    }

    @Override
    public int getItemCount() {
        return mTitles.length;
    }

    public static  class NormalTextViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        public NormalTextViewHolder(View itemView) {
            super(itemView);
            tv_title= (TextView) itemView.findViewById(R.id.tv_item_title );
        }
    }



}
