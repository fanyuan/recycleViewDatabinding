package com.recycleview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.recycleview.databinding.databinding.ItemFruitBinding;
import com.recycleview.databinding.model.Fruit;

import java.util.List;

public class FruitRvAdapter extends RecyclerView.Adapter<FruitRvAdapter.ViewHolder>{
    private List<Fruit> mFruitList;
    private LifecycleOwner lifecycleOwer;

    public FruitRvAdapter(List<Fruit> mFruitList,LifecycleOwner ower) {
        this.mFruitList = mFruitList;
        this.lifecycleOwer = ower;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.item_fruit, parent, false);
        final ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.bind(fruit);
        holder.binding.setLifecycleOwner(lifecycleOwer);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImageResource(ImageView imageView, int resource ) {
        imageView.setImageResource( resource );
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ItemFruitBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
        public void bind(@NonNull Fruit fruit){
            binding.setFruit(fruit);
        }
    }

}
