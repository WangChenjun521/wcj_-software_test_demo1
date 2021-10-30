package com.fdu.wcjproject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;
    public TextViewHolder(@NonNull View itemView){
        super(itemView);
        mTextView=itemView.findViewById(R.id.text);
     //   mTextView.setHeight(50);
        itemView.setOnClickListener(this);
    }
    public void bind(String text){
        mTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(v.getContext(),SearchActivity.class);
        intent.putExtra("extra",mTextView.getText());
        v.getContext().startActivity(intent);
    }
}
