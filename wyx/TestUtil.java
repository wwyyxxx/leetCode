/*
 * @Author: Tungbo
 * @Date: 2021-10-10 17:32:11
 * @LastEditTime: 2024-01-18 14:09:51
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
      list.add("863293032579937");
      list.add("860810042603812");
      list.add("866655033757208");
      list.add("864699039269844");
      list.add("863445031307799");
      list.add("868320045966770");
      list.add("865500037785568");
      list.add("864430037188327");
      list.add("866412036172328");
      list.add("861006034866819");
      list.add("867027034442009");
      list.add("867685034011221");
      list.add("860751047952020");
      list.add("867884032159542");
      list.add("867142035079534");
      list.add("861414038417045");
      list.add("860169056016803");
      list.add("868226031839709");
      list.add("867863049148821");
      list.add("860921040441079");
      list.add("868455032176890");
      list.add("869236047906805");
      list.add("866778032939245");
      list.add("864686031598007");
      list.add("861015031519768");
      list.add("860863030135255");
      list.add("863542047518193");
      list.add("860141046068533");
      list.add("865422035311745");
      list.add("865131040822295");
      list.add("866146035619042");
      list.add("867194048886710");
      list.add("863938057393651");
      list.add("863741043943906");
      list.add("862785051867631");
      list.add("862785050681173");
      list.add("866212042693287");
      list.add("868701054134634");
      list.add("860886050918995");
      list.add("862785050847998");
      list.add("862785051884115");
      list.add("863815046752819");
      list.add("865441031029002");
      list.add("863940048072667");
      list.add("867109045375053");
      list.add("868585047789251");
      list.add("869595052066148");
      list.add("869066034672932");
      list.add("866947052784456");
      list.add("860128048347650");
      list.add("868133035517051");
      list.add("866654031659508");
      list.add("865140041589282");
      list.add("869508044894592");
      list.add("862538030334680");
      list.add("867165044965443");
      list.add("860209041685195");
      list.add("867854041715600");
      list.add("869320037574458");
      list.add("869572044689899");
      list.add("864325059731493");
      list.add("866705064436972");
      list.add("867282050304555");
      list.add("868670032465115");
      list.add("864088052636776");
      list.add("869616058382519");
      list.add("866672050803732");
      list.add("860140058305411");
      list.add("868751050002079");
      list.add("860140058079735");
      list.add("863826055416634");
      list.add("862526038161155");
      list.add("861262033977855");
      list.add("862017036139096");
      list.add("860459040631373");
      list.add("864088056544711");
      list.add("864101047358412");
      list.add("862807045692634");
      list.add("864776060549334");
      list.add("868994041392106");
      list.add("862975031978711");
      list.add("864282032152158");
      list.add("864141036386941");
      list.add("865939034261720");
      list.add("864740032041473");
      list.add("866181039735635");
      list.add("863435030178366");
      list.add("861262039214154");
      list.add("865819039788721");
      list.add("869917029358202");
      list.add("860391043042052");
      list.add("352709083926204");
      list.add("868381030478957");
      list.add("868165037940618");
      list.add("864664038160808");
      list.add("867162048133425");
      list.add("869271043931671");
      list.add("863389033155410");
      list.add("865051040656115");
      list.add("867536030815612");
      list.add("865383035876634");
      list.add("865051042581402");
      list.add("864600032915243");
      list.add("860255041691337");
      list.add("864253039549894");
      list.add("865326041145080");
      list.add("861589049000078");
      list.add("357724082650650");
      list.add("866922034843134");
      list.add("865326048247269");
      list.add("865326047687119");
      list.add("868097040804129");
      list.add("867216036159857");
      list.add("862819034673376");
      list.add("862820033619410");
      list.add("863454035074611");
      list.add("861487035859682");
      list.add("862820034376671");
      list.add("869218045879358");
      list.add("868060037649030");
      list.add("865556048620418");
      list.add("868061035199192");
      list.add("867465032384916");
      list.add("868060034776612");
      list.add("866015030959614");
      list.add("866083058514836");
      list.add("866508032062759");
      list.add("868363038942432");
      list.add("869712041076175");
      list.add("865088035247716");
      list.add("867137038372217");
      list.add("869608059979237");
      list.add("864332040135495");
      list.add("869454031987125");
      list.add("869217036441806");
      list.add("867547030770400");
      list.add("868204042988898");
      list.add("860106045448747");
      list.add("867219036746855");
      list.add("865730037838873");
      list.add("869287048821873");
      list.add("866913034765237");
      list.add("867679039267979");
      list.add("866379030573910");
      list.add("865130030363930");
      list.add("868794036439080");
      list.add("862855048838860");
      list.add("869377034595233");
      list.add("860980030235628");
      list.add("862828045950772");
      list.add("866271041604141");
      list.add("862495042158872");
      list.add("861332043192017");
      list.add("868833057940673");
      list.add("868756053593446");
      list.add("864332040422331");
      list.add("862859059222410");
      list.add("861557058744159");
      list.add("865367041427102");
      list.add("864451041258526");
      list.add("869743058588158");
      list.add("869071033974651");
      for(String imei : list) {
         System.out.println(vaildImei(imei));
      }

      // // Arrays.toString(args);
      // LockA la = new LockA();
      // new Thread(la).start();
      // LockB lb = new LockB();
      // new Thread(lb).start();
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