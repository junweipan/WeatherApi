package com.junwei.weatherapis.repository;
import com.junwei.weatherapis.model.Apikey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApiKeyRepository extends CrudRepository<Apikey, Integer>
{
}