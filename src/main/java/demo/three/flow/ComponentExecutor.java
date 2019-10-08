package demo.three.flow;

import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 组件执行器
 * author  wenhe
 * date 2019/10/7
 */
public class ComponentExecutor {

  private static ExecutorService executor = new ThreadPoolExecutor(15, 15,
                                                                   365L, TimeUnit.DAYS,
                                                                   new LinkedBlockingQueue<>());

  public static final void run(DomainAbilityBean component, FlowContent content) {
    if (AnnotationUtils.isAnnotationPresent(AsyncComponent.class, AopUtils.getTargetClass(component))) {
      executor.submit(() -> { component.invoke(content); });
      return;
    }
    component.invoke(content);
  }

}
