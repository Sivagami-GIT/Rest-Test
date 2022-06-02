package com.apex.core;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.apex.pojo.UserXML;

public class XmlUtil {

	public static void main(String[] args) throws JAXBException {

		UserXML user = new UserXML("name", "email", "gender", "status");
		JAXBContext context = JAXBContext.newInstance(UserXML.class);
		Marshaller marshall = context.createMarshaller();
		marshall.marshal(user, System.out);
	}
}
