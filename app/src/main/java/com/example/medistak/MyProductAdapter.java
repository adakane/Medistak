package com.example.medistak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyProductAdapter extends  RecyclerView.Adapter<MyProductAdapter.ViewHolder> implements Filterable {
    ArrayList<MyProduct> myProductData;
    ArrayList<MyProduct> myProductFiltered;
    ArrayList<MyProduct> myOriginalData;
    Context context;

    public MyProductAdapter( ArrayList<MyProduct> myProductData, MainActivity activity) {
        this.myProductData = myProductData;
        this.context = activity;
        this.myProductFiltered = new ArrayList<>();
        this.myOriginalData = new ArrayList<>();
        myOriginalData.addAll(myProductData);
        myProductFiltered.addAll(myProductData);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_list, parent, false );
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyProduct myProductList = myProductData.get(position);
        holder.productViewName.setText(myProductList.getProductName());
        holder.productViewDesc.setText(myProductList.getProductDesc());
        holder.productViewImage.setImageResource(myProductList.getProductImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myProductList.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myProductData.size();
    }

    @Override
    public Filter getFilter() {
        return filterData;
    }
    public Filter filterData = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<MyProduct> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(myOriginalData);

            }
            else {
                for (MyProduct product: myProductFiltered) {
                    if (product.getProductName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(product);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            myProductData.clear();
            myProductData.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView productViewImage;
        TextView productViewName;
        TextView productViewDesc;
        TextView productViewPrice;
        Button productViewBuy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productViewImage = itemView.findViewById(R.id.productImage);
            productViewDesc = itemView.findViewById(R.id.productDesc);
            productViewName = itemView.findViewById(R.id.productName);
            productViewPrice = itemView.findViewById(R.id.productPrice);
            productViewBuy = itemView.findViewById(R.id.productBuy);
        }
    }
}
