package com.example.miguegar.practicamd.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miguegar.practicamd.R;
import com.example.miguegar.practicamd.adapter.PictureAdapterRecycleView;
import com.example.miguegar.practicamd.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Llama al metodo showToolbar con los parametros necesarios.
        showToolbar(getResources().getString(R.string.tab_home), false, view);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecycleView pictureAdapterRecycleView =
                new PictureAdapterRecycleView(buildPicture(),R.layout.cardview_picture,getActivity());

        pictureRecycler.setAdapter(pictureAdapterRecycleView);

        return view;
    }

    public ArrayList<Picture> buildPicture(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Miguel Garcia","Hace 3 días","1 me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Herbstlandschaft_(am_Rebhang).jpg/270px-Herbstlandschaft_(am_Rebhang).jpg","Leidy Martin","Hace 1 días","9 me gusta"));
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/87/b1/0f/87b10f2eef4e503faa1cb75da3d62150.jpg","Luna Miranda","Hace 8 días","4 me gusta"));

        return pictures;
    }

    //Personalizar el Toolbar
    public void showToolbar(String tittle, boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);                 //Para soporte a versiones anteriores.
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
