package com.daveamegs.googlebooksapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {
    ArrayList<Book> books;

    public BooksAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.book_list_items, parent,
                false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        TextView tvAuthors;
        TextView tvPublisher;
        TextView tvPublishedDate;

        public BookViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthors = itemView.findViewById(R.id.tvAuthors);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
            tvPublishedDate = itemView.findViewById(R.id.tvPublishedDate);
            itemView.setOnClickListener(this);
        }

        public void bind(Book book) {
            tvTitle.setText(book.title);
            tvAuthors.setText(book.authors);
            tvPublisher.setText(book.publisher);
            tvPublishedDate.setText(book.publishedDate);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Book selectedBook = books.get(position);
            Intent intent = new Intent(view.getContext(), BookDetail.class);
            intent.putExtra("Book", selectedBook);
            view.getContext().startActivity(intent);
        }
    }
}
