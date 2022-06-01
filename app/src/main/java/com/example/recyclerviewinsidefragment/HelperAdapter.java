package com.example.recyclerviewinsidefragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {
    Context context;
    private List<Content> contentList;

    public HelperAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.display_item,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        viewHolderClass.thumbnail.setText("" + contentList.get(position).getThumbnail());
        viewHolderClass.title.setText(contentList.get(position).getTitle());
        viewHolderClass.content.setText("" + contentList.get(position).getContent());
        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Item Selected",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder
    {
        TextView thumbnail;
        TextView title;
        TextView content;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            thumbnail = (TextView)itemView.findViewById(R.id.thumbnail_id);
            title = (TextView)itemView.findViewById(R.id.title_id);
            content = (TextView)itemView.findViewById(R.id.content_id);
        }
    }
}
