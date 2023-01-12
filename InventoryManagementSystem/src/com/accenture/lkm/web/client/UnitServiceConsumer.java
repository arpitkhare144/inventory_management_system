package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UnitServiceConsumer {

	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(UnitServiceConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;

	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private List<UnitBean> unitBeanList;

	private Map<String, String> unitMap;

	private RestTemplate restTemplate;

	public List<UnitBean> getUnitBeanList() throws MicroServiceException {
		hitGetUnitDetails();
		return unitBeanList;
	}

	public Map<String, String> getUnitMap() throws MicroServiceException {
		return unitMap;
	}

	public UnitServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of unit.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetUnitDetails() throws MicroServiceException {
		List<LinkedHashMap<String, Object>> list= restTemplate.getForObject(serviceURL+apiURL,List.class );
		 ObjectMapper mapper= new ObjectMapper();
		 if(list !=null) 
		 {
		  for (LinkedHashMap<String, Object> list1: list) {
		     UnitBean bean= mapper.convertValue(list1, UnitBean.class);
		     unitBeanList.add(bean);
		  }
		 }
	}

	/**
	 * This method hits material microservice to get the list of unit available
	 * for a given category id.
	 * 
	 * @param categoryId
	 * @return List<UnitBean>
	 * @throws MicroServiceException
	 */
	public List<UnitBean> hitGetUnitsByCategoryId(String categoryId) throws MicroServiceException {
		List<LinkedHashMap<String, Object>> list= restTemplate.getForObject(serviceURL+apiURLByCategoryId+categoryId, List.class );
		ObjectMapper mapper= new ObjectMapper();
		List<UnitBean> listBean = new ArrayList<>();
		if(list !=null){
			for (LinkedHashMap<String, Object> list1: list) {
			     UnitBean bean= mapper.convertValue(list1, UnitBean.class);
			     listBean.add(bean);
			  }
		}
		return listBean;
	}

}
