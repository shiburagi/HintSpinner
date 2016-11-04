package com.app.infideap.hintspinner;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by InfiDeaP on 4/12/2015.
 */
public class SpinnerArrayAdapter<T> extends ArrayAdapter<T> {

    private static final String TAG = SpinnerArrayAdapter.class.getSimpleName();
    private final String hint;
    private final int adjust;

    private List<T> t;

    public SpinnerArrayAdapter(Context context, int textViewId, List<T> objects) {
        this(context, textViewId, objects, null);
    }

    public SpinnerArrayAdapter(Context context, int id, List<T> objects, int hintTextId) {
        this(context, id, objects, context.getResources().getString(hintTextId));
    }

    public SpinnerArrayAdapter(Context context, int id, List<T> objects, String hint) {
        super(context, id, objects);

        t = objects;
        this.hint = hint;


        adjust = hint == null ? 0 : 1;

        Log.d(TAG, "Hint : " + hint);
        if (hint != null) {
            try {
                try {
                    t.add((T) Class.forName(t.getClass().getName(), true, null).newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, null, parent);

        TextView textView = (TextView) convertView;
        if (hint != null && position == 0) {
            textView.setText(hint);
            textView.setTextColor(ContextCompat
                    .getColor(
                            getContext(),
                            android.support.v7.appcompat.R.color.abc_hint_foreground_material_light)
            );
        }


        return convertView;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        convertView = super.getDropDownView(position, null, parent);
        if (position == 0 && hint != null) {
            TextView textView = new TextView(getContext());
            textView.setHeight(0);
            textView.setVisibility(View.GONE);

            convertView = textView;
        }
        return convertView;
    }


    @Override
    public int getCount() {
        return super.getCount();
    }


}

