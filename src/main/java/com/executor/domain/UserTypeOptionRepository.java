package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeOptionRepository extends CrudRepository <UserTypeOption, Long > {
}
