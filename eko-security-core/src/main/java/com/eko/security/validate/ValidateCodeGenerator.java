/**
 * 
 */
package com.eko.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
