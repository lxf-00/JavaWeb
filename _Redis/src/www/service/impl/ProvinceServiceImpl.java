package www.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import www.dao.ProviceDao;
import www.dao.impl.ProvinceDaoImpl;
import www.domain.Province;
import www.jedis.util.JedisPoolUtils;
import www.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProviceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        // 1， 从redis中查询数据
        // 1.1 连接redis
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        // 2，判断province_json是否为空
        if(province_json == null || province_json.length() == 0){
            // redis中没有数据
            System.out.println("redis中没有数据，查询数据库.....");
            // 2.1 从数据库中查询
            List<Province> all = dao.findAll();
            // 2.1 将all序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(all);
            }catch (JsonProcessingException e){
                e.printStackTrace();
            }

            // 2.2 将数据存入redis
            jedis.set("province", province_json);
            // 2.3 归还连接
            jedis.close();
        }else{
            System.out.println("redis中有缓存，查询中.....");
        }
        return province_json;
    }
}
