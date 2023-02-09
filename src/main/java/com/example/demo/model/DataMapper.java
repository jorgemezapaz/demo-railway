package com.example.demo.model;

import com.example.demo.dto.DataDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataMapper {
  public DataDTO buildDataDTO(Data data){
    return new DataDTO(data.getId(), data.getValue());
  }
}
