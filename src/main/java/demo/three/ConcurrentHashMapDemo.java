package demo.three;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
* ConcurrentHashMapDemo
*author  wenhe
*date 2019/8/7
*/
@Slf4j
public class ConcurrentHashMapDemo {

  @Test
  public void testTransfer(){
    ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>(2);
    map.put(1,1);
    map.put(2,2);
    map.put(3,3);
    map.put(4,4);
    map.put(5,5);
  }

}
