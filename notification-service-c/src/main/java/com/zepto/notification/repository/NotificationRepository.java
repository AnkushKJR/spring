package com.zepto.notification.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.notification.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>{

}
