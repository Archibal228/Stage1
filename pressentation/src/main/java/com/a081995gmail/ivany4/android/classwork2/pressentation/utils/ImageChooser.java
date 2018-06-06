package com.a081995gmail.ivany4.android.classwork2.pressentation.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.net.URI;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Archibal on 18.04.2018.
 */

public class ImageChooser {

    private static final int Camera_Request_Code = 123;
    private static final int Galeyy_Request_Code = 456;

    public static void srartCamera(Activity activity) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {

            File photo = getCameraFile(activity);

            if(photo.exists()){
                photo.delete();
            }

            Log.e("eeee","FILE path=" +photo.getAbsolutePath());

            Uri uri = FileProvider.getUriForFile(activity, "package com.a081995gmail.ivany4.android.classwork2.pressentation.utils.MyFileProvider", photo);


            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            activity.startActivityForResult(intent, Camera_Request_Code);
        }

    }


    public static void startGallery(Activity activity) {

        RxPermissions rxPermissions = new RxPermissions(activity);
rxPermissions
        .request( Manifest.permission.READ_PHONE_STATE)
                .subscribe(new Observer<Boolean>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(Boolean aBoolean) {
if (aBoolean){
    srartCamera(activity);
}
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           });


    }

    private static void chooseGalery(Activity activity){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {


            activity.startActivityForResult(intent, Galeyy_Request_Code);


        }
    }

    public static File getCameraFile(Activity activity) {
        File root = activity.getExternalFilesDir(null);
        if (root == null) {
            root = activity.getFilesDir();
        }
        File myDir = new File(root.getAbsoluteFile() + "/myDir");
        if (!myDir.exists()) {
            myDir.mkdir();
        }

        return new File(myDir.getAbsoluteFile() + "/" + ".jpg");
    }

    public static File getImageFromResult(Activity activity, int requestCode, int ResultCode, Intent data) {

        switch (requestCode) {
            case Camera_Request_Code: {
                File file = getCameraFile(activity);
                if (file.exists()) {
                    return file;
                } else {
                    return null;
                }
            }
            case Galeyy_Request_Code :{
                Uri uri = data.getData();
                Cursor cursor = activity.getApplicationContext().getContentResolver()
                        .query(uri,new String[]{MediaStore.Images.Media.DATA},null,null,null);

                if (cursor == null){
                    return null;
                }

                cursor.moveToFirst();
                int index = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                String file = cursor.getString(index);
                cursor.close();
                return new File(file);
            }


        }

        return null;
    }
}
