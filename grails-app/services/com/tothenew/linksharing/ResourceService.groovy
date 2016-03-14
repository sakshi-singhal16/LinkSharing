package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import grails.transaction.Transactional

@Transactional
class ResourceService {

	List<Resource> search(ResourceSearchCO resourceSearchCO) {

		Resource.searchCreatedResources(resourceSearchCO.getUser()).list([max:resourceSearchCO.max, offset:resourceSearchCO.offset])
	}
}
