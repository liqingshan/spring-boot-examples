package com.neo.repository;

import com.neo.model.Md5TelDO;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liqingshan
 * Date: 2019-09-17
 * Time: 18:37
 */
public interface Md5TelRepository {

    public void saveMd5Tel(Md5TelDO md5TelDO);
}
