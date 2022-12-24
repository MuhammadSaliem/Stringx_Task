package org.example;

public class Stringx {
    private char[] value;
    private int length;

    private enum replaceOptions {
        FIRST,
        LAST,
        ALL
    }
    public Stringx(){}
    public Stringx(char[] val)
    {
        value = val;
        length = val.length;
    }

    public Stringx(char val)
    {
        value = new char[1];
        value[0] = val;
        length = value.length;
    }

    public boolean isEmpty()
    {
        return length == 0 ? true : false;
    }

    public Stringx trim()
    {
        int startPos = 0;
        int endPos = this.getLength();

        for(int i = 0; i<this.getLength(); i++)
        {
            if(this.charAt(i) == ' ')
                startPos++;
            else
                break;
        }

        for(int i = this.getLength() - 1; i >= 0; i--)
        {
            if(this.charAt(i) == ' ')
                endPos --;
            else
                break;
        }
        return this.substring(startPos, endPos);
    }


    public int indexOf(char ch)
    {
        for(int i = 0; i < this.getLength(); i++)
        {
            if(this.charAt(i) == ch)
                return i;
        }
        return -1; // Not Found!
    }

    public int indexOf(Stringx txt)
    {
        int[] result = txt.wordOccurrence(txt, false, false);

        return result.length > 0 ? result[0] : -1; // Not Found!
    }

    public int LastIndexOf(char ch)
    {
        for(int i = this.length - 1; i >= 0; i--)
        {
            if(this.charAt(i) == ch)
                return i;
        }
        return -1; // Not Found!
    }

    public int LastIndexOf(Stringx txt)
    {
        int[] result = txt.wordOccurrence(txt, false, false);

        return result.length > 0 ? result[result.length - 1] : -1; // Not Found!
    }

    /*
    * @Create another one to insert main.Stringx
    *
    * */

    public Stringx insert(char ch)
    {
        char[] tempArr = new char[length+1];

        for(int i = 0; i<length; i++)
        {
            tempArr[i] = value[i];
        }

        tempArr[length] = ch;
        value = tempArr;

        return this;
    }

    public Stringx insert(Stringx txt)
    {
        return this.concat(txt);
    }

    public static Stringx concat(Stringx str1, Stringx str2)
    {
        return str1.concat(str2);
    }

    public static boolean equals(Stringx[] arr1, Stringx[] arr2)
    {
        if(arr1.length == 0 && arr2.length == 0)
            return true;

        if(arr1.length != arr2.length)
            return false;

        for(int i = 0; i < arr1.length; i++)
        {
            if(!arr1[i].equals(arr2[i]))
                return false;
        }

        return true;
    }
    public boolean equalsIgnoreCase(Stringx text)
    {
        return _equals(text, true);
    }

    public boolean equals(Stringx text)
    {
        return _equals(text, false);
    }

    private boolean _equals(Stringx text , boolean IgnoreCase)
    {
        if(text == null) {
            System.out.println("Null reference!");
            return false;
        }

        if(this.getLength() != text.getLength())
            return false;

        for(int i=0; i < this.getLength(); i++)
        {
            char ch1 = this.charAt(i);
            char ch2 = text.charAt(i);

            // If ignoreCase convert all to lowercase
            if(IgnoreCase)
            {
                ch1 = (ch1 >= 65 && ch1 <= 90) ? (char)(ch1+32) : (char)ch1;
                ch2 = (ch2 >= 65 && ch2 <= 90) ? (char)(ch2+32) : (char)ch2;
            }

            // Break -> If exist two characters are not equal
            if(ch1 != ch2)
                return false;
        }
        return true;
    }

    public boolean startsWith(Stringx text)
    {
        Stringx keyword = this.substring(0, text.length);
        return keyword.equals(text);
    }

    public boolean endsWith(Stringx text)
    {
        Stringx keyword = this.substring(this.length - text.length, this.length);
        return keyword.equals(text);
    }

    public char charAt(int index)
    {
        if(index < 0 || index >= length)
        {
            System.out.println("java index out of range");
            return 0;
        }
        return value[index];
    }

    public int compareTo(Stringx txt)
    {
        return _compareTo(txt, false);
    }

    public int compareToIgnoreCase(Stringx txt)
    {
        return _compareTo(txt, true);
    }

    private int _compareTo (Stringx txt, boolean ignoreCase)
    {
        int len1 = this.getLength();
        int len2 = txt.getLength();

        int iterations = len1 > len2 ? len2 : len1;

        char[] lst1, lst2;

        if(ignoreCase)
        {
            lst1 = this.toLower().getValue();
            lst2 = txt.toLower().getValue();
        }

        else
        {
            lst1 = this.getValue();
            lst2 = txt.getValue();
        }

        for(int i = 0; i < iterations; i++)
        {
            char ch1 = lst1[i];
            char ch2 = lst2[i];

            if(ch1 != ch2){
                return ch1 - ch2;
            }
        }

        return len1 - len2;
    }

    public Stringx concat(Stringx txt)
    {
        if(txt == null)
            return null;

        if(txt.getLength() == 0)
            return this;

        char[] tmpArr = new char[this.getLength() + txt.getLength()];
        int count = 0;

        for (int i = 0; i < this.getLength(); i++)
        {
            tmpArr[i] = this.charAt(i);
            count++;
        }

        for (int i = 0; i < txt.getLength(); i++)
        {
            tmpArr[i + count] = txt.charAt(i);
        }

        return new Stringx(tmpArr);
    }

    public boolean contains(Stringx text)
    {
        return this.numOfOccurrence(text, false) > 0 ? true : false;
    }

    public Stringx replaceAll(Stringx oldValue , Stringx newValue )
    {
        return replace(oldValue, newValue, replaceOptions.ALL);
    }

    public Stringx replaceFirst(Stringx oldValue , Stringx newValue )
    {
        return replace(oldValue, newValue, replaceOptions.FIRST);
    }

    public Stringx replaceLast(Stringx oldValue , Stringx newValue )
    {
        return replace(oldValue, newValue, replaceOptions.LAST);
    }


    private Stringx replace(Stringx oldValue, Stringx newValue, replaceOptions option)
    {
        int[] result = this.wordOccurrence(oldValue, false, false);

        int diff = 0;
        for(int i = 0; i< result.length; i++)
        {
            diff = Math.abs(oldValue.length - newValue.length) * i; // shift the difference between oldValue and newValue lengths

            if (i > 0 && option == replaceOptions.FIRST)
                break;

            if(option == replaceOptions.LAST)
                i = result.length - 1;

            Stringx txt1 = this.substring(0, result[i] -(diff)).insert(newValue);
            Stringx txt2 = this.substring(result[i]+oldValue.length - (diff) , this.length);
            this.setValue(txt1.concat(txt2).value);
        }

        return this;
    }



    public Stringx[] split(Stringx delimiter)
    {
        Stringx txt = this;
        int[] result = txt.wordOccurrence(delimiter, false, false);
        Stringx[] temp = new Stringx[result.length+1];
        int arrCount = 0;

        for(int i = 0; i < result.length; i++)
        {
            if (i == 0)
            {
                temp[arrCount] = txt.substring(0, result[i]);
                arrCount++;
            }

            if(i == result.length - 1)
            {
                temp[arrCount] = txt.substring(result[i]+1, txt.length);
                break;
            }

            temp[arrCount] = txt.substring(result[i]+1, result[i+1]);

            arrCount++;
        }
        return temp;
    }

    public Stringx substring(int start, int end)
    {
        // null check
        if(length == 0)
            return new Stringx(' ');

        // boundaries
        if(start < 0 || start > end || end > length)
            return new Stringx();


        char[] tempArr = new char[end - start];
        for(int i = 0, k = start; i < tempArr.length && k < end ; i++, k++)
        {
            tempArr[i] = (char)value[k];
        }

        return new Stringx(tempArr);
    }

    public Stringx substring(int start)
    {
        // null check
        if(length == 0)
            return new Stringx(' ');

        // boundaries
        if(start < 0)
            return new Stringx();


        char[] tempArr = new char[this.getLength() - start];
        for(int i = 0, k = start; i < tempArr.length && k < this.getLength() ; i++, k++)
        {
            tempArr[i] = (char)value[k];
        }

        return new Stringx(tempArr);
    }

    public Stringx toLower()
    {
        return convertCase(true);
    }

    public Stringx toUpper()
    {
        return convertCase(false);
    }

    private Stringx convertCase(boolean toLower)
    {
        char[] tempArr = new char[length];

        for(int i= 0; i < length; i++)
        {
            char ch = value[i];
            if(toLower)
                tempArr[i] = (ch >= 65 && ch <= 90) ? (char)(ch+32) : (char)(ch); // toLowercase
            else
                tempArr[i] = (ch >= 97 && ch <= 122) ? (char)(ch-32) : (char)(ch); // toUppercase
        }

        return new Stringx(tempArr);
    }

    public int countMatches(Stringx match){
        return numOfOccurrence(match,false);
    }
    private int[] wordOccurrence(Stringx word, boolean firstMatch ,boolean ignoreCase)
    {
        // null
        if(word == null)
            return null;

        // if search keyword > text => break
        if(word.getLength() > this.getLength())
            return null;

        // if keyword or text empty => break
        if(word.getLength() == 0 || this.getLength() == 0)
            return null;

        int[] result =new int[this.length];
        int resultPos = 0;

        int len = word.getLength();
        //word = word.toLower();

        // All matches
        for(int i = 0; i <= this.getLength(); i++)
        {
            int posEnd = len + i;
            Stringx keyword = this.substring(i, posEnd);


            if(ignoreCase)
            {
                word = word.toLower();
                keyword = keyword.toLower();
            }

            if(word.equals(keyword))
            {
                result[resultPos] = i;
                resultPos++;
            }

            //break firstMatch == True And we already got first match
            if(result.length > 0 && firstMatch)
                break;

            // break if reach the end of the text
            if(i + word.getLength() == this.getLength())
                break;
        }

        return shrinkArray(result, resultPos);
    }

    private int numOfOccurrence(Stringx word , boolean ignoreCase)
    {
        //null
        if(word == null) {
            System.out.println("Null reference!");
            return 0;
        }

        // if search keyword > text => break
        if(word.getLength() > this.getLength())
            return 0;

        // if keyword or text empty => break
        if(word.getLength() == 0 || this.getLength() == 0)
            return 0;

        int len = word.getLength();
        //word = word.toLower();

        int count = 0;
        for(int i = 0; i <= getLength(); i++)
        {
            int posEnd = len + i;
            Stringx keyword = this.substring(i, posEnd);

            if(ignoreCase)
            {
                word = word.toLower();
                keyword = keyword.toLower();
            }

            if(word.equals(keyword))
                count++;

            if(i + word.getLength() == this.getLength())
                break;
        }
        return count;
    }

    public static int[] shrinkArray(int[] arr, int size)
    {
        if(arr.length == size)
            return arr;

        int[] temp= new int[size];
        for(int i = 0; i < size; i++)
        {
            temp[i] = arr[i];
        }
        return temp;
    }

    public void print()
    {
        for(int i = 0; i < length; i++)
        {
            System.out.print(value[i]);
        }

        System.out.println();
    }

    public char[] getValue() {
        return value;
    }

    public void setValue(char[] value) {
        this.value = value;
        this.length = value.length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.getValue());
    }
}
