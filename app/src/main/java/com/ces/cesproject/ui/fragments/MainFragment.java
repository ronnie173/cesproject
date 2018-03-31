package com.ces.cesproject.ui.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ces.cesproject.R;
import com.ces.cesproject.data.DataItems;
import com.ces.cesproject.ui.tableview.TableViewListener;
import com.ces.cesproject.ui.tableview.adapters.TableViewAdapter;
import com.ces.cesproject.ui.tableview.models.Cell;
import com.ces.cesproject.ui.tableview.models.ColumnHeader;
import com.ces.cesproject.ui.tableview.models.RowHeader;
import com.evrencoskun.tableview.TableView;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Main fragment.
 */
public class MainFragment extends Fragment {


    private static final String TAG = MainFragment.class.getSimpleName();

    private TableView mTableView;
    private TableViewAdapter mTableAdapter;

    private ProgressDialog mProgressDialog;
    // For TableView
    private List<List<Cell>> mCellList;
    private List<ColumnHeader> mColumnHeaderList;
    private List<RowHeader> mRowHeaderList;


    /**
     * Instantiates a new Main fragment.
     */
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mTableView = (TableView) view.findViewById(R.id.my_TableView);

        // Create TableView Adapter
        mTableAdapter = new TableViewAdapter(getContext());
        mTableView.setAdapter(mTableAdapter);

        // Create listener
        mTableView.setTableViewListener(new TableViewListener(mTableView));
        return view;
    }

    /**
     * Populated table view.
     *
     * @param dataItemsList the user info list
     */
    public void populatedTableView(List<DataItems> dataItemsList) {
        // create Models
        mColumnHeaderList = createColumnHeaderList();
        mCellList = loadCellList(dataItemsList);
        mRowHeaderList = createRowHeaderList();

        // Set all items to the TableView
        mTableAdapter.setAllItems(mColumnHeaderList, mRowHeaderList, mCellList);
    }

    /**
     * Crates the column headers
     * @return
     */
    private List<ColumnHeader> createColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeader("Vendor Name"));
        list.add(new ColumnHeader("Stock Code"));
        list.add(new ColumnHeader("Description"));
        return list;
    }

    /**
     * Loads the cells with data from DataItems
     * @param dataItems
     * @return
     */
    private List<List<Cell>> loadCellList(List<DataItems> dataItems) {
        List<List<Cell>> lists = new ArrayList<>();

        // Creating cell model list from UserInfo list for Cell Items
        // In this example, UserInfo list is populated from web service

        for (int i = 0; i < dataItems.size(); i++) {
            List<Cell> list = new ArrayList<>();

            // The order should be same with column header list;
            list.add(new Cell("1-" + i, dataItems.get(i).vendor().name()));     // "Name"
            list.add(new Cell("2-" + i, dataItems.get(i).stockCode())); // "Stock Code"
            list.add(new Cell("3-" + i, dataItems.get(i).desc()));    // "Description"


            // Add
            lists.add(list);
        }

        return lists;
    }

    private List<RowHeader> createRowHeaderList() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < mCellList.size(); i++) {
            // Row headers just shows the index of the TableView List.
            list.add(new RowHeader(String.valueOf(i + 1)));
        }
        return list;
    }


}
