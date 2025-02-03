package wyx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import wyx.LockB.PinyinComparator;
import wyx.bean.ListNode;
import wyx.leetcode2024.wyx20240624.Solution234;
import wyx.other.Solution;
import wyx.utils.ExcelUtil;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2024-05-22 19:40:20
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
   public static void main(String[] args) {
      List<String> list = new ArrayList<>();
      list.add("867578070147345");
      int[] nums = new int[]{1, 2, 3, 3, 4, 5};
      int j = 1;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] != nums[i - 1]) {
             nums[j++] = nums[i]; // 原地去重
         }
     }
     System.out.println(Arrays.toString(nums));
     System.out.println(isIMEI("867589059240410"));
   
      new Thread(()->{
         System.out.println("hello world");
         // ExcelUtil.readExcel();
         
         // ExcelUtil.compareWebApi();
         // ExcelUtil.compareAndOutputToExcel("wyx", "wyy", "wyx/assets/test.xls");
      }).start();
      // sort();
      //wyx/assets/test.png
      // calculateMD5();
      // ListNode listNode = new ListNode(1);
      // listNode.next = new ListNode(1);
      // listNode.next.next = new ListNode(2);
      // listNode.next.next.next = new ListNode(1);
      // System.out.println(md5v2("wyx/assets/p6.jpg"));

      
   }
   
   public static String md5v2(String filePath) {
     try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      FileInputStream fis = new FileInputStream(filePath);
      byte[] dataBytes = new byte[1024];
      int bytesRead;

      // 逐块读取文件
      while ((bytesRead = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, bytesRead);
      }

      // 关闭输入流
      fis.close();

      // 获取 MD5 哈希值
      byte[] mdBytes = md.digest();

      // 将字节转换为十六进制字符串
      StringBuilder sb = new StringBuilder();
      for (byte b : mdBytes) {
          sb.append(String.format("%02x", b));
      }

      return sb.toString();
     } catch(Exception e) {
      return "";
     }
      
   }

   public static void calculateMD5() {
      // 创建 MessageDigest 实例，指定算法为 MD5
      MessageDigest md;
      try {
         md = MessageDigest.getInstance("MD5");
         // 读取文件并更新摘要
         try (FileInputStream fis = new FileInputStream(new File("wyx/assets/p6.jpg"))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
               md.update(buffer, 0, bytesRead);
            }
         }

         // 计算 MD5 哈希值
         byte[] hashBytes = md.digest();

         // 将字节数组转换为十六进制字符串
         StringBuilder sb = new StringBuilder();
         for (byte b : hashBytes) {
            sb.append(b);
         }

         System.out.println(sb.toString());
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
   }

   public static String calculateMD5(String input) {
      try {
          // 创建 MessageDigest 实例，指定算法为 MD5
          MessageDigest md = MessageDigest.getInstance("MD5");
  
          // 计算 MD5 哈希值
          byte[] hashBytes = md.digest(input.getBytes());
  
          // 将字节数组转换为十六进制字符串
          StringBuilder sb = new StringBuilder();
          for (byte b : hashBytes) {
              sb.append(String.format("%02x", b));
          }
  
          return sb.toString();
      } catch (NoSuchAlgorithmException e) {
          throw new RuntimeException("MD5 algorithm not found", e);
      }
  }

   public static void sort(){
      String str = "";
      String[] names = str.split(";");
      Arrays.sort(names, new PinyinComparator());
      System.out.println(Arrays.toString(names));
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

   public static boolean vaildImei(String imei) {
      if(imei.length() != 15) return false;
      char[] ch = imei.toCharArray();
      int sum1 = 0, sum2 = 0;
      for (int i = 0; i < ch.length - 1; i++) {
         char c = ch[i];
         if (c < '0' || c > '9') {
            return false;
         }
         if (i % 2 == 0) {
            sum1 += c - '0';
         } else {
            int temp = (c - '0') * 2;
            sum2 += temp >= 10 ? temp % 10 + temp / 10 : temp;
         }
      }
      return (sum1 + sum2 + ch[ch.length - 1] - '0') % 10 == 0;
   }

   public static boolean vaildSn(String sn) {
      return !sn.contains(":") && !sn.contains("：");
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

   static class PinyinComparator implements Comparator<String> {
      private HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

      public PinyinComparator() {
          format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
          format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
          format.setVCharType(HanyuPinyinVCharType.WITH_V);
      }

      @Override
      public int compare(String o1, String o2) {
          try {
              String pinyin1 = toPinyin(o1);
              String pinyin2 = toPinyin(o2);
              return pinyin1.compareTo(pinyin2);
          } catch (Exception e) {
              e.printStackTrace();
              return 0;
          }
      }

      private String toPinyin(String chinese) throws Exception {
          StringBuilder pinyin = new StringBuilder();
          for (char c : chinese.toCharArray()) {
              if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                  String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
                  if (pinyins != null) {
                      pinyin.append(pinyins[0]);
                  }
              } else {
                  pinyin.append(c);
              }
          }
          return pinyin.toString();
      }
  }
}