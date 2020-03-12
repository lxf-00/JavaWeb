package BeanUtils;

import le.javalearning.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtils工具类，简化数据封装
 * 用于封装JavaBean的
 *
 */
public class BeanUtilsTest1 {

    @Test
    public void test(){
        User user = new User();
        try{
            BeanUtils.setProperty(user, "name", "pass");
            System.out.println(user);

            String name = BeanUtils.getProperty(user, "name");
            System.out.println(name);
        } catch (IllegalAccessException E){
            E.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}
