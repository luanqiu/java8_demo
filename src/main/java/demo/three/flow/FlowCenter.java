package demo.three.flow;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * FlowCenter
 * author  wenhe
 * date 2019/8/11
 */
@Component
public class FlowCenter {

  /**
   * flowMap 是共享变量，方便访问
   */
  public static final Map<String, Map<StageEnum, List<DomainAbilityBean>>> flowMap
      = Maps.newConcurrentMap();

  /**
   * PostConstruct 注解的意思就是
   * 在容器启动成功之后，初始化 flowMap
   */
  @PostConstruct
  public void init() {
      // 初始化 flowMap
  }

}
