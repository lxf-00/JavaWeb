package www.service;

import www.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    /**
     * 使用redis缓存
     * @return
     */
    public String findAllJson();
}
