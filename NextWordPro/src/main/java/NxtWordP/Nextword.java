/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NxtWordP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ramu9
 */
public class Nextword {
    
    
    public static void main(String[] args)
    {
        String input="Sun";
        String[] phrasesToList=generatePredictedText(input,false);
        
        for(int i=0;i<phrasesToList.length;i++)
        {
            System.out.println(phrasesToList[i]);
        }
    }
    public static String[] generatePredictedText(String userInput,boolean casesen)
    {
        String[] listOfAllPhrases=getWords("cardsets.txt");
        return genaratePhraseList(userInput,listOfAllPhrases,casesen); 
    }
    public static String[] getWords(String filepath)
    {
        ArrayList<String> phrases=new ArrayList();
        try
        {
            FileReader filereader=new FileReader(filepath);
            BufferedReader bufferreader=new BufferedReader(filereader);
            String currentLine;
            while((currentLine=bufferreader.readLine())!=null)
            {
                phrases.add(currentLine);
            }
            bufferreader.close();
            filereader.close();
            Collections.sort(phrases);
        }
        catch(Exception e)
        {
            phrases.add(e.toString());
        }
        return phrases.toArray(new String[0]);
    }
    public static String[] genaratePhraseList(String userInput,String[] listOfAllPhrases,boolean casesen)
    {
        ArrayList<String> phrases=new ArrayList();
        for(int i=0;i<listOfAllPhrases.length;i++)
        {
            if(casesen)
            {
               if(listOfAllPhrases[i].startsWith(userInput))
               {
                  phrases.add(listOfAllPhrases[i]);  
               }
            }
            else
            {
                if(listOfAllPhrases[i].toUpperCase().startsWith(userInput.toUpperCase()))
                {
                    phrases.add(listOfAllPhrases[i]);
                }
            }
        }
        return phrases.toArray(new String[0]);
    }
}
