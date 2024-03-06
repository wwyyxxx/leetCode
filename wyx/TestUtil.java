/*
 * @Author: Tungbo
 * @Date: 2021-10-10 17:32:11
 * @LastEditTime: 2024-03-04 09:47:54
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-10-14 15:47:22
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
   public static void main(String[] args) {
      List<String> list = new ArrayList<>();
      list.add("866620069277638");
      list.add("860596054326653");
      
      
      for(String imei : list) {
         System.out.println(vaildImei(imei));
      }

      // // Arrays.toString(args);
      // LockA la = new LockA();
      // new Thread(la).start();
      // LockB lb = new LockB();
      // new Thread(lb).start();
   }

   public static boolean isIMEI(String imei) {
      char[] imeiChar = imei.toCharArray();
      int resultInt = 0;
      for (int i = 0; i < imeiChar.length-1; i++) {
          int a = Integer.parseInt(String.valueOf(imeiChar[i]));
          i++;
          final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
          final int b = temp < 10 ? temp : temp - 9;
          resultInt += a + b;
      }
      resultInt %= 10;
      resultInt = resultInt == 0 ? 0 : 10 - resultInt;
      int crc= Integer.parseInt(String.valueOf(imeiChar[14]));
      return (resultInt == crc);
  }

   private static boolean vaildImei(String imei) {
      char[] ch = imei.toCharArray();
      int sum1 = 0, sum2 = 0;
      for (int i = 0; i < ch.length - 1; i++) {
         if (i % 2 == 0) {
            sum1 += ch[i] - '0';
         } else {
            int temp = (ch[i] - '0') * 2;
            sum2 += temp >= 10 ? temp % 10 + temp / 10 : temp;
         }
      }
      return (sum1 + sum2 + ch[ch.length - 1] - '0') % 10 == 0;
   }

   public int trap(int[] height) {
      int ans = 0;
      int[] maxLeft = new int[height.length];
      int[] maxRight = new int[height.length];
      for (int i = 1; i < height.length - 1; i++) {
         maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
      }
      for (int i = height.length - 2; i >= 0; i--) {
         maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
      }
      for (int i = 1; i < height.length - 1; i++) {
         int min = Math.min(maxLeft[i], maxRight[i]);
         if (min > height[i]) {
            ans += (min - height[i]);
         }
      }
      return ans;
   }

   public static String obj1 = "obj1";
   public static final Semaphore a1 = new Semaphore(1);
   public static String obj2 = "obj2";
   public static final Semaphore a2 = new Semaphore(1);
}

class LockA implements Runnable {
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockA start");
         while (true) {
            System.out.println(new Date().toString() + " LockA tryLock LockA");
            if (TestUtil.a1.tryAcquire(1, TimeUnit.SECONDS)) {
               System.out.println(new Date().toString() + " LockA lock obj1");
               Thread.sleep(3000); // 此处等待是给B能锁住机会
               if (TestUtil.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                  System.out.println(new Date().toString() + " LockA lock obj2");
                  Thread.sleep(60 * 1000); // 为测试，占用了就不放
               } else {
                  System.out.println(new Date().toString() + "LockA lock obj2 fail");
               }
            } else {
               System.out.println(new Date().toString() + "LockA lock obj1  fail");
            }
            TestUtil.a1.release(); // 释放
            TestUtil.a2.release();
            Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

class LockB implements Runnable {
   public void run() {
      try {
         System.out.println(new Date().toString() + " LockB start");
         while (true) {
            System.out.println(new Date().toString() + " LockA tryLock LockB");
            if (TestUtil.a2.tryAcquire(1, TimeUnit.SECONDS)) {
               System.out.println(new Date().toString() + " LockB lock obj2");
               Thread.sleep(3000); // 此处等待是给A能锁住机会
               if (TestUtil.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                  System.out.println(new Date().toString() + " LockB lock obj1");
                  Thread.sleep(60 * 1000); // 为测试，占用了就不放
               } else {
                  System.out.println(new Date().toString() + "LockB lock obj1 fail");
               }
            } else {
               System.out.println(new Date().toString() + "LockB lock obj2 fail");
            }
            TestUtil.a1.release(); // 释放
            TestUtil.a2.release();
            Thread.sleep(10 * 1000); // 马上进行尝试，现实情况下do something是不确定的
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private void testJson() {

   }
}