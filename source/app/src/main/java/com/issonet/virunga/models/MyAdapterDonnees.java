package com.issonet.virunga.models;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.issonet.virunga.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterDonnees extends RecyclerView.Adapter<MyAdapterDonnees.MyViewHolderAMI>
        implements Filterable {

    List<donnees> list;
    List<donnees> listResult;
    Activity context;



    //ajouter un constructeur prenant en entrée une liste
    public MyAdapterDonnees(Activity context, List<donnees> list) {
        this.list = list;
        this.context = context;
        this.listResult = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public MyViewHolderAMI onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_donnees, viewGroup, false);


        return new MyViewHolderAMI(view);
    }

    //c'est ici que entre allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(final MyViewHolderAMI myViewHolder, final int position) {
        final donnees myObject = listResult.get(position);
        myViewHolder.bind(myObject);

    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listResult = list;
                } else {
                    List<donnees> filteredList = new ArrayList<>();
                    for (donnees row : listResult) {

                        // name match condition. this might differ depending on your requirement
//                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }


                    listResult = filteredList;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listResult;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listResult = (ArrayList<donnees>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolderAMI extends RecyclerView.ViewHolder {

        private TextView txt_titre,
                txt_description;
        private ImageView img_view;

        public MyViewHolderAMI(final View itemView) {
            super(itemView);

            txt_titre = itemView.findViewById(R.id.txt_titre);
            img_view = itemView.findViewById(R.id.img_view);
            txt_description = itemView.findViewById(R.id.txt_description);


        }

        //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
        public void bind(donnees myObject) {
           txt_titre.setText(myObject.getTitle());
           txt_description.setText(myObject.getDescription());
           img_view.setImageResource(myObject.getImage_url());
          // txt_prix.setText(myObject.getPrix()+"  ");



        }
    }

}
