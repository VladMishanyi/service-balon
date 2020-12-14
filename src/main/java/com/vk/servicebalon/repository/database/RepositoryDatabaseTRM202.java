package com.vk.servicebalon.repository.database;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepositoryDatabaseTRM202 extends CrudRepository<TableModelTRM202, Long> {

    List<TableModelTRM202> findByDateBetween (Date start, Date end);
}
