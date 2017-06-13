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
    private List<String> addresses;
    private List<String> hosts;
    private ListModel tempValues = null;

    public ChatButtonAdapter(Activity a, Resources resLocal) {
        activity = a;
        res = resLocal;
        hosts = new ArrayList<>();
        addresses = new ArrayList<>();
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ChatButtonAdapter(Activity a, Resources resLocal, List<String> addresses, List<String> hosts) throws ArraySizeNotEqualException {
        if (addresses.size() == hosts.size()) {
            activity = a;
            res = resLocal;
            this.addresses = addresses;
            this.hosts = hosts;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } else {
            //throw new ArraySizeNotEqualException("The addresses list has to be of the same size as the hosts list.");
        }
    }

    @Override
    public int getCount() {
        if (addresses.size() <= 0)
            return 1;
        return addresses.size();
    }

    @Override
    public String[] getItem(int position) {
        return new String[]{hosts.get(position), addresses.get(position)};
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {
            vi = inflater.inflate(R.layout.listitem, null);

            holder = new ViewHolder();
            holder.host = (TextView) vi.findViewById(R.id.host);
            holder.address = (TextView) vi.findViewById(R.id.address);

            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }

        if (addresses.size() <= 0) {
            holder.host.setText("No Hosts");
            holder.address.setText("Searching...");
        } else {
            tempValues = new ListModel(hosts.get(position), addresses.get(position));

            holder.host.setText(tempValues.getHost());
            holder.address.setText(tempValues.getAddress());

            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }

    public void addItem(String host, String address) {
        hosts.add(host);
        addresses.add(address);
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
            MainActivity root = (MainActivity) activity;
            root.onItemClick(position);
        }
    }
}

