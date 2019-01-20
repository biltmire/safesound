
package com.example.testapp;
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Contact {
    static
    String keyword = new String();
    String number = new String();
    /*
    protected contact (){
        keyword = "help";
        number = "911";
    }

    protected Contact (String keyword, String number){
        setKeyword(keyword);
        setNumber(number);
    }


    protected  Contact (String input){
        StringTokenizer line = new StringTokenizer(input, ":");
        setKeyword(line.nextToken());
        setNumber(line.nextToken());
    }

    protected void setKeyword(String keyword){
        if (keyword.length() > 0)
            this.keyword = keyword;
    }

    protected void setNumber(String number){
        if (number.length() > 0)
            this.number = number;
    }

    public String toString(){
        return keyword+":"+number;
    }


    protected int loadContacts(ArrayList<Contact> contacts, String filename)
    {
        try
        {
            String line = null;
            BufferedReader br = new BufferedReader (new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                if (line.trim().length()==0) continue;	//skips empty line
                contacts.add(new Contact(line));
            }
            br.close();
        }

        catch (IOException ioe)
        {
            //ADD CATCH FOR ANDROID
        }
        return contacts.size();
    }

    protected void removeContacts(int index, ArrayList<Contact> contacts){
        contacts.remove(index+1);
    }

}
*/