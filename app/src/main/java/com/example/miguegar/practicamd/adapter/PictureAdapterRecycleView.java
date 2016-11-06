package com.example.miguegar.practicamd.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguegar.practicamd.R;
import com.example.miguegar.practicamd.model.Picture;
import com.example.miguegar.practicamd.view.PictureDatailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by miguegar on 12/10/2016.
 */

//Se extiende de Adapter que es de tipo PictureViewHolder.
// Se accede a el mediante la clase padre (PictureAdapterRecycleView) y el nomre de la clase hijo (PictureViewHolder)
public class PictureAdapterRecycleView extends RecyclerView.Adapter<PictureAdapterRecycleView.PictureViewHolder> {

    //Variables utilizadas.
    private ArrayList<Picture> pictures;
    private int resourse;
    private Activity activity;

    //Constructor con las variaes declaradas.
    public PictureAdapterRecycleView(ArrayList<Picture> pictures, int resourse, Activity activity) {
        this.pictures = pictures;
        this.resourse = resourse;
        this.activity = activity;
    }


    //Metodos requeridos del ADAPTER.
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Convertir el recurso(xml) en un View de java para pasarlo al constructo de la clase PictureViewHolder declarada lineas abajo de esta clase.
        View view = LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return new PictureViewHolder(view);
    }

    //Metodo que trabaja con toda la lista de elementos de CARDVIEW (Pojo Picture)
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //Este objeto obtiene la Lista del elementos.
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());  // a traves de holder que es de tipo PictureViewHolder clase que maneja los view podemos tener acceso a ellos y setear informacion
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, PictureDatailActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                }  else {
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }




    //Clase que trabaja con todos los views que compone el CARDVIEW
    // Esta clase debe recibir el Layout para poder manjar los views
    // El layout es enviado a esta clase mendiante el metodo onCreateViewHolder del Adapter.
    public class PictureViewHolder extends RecyclerView.ViewHolder {

        //declarar los views de CARDVIEW
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        //Constructor que recibe el contexto e instancia los elementos
        public PictureViewHolder(View itemView) {
            super(itemView);
            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    = (TextView)  itemView.findViewById(R.id.userNameCard);
            timeCard        = (TextView)  itemView.findViewById(R.id.timeCard);
            likeNumberCard  = (TextView)  itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
