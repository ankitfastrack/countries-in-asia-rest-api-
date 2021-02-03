package com.example.miskaa_internship;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.io.InputStream;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    Context context;
    static int count=0;

    @NonNull
    private List<Country> data;
    public ListAdapter(Context context, List<Country>data)
    {
        this.context = context;
        this.data=data;
    }
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.view_layout,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder,final int position) {
        //get data from pojo class
        String country_name=data.get(position).getName();
        String country_Capital=data.get(position).getCapital();
        String flagurl=data.get(position).getFlag();
        String country_region=data.get(position).getRegion();
        String country_subregion=data.get(position).getSubregion();
        String country_population=data.get(position).getPopulation().toString();
        List<String> border=data.get(position).getBorders();
        String country_border="";
        List<Language> lan=data.get(position).getLanguages();
        String country_language="";
        for(int i=0;i<border.size();i++)
        {
            country_border=country_border+border.get(i)+"\n";
        }
        for(int i=0;i<lan.size();i++)
        {
            country_language=country_language+lan.get(i).getName()+" - "+lan.get(i).getNativeName()+"\n";

        }
        // set data into holder
        utils.fetchSvg(context, flagurl, holder.country_flag);
        holder.country_name.setText(country_name);
        holder.country_capital.setText(country_Capital);
        holder.country_region.setText(country_region);
        holder.country_subregion.setText(country_subregion);
        holder.country_population.setText(country_population);
        holder.country_border.setText(country_border);
        holder.country_languages.setText(country_language);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView country_flag;
        CardView cdview;
        TextView country_name,country_capital,country_region,country_subregion,country_population,country_border,country_languages;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            cdview=(CardView) itemView.findViewById(R.id.cdview);
            country_flag=(ImageView) itemView.findViewById(R.id.view_flag);
            country_name=(TextView) itemView.findViewById(R.id.country_name);
            country_capital=(TextView) itemView.findViewById(R.id.captial_data);
            country_region=(TextView) itemView.findViewById(R.id.region_data);
            country_subregion=(TextView) itemView.findViewById(R.id.subregion_data);
            country_population=(TextView) itemView.findViewById(R.id.population_data);
            country_border=(TextView) itemView.findViewById(R.id.border_data);
            country_languages=(TextView) itemView.findViewById(R.id.languages_data);
        }
    }

}
