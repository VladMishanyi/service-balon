package com.vk.servicebalon.repository.database;

import com.vk.servicebalon.table.TableModelTRM138;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryDatabaseTRM138 extends JpaRepository<TableModelTRM138, Long> {

    List<TableModelTRM138> findByDateBetween (LocalDateTime start, LocalDateTime end);

    @Query(value = "SELECT * FROM trm138 ORDER BY date DESC LIMIT 1",nativeQuery = true)
    TableModelTRM138 findLastValueByDate ();
}
