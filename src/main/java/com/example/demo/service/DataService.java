package com.example.demo.service;

import com.example.demo.dto.DataDTO;
import com.example.demo.model.Data;
import com.example.demo.model.DataMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class DataService {
  private final RestTemplate restTemplate;

  private String hash() {
    String credentials = "admin:1234";
    return new String(Base64.encodeBase64(credentials.getBytes()));
  }

  public DataDTO getById(Long id) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
//    headers.add("Authorization", "Basic " + hash());
    headers.add("Authorization", "Bearer " + hash());
    ResponseEntity<Data> response = restTemplate.exchange(
        "https://00ele.mocklab.io/json/" + id.toString(),
        HttpMethod.GET,
        new HttpEntity<>(headers),
        Data.class
    );
    return DataMapper.buildDataDTO(response.getBody());
  }
}
