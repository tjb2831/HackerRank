/**
 * URL:
 *    https://www.hackerrank.com/challenges/the-love-letter-mystery
 *
 * Summary:
 *    Given a string of lowercase english letters, determine the minimum number of
 *    operations needed to turn the string into a palindrome. A single operation
 *    is defined as demoting a letter a single time. See the operational constraints
 *    for more information.
 *
 * Operational Constraints:
 *    1) Letters are always reduced, never promoted. Example: 'c' can be reduced
 *       to 'b', but 'b' cannot be promoted to 'c'
 *    2) Letters can be reduced until they become 'a'. Once they change to 'a', they
 *       cannot be operated on further
 * 
 * @author Thomas Bresnahan
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{

   /**
    * Calculate the number of operations that would transform the given
    * String into a palindrome
    *
    * @param original The String on which to calculate
    *
    * @return
    *    The minimum number of operations required for the transformation
    *
    * @throws InvalidArgumentException
    *    The given String is {@code null} or has invalid characters
    */
   private static int calcPalindromeOps( String original )
   {
      if( original == null )
         throw new IllegalArgumentException( "Null input string" );

      int operCount = 0;
      int leftIdx = 0;
      int rightIdx = original.length() - 1;
      char leftChar, rightChar;

      while( leftIdx < rightIdx )
      {
         leftChar = original.charAt( leftIdx );
         rightChar = original.charAt( rightIdx );

         // Verify the characters are in range
         if( leftChar < 'a' || leftChar > 'z' ||
             rightChar < 'a' || rightChar > 'z' )
         {
            throw new IllegalArgumentException( "Invalid character" );
         }

         operCount += Math.abs( leftChar - rightChar );
         ++leftIdx;
         --rightIdx;
      }

      return operCount;
   }

   /**
    * Read in the test inputs from Standard Input.
    * <p>
    * <em>NB:</em> The inputs are assumed to be valid and present.
    * 
    * @return
    *    The test inputs
    */
   private static List<String> readInput()
   {
      Scanner in = new Scanner( System.in );
      List<String> tests = new LinkedList<String>();

      final int numTests = in.nextInt();
      for( int testIdx = 0; testIdx < numTests; ++testIdx )
      {
         tests.add( in.next() );
      }

      return tests;
   }

   public static void main(String[] args)
   {
      List<String> tests = readInput();
      for( String test : tests )
      {
         System.out.println( calcPalindromeOps( test ) );
      }
   }

}
