package com.truong.btvnmasterdev.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.truong.btvnmasterdev.R;
import com.truong.btvnmasterdev.item;

import java.util.ArrayList;

public class EditTextAdapter extends RecyclerView.Adapter<EditTextAdapter.EditTextHolder>{
    private ArrayList<item> data;
    private LayoutInflater inflater;

    public EditTextAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EditTextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_edit,parent,false);
        return new EditTextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditTextHolder holder, int position) {
        item it = data.get(position);
        holder.edtItem.setHint(data.get(position).getItem());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class EditTextHolder extends RecyclerView.ViewHolder {
        private EditText edtItem;
        public EditTextHolder(@NonNull View itemView) {
            super(itemView);
            edtItem = itemView.findViewById(R.id.edt_item);

            edtItem.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    data.get(getAdapterPosition()).setItem(edtItem.getText().toString());


                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

    }
}
