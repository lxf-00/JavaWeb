import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import www.domain.Person;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        // 1， 创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        // 2， 创建Jackson核心对象 ObjectMapper
        ObjectMapper om = new ObjectMapper();

        // 3，转换
        /*

            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串

         */
        // String json = om.writeValueAsString(p);
        // 将转换的数据保存
        om.writeValue(new File("./b.txt"), p);
        // System.out.println(json);
    }

    @Test
    public void test2() throws Exception{
        Person p = new Person();
        p.setName("张三");
        p.setGender("男");
        p.setAge(23);
        p.setBirthday(new Date());


        ObjectMapper mapper = new ObjectMapper();
        // java对象转换为json数据
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setBirthday(new Date());
        p.setGender("男");

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setBirthday(new Date());
        p1.setGender("男");

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setBirthday(new Date());
        p2.setGender("男");

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(23);
        p3.setBirthday(new Date());
        p3.setGender("男");

        // 添加到集合中
        List<Person> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);

        System.out.println(string);
    }

    @Test
    public void test4() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        System.out.println(json);
    }

    // Json字符串转为Java对象
    @Test
    public void test5() throws IOException {
        // 1, 初始化Json字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        // 2， 创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        // 3, 转换为Java对象
        Person p = mapper.readValue(json, Person.class);

        System.out.println(p);
    }
}
