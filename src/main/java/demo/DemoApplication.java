package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

import demo.three.flow.ApplicationContextHelper;
import demo.three.flow.FlowContent;
import demo.three.flow.FlowStart;


/**
* DemoApplication
*author  wenhe
*date 2019/9/24
*/
@SpringBootApplication(scanBasePackages = {"demo"})
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
    ApplicationContextHelper.getBean(FlowStart.class)
        .start("flow1",new FlowContent());
  }


}
