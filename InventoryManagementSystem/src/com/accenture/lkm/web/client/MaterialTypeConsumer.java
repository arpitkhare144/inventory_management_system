package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialTypeConsumer {

	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(MaterialTypeConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;

	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private RestTemplate restTemplate;

	private List<MaterialTypeBean> materialTypeBeanList;

	private Map<String, String> categoryTypeMap;

	public List<MaterialTypeBean> getMaterialTypeBeanList() throws MicroServiceException {
		hitGetMaterialType();
		return materialTypeBeanList;
	}

	public Map<String, String> getCategoryTypeMap() throws MicroServiceException {
		return categoryTypeMap;
	}

	public MaterialTypeConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material type.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialType() throws MicroServiceException {
      
     List<LinkedHashMap<String, Object>> list= restTemplate.getForObject(serviceURL+apiURL,List.class );
	 ObjectMapper mapper= new ObjectMapper();
	 if(list !=null) 
	 {
	  for (LinkedHashMap<String, Object> list1: list) {
	     MaterialTypeBean bean= mapper.convertValue(list1, MaterialTypeBean.class);
	     materialTypeBeanList.add(bean);
	  }
	 }
	
    }


	/**
	 * This method hits material microservice to get the details of Material
	 * type based on category id.
	 * 
	 * @param categoryId
	 * @return List<MaterialTypeBean>
	 * @throws MicroServiceException
	 */
	public List<MaterialTypeBean> hitGetTypesBasedOnCategoryId(String categoryId) throws MicroServiceException {
		List<LinkedHashMap<String, Object>> list= restTemplate.getForObject(serviceURL+apiURLByCategoryId+categoryId, List.class );
		ObjectMapper mapper= new ObjectMapper();
		List<MaterialTypeBean> listBean = new ArrayList<>();
		if(list !=null){
			for (LinkedHashMap<String, Object> list1: list) {
			     MaterialTypeBean bean= mapper.convertValue(list1, MaterialTypeBean.class);
			     listBean.add(bean);
			  }
		}
		return listBean;
	}

}
