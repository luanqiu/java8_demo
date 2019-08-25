package demo.two;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
* ArrayListDemo
*author  wenhe
*/
@Slf4j
public class HashMapDemo {

  @Test
  public void testRemove(){
    HashMap<String,String > map = Maps.newHashMap();
    map.put("1","1");
    map.put("2","2");

    map.forEach((s, s2) -> map.remove("1"));
  }

  class DemoDTO implements Serializable,Comparable<String>{
    private static final long serialVersionUID = -5222606202683030702L;

    private Integer i;

    public DemoDTO(Integer i) {
      this.i = i;
    }

    @Override
    public int hashCode() {
      return 2;
    }


    @Override
    public int compareTo(String o) {
      return 1;
    }
  }


  @Test
  public void testHashTreeNode(){
    Map<DemoDTO,Integer> map = new HashMap();
    for(int i=0;i<32;i++){
      map.put(new DemoDTO(i),i);
    }
    log.info(JSON.toJSONString(map));
  }

  @Test
  public void testArray(){
    String[] array = new String[]{"1", "2", "3"};
    String[] array1 = array;
    log.info("array[0] ={}",array[0]);
    log.info("array1[0] ={}",array1[0]);
    array[0] ="4";
    log.info("array[0] 的值被改变");
    log.info("array[0] ={}",array[0]);
    log.info("array1[0] ={}",array1[0]);
  }

  @Test
  public void compute(){
    HashMap<Integer,Integer> map = Maps.newHashMap();
    map.put(10,10);
    log.info("compute 之前值为：{}",map.get(10));
    map.compute(10,(key,value) -> key * value);
    log.info("compute 之后值为：{}",map.get(10));
    // 还原测试值
    map.put(10,10);

    // 如果为 11 的 key 不存在的话，需要注意 value 为空的情况
//    map.compute(11,(key,value) -> key * value);
    // 自己判断空指针
    map.compute(11,(key,value) -> null == value ? null : key * value);
    // computeIfPresent 方法里面判断
    map.computeIfPresent(11,(key,value) -> key * value);
    log.info("computeIfPresent 之后值为：{}",map.get(11));
  }

  @Test
  public void testInitMapByMaps(){
    Map<String,String> hashMap = Maps.newHashMap();
    Map<String,String> linkedHashMap = Maps.newLinkedHashMap();
    Map<String,String> withExpectedSizeHashMap = Maps.newHashMapWithExpectedSize(20);
  }


  @Test
  public void testDifference(){
    Map<String,String> leftMap = ImmutableMap.of("1","1","2","2","3","3");
    Map<String,String> rightMap = ImmutableMap.of("2","2","3","30","4","4");
    MapDifference difference = Maps.difference(leftMap, rightMap);
    log.info("左边 map 独有 key：{}",difference.entriesOnlyOnLeft());
    log.info("右边 map 独有 key：{}",difference.entriesOnlyOnRight());
    log.info("左右边 map 都有 key，并且 value 相等：{}",difference.entriesInCommon());
    log.info("左右边 map 都有 key，但 value 不等：{}",difference.entriesDiffering());
  }


}
