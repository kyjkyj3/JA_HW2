package com.example.yj.ja_hw2.ContentResolver;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by YJ on 2015-01-11.
 */
public class AddressResolver {
    public static ArrayList<String> getContactsData(Context context, String[] nameList,String[] phoneList){
        ArrayList<String> list = new ArrayList<String>();
        Cursor c = context.getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                new String[] {BaseColumns._ID},null,null,null);
        c.moveToFirst();

        if(c.getCount()>0){
            nameList = new String[c.getCount()];
            phoneList = new String[c.getCount()];
            for(int i=0; i<c.getCount();i++){
                try{
                    String _id = c.getString(
                            c.getColumnIndex(BaseColumns._ID));
                    Uri contactUri = ContentUris.withAppendedId
                            (ContactsContract.Contacts.CONTENT_URI,Integer.parseInt((_id)));
                    Uri dataUri = Uri.withAppendedPath(contactUri, ContactsContract.Contacts.Data.CONTENT_DIRECTORY);
                    Cursor c2 = context.getContentResolver().query(dataUri,
                            new String[] {
                                    BaseColumns._ID, ContactsContract.Contacts.Data.MIMETYPE,
                                    ContactsContract.Contacts.Data.DATA1,ContactsContract.Contacts.Data.DATA2,
                                    ContactsContract.Contacts.Data.DATA3,ContactsContract.Contacts.Data.DATA4,
                                    ContactsContract.Contacts.Data.DATA5,ContactsContract.Contacts.Data.DATA6,
                                    ContactsContract.Contacts.Data.DATA7,ContactsContract.Contacts.Data.DATA8,
                                    ContactsContract.Contacts.Data.DATA9,ContactsContract.Contacts.Data.DATA10,
                                    ContactsContract.Contacts.Data.DATA11,ContactsContract.Contacts.Data.DATA12,
                                    ContactsContract.Contacts.Data.DATA13,ContactsContract.Contacts.Data.DATA14,
                                    ContactsContract.Contacts.Data.DATA15},null,null,null);

                try{
                    while(c2.moveToNext()){
                        if(!c2.isNull(c.getColumnIndex(BaseColumns._ID))){
                            String mineType = c2.getString(c2.getColumnIndex(ContactsContract.Contacts.Data.MIMETYPE));
                            if(mineType.equals(ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)){
                                nameList[i] = c2.getString(c2.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME));
                            }
                            else if (mineType.equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)){
                                phoneList[i] = c2.getString(c2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                            }
                        }
                    }
                }finally {
                    c2.close();
                }
                    c.moveToNext();
                } catch (Exception e){
                    Log.e("YJ",e.toString());
                }
            }

        for(int i=0; i<nameList.length;i++){
            list.add(nameList[i]+"("+phoneList[i]+")");
        }
        }return list;
    }
}
