package lesson2;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Nastya
 * Date: 23.10.14
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class PrimeNumbers {
      @Test
      public void isPrimaryNum()
      {
          Assert.assertEquals(isPrime(12), false);
          Assert.assertEquals(isPrime(3), true);
      }



    public static boolean isPrime(int num)
    {
        for(int k = 2; k<num; k++)
        {
            if(num%k == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(121));
    }
}
