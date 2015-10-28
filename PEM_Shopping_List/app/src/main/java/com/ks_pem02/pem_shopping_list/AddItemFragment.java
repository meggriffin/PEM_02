package com.ks_pem02.pem_shopping_list;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemFragment extends Fragment {


    private Button cancelButton;
    private Button addItemButton;

    private CancelDialogFragment cdf;
    private AddItemDialogFragment aidf;

    private ImageView imageView;
    String imgUrl [] = {"https://c2.staticflickr.com/2/1133/1365317011_cc31ebad9a.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/5/50/Avocado_open.jpg",
            "https://c1.staticflickr.com/3/2355/2104039823_b47da37172_b.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Banana.png/836px-Banana.png",
            "https://upload.wikimedia.org/wikipedia/commons/5/5f/Skimmed_milk.jpg"};



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddItemFragment newInstance(String param1, String param2) {
        AddItemFragment fragment = new AddItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);

        String random = (imgUrl[new Random().nextInt(imgUrl.length)]);

        Picasso.with(getActivity())
                .load(random)
                .resize(120, 120)
                .centerCrop()
                .into(imageView);

        System.out.println("ImageView created "+ imageView);

        cancelButton = (Button) view.findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("CAAAANCEL");
                cancelItem();

            }
        });
        addItemButton = (Button) view.findViewById(R.id.addItem);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("SAAAAAVE");
                addItem();
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void cancelItem() {
        CancelDialogFragment newFragment = new CancelDialogFragment();
        newFragment.show(getActivity().getFragmentManager(), "cancel");
    }
    public void addItem(){
        AddItemDialogFragment nuFragment = new AddItemDialogFragment();
        nuFragment.setTargetFragment(this, 1);
        nuFragment.show(getActivity().getFragmentManager(), "save");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data ){
        switch (requestCode){
            case 1:
                if(resultCode == Activity.RESULT_OK){


                    System.out.println("JAAA!!");

                    EditText itemName = (EditText) getView().findViewById(R.id.itemName);
                    EditText itemPrice = (EditText) getView().findViewById(R.id.itemPrice);
                    ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);

                    mListener.addItemToList(itemName.getText().toString(),itemPrice.getText().toString(),"@drawable/avocado");



                }else if(resultCode == Activity.RESULT_CANCELED){


                    System.out.println("NEEEE!!");



                }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);

        public void addItemToList(String _firstLine, String _secondLine, String _uri);

    }




}
