import org.example.Stringx;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
    Test class naming convention
     use the 'suffix' for test classes and the prefix for test methods:
        -the MyClass test            --> MyClassTest
        -test the calculate method   --> testCalculate()
 */
public class Stringx_Test {

    /* JUnit test methods naming convention
        "MethodName_StateUnderTest_ExpectedBehavior"
        -example: isAdult_AgeLessThan18_False
     */



    @Test
    public void toString_convertStringxToString_String(){
        Stringx name = new Stringx("Saleem".toCharArray());
        assertInstanceOf(String.class, name.toString());
    }

    @Test
    public void toLower_convertStringToLowerCase_True()
    {
        Stringx strBefore = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx strAfter = new Stringx("saleem goes to work at 9:00 am. saleem likes shawarma.".toCharArray());

        assertEquals(strBefore.toLower().toString(), strAfter.toString());
    }

    @Test
    public void toUpper_convertStringToUpperCase_True()
    {
        Stringx strBefore = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx strAfter = new Stringx("SALEEM GOES TO WORK AT 9:00 AM. SALEEM LIKES SHAWARMA.".toCharArray());

        assertEquals(strBefore.toUpper().toString(), strAfter.toString());
    }

    @Test
    public void numOfOccurrence_countTheNumberOfMatches_2(){
        Stringx str = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx match = new Stringx("Saleem".toCharArray());

        assertEquals(str.countMatches(match), 2);
    }

    @Test
    public void charAt_returnIndexOf0_S(){
        Stringx str = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());

        assertEquals(str.charAt(0), 'S');
    }

    @Test
    public void subString_getFirstFiveChar_Hello(){
        Stringx x = new Stringx("Hello there, how are you doing?".toCharArray());
        assertEquals(x.substring(0,5).toString(), "Hello");
    }

    @Test
    public void equals_checkIfDifferentNamesAreEqual_False(){
        Stringx name1 = new Stringx("Ahmed".toCharArray());
        Stringx name2 = new Stringx("ahmed".toCharArray());

        assertFalse(name1.equals(name2));
    }

    @Test
    public void equalsIgnoreCase_sameNamesWithDifferentCases_True(){
        Stringx name1 = new Stringx("Ahmed".toCharArray());
        Stringx name2 = new Stringx("ahmed".toCharArray());

        assertTrue(name1.equalsIgnoreCase(name2));
    }

    @Test
    public void trim_returnTextWithoutWhitespaces_Hello(){
        Stringx txt = new Stringx("   Hello    ".toCharArray());

        assertEquals(txt.trim().toString(), "Hello");
    }

    @Test
    public void indexOf_returnFirstAppearanceOfS_0(){
        Stringx txt = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());

        assertEquals(txt.indexOf('S'), 0);
    }

    @Test
    public void lastIndexOf_returnLastAppearanceOfS_0(){
        Stringx txt = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());

        assertEquals(txt.LastIndexOf('S'), 32);
    }

    @Test
    public void lastIndexOf_returnLastAppearanceOfz_Negative(){
        Stringx txt = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());

        assertEquals(txt.LastIndexOf('z'), -1);
    }

    @Test
    void insert_insertKToSaleem(){
        Stringx name = new Stringx("Saleem".toCharArray());
        assertEquals(name.insert('K').toString(), "SaleemK");
    }


    @Test
    public void concat_returnConcatofTwoStrings_HelloWorld(){
        Stringx str1 = new Stringx("Hello".toCharArray());
        Stringx str2 = new Stringx("World".toCharArray());

        assertEquals(Stringx.concat(str1, str2).toString(), "HelloWorld");
    }

    @Test
    public void startsWith_checkIfStringStartsWithHello_True(){
        Stringx str = new Stringx("Hello World".toCharArray());
        Stringx startWith = new Stringx("Hello".toCharArray());

        assertTrue(str.startsWith(startWith));
    }

    @Test
    public void endsWith_checkIfStringEndsWithHello_False(){
        Stringx str = new Stringx("Hello World".toCharArray());
        Stringx endWith = new Stringx("Hello".toCharArray());

        assertFalse(str.endsWith(endWith));
    }

    @Test
    public void contains_checkIfStringSaleem_True(){
        Stringx str = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx searchKeyword = new Stringx("Saleem".toCharArray());

        assertTrue(str.contains(searchKeyword));
    }

    @Test
    public void replaceFirst_replaceSaleemWithAhmed_True(){
        Stringx strBefore = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx strAfter = new Stringx("Ahmed goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());

        Stringx oldVal = new Stringx("Saleem".toCharArray());
        Stringx newVal = new Stringx("Ahmed".toCharArray());

        assertEquals(strBefore.replaceFirst(oldVal, newVal).toString(), strAfter.toString());
    }

    @Test
    public void replaceLast_replaceSaleemWithAhmed_True(){
        Stringx strBefore = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx strAfter = new Stringx("Saleem goes to work at 9:00 AM. Ahmed likes shawarma.".toCharArray());

        Stringx oldVal = new Stringx("Saleem".toCharArray());
        Stringx newVal = new Stringx("Ahmed".toCharArray());

        assertEquals(strBefore.replaceLast(oldVal, newVal).toString(), strAfter.toString());
    }

    @Test
    public void replaceAll_replaceSaleemWithAhmed_True(){
        Stringx strBefore = new Stringx("Saleem goes to work at 9:00 AM. Saleem likes shawarma.".toCharArray());
        Stringx strAfter = new Stringx("Ahmed goes to work at 9:00 AM. Ahmed likes shawarma.".toCharArray());

        Stringx oldVal = new Stringx("Saleem".toCharArray());
        Stringx newVal = new Stringx("Ahmed".toCharArray());

        assertEquals(strBefore.replaceAll(oldVal, newVal).toString(), strAfter.toString());
    }

    @Test
    public void split_splitStringUsingDelimiter_True(){
        Stringx str = new Stringx("one two three".toCharArray());
        Stringx[] strArr = new Stringx[]{new Stringx("one".toCharArray()), new Stringx("two".toCharArray()), new Stringx("three".toCharArray()) };

        Stringx[] result = str.split(new Stringx(' '));
        assertTrue(Stringx.equals(strArr, result));
    }

    @Test
    public void compareTo_compareSaleemToAhmed_PositiveNumber(){
        Stringx str1 = new Stringx("Saleem".toCharArray());
        Stringx str2 = new Stringx("Ahmed".toCharArray());

        assertTrue(str1.compareTo(str2) > 0 );
    }

    @Test
    public void compareTo_compareAhmedToSaleem_NegativeNumber(){
        Stringx str1 = new Stringx("Ahmed".toCharArray());
        Stringx str2 = new Stringx("Saleem".toCharArray());

        assertTrue(str1.compareTo(str2) < 0 );
    }

    @Test
    public void compareTo_compareSaleemToSaleem_0(){
        Stringx str1 = new Stringx("Saleem".toCharArray());
        Stringx str2 = new Stringx("Saleem".toCharArray());

        assertTrue(str1.compareTo(str2) == 0 );
    }

    @Test
    public void compareToIgnorecase_compareSaleemTosaleem_0(){
        Stringx str1 = new Stringx("Saleem".toCharArray());
        Stringx str2 = new Stringx("saleem".toCharArray());

        assertTrue(str1.compareToIgnoreCase(str2) == 0 );
    }
}
