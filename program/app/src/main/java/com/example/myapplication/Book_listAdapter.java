package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Book_listAdapter extends BaseAdapter {
    private Context context;
    private List<Book> lsBooks;

    public Book_listAdapter(Context context, List<Book> lsBooks) {
        this.context = context;
        this.lsBooks = lsBooks;
    }

    @Override
    public int getCount() {
        return lsBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return lsBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.book_list,viewGroup,false);
        }
        ImageView imBook = view.findViewById(R.id.book_image);
        TextView tvBook_name = view.findViewById(R.id.book_name);
        TextView tvAuthor = view.findViewById(R.id.author);
        ImageView score = view.findViewById(R.id.score);
        Book book = lsBooks.get(index);
        imBook.setImageResource(book.getBookImageId());
        tvBook_name.setText(book.getName());
        tvAuthor.setText(book.getAuthor());
        switch (book.getScore()){
            case 1:
                score.setImageResource(R.drawable.star1);
                break;
            case 2:
                score.setImageResource(R.drawable.star2);
                break;
            case 3:
                score.setImageResource(R.drawable.star3);
                break;
            case 4:
                score.setImageResource(R.drawable.star4);
                break;
            case 5:
                score.setImageResource(R.drawable.star5);
                break;
        }


        return view;
    }
}
