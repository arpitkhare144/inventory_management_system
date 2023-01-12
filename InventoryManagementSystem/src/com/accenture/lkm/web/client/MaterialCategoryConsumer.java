package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialCategoryConsumer {

	@SuppressWarnings("unused")
	private static Logger LOGGER = Logger.getLogger(MaterialCategoryConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialCategoryConsumer.apiURLForById}")
	private String apiURLForById;
	private RestTemplate restTemplate;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private Map<String, String> categoryMap;

	public Map<String, String> getCategoryMap() throws MicroServiceException {
		return categoryMap;
	}

	public List<MaterialCategoryBean> getMaterialCategoryBeanList() throws MicroServiceException {
		hitGetMaterialCategories();
		return materialCategoryBeanList;
	}

	public MaterialCategoryConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material
	 * category.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialCategories() throws MicroServiceException {
		
		
		
		List<LinkedHashMap<String, Object>> list= restTemplate.getForObject(serviceURL+apiURL, List.class );
		materialCategoryBeanList=new ArrayList<MaterialCategoryBean>();
		ObjectMapper mapper= new ObjectMapper();
		if(list !=null) 
		{
		 for (LinkedHashMap<String, Object> list1: list) {
		     MaterialCategoryBean bean= mapper.convertValue(list1, MaterialCategoryBean.class);
		     materialCategoryBeanList.add(bean);
		 }
		}
	}

	/**
	 * This method hits material microservice to get the details of Material
	 * category for given category id.
	 * 
	 * @param categoryId
	 * @return MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	public MaterialCategoryBean hitGetMaterialCategoryById(String categoryId) throws MicroServiceException {
		MaterialCategoryBean materialCategoryBean = restTemplate.getForObject(serviceURL+apiURLForById+categoryId, MaterialCategoryBean.class);
		if(materialCategoryBean!=null) {
		System.out.println("Material category Bean:"+materialCategoryBean);
		}
		else{
		System.out.println("No user exist---------------");
		}
		return materialCategoryBean;
     }
	
}
