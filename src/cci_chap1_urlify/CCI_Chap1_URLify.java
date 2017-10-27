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
    
    private static void URLify(String str, int len)
    {
        char[] arr = str.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        
        for (int i=0; i<arr.length; i++)
        {
            if (!queue.isEmpty())
            {
                if (queue.getLast() == ' ')
                {
                    queue.pollLast();
                    arr[i-1] = '%';
                    queue.addLast('0');
                    queue.addLast('2');
                    queue.addFirst(arr[i]);
                }
                else
                {
                    queue.addFirst(arr[i]);
                    arr[i-1] = queue.pollLast();
                }
            }
            
            else if (arr[i] == ' ')
            {
                queue.addFirst(arr[i]);
            }
        }
        
        if (!queue.isEmpty())
        {
            arr[arr.length-1] = queue.pollLast();
        }
        
        String url = "";
        for (char c : arr)
        {
            url += c;
        }
        
        System.out.println(url);
    }
    
}
