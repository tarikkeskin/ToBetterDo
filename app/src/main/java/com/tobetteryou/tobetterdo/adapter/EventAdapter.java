package com.tobetteryou.tobetterdo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.tobetteryou.tobetterdo.databinding.CardEventBinding;
import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.fragments.MainPageFragmentDirections;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.CardDesignAttachment> {
    private Context mContext;
    private List<Event> eventArrayList;

    public EventAdapter(Context mContext, List<Event> eventArrayList) {
        this.mContext = mContext;
        this.eventArrayList = eventArrayList;
    }

    public class CardDesignAttachment extends RecyclerView.ViewHolder{
        private CardEventBinding tasarim;

        public CardDesignAttachment(CardEventBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardDesignAttachment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardEventBinding tasarim = CardEventBinding.inflate(layoutInflater,parent,false);
        return new CardDesignAttachment(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignAttachment holder, int position) {
        Event event = eventArrayList.get(position);
        CardEventBinding t = holder.tasarim;

        t.textViewEvent.setText(event.getEvent_name());

        t.cardEvent.setOnClickListener(view -> {
            MainPageFragmentDirections.DetailToDoNavigation gecis = MainPageFragmentDirections.detailToDoNavigation(event);
            Navigation.findNavController(view).navigate(gecis);

        });

        t.imageViewDeleteIcon.setOnClickListener(view -> {
            Snackbar.make(view,"You wanna delete "+event.getEvent_name()+" ?",Snackbar.LENGTH_LONG)
                    .setAction("Yes",view1 -> {
                        Log.e("Event Delete",String.valueOf(event.getEvent_id()));
                    })
                    .show();

        });

    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }



}
