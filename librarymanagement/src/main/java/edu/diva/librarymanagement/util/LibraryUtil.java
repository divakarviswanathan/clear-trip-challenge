package edu.diva.librarymanagement.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author divakar
 *
 */
@Component
public class LibraryUtil {

	public boolean validateUserDetails(List<String> supportingDocuments) {
		if (supportingDocuments == null || supportingDocuments.size() <= 0) {
			return false;
		}
		for (String locations : supportingDocuments) {
			if (StringUtils.isEmpty(locations.trim())) {
				return false;
			}
		}
		return true;
	}
}
