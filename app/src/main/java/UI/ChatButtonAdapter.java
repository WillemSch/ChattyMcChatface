package UI;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.willem.chattymcchatface.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom adapter for the hosts list to show our data.
 *
 * @author Willem Schooltink
 * @version 1.0.0
 */

public class ChatButtonAdapter extends BaseAdapter implements View.OnClickListener {

    private static LayoutInflater inflater;
    public Resources res;
    private Activity activity;
    private ListModel tempValues = null;

    public ChatButtonAdapter(Activity a, Resources resLocal) {
        activity = a;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ChatButtonAdapter(Activity a, Resources resLocal, List<String> addresses, List<String> hosts) {
        activity = a;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String[] getItem(int position) {
        return new String[]{};
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        return vi;
    }

    public void addItem(String host, String address) {
    }

    @Override
    public void onClick(View v) {

    }

    private static class ViewHolder {
        private TextView host;
        private TextView address;
    }

    private class OnItemClickListener implements View.OnClickListener {
        private int position;

        OnItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
        }
    }
}

