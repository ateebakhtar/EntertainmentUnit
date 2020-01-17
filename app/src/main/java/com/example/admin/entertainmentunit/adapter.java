package com.example.admin.entertainmentunit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>
{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> b=new ArrayList<>();
    private ArrayList<String> mImageNames=new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<>();
    private ArrayList<String> ids=new ArrayList<>();
    private ArrayList<String> po=new ArrayList<>();
    private Context mContext;
    int place;
    int idd;

    public adapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mImageNames,int p,int ido) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
        place = p;
        idd = ido;
        MyApplication s = new MyApplication();
        idd =  s.getSomeVariable();
        System.out.println(idd);
        if (mImages.isEmpty() )
        {
            System.out.println("EMPTAJTAJTJA");
        }
    }
    public adapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mImageNames,int p,int ido, ArrayList<String> u,ArrayList<String> z) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
        this.ids = u;
        this.po = z;
        place = p;
        idd = ido;
        MyApplication s = new MyApplication();
        idd =  s.getSomeVariable();
        System.out.println(idd);
        if (mImages.isEmpty() )
        {
            System.out.println("EMPTAJTAJTJA");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_relative,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext)

                .load(mImages.get(position))
                .into(holder.image);
//        holder.imageName.setText(mImageNames.get(position));
        holder.b.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d(TAG,"bla bla");
                Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();

                if(place == 1)
                {
                    Intent x = new Intent(mContext,movieinfo.class);
                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", position+1);
                    dataBundle.putString("name",mImageNames.get(position));
                    x.putExtras(dataBundle);
                    mContext.startActivity(x);
                }
                else if(place == 2)
                {
                    Intent x = new Intent(mContext,songinfo.class);
                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", position+1);
                    dataBundle.putString("name",mImageNames.get(position));
                    x.putExtras(dataBundle);
                    mContext.startActivity(x);


                }
                else if( place == 3)
                {
                    Intent x = new Intent(mContext,showinfo.class);
                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", position+1);
                    dataBundle.putString("name",mImageNames.get(position));
                    x.putExtras(dataBundle);
                    mContext.startActivity(x);
                }
                else
                {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle(mImageNames.get(position));
                    builder.setMessage("Do you want to view/delete this item ??");
                    builder.setPositiveButton("Delete Item", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            playlistDB x = new playlistDB(mContext);
                            MyApplication s = new MyApplication();

                            String temp = ids.get(position);
                            int qw = Integer.parseInt(temp);

                            x.deletedata(qw);
                            Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_SHORT).show();
                            Intent p = new Intent(mContext,playlist.class);
                            mContext.startActivity(p);

                        }
                    });
                    builder.setNegativeButton("View Info", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            if(po.get(position).equals("show"))
                            {
                                Intent x = new Intent(mContext,showinfo.class);
                                Bundle dataBundle = new Bundle();
                                dataBundle.putInt("id", position+1);
                                dataBundle.putString("name",mImageNames.get(position));
                                System.out.println("shows"+mImageNames.get(position));
                                x.putExtras(dataBundle);
                                mContext.startActivity(x);
                            }
                            else if(po.get(position).equals("movie"))
                            {
                                Intent x = new Intent(mContext,movieinfo.class);
                                Bundle dataBundle = new Bundle();
                                dataBundle.putInt("id", position+1);
                                dataBundle.putString("name",mImageNames.get(position));
                                System.out.println("movis"+mImageNames.get(position));
                                x.putExtras(dataBundle);
                                mContext.startActivity(x);
                            }
                            else
                            {
                                Intent x = new Intent(mContext,songinfo.class);
                                Bundle dataBundle = new Bundle();
                                dataBundle.putInt("id", position+1);
                                dataBundle.putString("name",mImageNames.get(position));
                                System.out.println("songs"+mImageNames.get(position));
                                x.putExtras(dataBundle);
                                mContext.startActivity(x);
                            }

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView image;
        TextView imageName;
        TextView b;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView)
        {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            imageName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);
            b=itemView.findViewById(R.id.textView2);
        }

    }
}
