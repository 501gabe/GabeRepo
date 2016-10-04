package com.gabe.android.aca.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Gabe on 9/15/16.
 */
public class DialogNewNote extends DialogFragment {

    private static final int CAMERA_REQUEST = 123;
    public ImageView imageView;


    private Uri mImageUri = Uri.EMPTY; //
    String mCurrentPhotoPath; //this is the file path where the photo will be saved.

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialogue_new_note, null);


        final EditText editTitle = (EditText) dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText) dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = (CheckBox) dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = (CheckBox) dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = (CheckBox) dialogView.findViewById(R.id.checkBoxImportant);


        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);
        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);
        Button photoButton = (Button) dialogView.findViewById(R.id.picbutton);
        imageView = (ImageView) dialogView.findViewById(R.id.previewimageView);


        builder.setView(dialogView).setMessage("Add a new note");
        //Handle the cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });



        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                    Log.e("error", "error creating file");

                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }


            }
        });



        //Handle the OK Button
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new note
                Note newNote = new Note();

                //Set it's variables to match the users entries on the form
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.settodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());
                newNote.setUri(mImageUri);

                //Get a reference to Main Activity
                MainActivity callingActivity = (MainActivity) getActivity();

                //Pass newNote back to MainActivity
                callingActivity.createNewNote(newNote);

                //Quit the dialog
                dismiss();
            }
        });

        return builder.create();


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Log.i("uri_test", mImageUri.toString());

            try {
                imageView.setImageURI(Uri.parse(mImageUri.toString()));

            } catch (Exception e) {
                Log.e("Error", "Uri not set");
            }

        } else {
            mImageUri = Uri.EMPTY;
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  // filename
                ".jpg",         // extension
                storageDir      // folder
        );

        // Save for use with ACTION_VIEW Intent
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();

        return image;
    }


}



