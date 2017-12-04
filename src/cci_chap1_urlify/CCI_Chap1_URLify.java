/*
    URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith ", 13
    Output: "Mr%20John%20Smith"
 */
package cci_chap1_urlify;

import java.util.*;

/**
 *
 * @author Ali
 */
public class CCI_Chap1_URLify 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        URLify("Mr John Smith    ", 13);
    }
    
    private static void URLify(String str, int charCount)
    {
        char[] content = str.toCharArray();
        int spaceCount = 0, index;
        for(int i=0; i<charCount; i++)
            if(content[i] == ' ')
                spaceCount++;
        
        index = charCount + spaceCount * 2;
        if (charCount < str.length()) 
            content[charCount] = '\0';
        
        for (int i = charCount - 1; i >= 0; i-- ) {
            if (content[i] == ' ') 
            {
                content[index - 1] = '0';
                content[index - 2] = '2';
                content[index - 3] = '%';
                index = index - 3;
            } 
            else {
                content[index - 1] = content[i];
                index--;
            }
        }
        
        String url = "";
        for (char c : content)
        {
            url += c;
        }
        
        System.out.println(url);
    }
    
}
