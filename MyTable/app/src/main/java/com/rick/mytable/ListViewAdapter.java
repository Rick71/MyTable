package com.rick.mytable;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rick on 26/02/15.
 */
public class ListViewAdapter extends BaseAdapter {

        // Declare Variables
        Context mContext;
        LayoutInflater inflater;
        private List<Lugar> barList = null;
        private ArrayList<Lugar> arraylist;

        public ListViewAdapter(Context context,
                               List<Lugar> worldpopulationlist) {
            mContext = context;
            this.barList = worldpopulationlist;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<Lugar>();
            this.arraylist.addAll(worldpopulationlist);
        }

        public class ViewHolder {
            TextView name;
            TextView description;
            TextView latitude;
            TextView longitude;
            ImageView picBar;
        }

        @Override
        public int getCount() {
            return barList.size();
        }

        @Override
        public Lugar getItem(int position) {
            return barList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;

            if (view == null) {

                holder = new ViewHolder();

                view = inflater.inflate(R.layout.listview_item, null);

                holder.name = (TextView) view.findViewById(R.id.name);
                holder.description = (TextView) view.findViewById(R.id.description);
                holder.latitude = (TextView) view.findViewById(R.id.latitude);
                holder.longitude = (TextView) view.findViewById(R.id.longitud);
                holder.picBar = (ImageView) view.findViewById(R.id.imgBar);

                view.setTag(holder);

            } else {

                holder = (ViewHolder) view.getTag();

            }

            holder.name.setText(barList.get(position).getName());
            holder.description.setText(barList.get(position).getDescripcion());
            holder.latitude.setText(barList.get(position).getLatitud());
            holder.longitude.setText(barList.get(position).getLongitud());
            holder.picBar.setImageDrawable(Drawable.createFromStream(new ByteArrayInputStream(barList.get(position).getImage()),barList.get(position).getName()));

            view.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    Intent intent = new Intent(mContext, SingleItemView.class);

                    intent.putExtra("name",(barList.get(position).getName()));
                    intent.putExtra("descripcion",(barList.get(position).getDescripcion()));
                    intent.putExtra("Latitud",(barList.get(position).getLatitud()));
                    intent.putExtra("Longitud",(barList.get(position).getLongitud()));
                    intent.putExtra("image",(barList.get(position).getImage()));
                    mContext.startActivity(intent);
                }
            });

            return view;
        }

}
