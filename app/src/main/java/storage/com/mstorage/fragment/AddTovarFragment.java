package storage.com.mstorage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import storage.com.mstorage.R;
import storage.com.mstorage.model.Tovar;

/**
 * Created by vamsi on 08-Jul-16.
 */

public class AddTovarFragment extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabaseReference;
    private TextInputEditText movieName;
    private TextInputEditText movieLogo;
    private RatingBar mRatingBar;
    private Button bSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tovar_fragment,container,false);

        movieName = (TextInputEditText) v.findViewById(R.id.tiet_movie_name);
        movieLogo = (TextInputEditText) v.findViewById(R.id.tiet_movie_logo);
        bSubmit = (Button) v.findViewById(R.id.b_submit);
        mRatingBar = (RatingBar) v.findViewById(R.id.rating_bar);

        //initializing database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        bSubmit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.b_submit:
                if(!isEmpty(movieName) && !isEmpty(movieName)){
                    myNewMovie("53", movieName.getText().toString().trim(),movieLogo.getText().toString());
                }else{
                    if(isEmpty(movieName)){
                        Toast.makeText(getContext(), "Please enter a movie name!", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(movieLogo)){
                        Toast.makeText(getContext(), "Please specify a url for the logo", Toast.LENGTH_SHORT).show();
                    }
                }
                //to remove current fragment
                getActivity().onBackPressed();
                break;
        }
    }

    private void myNewMovie(String userId, String movieName, String moviePoster) {
        //Creating a movie object with user defined variables
        Tovar movie = new Tovar(movieName,moviePoster);
        //referring to movies node and setting the values from movie object to that location
        mDatabaseReference.child("users").child(userId).child("movies").push().setValue(movie);
    }

    //check if edittext is empty
    private boolean isEmpty(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }


}
